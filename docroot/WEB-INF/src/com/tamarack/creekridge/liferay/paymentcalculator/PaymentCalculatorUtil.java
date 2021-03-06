/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 * @desctiption Utility class for getting different lists for the page
 */

package com.tamarack.creekridge.liferay.paymentcalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.tamarack.creekridge.managedocument.ManageDocumentUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalService;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;




public class PaymentCalculatorUtil {
	
	private static Log _log = LogFactory.getLog(PaymentCalculatorUtil.class);
	
	public static Double getDoubleFromCurrency (String currencyString) {
		String newPrice = currencyString.replaceAll("[^\\d.]+", "");
		return Double.parseDouble(newPrice);
	}
	
	public static long getLongFromCurrency (String currencyString) {
		return getDoubleFromCurrency (currencyString).longValue();
	}
	
	public static CreditApp populateAppFromRequest (ActionRequest actionRequest, CreditApp creditApp) {
		
		//map form fields to the application
		
		creditApp.setEquipmentPrice(getDoubleFromCurrency(ParamUtil.getString(actionRequest, "equipmentPrice")));
		creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
		creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
		creditApp.setCustomerBusinessDesc(ParamUtil.getString(actionRequest,"customerBusinessDesc"));
		creditApp.setCustomerBusinessFederalTaxID(ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
		creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date busStartDate=ParamUtil.getDate(actionRequest,"customerBusinessStartDate", dateFormat);
		creditApp.setCustomerBusinessStartDate(busStartDate);
		creditApp.setCustomerBusinessType(ParamUtil.getString(actionRequest,"customerBusinessType"));
		creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
		creditApp.setCustomerAddress1(ParamUtil.getString(actionRequest,"customerAddress1"));
		creditApp.setCustomerAddress2(ParamUtil.getString(actionRequest,"customerAddress2"));
		
		creditApp.setCustomerState(ParamUtil.getString(actionRequest,"customerState"));
		creditApp.setCustomerCity(ParamUtil.getString(actionRequest,"customerCity"));
		creditApp.setCustomerZip(ParamUtil.getString(actionRequest,"customerZip"));
		
		//equipment info
		if(actionRequest.getParameter("equipmentLocAsCustomerFlag") != null)
			creditApp.setEquipmentLocAsCustomerFlag(ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
		
		_log.info("equipmentLocAsCustomerFlag = " + creditApp.getEquipmentLocAsCustomerFlag());
		
		if (!creditApp.getEquipmentLocAsCustomerFlag()) {
			creditApp.setEquipmentAddress1(ParamUtil.getString(actionRequest,"equipmentAddress1"));
			creditApp.setEquipmentAddress2(ParamUtil.getString(actionRequest,"equipmentAddress2"));
			creditApp.setEquipmentState(ParamUtil.getString(actionRequest,"equipmentState"));
			creditApp.setEquipmentCity(ParamUtil.getString(actionRequest,"equipmentCity"));
			creditApp.setEquipmentZip(ParamUtil.getString(actionRequest,"equipmentZip"));
			
		} else {
			creditApp.setEquipmentAddress1(creditApp.getCustomerAddress1());
			creditApp.setEquipmentAddress2(creditApp.getCustomerAddress2());
			creditApp.setEquipmentState(creditApp.getCustomerState());
			creditApp.setEquipmentCity(creditApp.getCustomerCity());
			creditApp.setEquipmentZip(creditApp.getCustomerZip());	
		}
		
		creditApp.setEquipmentDesc(ParamUtil.getString(actionRequest,"equipmentDesc"));
		
		
		
		creditApp.setCustomerContact(ParamUtil.getString(actionRequest,"customerContact"));
		creditApp.setCustomerContactPhone(ParamUtil.getString(actionRequest,"customerContactPhone"));
		creditApp.setCustomerContactFax(ParamUtil.getString(actionRequest,"customerContactFax"));
		creditApp.setCustomerContactEmail(ParamUtil.getString(actionRequest,"customerContactEmail"));
		//_log.info ("populateAppFromRequest: " + creditApp);
		return creditApp;
	}
	
	
	
	public static CreditAppBankReference populateBankReferenceFromJsonString (String referenceJson, CreditAppBankReference reference) throws JSONException {
		JSONObject referenceJObj = JSONFactoryUtil.createJSONObject(referenceJson);
		reference.setCreditAppId(Long.valueOf(referenceJObj.getString("creditAppId")));
		reference.setBankReferenceName(referenceJObj.getString("bankReferenceName"));
		reference.setBankReferenceContact(referenceJObj.getString("bankReferenceContact"));
		reference.setBankReferencePhone(referenceJObj.getString("bankReferencePhone"));
		reference.setBankReferenceAccountType(referenceJObj.getString("bankReferenceAccountType"));
		reference.setBankReferenceAccountNumber(referenceJObj.getString("bankReferenceAccountNumber"));
		
		return reference;
	}	
	
	public static CreditAppPrincipal populatePrincipalFromJsonString (String principalJson, CreditAppPrincipal principal) throws JSONException {
	
			JSONObject principalJObj = JSONFactoryUtil.createJSONObject(principalJson);
			
			principal.setCreditAppId(Long.valueOf(principalJObj.getString("creditAppId")));
			principal.setPrincipalFirstName(principalJObj.getString("principalFirstName"));
			principal.setPrincipalMiddleName(principalJObj.getString("principalMiddleName"));
			principal.setPrincipalLastName(principalJObj.getString("principalLastName"));
			principal.setPrincipalSSN(principalJObj.getString("principalSSN"));
			principal.setPrincipalHomePhoneNumber(principalJObj.getString("principalHomePhoneNumber"));
			principal.setPrincipalAddress1(principalJObj.getString("principalAddress1"));
			principal.setPrincipalAddress2(principalJObj.getString("principalAddress2"));
			principal.setPrincipalCity(principalJObj.getString("principalCity"));
			principal.setPrincipalState(principalJObj.getString("principalState"));
			principal.setPrincipalZip(principalJObj.getString("principalZip"));
			principal.setPrincipalEmail(principalJObj.getString("principalEmail"));
			
		return principal;
		
	}
	
	public static void generateCreditAppXML(CreditApp creditApp, String path) {
		
		_log.info("generateCreditAppXML running...");
		
		String creditAppXML = "";
		creditAppXML += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		creditAppXML += "<CreditApp>";
		creditAppXML += creditApp.toXmlString();
		
		
		
		
		try {
			
			//PRINCIPALS
			
			creditAppXML += "<CreditAppPrincipals>";
			
			List<CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
			
			_log.info("generateCreditAppXML principals" + principals.toString());
			
			if (principals != null && !principals.isEmpty()) {
				for (CreditAppPrincipal principal : principals) {
					creditAppXML += principal.toXmlString();
				}
			}

			creditAppXML += "</CreditAppPrincipals>";
			
			//REFS
			
			creditAppXML += "<CreditAppBankReferences>";
			
			List<CreditAppBankReference> bankReferences = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
			_log.info("generateCreditAppXML bankReferences" + bankReferences.toString());
			if (bankReferences != null && !bankReferences.isEmpty()) {
				for (CreditAppBankReference bankReference : bankReferences) {
					creditAppXML += bankReference.toXmlString();
				}
			}
			
			creditAppXML += "</CreditAppBankReferences>";
			
			//PURCHASE OPTIONS
			creditAppXML += "<PurchaseOption>";
			
			PurchaseOption purchaseOption = PurchaseOptionLocalServiceUtil.getPurchaseOption(creditApp.getPurchaseOptionId());
			_log.info("generateCreditAppXML purchaseOption" + purchaseOption);
			if (purchaseOption != null)
				creditAppXML += purchaseOption.toXmlString();
			
			creditAppXML += "</PurchaseOption>";
			
			//TERMS
			creditAppXML += "<Term>";
			
			Term term = TermLocalServiceUtil.getTerm(creditApp.getTermId());
			_log.info("generateCreditAppXML term" + term);
			if (term != null)
				creditAppXML += term.toXmlString();
			
			creditAppXML += "</Term>";
			
			
			//PRODUCTS
			creditAppXML += "<Product>";
			
			Product product = ProductLocalServiceUtil.getProduct(creditApp.getProductId());
			_log.info("generateCreditAppXML product" + product);
			if (product != null)
				creditAppXML += product.toXmlString();
			
			creditAppXML += "</Product>";
			
			
			//RATE FACTOR RULES
			creditAppXML += "<RateFactorRule>";
			
			RateFactorRule rateFactorRule = RateFactorRuleLocalServiceUtil.getRateFactorRule(creditApp.getRateFactorRuleId());
			_log.info("generateCreditAppXML rateFactorRule" + rateFactorRule);
			if (rateFactorRule != null)
				creditAppXML += rateFactorRule.toXmlString();
			
			creditAppXML += "</RateFactorRule>";
			
			//VENDOR
			creditAppXML += "<Vendor>";
			
			try {
				Group group = GroupLocalServiceUtil.getGroup(creditApp.getVendorId());
				_log.info("generateCreditAppXML group" + group);
				ExpandoBridge bridge = group.getExpandoBridge();
				_log.info("generateCreditAppXML bridge" + bridge);
				
				
				creditAppXML += "<model><model-name>com.liferay.portal.model.Group</model-name>";
				creditAppXML += "<column><column-name>VendorName</column-name><column-value><![CDATA[";
				creditAppXML += group.getName();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "<column><column-name>VendorAddress</column-name><column-value><![CDATA[";
				creditAppXML += ManageDocumentUtil.getExpandoValue(group, "Vendor Address").getData() + " " + ManageDocumentUtil.getExpandoValue(group, "Vendor Address 2").getData();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "<column><column-name>VendorCity</column-name><column-value><![CDATA[";
				creditAppXML += ManageDocumentUtil.getExpandoValue(group, "Vendor City").getData();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "<column><column-name>VendorState</column-name><column-value><![CDATA[";
				creditAppXML += ManageDocumentUtil.getExpandoValue(group, "Vendor State").getData();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "<column><column-name>VendorZipCode</column-name><column-value><![CDATA[";
				creditAppXML += ManageDocumentUtil.getExpandoValue(group, "Vendor Zip Code").getData();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "<column><column-name>VendorPhone</column-name><column-value><![CDATA[";
				creditAppXML += ManageDocumentUtil.getExpandoValue(group, "Vendor Phone").getData();
				creditAppXML += "]]></column-value></column>";
				creditAppXML += "</model>";
			} catch (Exception ex) {
				_log.error("generateCreditAppXML error while getting vendor info. Please check custom fields for Vendor Info");
			}
			
			creditAppXML += "</Vendor>";
			
			
			
			creditAppXML += "</CreditApp>";
			//CREDIT APP END
			
			
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmm");
			String fileName = "..\\..\\..\\creditApps\\creditApp_" + creditApp.getCustomerName()  + "_" +  dateFormat.format(new Date()) + ".xml";
			File generatedFile = new File(path + fileName);
	        FileWriter fileWriter = new FileWriter(generatedFile);
	        fileWriter.write(creditAppXML);
	        fileWriter.close();
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}
		catch (Exception e) {
			_log.error("generateCreditAppXML generic exception " + e);
		}
	}
}
