/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.tamarack.creekridge.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.service.CreditAppStatusLocalService;
import com.tamarack.creekridge.service.persistence.CreditAppBankReferencePersistence;
import com.tamarack.creekridge.service.persistence.CreditAppDocumentPersistence;
import com.tamarack.creekridge.service.persistence.CreditAppPersistence;
import com.tamarack.creekridge.service.persistence.CreditAppPrincipalPersistence;
import com.tamarack.creekridge.service.persistence.CreditAppStatusPersistence;
import com.tamarack.creekridge.service.persistence.ProductPersistence;
import com.tamarack.creekridge.service.persistence.ProposalOptionPersistence;
import com.tamarack.creekridge.service.persistence.PurchaseOptionPersistence;
import com.tamarack.creekridge.service.persistence.RateFactorRulePersistence;
import com.tamarack.creekridge.service.persistence.TermPersistence;
import com.tamarack.creekridge.service.persistence.VendorMessagePersistence;
import com.tamarack.creekridge.service.persistence.VendorPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the credit app status local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.tamarack.creekridge.service.impl.CreditAppStatusLocalServiceImpl}.
 * </p>
 *
 * @author tamarack
 * @see com.tamarack.creekridge.service.impl.CreditAppStatusLocalServiceImpl
 * @see com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil
 * @generated
 */
