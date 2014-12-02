package com.tamarack.creekridge.liferay.paymentcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;

/**
 * Portlet implementation class PaymentCalculatorTable
 */
public class PaymentCalculator extends MVCPortlet {

	/**
	 * @see MVCPortlet#MVCPortlet()
	 */
	public PaymentCalculator() {
		super();
	}

	private static Log _log = LogFactory.getLog(PaymentCalculator.class);
	private Long vendorId;
	private User currentUser;
	private ThemeDisplay themeDisplay;
	private List <ProposalOptionWrapper> proposalOptionList;

	private boolean hasProposalIncluded = false;
	private boolean isAppCreated=false;
	
	@Override 
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		_log.info("processAction started");
		super.processAction(actionRequest, actionResponse);
		
		_log.info("processAction ended");
	}
	
	@Override 
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		_log.info("render started");
		
		
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		//page variables available
		List<Product> productOptions = new ArrayList<Product>();
		CreditApp creditApp;
		
		themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		vendorId = themeDisplay.getLayout().getGroupId();
		currentUser = themeDisplay.getUser();
	
		try {
			productOptions = ProductLocalServiceUtil.getProducts(-1, -1);
			renderRequest.setAttribute("productOptions", productOptions);
				
			creditApp = (CreditApp) renderRequest.getAttribute("creditApp");
			if (creditApp == null) { //try page parameter
				
				String appId = httpReq.getParameter("creditAppId");
				
				if (appId == null) {//try namespace prefixed version
					appId = httpReq.getParameter(renderResponse.getNamespace()+"creditAppId");
				} 
				
				if (appId == null) {
					appId = httpReq.getParameter("creditAppId");
				}
				
				if (appId == null)
					appId = ParamUtil.getString(renderRequest, "creditAppId");
				
				if (appId != null && appId != "") {
					creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long (appId));
				}
				
			} //else app was found
			
			
			
			_log.info("creditApp: " + creditApp);
			
			if (creditApp != null) {
				renderRequest.setAttribute("creditApp", creditApp);
				proposalOptionList = new ArrayList<ProposalOptionWrapper>();
				for (ProposalOption po: ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditApp.getCreditAppId())) {
					proposalOptionList.add (new ProposalOptionWrapper(po));
				}
	
				//need to figure out if we want to switch back to the action vs ajax
				renderRequest.setAttribute("proposalList", JSONFactoryUtil.looseSerialize(proposalOptionList));
				renderRequest.setAttribute("proposalOptionList", proposalOptionList);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		super.render(renderRequest, renderResponse);
		_log.info("render ended");
	}
	
	//	ADD CREDIT REFERENCE 
	public void addCreditAppBankReference (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("addCreditAppBankReference started");
		
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		
		try {
			
			CreditAppBankReference reference = CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(currentUser, themeDisplay);
			reference = PaymentCalculatorUtil.populateBankReferenceFromRequest(actionRequest, reference);
			reference.setCreditAppId(creditAppId);
			CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(reference);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
			actionResponse.setWindowState(LiferayWindowState.NORMAL);
			
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "bankReferenceSection");
		SessionMessages.add(actionRequest, "bankReferenceSaved");
		_log.info("addCreditAppBankReference ended");
	}
	
	//	EDIT CREDIT REFERENCE 
	public void editCreditAppBankReference (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("addCreditAppBankReference started");
		
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		long referenceId = ParamUtil.getLong(actionRequest, "resourcePrimKey");
		try {
			CreditAppBankReference reference = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReference(referenceId);
			reference = PaymentCalculatorUtil.populateBankReferenceFromRequest(actionRequest, reference);
			reference.setModifiedDate(new Date());
			CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(reference);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
		} catch (Exception e) {
			_log.error(e); 
		}
		actionResponse.setRenderParameter ("openSection", "bankReferenceSection");
		_log.info("editCreditAppBankReference ended");
	}
	
	//	DELETE CREDIT REFERENCE 
	public void deleteCreditAppBankReference (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("deleteCreditAppBankReference started");
		
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		long referenceId = ParamUtil.getLong(actionRequest, "resourcePrimKey");
		
		try {
			
			CreditAppBankReferenceLocalServiceUtil.deleteCreditAppBankReference(referenceId);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
			
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "bankReferenceSection");
		_log.info("deleteCreditAppBankReference ended");
	}
	
	//ADD PRINCIPAL
	public void addCreditAppPrincipal (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("addCreditAppPrincipal started");
		
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		
		try {
			CreditAppPrincipal principal = CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(currentUser, themeDisplay);
			principal = PaymentCalculatorUtil.populatePrincipalFromRequest(actionRequest, principal);
			principal.setCreditAppId(creditAppId);
			CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(principal);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
			actionResponse.setWindowState(LiferayWindowState.NORMAL);
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "principalSection");
		SessionMessages.add(actionRequest, "principalSaved");
		_log.info("addCreditAppPrincipal ended");
	}
	
	//EDIT PRINCIPAL
	public void editCreditAppPrincipal (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("editCreditAppPrincipal started");
		
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		long principalId = ParamUtil.getLong(actionRequest, "resourcePrimKey");
		try {
			CreditAppPrincipal principal = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipal(principalId);
			principal = PaymentCalculatorUtil.populatePrincipalFromRequest(actionRequest, principal);
			principal.setModifiedDate(new Date());
			CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(principal);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
			
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "principalSection");
		_log.info("editCreditAppPrincipal ended");
	}
	
	//DELETE PRINCIPAL
	public void deleteCreditAppPrincipal (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("deleteCreditAppPrincipal started");
		
		long principalId = ParamUtil.getLong(actionRequest, "resourcePrimKey");
		_log.info("resourcePrimKey" + principalId);
		long creditAppId = ParamUtil.getLong(actionRequest, "appId");
		_log.info("creditAppId" + creditAppId);
		try {
			
			CreditAppPrincipalLocalServiceUtil.deleteCreditAppPrincipal(principalId);
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			actionRequest.setAttribute("creditApp", creditApp);
			
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "principalSection");
		_log.info("deleteCreditAppPrincipal ended");
	}

	
	public void submitApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		saveApplicationInfo (actionRequest, actionResponse);
		
		CreditApp creditApp = null;
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		try {
			
			creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			CreditAppStatus creditAppStatus = CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Submitted");
			creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
			_log.info("Credit App has been submitted" + creditApp);
			SessionMessages.add(actionRequest, "appSubmitted");
			actionRequest.setAttribute("creditApp", creditApp);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}
	
	public void saveApplicationInfo (ActionRequest actionRequest, ActionResponse actionResponse) {

		CreditApp creditApp = null;
		_log.info("saveApplicationInfo actionrequest started: ");
		
		try {
			
			long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
			
			_log.info("creditAppId: " + creditAppId);
			
			if (creditAppId != 0)
				creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			
			if (actionRequest.getMethod() == "GET") {
				actionRequest.setAttribute("creditApp", creditApp);
				return;
			}
			
			if (creditApp == null) {
				creditApp = CreditAppLocalServiceUtil.addCreditApp (currentUser, themeDisplay);
				_log.info("Application has been created. " + creditApp);
				isAppCreated = true;
				
			} else {
				creditApp.setCreditAppStatusId(2);
				_log.info("Application has been updated. " + creditApp);
				
			}
			
			creditApp = PaymentCalculatorUtil.populateAppFromRequest(actionRequest, creditApp);
			
			//process proposalOptions
			if (proposalOptionList == null || proposalOptionList.isEmpty()) {
				_log.info("proposalOptionList is empty");
				SessionErrors.add(actionRequest, "runCalculatorRequired");
				actionResponse.setRenderParameter("calculatorSectionState", "open");
				
			} else {
				_log.info("proposalOptionList is populated: " + proposalOptionList.size());
				
				
				for (ProposalOptionWrapper pow: proposalOptionList) {
					_log.info("pow.propOption: " + pow.propOption);
					
					if (pow.propOption.getIncludeInProposal()) {
						pow.propOption.setCreditAppId(creditApp.getCreditAppId());
						pow.propOption = ProposalOptionLocalServiceUtil.updateProposalOption(pow.propOption);
						hasProposalIncluded = true;

					}
					
					if (pow.propOption.getUseForCreditApp()) {
						creditApp.setPaymentAmount(pow.propOption.getPaymentAmount());
						creditApp.setTermId(pow.propOption.getTermId());
						creditApp.setProductId(pow.propOption.getProductId());
						creditApp.setPurchaseOptionId(pow.propOption.getPurchaseOptionId());
						creditApp.setEquipmentPrice(pow.eqPrice);
					}
				}
				
				if (!hasProposalIncluded) {
					SessionErrors.add(actionRequest, "error-one-proposal-required");	
				}
			}
			
			
			
			//update app info
			creditApp.setModifiedDate(new Date());
			creditApp = CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
			if (isAppCreated) {
				SessionMessages.add(actionRequest, "appSaved");
			} else {
				SessionMessages.add(actionRequest, "appUpdated");
			}
		
		} catch (Exception e) {
			_log.error(e);
		}
		

		actionResponse.setRenderParameter("openSection", "customerAndEquipmentInfo");
		
		_log.info("Setting attribute : creditApp=" + creditApp );
		actionRequest.setAttribute("creditApp", creditApp);
		
	}
	
	public List<ProposalOptionWrapper> calculatePayments(String selectedOptions) throws Exception {
		
		List <RateFactorRule> rateFactorRuleList = new ArrayList <RateFactorRule> ();
		
		
		JSONObject selectedOptionsObject = JSONFactoryUtil.createJSONObject(selectedOptions);
		_log.info("calculatePayments JSON : " + selectedOptionsObject);
		
		JSONArray productIdList = selectedOptionsObject.getJSONArray("products");
		_log.info("calculatePayments JSON productIdList : " + productIdList);
		
		JSONArray purchaseOptionIdList = selectedOptionsObject.getJSONArray("purchaseOptions");
		_log.info("calculatePayments JSON purchaseOptionIdList : " + purchaseOptionIdList);
		
		JSONArray termIdList = selectedOptionsObject.getJSONArray("termOptions");
		_log.info("calculatePayments JSON termIdList : " + purchaseOptionIdList);
		
		Double equipmentPrice = selectedOptionsObject.getDouble("equipmentPrice");
		_log.info("calculatePayments JSON equipmentPrice : " + equipmentPrice);
		
		//build query for terms
		if (termIdList.length()>0) {
			for (int i = 0; i < termIdList.length(); i++) {
				for (int j = 0; j < purchaseOptionIdList.length(); j++) {
					for (int k = 0; k < productIdList.length(); k++) {
						List <RateFactorRule> tempRfRList = new ArrayList <RateFactorRule> ();
						tempRfRList = fetchRatefactorOptionForCalculations(productIdList.getLong(k), purchaseOptionIdList.getLong(j), termIdList.getLong(i), equipmentPrice);
						if (!tempRfRList.isEmpty()) {
							rateFactorRuleList.add(tempRfRList.get(0));
						}
					}
				}
			}	
		}
		
		
		proposalOptionList = new ArrayList <ProposalOptionWrapper> ();
		
		
		for (RateFactorRule rate: rateFactorRuleList) {
			ProposalOption proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
			proposalOption.setRateFactorRuleId(rate.getRateFactorRuleId());
			// Auditing Values
			 proposalOption.setCompanyId(currentUser.getCompanyId());
			 proposalOption.setUserId(currentUser.getUserId());
			 proposalOption.setUserName(currentUser.getScreenName());
			 proposalOption.setModifiedDate(new Date());
			 proposalOption.setCreateDate(new Date());
			 //	Other fields

			 proposalOption.setProductId(rate.getProductId());
			 proposalOption.setPurchaseOptionId(rate.getPurchaseOptionId());
			 proposalOption.setTermId(rate.getTermId());
			 proposalOption.setRateFactorRuleId(rate.getRateFactorRuleId());
			 
			 Term tempTerm = TermLocalServiceUtil.getTerm(rate.getTermId());
			 
			 Double paymentAmount = (equipmentPrice/tempTerm.getTermMonths()) * (1+rate.getRateFactor()) ;
			 
			 proposalOption.setPaymentAmount(paymentAmount);
			 proposalOption.setEquipmentPrice(equipmentPrice);
			 
			 proposalOptionList.add(new ProposalOptionWrapper(proposalOption));
			 
		}
		
		if (proposalOptionList.size()==1){
			proposalOptionList.get(0).propOption.setIncludeInProposal(true);
			proposalOptionList.get(0).propOption.setUseForCreditApp(true);
		}
		
		return proposalOptionList;
		
	}
	
	private List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long prodId, Long optionId, Long termId, Double eqPrice) throws Exception {
		//main object passed from the page
		
		
		DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil
				.forClass(RateFactorRule.class,
						PortletClassLoaderUtil.getClassLoader());
		
		//only rules that are active and belong to a site/vendorId
		Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",
				vendorId);
		Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",
				true);
		
		Criterion crit = RestrictionsFactoryUtil.eq("productId", prodId);
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("purchaseOptionId", optionId));
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("termId", termId));
		
		
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.le("minPrice", eqPrice));
		
		rateFactorCriteriaQuery.add(crit);
		

		rateFactorCriteriaQuery.add(vendorIdCriteria);
		rateFactorCriteriaQuery.add(activeFlagCriteria);
		
		//orderby price
		rateFactorCriteriaQuery.addOrder(OrderFactoryUtil.desc("minPrice"));

		@SuppressWarnings("unchecked")
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil
				.dynamicQuery(rateFactorCriteriaQuery);
		
		_log.info("fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}

	public List<RateFactorRule> fetchRatefactorOption(String currentSelectedOptions)
			throws Exception {
		
		//main object passed from the page
		JSONObject options = JSONFactoryUtil.createJSONObject(currentSelectedOptions);
		_log.info("fetchRatefactorOptionByProduct JSON : " + options);
		
		JSONArray productIdList = options.getJSONArray("products");
		_log.info("fetchRatefactorOptionByProduct JSON productIdList : " + productIdList);
		
		JSONArray purchaseOptionIdList = options.getJSONArray("purchaseOptions");
		_log.info("fetchRatefactorOptionByProduct JSON purchaseOptionIdList : " + purchaseOptionIdList);

		
		DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil
				.forClass(RateFactorRule.class,
						PortletClassLoaderUtil.getClassLoader());

		Criterion productCriteria = null;
		Criterion purchaseOptionCriteria = null;
		
		//only rules that are active and belong to a site/vendorId
		Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",
				vendorId);
		Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",
				true);
		
		// build query for product ids
		if (productIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				if (i == 0) {
					productCriteria = RestrictionsFactoryUtil.eq("productId",
							new Long(productIdList.getString(i)).longValue());
				} else {
					productCriteria = RestrictionsFactoryUtil
							.or(productCriteria, RestrictionsFactoryUtil.eq(
									"productId",
									new Long(productIdList.getString(i)).longValue()));
				}
			}
		}

		// build query for purchaseOption ids
		if (purchaseOptionIdList.length()>0) {
			for (int i = 0; i < purchaseOptionIdList.length(); i++) {
				if (i == 0) {
					purchaseOptionCriteria = RestrictionsFactoryUtil.eq(
							"purchaseOptionId", purchaseOptionIdList.getLong(i));
				} else {
					purchaseOptionCriteria = RestrictionsFactoryUtil.or(
							purchaseOptionCriteria, RestrictionsFactoryUtil.eq(
									"purchaseOptionId",purchaseOptionIdList.getLong(i)));
				}
			}
		}
		if (productCriteria != null){
			rateFactorCriteriaQuery.add(productCriteria);
			
			if (purchaseOptionCriteria != null)
				rateFactorCriteriaQuery.add(purchaseOptionCriteria);
		}
		
		rateFactorCriteriaQuery.add(vendorIdCriteria);
		rateFactorCriteriaQuery.add(activeFlagCriteria);

		@SuppressWarnings("unchecked")
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil
				.dynamicQuery(rateFactorCriteriaQuery);
		
		return rateFactorRuleList;
	}
	
	//needed for the js table
	public class ProposalOptionWrapper {
		public ProposalOption propOption;
		public String termName;
		public String productName;
		public String prodOptionName;
		public Double eqPrice;
		public Double paymentAmount;
	
		public Long proposalOptionId;
		
		public ProposalOptionWrapper (ProposalOption propOption) {
			this.propOption = propOption;
			try {
				this.proposalOptionId = propOption.getProposalOptionId();
				this.termName = TermLocalServiceUtil.getTerm(propOption.getTermId()).getTermName();
				this.productName = ProductLocalServiceUtil.getProduct(propOption.getProductId()).getProductName();
				this.prodOptionName = PurchaseOptionLocalServiceUtil.getPurchaseOption(propOption.getPurchaseOptionId()).getPurchaseOptionName();
				this.eqPrice = propOption.getEquipmentPrice();
				this.paymentAmount = propOption.getPaymentAmount();
				
				
			} catch (SystemException e) {
				_log.error(e);
				e.printStackTrace();
			} catch (PortalException e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(resourceRequest);
		List <RateFactorRule> rateFactorList = new ArrayList <RateFactorRule>();
		List <PurchaseOption> purchaseOptionList = new ArrayList <PurchaseOption> ();
		List <Term> termList = new ArrayList <Term> ();
		
		_log.info(resourceRequest.getResourceID());
		
		String selectedOptionsParam = PortalUtil.getOriginalServletRequest(request).getParameter("selectedOptions");
		
		if (selectedOptionsParam != null) {
			try {
				rateFactorList = fetchRatefactorOption(selectedOptionsParam);
			} catch (Exception e) {
				_log.error (e);
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
		}
		
		if (resourceRequest.getResourceID().equalsIgnoreCase(
				"processProductsSelection")) {
			try {
				_log.info ("processProductsSelection rateFactorList size " + rateFactorList.size());
				Set <Long> poSet = new HashSet <Long> ();
				for (RateFactorRule rateFactorValue : rateFactorList) {
					_log.info(rateFactorValue);
					if (!poSet.contains(rateFactorValue.getPurchaseOptionId())) {
						poSet.add(rateFactorValue.getPurchaseOptionId());
						PurchaseOption po = PurchaseOptionLocalServiceUtil.getPurchaseOption(rateFactorValue.getPurchaseOptionId());
						purchaseOptionList.add(po);
					} 
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(purchaseOptionList));
		}
		
		if (resourceRequest.getResourceID().equalsIgnoreCase(
				"processPurchaseOptionsSelection")) {
			try {
				
				_log.info ("rateFactorList size " + rateFactorList.size());
				Set <Long> termSet = new HashSet <Long> ();
				for (RateFactorRule rateFactorValue : rateFactorList) {
					_log.info(rateFactorValue);
					if (!termSet.contains(rateFactorValue.getTermId())) {
						termSet.add(rateFactorValue.getTermId());
						Term term = TermLocalServiceUtil.getTerm(new Long(rateFactorValue.getTermId()).longValue());
						termList.add(term);
					} 
				}
				
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(termList));
			} catch (Exception e) {
				_log. error(e);
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"calculatePayments")) {
			try {
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(calculatePayments(selectedOptionsParam)));
			} catch (Exception e) {
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
				_log. error(e);
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"updateUseForApplication")) {
			
			String selectedProposalOptionId = PortalUtil.getOriginalServletRequest(request).getParameter("proposalOptionId");
			
			if (selectedProposalOptionId != null) {
				for (ProposalOptionWrapper pow: proposalOptionList) {
					if (pow.propOption.getProposalOptionId() == Long.valueOf(selectedProposalOptionId)) {
						pow.propOption.setUseForCreditApp(true);
						pow.propOption.setIncludeInProposal(true);
					} else {
						pow.propOption.setUseForCreditApp(false);
					}
				}	
				resourceResponse.getWriter().write("{\"proposalOptionId\": \"" + selectedProposalOptionId + "\"}");
			} else {
				resourceResponse.getWriter().write("{ \"error\": \"selectedProposalOptionId not found " + selectedProposalOptionId + "\"}");
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"updateIncludeInProposal")) {
			String selectedProposalOptionId = PortalUtil.getOriginalServletRequest(request).getParameter("purchaseOptionId");
			String selectedValue = PortalUtil.getOriginalServletRequest(request).getParameter("selectedValue");
		
			for (ProposalOptionWrapper pow: proposalOptionList) {
				if (pow.propOption.getProposalOptionId() == Long.valueOf(selectedProposalOptionId)) {
					pow.propOption.setIncludeInProposal(Boolean.valueOf(selectedValue));
				}
				
				if (Boolean.valueOf(selectedValue) == false) {
					pow.propOption.setUseForCreditApp(false);
				}
			}	
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(proposalOptionList));
		}		
		super.serveResource(resourceRequest, resourceResponse);
	}
}