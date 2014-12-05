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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RateFactorRule service. Represents a row in the &quot;eCreekRidge_RateFactorRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.RateFactorRuleImpl}.
 * </p>
 *
 * @author tamarack
 * @see RateFactorRule
 * @see com.tamarack.creekridge.model.impl.RateFactorRuleImpl
 * @see com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl
 * @generated
 */
public interface RateFactorRuleModel extends BaseModel<RateFactorRule>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rate factor rule model instance should use the {@link RateFactorRule} interface instead.
	 */

	/**
	 * Returns the primary key of this rate factor rule.
	 *
	 * @return the primary key of this rate factor rule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rate factor rule.
	 *
	 * @param primaryKey the primary key of this rate factor rule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the rate factor rule ID of this rate factor rule.
	 *
	 * @return the rate factor rule ID of this rate factor rule
	 */
	public long getRateFactorRuleId();

	/**
	 * Sets the rate factor rule ID of this rate factor rule.
	 *
	 * @param rateFactorRuleId the rate factor rule ID of this rate factor rule
	 */
	public void setRateFactorRuleId(long rateFactorRuleId);

	/**
	 * Returns the company ID of this rate factor rule.
	 *
	 * @return the company ID of this rate factor rule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this rate factor rule.
	 *
	 * @param companyId the company ID of this rate factor rule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this rate factor rule.
	 *
	 * @return the user ID of this rate factor rule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this rate factor rule.
	 *
	 * @param userId the user ID of this rate factor rule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this rate factor rule.
	 *
	 * @return the user uuid of this rate factor rule
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this rate factor rule.
	 *
	 * @param userUuid the user uuid of this rate factor rule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this rate factor rule.
	 *
	 * @return the group ID of this rate factor rule
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this rate factor rule.
	 *
	 * @param groupId the group ID of this rate factor rule
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user name of this rate factor rule.
	 *
	 * @return the user name of this rate factor rule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this rate factor rule.
	 *
	 * @param userName the user name of this rate factor rule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this rate factor rule.
	 *
	 * @return the create date of this rate factor rule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this rate factor rule.
	 *
	 * @param createDate the create date of this rate factor rule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this rate factor rule.
	 *
	 * @return the modified date of this rate factor rule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this rate factor rule.
	 *
	 * @param modifiedDate the modified date of this rate factor rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the product ID of this rate factor rule.
	 *
	 * @return the product ID of this rate factor rule
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this rate factor rule.
	 *
	 * @param productId the product ID of this rate factor rule
	 */
	public void setProductId(long productId);

	/**
	 * Returns the term ID of this rate factor rule.
	 *
	 * @return the term ID of this rate factor rule
	 */
	public long getTermId();

	/**
	 * Sets the term ID of this rate factor rule.
	 *
	 * @param termId the term ID of this rate factor rule
	 */
	public void setTermId(long termId);

	/**
	 * Returns the purchase option ID of this rate factor rule.
	 *
	 * @return the purchase option ID of this rate factor rule
	 */
	public long getPurchaseOptionId();

	/**
	 * Sets the purchase option ID of this rate factor rule.
	 *
	 * @param purchaseOptionId the purchase option ID of this rate factor rule
	 */
	public void setPurchaseOptionId(long purchaseOptionId);

	/**
	 * Returns the vendor ID of this rate factor rule.
	 *
	 * @return the vendor ID of this rate factor rule
	 */
	public long getVendorId();

	/**
	 * Sets the vendor ID of this rate factor rule.
	 *
	 * @param vendorId the vendor ID of this rate factor rule
	 */
	public void setVendorId(long vendorId);

	/**
	 * Returns the min price of this rate factor rule.
	 *
	 * @return the min price of this rate factor rule
	 */
	public double getMinPrice();

	/**
	 * Sets the min price of this rate factor rule.
	 *
	 * @param minPrice the min price of this rate factor rule
	 */
	public void setMinPrice(double minPrice);

	/**
	 * Returns the rate factor of this rate factor rule.
	 *
	 * @return the rate factor of this rate factor rule
	 */
	public double getRateFactor();

	/**
	 * Sets the rate factor of this rate factor rule.
	 *
	 * @param rateFactor the rate factor of this rate factor rule
	 */
	public void setRateFactor(double rateFactor);

	/**
	 * Returns the effective date of this rate factor rule.
	 *
	 * @return the effective date of this rate factor rule
	 */
	public Date getEffectiveDate();

	/**
	 * Sets the effective date of this rate factor rule.
	 *
	 * @param effectiveDate the effective date of this rate factor rule
	 */
	public void setEffectiveDate(Date effectiveDate);

	/**
	 * Returns the active of this rate factor rule.
	 *
	 * @return the active of this rate factor rule
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this rate factor rule is active.
	 *
	 * @return <code>true</code> if this rate factor rule is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this rate factor rule is active.
	 *
	 * @param active the active of this rate factor rule
	 */
	public void setActive(boolean active);

	/**
	 * Returns the expiration date of this rate factor rule.
	 *
	 * @return the expiration date of this rate factor rule
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this rate factor rule.
	 *
	 * @param expirationDate the expiration date of this rate factor rule
	 */
	public void setExpirationDate(Date expirationDate);

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
	public int compareTo(RateFactorRule rateFactorRule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<RateFactorRule> toCacheModel();

	@Override
	public RateFactorRule toEscapedModel();

	@Override
	public RateFactorRule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}