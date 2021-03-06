package com.tamarack.creekridge.liferay.paymentcalculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;

public class PaymentCalculatorQueryUtil {
	
	private static Log _log = LogFactory.getLog(PaymentCalculatorQueryUtil.class);

	public List<RateFactorRule> fetchRatefactorOption(String currentSelectedOptions, long vendorId)
			throws Exception {
		
		//main object passed from the page
		JSONObject options = JSONFactoryUtil.createJSONObject(currentSelectedOptions);
		JSONArray productIdList = options.getJSONArray("products");
		JSONArray purchaseOptionIdList = options.getJSONArray("purchaseOptions");
		
		List<RateFactorRule> rateFactorRuleList = new ArrayList <RateFactorRule> ();
	
		
		if (productIdList.length()>0 && purchaseOptionIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				for (int j = 0; j < purchaseOptionIdList.length(); j++) {
					rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByProductPurchaseOptionPrice(true, vendorId, productIdList.getLong(i),  purchaseOptionIdList.getLong(j), 
							options.getDouble("equipmentPrice")));
				}
			}
		} else if (productIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProductPrice(true, vendorId, productIdList.getLong(i),
						options.getDouble("equipmentPrice")));
			}
		}
		
		_log.info("fetchRatefactorOption list: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}
	
	public List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long productId, Long purchaseOptionId, Long termId, long eqPrice, long vendorId) throws Exception {

		
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProductOptionTermPrice(true, vendorId, productId, purchaseOptionId, termId, eqPrice);
		_log.info("fetchRatefactorOptionForCalculations fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}
	
	@SuppressWarnings("unchecked")
	public List <RateFactorRule> fetchActiveProductsForEquipmentPrice (long vendorId, double eqPrice) throws SystemException {
		List<RateFactorRule> rfrList = new ArrayList <RateFactorRule> ();
		_log.info("fetchActiveProductsForEquipmentPrice vendorId: " + vendorId);
		_log.info("fetchActiveProductsForEquipmentPrice eqPrice: " + eqPrice);
		
		DynamicQuery rfrQuery = DynamicQueryFactoryUtil.forClass(
				RateFactorRule.class, PortletClassLoaderUtil.getClassLoader());
		
		
		rfrQuery.add(PropertyFactoryUtil.forName("active").eq(true));
		rfrQuery.add(PropertyFactoryUtil.forName("vendorId").eq(vendorId));
		rfrQuery.add(PropertyFactoryUtil.forName("minPrice").le(eqPrice));
		
		
		rfrList = RateFactorRuleLocalServiceUtil.dynamicQuery(rfrQuery);
		_log.info("fetchActiveProductsForEquipmentPrice rfrList returned: " + rfrList);
		return rfrList;
		
	}
	
	public static ExpandoValue getExpandoValue (Group group, String fieldName) {
		try {
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(),  group.getClassNameId(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			ExpandoValue expando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), fieldName, group.getPrimaryKey());
			_log.info("getExpandoValue: " + expando);
			return expando;
			
		} catch (Exception e) {
			_log.error(e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List <Term> getTermsById (List <Long> termIds) throws SystemException {
		List <Term> terms = new ArrayList <Term> ();
		
		//create dynamic query
		DynamicQuery termDquery = DynamicQueryFactoryUtil.forClass(Term.class, PortletClassLoaderUtil.getClassLoader());
		termDquery.add(PropertyFactoryUtil.forName("termId").in((Collection<Long>) termIds));
		
		Order ascOrder = OrderFactoryUtil.asc("termMonths");
		termDquery.addOrder(ascOrder);
		
		terms = TermLocalServiceUtil.dynamicQuery(termDquery);
		_log.info("getTermsById returns " + terms.toString());
		return terms;
	}
}
