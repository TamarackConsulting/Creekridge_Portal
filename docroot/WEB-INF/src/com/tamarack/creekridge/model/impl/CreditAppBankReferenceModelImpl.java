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

package com.tamarack.creekridge.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppBankReferenceModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CreditAppBankReference service. Represents a row in the &quot;eCreekRidge_CreditAppBankReference&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.CreditAppBankReferenceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CreditAppBankReferenceImpl}.
 * </p>
 *
 * @author Tamarack Consulting
 * @see CreditAppBankReferenceImpl
 * @see com.tamarack.creekridge.model.CreditAppBankReference
 * @see com.tamarack.creekridge.model.CreditAppBankReferenceModel
 * @generated
 */
public class CreditAppBankReferenceModelImpl extends BaseModelImpl<CreditAppBankReference>
	implements CreditAppBankReferenceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a credit app bank reference model instance should use the {@link com.tamarack.creekridge.model.CreditAppBankReference} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_CreditAppBankReference";
	public static final Object[][] TABLE_COLUMNS = {
			{ "bankReferenceId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "creditAppId", Types.BIGINT },
			{ "sequenceNumber", Types.BIGINT },
			{ "bankReferenceName", Types.VARCHAR },
			{ "bankReferenceContact", Types.VARCHAR },
			{ "bankReferencePhone", Types.VARCHAR },
			{ "bankReferenceAccountType", Types.VARCHAR },
			{ "bankReferenceAccountNumber", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_CreditAppBankReference (bankReferenceId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creditAppId LONG,sequenceNumber LONG,bankReferenceName VARCHAR(75) null,bankReferenceContact VARCHAR(75) null,bankReferencePhone VARCHAR(75) null,bankReferenceAccountType VARCHAR(75) null,bankReferenceAccountNumber VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_CreditAppBankReference";
	public static final String ORDER_BY_JPQL = " ORDER BY creditAppBankReference.sequenceNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_CreditAppBankReference.sequenceNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.CreditAppBankReference"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.CreditAppBankReference"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.CreditAppBankReference"),
			true);
	public static long CREDITAPPID_COLUMN_BITMASK = 1L;
	public static long SEQUENCENUMBER_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.CreditAppBankReference"));

	public CreditAppBankReferenceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bankReferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBankReferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bankReferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppBankReference.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppBankReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bankReferenceId", getBankReferenceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("bankReferenceName", getBankReferenceName());
		attributes.put("bankReferenceContact", getBankReferenceContact());
		attributes.put("bankReferencePhone", getBankReferencePhone());
		attributes.put("bankReferenceAccountType", getBankReferenceAccountType());
		attributes.put("bankReferenceAccountNumber",
			getBankReferenceAccountNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bankReferenceId = (Long)attributes.get("bankReferenceId");

		if (bankReferenceId != null) {
			setBankReferenceId(bankReferenceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creditAppId = (Long)attributes.get("creditAppId");

		if (creditAppId != null) {
			setCreditAppId(creditAppId);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}

		String bankReferenceName = (String)attributes.get("bankReferenceName");

		if (bankReferenceName != null) {
			setBankReferenceName(bankReferenceName);
		}

		String bankReferenceContact = (String)attributes.get(
				"bankReferenceContact");

		if (bankReferenceContact != null) {
			setBankReferenceContact(bankReferenceContact);
		}

		String bankReferencePhone = (String)attributes.get("bankReferencePhone");

		if (bankReferencePhone != null) {
			setBankReferencePhone(bankReferencePhone);
		}

		String bankReferenceAccountType = (String)attributes.get(
				"bankReferenceAccountType");

		if (bankReferenceAccountType != null) {
			setBankReferenceAccountType(bankReferenceAccountType);
		}

		String bankReferenceAccountNumber = (String)attributes.get(
				"bankReferenceAccountNumber");

		if (bankReferenceAccountNumber != null) {
			setBankReferenceAccountNumber(bankReferenceAccountNumber);
		}
	}

	@Override
	public long getBankReferenceId() {
		return _bankReferenceId;
	}

	@Override
	public void setBankReferenceId(long bankReferenceId) {
		_bankReferenceId = bankReferenceId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCreditAppId() {
		return _creditAppId;
	}

	@Override
	public void setCreditAppId(long creditAppId) {
		_columnBitmask |= CREDITAPPID_COLUMN_BITMASK;

		if (!_setOriginalCreditAppId) {
			_setOriginalCreditAppId = true;

			_originalCreditAppId = _creditAppId;
		}

		_creditAppId = creditAppId;
	}

	public long getOriginalCreditAppId() {
		return _originalCreditAppId;
	}

	@Override
	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_columnBitmask = -1L;

		if (!_setOriginalSequenceNumber) {
			_setOriginalSequenceNumber = true;

			_originalSequenceNumber = _sequenceNumber;
		}

		_sequenceNumber = sequenceNumber;
	}

	public long getOriginalSequenceNumber() {
		return _originalSequenceNumber;
	}

	@Override
	public String getBankReferenceName() {
		if (_bankReferenceName == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankReferenceName;
		}
	}

	@Override
	public void setBankReferenceName(String bankReferenceName) {
		_bankReferenceName = bankReferenceName;
	}

	@Override
	public String getBankReferenceContact() {
		if (_bankReferenceContact == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankReferenceContact;
		}
	}

	@Override
	public void setBankReferenceContact(String bankReferenceContact) {
		_bankReferenceContact = bankReferenceContact;
	}

	@Override
	public String getBankReferencePhone() {
		if (_bankReferencePhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankReferencePhone;
		}
	}

	@Override
	public void setBankReferencePhone(String bankReferencePhone) {
		_bankReferencePhone = bankReferencePhone;
	}

	@Override
	public String getBankReferenceAccountType() {
		if (_bankReferenceAccountType == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankReferenceAccountType;
		}
	}

	@Override
	public void setBankReferenceAccountType(String bankReferenceAccountType) {
		_bankReferenceAccountType = bankReferenceAccountType;
	}

	@Override
	public String getBankReferenceAccountNumber() {
		if (_bankReferenceAccountNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankReferenceAccountNumber;
		}
	}

	@Override
	public void setBankReferenceAccountNumber(String bankReferenceAccountNumber) {
		_bankReferenceAccountNumber = bankReferenceAccountNumber;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CreditAppBankReference.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CreditAppBankReference toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CreditAppBankReference)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CreditAppBankReferenceImpl creditAppBankReferenceImpl = new CreditAppBankReferenceImpl();

		creditAppBankReferenceImpl.setBankReferenceId(getBankReferenceId());
		creditAppBankReferenceImpl.setCompanyId(getCompanyId());
		creditAppBankReferenceImpl.setUserId(getUserId());
		creditAppBankReferenceImpl.setUserName(getUserName());
		creditAppBankReferenceImpl.setCreateDate(getCreateDate());
		creditAppBankReferenceImpl.setModifiedDate(getModifiedDate());
		creditAppBankReferenceImpl.setCreditAppId(getCreditAppId());
		creditAppBankReferenceImpl.setSequenceNumber(getSequenceNumber());
		creditAppBankReferenceImpl.setBankReferenceName(getBankReferenceName());
		creditAppBankReferenceImpl.setBankReferenceContact(getBankReferenceContact());
		creditAppBankReferenceImpl.setBankReferencePhone(getBankReferencePhone());
		creditAppBankReferenceImpl.setBankReferenceAccountType(getBankReferenceAccountType());
		creditAppBankReferenceImpl.setBankReferenceAccountNumber(getBankReferenceAccountNumber());

		creditAppBankReferenceImpl.resetOriginalValues();

		return creditAppBankReferenceImpl;
	}

	@Override
	public int compareTo(CreditAppBankReference creditAppBankReference) {
		int value = 0;

		if (getSequenceNumber() < creditAppBankReference.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppBankReference.getSequenceNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppBankReference)) {
			return false;
		}

		CreditAppBankReference creditAppBankReference = (CreditAppBankReference)obj;

		long primaryKey = creditAppBankReference.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CreditAppBankReferenceModelImpl creditAppBankReferenceModelImpl = this;

		creditAppBankReferenceModelImpl._originalCreditAppId = creditAppBankReferenceModelImpl._creditAppId;

		creditAppBankReferenceModelImpl._setOriginalCreditAppId = false;

		creditAppBankReferenceModelImpl._originalSequenceNumber = creditAppBankReferenceModelImpl._sequenceNumber;

		creditAppBankReferenceModelImpl._setOriginalSequenceNumber = false;

		creditAppBankReferenceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CreditAppBankReference> toCacheModel() {
		CreditAppBankReferenceCacheModel creditAppBankReferenceCacheModel = new CreditAppBankReferenceCacheModel();

		creditAppBankReferenceCacheModel.bankReferenceId = getBankReferenceId();

		creditAppBankReferenceCacheModel.companyId = getCompanyId();

		creditAppBankReferenceCacheModel.userId = getUserId();

		creditAppBankReferenceCacheModel.userName = getUserName();

		String userName = creditAppBankReferenceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			creditAppBankReferenceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			creditAppBankReferenceCacheModel.createDate = createDate.getTime();
		}
		else {
			creditAppBankReferenceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			creditAppBankReferenceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			creditAppBankReferenceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		creditAppBankReferenceCacheModel.creditAppId = getCreditAppId();

		creditAppBankReferenceCacheModel.sequenceNumber = getSequenceNumber();

		creditAppBankReferenceCacheModel.bankReferenceName = getBankReferenceName();

		String bankReferenceName = creditAppBankReferenceCacheModel.bankReferenceName;

		if ((bankReferenceName != null) && (bankReferenceName.length() == 0)) {
			creditAppBankReferenceCacheModel.bankReferenceName = null;
		}

		creditAppBankReferenceCacheModel.bankReferenceContact = getBankReferenceContact();

		String bankReferenceContact = creditAppBankReferenceCacheModel.bankReferenceContact;

		if ((bankReferenceContact != null) &&
				(bankReferenceContact.length() == 0)) {
			creditAppBankReferenceCacheModel.bankReferenceContact = null;
		}

		creditAppBankReferenceCacheModel.bankReferencePhone = getBankReferencePhone();

		String bankReferencePhone = creditAppBankReferenceCacheModel.bankReferencePhone;

		if ((bankReferencePhone != null) && (bankReferencePhone.length() == 0)) {
			creditAppBankReferenceCacheModel.bankReferencePhone = null;
		}

		creditAppBankReferenceCacheModel.bankReferenceAccountType = getBankReferenceAccountType();

		String bankReferenceAccountType = creditAppBankReferenceCacheModel.bankReferenceAccountType;

		if ((bankReferenceAccountType != null) &&
				(bankReferenceAccountType.length() == 0)) {
			creditAppBankReferenceCacheModel.bankReferenceAccountType = null;
		}

		creditAppBankReferenceCacheModel.bankReferenceAccountNumber = getBankReferenceAccountNumber();

		String bankReferenceAccountNumber = creditAppBankReferenceCacheModel.bankReferenceAccountNumber;

		if ((bankReferenceAccountNumber != null) &&
				(bankReferenceAccountNumber.length() == 0)) {
			creditAppBankReferenceCacheModel.bankReferenceAccountNumber = null;
		}

		return creditAppBankReferenceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{bankReferenceId=");
		sb.append(getBankReferenceId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", creditAppId=");
		sb.append(getCreditAppId());
		sb.append(", sequenceNumber=");
		sb.append(getSequenceNumber());
		sb.append(", bankReferenceName=");
		sb.append(getBankReferenceName());
		sb.append(", bankReferenceContact=");
		sb.append(getBankReferenceContact());
		sb.append(", bankReferencePhone=");
		sb.append(getBankReferencePhone());
		sb.append(", bankReferenceAccountType=");
		sb.append(getBankReferenceAccountType());
		sb.append(", bankReferenceAccountNumber=");
		sb.append(getBankReferenceAccountNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppBankReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bankReferenceId</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditAppId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNumber</column-name><column-value><![CDATA[");
		sb.append(getSequenceNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceName</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceContact</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferencePhone</column-name><column-value><![CDATA[");
		sb.append(getBankReferencePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceAccountType</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceAccountType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceAccountNumber</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceAccountNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CreditAppBankReference.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CreditAppBankReference.class
		};
	private long _bankReferenceId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _originalCreditAppId;
	private boolean _setOriginalCreditAppId;
	private long _sequenceNumber;
	private long _originalSequenceNumber;
	private boolean _setOriginalSequenceNumber;
	private String _bankReferenceName;
	private String _bankReferenceContact;
	private String _bankReferencePhone;
	private String _bankReferenceAccountType;
	private String _bankReferenceAccountNumber;
	private long _columnBitmask;
	private CreditAppBankReference _escapedModel;
}