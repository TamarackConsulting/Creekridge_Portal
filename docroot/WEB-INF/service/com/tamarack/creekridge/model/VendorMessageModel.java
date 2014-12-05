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
 * The base model interface for the VendorMessage service. Represents a row in the &quot;eCreekRidge_VendorMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.VendorMessageImpl}.
 * </p>
 *
 * @author tamarack
 * @see VendorMessage
 * @see com.tamarack.creekridge.model.impl.VendorMessageImpl
 * @see com.tamarack.creekridge.model.impl.VendorMessageModelImpl
 * @generated
 */
public interface VendorMessageModel extends AuditedModel,
	BaseModel<VendorMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vendor message model instance should use the {@link VendorMessage} interface instead.
	 */

	/**
	 * Returns the primary key of this vendor message.
	 *
	 * @return the primary key of this vendor message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vendor message.
	 *
	 * @param primaryKey the primary key of this vendor message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the vendor ID of this vendor message.
	 *
	 * @return the vendor ID of this vendor message
	 */
	public long getVendorId();

	/**
	 * Sets the vendor ID of this vendor message.
	 *
	 * @param vendorId the vendor ID of this vendor message
	 */
	public void setVendorId(long vendorId);

	/**
	 * Returns the company ID of this vendor message.
	 *
	 * @return the company ID of this vendor message
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this vendor message.
	 *
	 * @param companyId the company ID of this vendor message
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this vendor message.
	 *
	 * @return the user ID of this vendor message
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this vendor message.
	 *
	 * @param userId the user ID of this vendor message
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this vendor message.
	 *
	 * @return the user uuid of this vendor message
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this vendor message.
	 *
	 * @param userUuid the user uuid of this vendor message
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this vendor message.
	 *
	 * @return the user name of this vendor message
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this vendor message.
	 *
	 * @param userName the user name of this vendor message
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this vendor message.
	 *
	 * @return the create date of this vendor message
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this vendor message.
	 *
	 * @param createDate the create date of this vendor message
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this vendor message.
	 *
	 * @return the modified date of this vendor message
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this vendor message.
	 *
	 * @param modifiedDate the modified date of this vendor message
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the key of this vendor message.
	 *
	 * @return the key of this vendor message
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this vendor message.
	 *
	 * @param key the key of this vendor message
	 */
	public void setKey(String key);

	/**
	 * Returns the value of this vendor message.
	 *
	 * @return the value of this vendor message
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this vendor message.
	 *
	 * @param value the value of this vendor message
	 */
	public void setValue(String value);

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
	public int compareTo(VendorMessage vendorMessage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VendorMessage> toCacheModel();

	@Override
	public VendorMessage toEscapedModel();

	@Override
	public VendorMessage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}