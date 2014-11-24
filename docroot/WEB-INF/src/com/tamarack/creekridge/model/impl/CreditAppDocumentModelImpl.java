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

import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.model.CreditAppDocumentModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CreditAppDocument service. Represents a row in the &quot;eCreekRidge_CreditAppDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.CreditAppDocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CreditAppDocumentImpl}.
 * </p>
 *
 * @author tamarack
 * @see CreditAppDocumentImpl
 * @see com.tamarack.creekridge.model.CreditAppDocument
 * @see com.tamarack.creekridge.model.CreditAppDocumentModel
 * @generated
 */
public class CreditAppDocumentModelImpl extends BaseModelImpl<CreditAppDocument>
	implements CreditAppDocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a credit app document model instance should use the {@link com.tamarack.creekridge.model.CreditAppDocument} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_CreditAppDocument";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CreditAppDocumentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "creditAppId", Types.BIGINT },
			{ "sequenceNumber", Types.BIGINT },
			{ "documentTitle", Types.VARCHAR },
			{ "documentFileName", Types.VARCHAR },
			{ "documentFileLocation", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_CreditAppDocument (CreditAppDocumentId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creditAppId LONG,sequenceNumber LONG,documentTitle VARCHAR(75) null,documentFileName VARCHAR(75) null,documentFileLocation VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_CreditAppDocument";
	public static final String ORDER_BY_JPQL = " ORDER BY creditAppDocument.sequenceNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_CreditAppDocument.sequenceNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.CreditAppDocument"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.CreditAppDocument"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.CreditAppDocument"),
			true);
	public static long CREDITAPPID_COLUMN_BITMASK = 1L;
	public static long SEQUENCENUMBER_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.CreditAppDocument"));

	public CreditAppDocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreditAppDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppDocument.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CreditAppDocumentId", getCreditAppDocumentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("documentTitle", getDocumentTitle());
		attributes.put("documentFileName", getDocumentFileName());
		attributes.put("documentFileLocation", getDocumentFileLocation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CreditAppDocumentId = (Long)attributes.get("CreditAppDocumentId");

		if (CreditAppDocumentId != null) {
			setCreditAppDocumentId(CreditAppDocumentId);
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

		String documentTitle = (String)attributes.get("documentTitle");

		if (documentTitle != null) {
			setDocumentTitle(documentTitle);
		}

		String documentFileName = (String)attributes.get("documentFileName");

		if (documentFileName != null) {
			setDocumentFileName(documentFileName);
		}

		String documentFileLocation = (String)attributes.get(
				"documentFileLocation");

		if (documentFileLocation != null) {
			setDocumentFileLocation(documentFileLocation);
		}
	}

	@Override
	public long getCreditAppDocumentId() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setCreditAppDocumentId(long CreditAppDocumentId) {
		_CreditAppDocumentId = CreditAppDocumentId;
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
	public String getDocumentTitle() {
		if (_documentTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _documentTitle;
		}
	}

	@Override
	public void setDocumentTitle(String documentTitle) {
		_documentTitle = documentTitle;
	}

	@Override
	public String getDocumentFileName() {
		if (_documentFileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _documentFileName;
		}
	}

	@Override
	public void setDocumentFileName(String documentFileName) {
		_documentFileName = documentFileName;
	}

	@Override
	public String getDocumentFileLocation() {
		if (_documentFileLocation == null) {
			return StringPool.BLANK;
		}
		else {
			return _documentFileLocation;
		}
	}

	@Override
	public void setDocumentFileLocation(String documentFileLocation) {
		_documentFileLocation = documentFileLocation;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CreditAppDocument.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CreditAppDocument toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CreditAppDocument)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CreditAppDocumentImpl creditAppDocumentImpl = new CreditAppDocumentImpl();

		creditAppDocumentImpl.setCreditAppDocumentId(getCreditAppDocumentId());
		creditAppDocumentImpl.setCompanyId(getCompanyId());
		creditAppDocumentImpl.setUserId(getUserId());
		creditAppDocumentImpl.setUserName(getUserName());
		creditAppDocumentImpl.setCreateDate(getCreateDate());
		creditAppDocumentImpl.setModifiedDate(getModifiedDate());
		creditAppDocumentImpl.setCreditAppId(getCreditAppId());
		creditAppDocumentImpl.setSequenceNumber(getSequenceNumber());
		creditAppDocumentImpl.setDocumentTitle(getDocumentTitle());
		creditAppDocumentImpl.setDocumentFileName(getDocumentFileName());
		creditAppDocumentImpl.setDocumentFileLocation(getDocumentFileLocation());

		creditAppDocumentImpl.resetOriginalValues();

		return creditAppDocumentImpl;
	}

	@Override
	public int compareTo(CreditAppDocument creditAppDocument) {
		int value = 0;

		if (getSequenceNumber() < creditAppDocument.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppDocument.getSequenceNumber()) {
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

		if (!(obj instanceof CreditAppDocument)) {
			return false;
		}

		CreditAppDocument creditAppDocument = (CreditAppDocument)obj;

		long primaryKey = creditAppDocument.getPrimaryKey();

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
		CreditAppDocumentModelImpl creditAppDocumentModelImpl = this;

		creditAppDocumentModelImpl._originalCreditAppId = creditAppDocumentModelImpl._creditAppId;

		creditAppDocumentModelImpl._setOriginalCreditAppId = false;

		creditAppDocumentModelImpl._originalSequenceNumber = creditAppDocumentModelImpl._sequenceNumber;

		creditAppDocumentModelImpl._setOriginalSequenceNumber = false;

		creditAppDocumentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CreditAppDocument> toCacheModel() {
		CreditAppDocumentCacheModel creditAppDocumentCacheModel = new CreditAppDocumentCacheModel();

		creditAppDocumentCacheModel.CreditAppDocumentId = getCreditAppDocumentId();

		creditAppDocumentCacheModel.companyId = getCompanyId();

		creditAppDocumentCacheModel.userId = getUserId();

		creditAppDocumentCacheModel.userName = getUserName();

		String userName = creditAppDocumentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			creditAppDocumentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			creditAppDocumentCacheModel.createDate = createDate.getTime();
		}
		else {
			creditAppDocumentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			creditAppDocumentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			creditAppDocumentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		creditAppDocumentCacheModel.creditAppId = getCreditAppId();

		creditAppDocumentCacheModel.sequenceNumber = getSequenceNumber();

		creditAppDocumentCacheModel.documentTitle = getDocumentTitle();

		String documentTitle = creditAppDocumentCacheModel.documentTitle;

		if ((documentTitle != null) && (documentTitle.length() == 0)) {
			creditAppDocumentCacheModel.documentTitle = null;
		}

		creditAppDocumentCacheModel.documentFileName = getDocumentFileName();

		String documentFileName = creditAppDocumentCacheModel.documentFileName;

		if ((documentFileName != null) && (documentFileName.length() == 0)) {
			creditAppDocumentCacheModel.documentFileName = null;
		}

		creditAppDocumentCacheModel.documentFileLocation = getDocumentFileLocation();

		String documentFileLocation = creditAppDocumentCacheModel.documentFileLocation;

		if ((documentFileLocation != null) &&
				(documentFileLocation.length() == 0)) {
			creditAppDocumentCacheModel.documentFileLocation = null;
		}

		return creditAppDocumentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{CreditAppDocumentId=");
		sb.append(getCreditAppDocumentId());
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
		sb.append(", documentTitle=");
		sb.append(getDocumentTitle());
		sb.append(", documentFileName=");
		sb.append(getDocumentFileName());
		sb.append(", documentFileLocation=");
		sb.append(getDocumentFileLocation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CreditAppDocumentId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppDocumentId());
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
			"<column><column-name>documentTitle</column-name><column-value><![CDATA[");
		sb.append(getDocumentTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileName</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileLocation</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileLocation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CreditAppDocument.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CreditAppDocument.class
		};
	private long _CreditAppDocumentId;
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
	private String _documentTitle;
	private String _documentFileName;
	private String _documentFileLocation;
	private long _columnBitmask;
	private CreditAppDocument _escapedModel;
}