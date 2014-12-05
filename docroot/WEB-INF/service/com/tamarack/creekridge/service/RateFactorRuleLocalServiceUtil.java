/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.tamarack.creekridge.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RateFactorRule. This utility wraps
 * {@link com.tamarack.creekridge.service.impl.RateFactorRuleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tamarack
 * @see RateFactorRuleLocalService
 * @see com.tamarack.creekridge.service.base.RateFactorRuleLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.impl.RateFactorRuleLocalServiceImpl
 * @generated
 */
public class RateFactorRuleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.tamarack.creekridge.service.impl.RateFactorRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rate factor rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule addRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRateFactorRule(rateFactorRule);
	}

	/**
	* Creates a new rate factor rule with the primary key. Does not add the rate factor rule to the database.
	*
	* @param rateFactorRuleId the primary key for the new rate factor rule
	* @return the new rate factor rule
	*/
	public static com.tamarack.creekridge.model.RateFactorRule createRateFactorRule(
		long rateFactorRuleId) {
		return getService().createRateFactorRule(rateFactorRuleId);
	}

	/**
	* Deletes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule that was removed
	* @throws PortalException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule deleteRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRateFactorRule(rateFactorRuleId);
	}

	/**
	* Deletes the rate factor rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule deleteRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRateFactorRule(rateFactorRule);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.tamarack.creekridge.model.RateFactorRule fetchRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRateFactorRule(rateFactorRuleId);
	}

	/**
	* Returns the rate factor rule with the primary key.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule
	* @throws PortalException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule getRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRateFactorRule(rateFactorRuleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rate factor rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> getRateFactorRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRateFactorRules(start, end);
	}

	/**
	* Returns the number of rate factor rules.
	*
	* @return the number of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int getRateFactorRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRateFactorRulesCount();
	}

	/**
	* Updates the rate factor rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule updateRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRateFactorRule(rateFactorRule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> getActiveRateFactorRuleByGroupId(
		long groupId) throws java.lang.Exception {
		return getService().getActiveRateFactorRuleByGroupId(groupId);
	}

	public static com.tamarack.creekridge.model.RateFactorRule getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(
		long vendorId, boolean active, long productId, long termId,
		long purchaseOptionId) throws java.lang.Exception {
		return getService()
				   .getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(vendorId,
			active, productId, termId, purchaseOptionId);
	}

	public static com.tamarack.creekridge.model.RateFactorRule getRateFactorRuleByMatchingEquipmentPrice(
		long vendorId, boolean active, long productId, long termId,
		long purchaseOptionId, double equipmentPrice)
		throws java.lang.Exception {
		return getService()
				   .getRateFactorRuleByMatchingEquipmentPrice(vendorId, active,
			productId, termId, purchaseOptionId, equipmentPrice);
	}

	public static void clearService() {
		_service = null;
	}

	public static RateFactorRuleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RateFactorRuleLocalService.class.getName());

			if (invokableLocalService instanceof RateFactorRuleLocalService) {
				_service = (RateFactorRuleLocalService)invokableLocalService;
			}
			else {
				_service = new RateFactorRuleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RateFactorRuleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RateFactorRuleLocalService service) {
	}

	private static RateFactorRuleLocalService _service;
}