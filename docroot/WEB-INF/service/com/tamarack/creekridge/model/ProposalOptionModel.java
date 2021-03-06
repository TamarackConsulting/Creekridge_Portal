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

package com.tamarack.creekridge.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProposalOption service. Represents a row in the &quot;eCreekRidge_ProposalOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.ProposalOptionImpl}.
 * </p>
 *
 * @author Tamarack Consulting
 * @see ProposalOption
 * @see com.tamarack.creekridge.model.impl.ProposalOptionImpl
 * @see com.tamarack.creekridge.model.impl.ProposalOptionModelImpl
 * @generated
 */
public interface ProposalOptionModel extends AuditedModel,
	BaseModel<ProposalOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a proposal option model instance should use the {@link ProposalOption} interface instead.
	 */

	/**
	 * Returns the primary key of this proposal option.
	 *
	 * @return the primary key of this proposal option
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this proposal option.
	 *
	 * @param primaryKey the primary key of this proposal option
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the proposal option ID of this proposal option.
	 *
	 * @return the proposal option ID of this proposal option
	 */
	public long getProposalOptionId();

	/**
	 * Sets the proposal option ID of this proposal option.
	 *
	 * @param proposalOptionId the proposal option ID of this proposal option
	 */
	public void setProposalOptionId(long proposalOptionId);

	/**
	 * Returns the company ID of this proposal option.
	 *
	 * @return the company ID of this proposal option
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this proposal option.
	 *
	 * @param companyId the company ID of this proposal option
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this proposal option.
	 *
	 * @return the user ID of this proposal option
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this proposal option.
	 *
	 * @param userId the user ID of this proposal option
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this proposal option.
	 *
	 * @return the user uuid of this proposal option
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this proposal option.
	 *
	 * @param userUuid the user uuid of this proposal option
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this proposal option.
	 *
	 * @return the user name of this proposal option
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this proposal option.
	 *
	 * @param userName the user name of this proposal option
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this proposal option.
	 *
	 * @return the create date of this proposal option
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this proposal option.
	 *
	 * @param createDate the create date of this proposal option
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this proposal option.
	 *
	 * @return the modified date of this proposal option
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this proposal option.
	 *
	 * @param modifiedDate the modified date of this proposal option
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the credit app ID of this proposal option.
	 *
	 * @return the credit app ID of this proposal option
	 */
	public long getCreditAppId();

	/**
	 * Sets the credit app ID of this proposal option.
	 *
	 * @param creditAppId the credit app ID of this proposal option
	 */
	public void setCreditAppId(long creditAppId);

	/**
	 * Returns the product ID of this proposal option.
	 *
	 * @return the product ID of this proposal option
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this proposal option.
	 *
	 * @param productId the product ID of this proposal option
	 */
	public void setProductId(long productId);

	/**
	 * Returns the term ID of this proposal option.
	 *
	 * @return the term ID of this proposal option
	 */
	public long getTermId();

	/**
	 * Sets the term ID of this proposal option.
	 *
	 * @param termId the term ID of this proposal option
	 */
	public void setTermId(long termId);

	/**
	 * Returns the purchase option ID of this proposal option.
	 *
	 * @return the purchase option ID of this proposal option
	 */
	public long getPurchaseOptionId();

	/**
	 * Sets the purchase option ID of this proposal option.
	 *
	 * @param purchaseOptionId the purchase option ID of this proposal option
	 */
	public void setPurchaseOptionId(long purchaseOptionId);

	/**
	 * Returns the rate factor rule ID of this proposal option.
	 *
	 * @return the rate factor rule ID of this proposal option
	 */
	public long getRateFactorRuleId();

	/**
	 * Sets the rate factor rule ID of this proposal option.
	 *
	 * @param rateFactorRuleId the rate factor rule ID of this proposal option
	 */
	public void setRateFactorRuleId(long rateFactorRuleId);

	/**
	 * Returns the payment amount of this proposal option.
	 *
	 * @return the payment amount of this proposal option
	 */
	public double getPaymentAmount();

	/**
	 * Sets the payment amount of this proposal option.
	 *
	 * @param paymentAmount the payment amount of this proposal option
	 */
	public void setPaymentAmount(double paymentAmount);

	/**
	 * Returns the equipment price of this proposal option.
	 *
	 * @return the equipment price of this proposal option
	 */
	public double getEquipmentPrice();

	/**
	 * Sets the equipment price of this proposal option.
	 *
	 * @param equipmentPrice the equipment price of this proposal option
	 */
	public void setEquipmentPrice(double equipmentPrice);

	/**
	 * Returns the include in proposal of this proposal option.
	 *
	 * @return the include in proposal of this proposal option
	 */
	public boolean getIncludeInProposal();

	/**
	 * Returns <code>true</code> if this proposal option is include in proposal.
	 *
	 * @return <code>true</code> if this proposal option is include in proposal; <code>false</code> otherwise
	 */
	public boolean isIncludeInProposal();

	/**
	 * Sets whether this proposal option is include in proposal.
	 *
	 * @param includeInProposal the include in proposal of this proposal option
	 */
	public void setIncludeInProposal(boolean includeInProposal);

	/**
	 * Returns the use for credit app of this proposal option.
	 *
	 * @return the use for credit app of this proposal option
	 */
	public boolean getUseForCreditApp();

	/**
	 * Returns <code>true</code> if this proposal option is use for credit app.
	 *
	 * @return <code>true</code> if this proposal option is use for credit app; <code>false</code> otherwise
	 */
	public boolean isUseForCreditApp();

	/**
	 * Sets whether this proposal option is use for credit app.
	 *
	 * @param useForCreditApp the use for credit app of this proposal option
	 */
	public void setUseForCreditApp(boolean useForCreditApp);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ProposalOption proposalOption);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ProposalOption> toCacheModel();

	@Override
	public ProposalOption toEscapedModel();

	@Override
	public ProposalOption toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}