public abstract class CreditAppStatusLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CreditAppStatusLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil} to access the credit app status local service.
	 */

	/**
	 * Adds the credit app status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditAppStatus the credit app status
	 * @return the credit app status that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CreditAppStatus addCreditAppStatus(CreditAppStatus creditAppStatus)
		throws SystemException {
		creditAppStatus.setNew(true);

		return creditAppStatusPersistence.update(creditAppStatus);
	}

	/**
	 * Creates a new credit app status with the primary key. Does not add the credit app status to the database.
	 *
	 * @param CreditAppStatusId the primary key for the new credit app status
	 * @return the new credit app status
	 */
	@Override
	public CreditAppStatus createCreditAppStatus(long CreditAppStatusId) {
		return creditAppStatusPersistence.create(CreditAppStatusId);
	}

	/**
	 * Deletes the credit app status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CreditAppStatusId the primary key of the credit app status
	 * @return the credit app status that was removed
	 * @throws PortalException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CreditAppStatus deleteCreditAppStatus(long CreditAppStatusId)
		throws PortalException, SystemException {
		return creditAppStatusPersistence.remove(CreditAppStatusId);
	}

	/**
	 * Deletes the credit app status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditAppStatus the credit app status
	 * @return the credit app status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CreditAppStatus deleteCreditAppStatus(
		CreditAppStatus creditAppStatus) throws SystemException {
		return creditAppStatusPersistence.remove(creditAppStatus);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CreditAppStatus.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return creditAppStatusPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return creditAppStatusPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return creditAppStatusPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return creditAppStatusPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return creditAppStatusPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CreditAppStatus fetchCreditAppStatus(long CreditAppStatusId)
		throws SystemException {
		return creditAppStatusPersistence.fetchByPrimaryKey(CreditAppStatusId);
	}

	/**
	 * Returns the credit app status with the primary key.
	 *
	 * @param CreditAppStatusId the primary key of the credit app status
	 * @return the credit app status
	 * @throws PortalException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus getCreditAppStatus(long CreditAppStatusId)
		throws PortalException, SystemException {
		return creditAppStatusPersistence.findByPrimaryKey(CreditAppStatusId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return creditAppStatusPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the credit app statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app statuses
	 * @param end the upper bound of the range of credit app statuses (not inclusive)
	 * @return the range of credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppStatus> getCreditAppStatuses(int start, int end)
		throws SystemException {
		return creditAppStatusPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of credit app statuses.
	 *
	 * @return the number of credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCreditAppStatusesCount() throws SystemException {
		return creditAppStatusPersistence.countAll();
	}

	/**
	 * Updates the credit app status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param creditAppStatus the credit app status
	 * @return the credit app status that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CreditAppStatus updateCreditAppStatus(
		CreditAppStatus creditAppStatus) throws SystemException {
		return creditAppStatusPersistence.update(creditAppStatus);
	}

	/**
	 * Returns the credit app local service.
	 *
	 * @return the credit app local service
	 */
	public com.tamarack.creekridge.service.CreditAppLocalService getCreditAppLocalService() {
		return creditAppLocalService;
	}

	/**
	 * Sets the credit app local service.
	 *
	 * @param creditAppLocalService the credit app local service
	 */
	public void setCreditAppLocalService(
		com.tamarack.creekridge.service.CreditAppLocalService creditAppLocalService) {
		this.creditAppLocalService = creditAppLocalService;
	}

	/**
	 * Returns the credit app persistence.
	 *
	 * @return the credit app persistence
	 */
	public CreditAppPersistence getCreditAppPersistence() {
		return creditAppPersistence;
	}

	/**
	 * Sets the credit app persistence.
	 *
	 * @param creditAppPersistence the credit app persistence
	 */
	public void setCreditAppPersistence(
		CreditAppPersistence creditAppPersistence) {
		this.creditAppPersistence = creditAppPersistence;
	}

	/**
	 * Returns the credit app bank reference local service.
	 *
	 * @return the credit app bank reference local service
	 */
	public com.tamarack.creekridge.service.CreditAppBankReferenceLocalService getCreditAppBankReferenceLocalService() {
		return creditAppBankReferenceLocalService;
	}

	/**
	 * Sets the credit app bank reference local service.
	 *
	 * @param creditAppBankReferenceLocalService the credit app bank reference local service
	 */
	public void setCreditAppBankReferenceLocalService(
		com.tamarack.creekridge.service.CreditAppBankReferenceLocalService creditAppBankReferenceLocalService) {
		this.creditAppBankReferenceLocalService = creditAppBankReferenceLocalService;
	}

	/**
	 * Returns the credit app bank reference persistence.
	 *
	 * @return the credit app bank reference persistence
	 */
	public CreditAppBankReferencePersistence getCreditAppBankReferencePersistence() {
		return creditAppBankReferencePersistence;
	}

	/**
	 * Sets the credit app bank reference persistence.
	 *
	 * @param creditAppBankReferencePersistence the credit app bank reference persistence
	 */
	public void setCreditAppBankReferencePersistence(
		CreditAppBankReferencePersistence creditAppBankReferencePersistence) {
		this.creditAppBankReferencePersistence = creditAppBankReferencePersistence;
	}

	/**
	 * Returns the credit app document local service.
	 *
	 * @return the credit app document local service
	 */
	public com.tamarack.creekridge.service.CreditAppDocumentLocalService getCreditAppDocumentLocalService() {
		return creditAppDocumentLocalService;
	}

	/**
	 * Sets the credit app document local service.
	 *
	 * @param creditAppDocumentLocalService the credit app document local service
	 */
	public void setCreditAppDocumentLocalService(
		com.tamarack.creekridge.service.CreditAppDocumentLocalService creditAppDocumentLocalService) {
		this.creditAppDocumentLocalService = creditAppDocumentLocalService;
	}

	/**
	 * Returns the credit app document persistence.
	 *
	 * @return the credit app document persistence
	 */
	public CreditAppDocumentPersistence getCreditAppDocumentPersistence() {
		return creditAppDocumentPersistence;
	}

	/**
	 * Sets the credit app document persistence.
	 *
	 * @param creditAppDocumentPersistence the credit app document persistence
	 */
	public void setCreditAppDocumentPersistence(
		CreditAppDocumentPersistence creditAppDocumentPersistence) {
		this.creditAppDocumentPersistence = creditAppDocumentPersistence;
	}

	/**
	 * Returns the credit app principal local service.
	 *
	 * @return the credit app principal local service
	 */
	public com.tamarack.creekridge.service.CreditAppPrincipalLocalService getCreditAppPrincipalLocalService() {
		return creditAppPrincipalLocalService;
	}

	/**
	 * Sets the credit app principal local service.
	 *
	 * @param creditAppPrincipalLocalService the credit app principal local service
	 */
	public void setCreditAppPrincipalLocalService(
		com.tamarack.creekridge.service.CreditAppPrincipalLocalService creditAppPrincipalLocalService) {
		this.creditAppPrincipalLocalService = creditAppPrincipalLocalService;
	}

	/**
	 * Returns the credit app principal persistence.
	 *
	 * @return the credit app principal persistence
	 */
	public CreditAppPrincipalPersistence getCreditAppPrincipalPersistence() {
		return creditAppPrincipalPersistence;
	}

	/**
	 * Sets the credit app principal persistence.
	 *
	 * @param creditAppPrincipalPersistence the credit app principal persistence
	 */
	public void setCreditAppPrincipalPersistence(
		CreditAppPrincipalPersistence creditAppPrincipalPersistence) {
		this.creditAppPrincipalPersistence = creditAppPrincipalPersistence;
	}

	/**
	 * Returns the credit app status local service.
	 *
	 * @return the credit app status local service
	 */
	public com.tamarack.creekridge.service.CreditAppStatusLocalService getCreditAppStatusLocalService() {
		return creditAppStatusLocalService;
	}

	/**
	 * Sets the credit app status local service.
	 *
	 * @param creditAppStatusLocalService the credit app status local service
	 */
	public void setCreditAppStatusLocalService(
		com.tamarack.creekridge.service.CreditAppStatusLocalService creditAppStatusLocalService) {
		this.creditAppStatusLocalService = creditAppStatusLocalService;
	}

	/**
	 * Returns the credit app status persistence.
	 *
	 * @return the credit app status persistence
	 */
	public CreditAppStatusPersistence getCreditAppStatusPersistence() {
		return creditAppStatusPersistence;
	}

	/**
	 * Sets the credit app status persistence.
	 *
	 * @param creditAppStatusPersistence the credit app status persistence
	 */
	public void setCreditAppStatusPersistence(
		CreditAppStatusPersistence creditAppStatusPersistence) {
		this.creditAppStatusPersistence = creditAppStatusPersistence;
	}

	/**
	 * Returns the product local service.
	 *
	 * @return the product local service
	 */
	public com.tamarack.creekridge.service.ProductLocalService getProductLocalService() {
		return productLocalService;
	}

	/**
	 * Sets the product local service.
	 *
	 * @param productLocalService the product local service
	 */
	public void setProductLocalService(
		com.tamarack.creekridge.service.ProductLocalService productLocalService) {
		this.productLocalService = productLocalService;
	}

	/**
	 * Returns the product persistence.
	 *
	 * @return the product persistence
	 */
	public ProductPersistence getProductPersistence() {
		return productPersistence;
	}

	/**
	 * Sets the product persistence.
	 *
	 * @param productPersistence the product persistence
	 */
	public void setProductPersistence(ProductPersistence productPersistence) {
		this.productPersistence = productPersistence;
	}

	/**
	 * Returns the proposal option local service.
	 *
	 * @return the proposal option local service
	 */
	public com.tamarack.creekridge.service.ProposalOptionLocalService getProposalOptionLocalService() {
		return proposalOptionLocalService;
	}

	/**
	 * Sets the proposal option local service.
	 *
	 * @param proposalOptionLocalService the proposal option local service
	 */
	public void setProposalOptionLocalService(
		com.tamarack.creekridge.service.ProposalOptionLocalService proposalOptionLocalService) {
		this.proposalOptionLocalService = proposalOptionLocalService;
	}

	/**
	 * Returns the proposal option persistence.
	 *
	 * @return the proposal option persistence
	 */
	public ProposalOptionPersistence getProposalOptionPersistence() {
		return proposalOptionPersistence;
	}

	/**
	 * Sets the proposal option persistence.
	 *
	 * @param proposalOptionPersistence the proposal option persistence
	 */
	public void setProposalOptionPersistence(
		ProposalOptionPersistence proposalOptionPersistence) {
		this.proposalOptionPersistence = proposalOptionPersistence;
	}

	/**
	 * Returns the purchase option local service.
	 *
	 * @return the purchase option local service
	 */
	public com.tamarack.creekridge.service.PurchaseOptionLocalService getPurchaseOptionLocalService() {
		return purchaseOptionLocalService;
	}

	/**
	 * Sets the purchase option local service.
	 *
	 * @param purchaseOptionLocalService the purchase option local service
	 */
	public void setPurchaseOptionLocalService(
		com.tamarack.creekridge.service.PurchaseOptionLocalService purchaseOptionLocalService) {
		this.purchaseOptionLocalService = purchaseOptionLocalService;
	}

	/**
	 * Returns the purchase option persistence.
	 *
	 * @return the purchase option persistence
	 */
	public PurchaseOptionPersistence getPurchaseOptionPersistence() {
		return purchaseOptionPersistence;
	}

	/**
	 * Sets the purchase option persistence.
	 *
	 * @param purchaseOptionPersistence the purchase option persistence
	 */
	public void setPurchaseOptionPersistence(
		PurchaseOptionPersistence purchaseOptionPersistence) {
		this.purchaseOptionPersistence = purchaseOptionPersistence;
	}

	/**
	 * Returns the rate factor rule local service.
	 *
	 * @return the rate factor rule local service
	 */
	public com.tamarack.creekridge.service.RateFactorRuleLocalService getRateFactorRuleLocalService() {
		return rateFactorRuleLocalService;
	}

	/**
	 * Sets the rate factor rule local service.
	 *
	 * @param rateFactorRuleLocalService the rate factor rule local service
	 */
	public void setRateFactorRuleLocalService(
		com.tamarack.creekridge.service.RateFactorRuleLocalService rateFactorRuleLocalService) {
		this.rateFactorRuleLocalService = rateFactorRuleLocalService;
	}

	/**
	 * Returns the rate factor rule persistence.
	 *
	 * @return the rate factor rule persistence
	 */
	public RateFactorRulePersistence getRateFactorRulePersistence() {
		return rateFactorRulePersistence;
	}

	/**
	 * Sets the rate factor rule persistence.
	 *
	 * @param rateFactorRulePersistence the rate factor rule persistence
	 */
	public void setRateFactorRulePersistence(
		RateFactorRulePersistence rateFactorRulePersistence) {
		this.rateFactorRulePersistence = rateFactorRulePersistence;
	}

	/**
	 * Returns the term local service.
	 *
	 * @return the term local service
	 */
	public com.tamarack.creekridge.service.TermLocalService getTermLocalService() {
		return termLocalService;
	}

	/**
	 * Sets the term local service.
	 *
	 * @param termLocalService the term local service
	 */
	public void setTermLocalService(
		com.tamarack.creekridge.service.TermLocalService termLocalService) {
		this.termLocalService = termLocalService;
	}

	/**
	 * Returns the term persistence.
	 *
	 * @return the term persistence
	 */
	public TermPersistence getTermPersistence() {
		return termPersistence;
	}

	/**
	 * Sets the term persistence.
	 *
	 * @param termPersistence the term persistence
	 */
	public void setTermPersistence(TermPersistence termPersistence) {
		this.termPersistence = termPersistence;
	}

	/**
	 * Returns the vendor local service.
	 *
	 * @return the vendor local service
	 */
	public com.tamarack.creekridge.service.VendorLocalService getVendorLocalService() {
		return vendorLocalService;
	}

	/**
	 * Sets the vendor local service.
	 *
	 * @param vendorLocalService the vendor local service
	 */
	public void setVendorLocalService(
		com.tamarack.creekridge.service.VendorLocalService vendorLocalService) {
		this.vendorLocalService = vendorLocalService;
	}

	/**
	 * Returns the vendor persistence.
	 *
	 * @return the vendor persistence
	 */
	public VendorPersistence getVendorPersistence() {
		return vendorPersistence;
	}

	/**
	 * Sets the vendor persistence.
	 *
	 * @param vendorPersistence the vendor persistence
	 */
	public void setVendorPersistence(VendorPersistence vendorPersistence) {
		this.vendorPersistence = vendorPersistence;
	}

	/**
	 * Returns the vendor message local service.
	 *
	 * @return the vendor message local service
	 */
	public com.tamarack.creekridge.service.VendorMessageLocalService getVendorMessageLocalService() {
		return vendorMessageLocalService;
	}

	/**
	 * Sets the vendor message local service.
	 *
	 * @param vendorMessageLocalService the vendor message local service
	 */
	public void setVendorMessageLocalService(
		com.tamarack.creekridge.service.VendorMessageLocalService vendorMessageLocalService) {
		this.vendorMessageLocalService = vendorMessageLocalService;
	}

	/**
	 * Returns the vendor message persistence.
	 *
	 * @return the vendor message persistence
	 */
	public VendorMessagePersistence getVendorMessagePersistence() {
		return vendorMessagePersistence;
	}

	/**
	 * Sets the vendor message persistence.
	 *
	 * @param vendorMessagePersistence the vendor message persistence
	 */
	public void setVendorMessagePersistence(
		VendorMessagePersistence vendorMessagePersistence) {
		this.vendorMessagePersistence = vendorMessagePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.tamarack.creekridge.model.CreditAppStatus",
			creditAppStatusLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.tamarack.creekridge.model.CreditAppStatus");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return CreditAppStatus.class;
	}

	protected String getModelClassName() {
		return CreditAppStatus.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = creditAppStatusPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.tamarack.creekridge.service.CreditAppLocalService.class)
	protected com.tamarack.creekridge.service.CreditAppLocalService creditAppLocalService;
	@BeanReference(type = CreditAppPersistence.class)
	protected CreditAppPersistence creditAppPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.CreditAppBankReferenceLocalService.class)
	protected com.tamarack.creekridge.service.CreditAppBankReferenceLocalService creditAppBankReferenceLocalService;
	@BeanReference(type = CreditAppBankReferencePersistence.class)
	protected CreditAppBankReferencePersistence creditAppBankReferencePersistence;
	@BeanReference(type = com.tamarack.creekridge.service.CreditAppDocumentLocalService.class)
	protected com.tamarack.creekridge.service.CreditAppDocumentLocalService creditAppDocumentLocalService;
	@BeanReference(type = CreditAppDocumentPersistence.class)
	protected CreditAppDocumentPersistence creditAppDocumentPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.CreditAppPrincipalLocalService.class)
	protected com.tamarack.creekridge.service.CreditAppPrincipalLocalService creditAppPrincipalLocalService;
	@BeanReference(type = CreditAppPrincipalPersistence.class)
	protected CreditAppPrincipalPersistence creditAppPrincipalPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.CreditAppStatusLocalService.class)
	protected com.tamarack.creekridge.service.CreditAppStatusLocalService creditAppStatusLocalService;
	@BeanReference(type = CreditAppStatusPersistence.class)
	protected CreditAppStatusPersistence creditAppStatusPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.ProductLocalService.class)
	protected com.tamarack.creekridge.service.ProductLocalService productLocalService;
	@BeanReference(type = ProductPersistence.class)
	protected ProductPersistence productPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.ProposalOptionLocalService.class)
	protected com.tamarack.creekridge.service.ProposalOptionLocalService proposalOptionLocalService;
	@BeanReference(type = ProposalOptionPersistence.class)
	protected ProposalOptionPersistence proposalOptionPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.PurchaseOptionLocalService.class)
	protected com.tamarack.creekridge.service.PurchaseOptionLocalService purchaseOptionLocalService;
	@BeanReference(type = PurchaseOptionPersistence.class)
	protected PurchaseOptionPersistence purchaseOptionPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.RateFactorRuleLocalService.class)
	protected com.tamarack.creekridge.service.RateFactorRuleLocalService rateFactorRuleLocalService;
	@BeanReference(type = RateFactorRulePersistence.class)
	protected RateFactorRulePersistence rateFactorRulePersistence;
	@BeanReference(type = com.tamarack.creekridge.service.TermLocalService.class)
	protected com.tamarack.creekridge.service.TermLocalService termLocalService;
	@BeanReference(type = TermPersistence.class)
	protected TermPersistence termPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.VendorLocalService.class)
	protected com.tamarack.creekridge.service.VendorLocalService vendorLocalService;
	@BeanReference(type = VendorPersistence.class)
	protected VendorPersistence vendorPersistence;
	@BeanReference(type = com.tamarack.creekridge.service.VendorMessageLocalService.class)
	protected com.tamarack.creekridge.service.VendorMessageLocalService vendorMessageLocalService;
	@BeanReference(type = VendorMessagePersistence.class)
	protected VendorMessagePersistence vendorMessagePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CreditAppStatusLocalServiceClpInvoker _clpInvoker = new CreditAppStatusLocalServiceClpInvoker();
}