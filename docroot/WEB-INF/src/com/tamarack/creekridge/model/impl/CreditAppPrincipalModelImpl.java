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

import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppPrincipalModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CreditAppPrincipal service. Represents a row in the &quot;eCreekRidge_CreditAppPrincipal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.CreditAppPrincipalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CreditAppPrincipalImpl}.
 * </p>
 *
 * @author tamarack
 * @see CreditAppPrincipalImpl
 * @see com.tamarack.creekridge.model.CreditAppPrincipal
 * @see com.tamarack.creekridge.model.CreditAppPrincipalModel
 * @generated
 */
public class CreditAppPrincipalModelImpl extends BaseModelImpl<CreditAppPrincipal>
	implements CreditAppPrincipalModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a credit app principal model instance should use the {@link com.tamarack.creekridge.model.CreditAppPrincipal} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_CreditAppPrincipal";
	public static final Object[][] TABLE_COLUMNS = {
			{ "principalId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "creditAppId", Types.BIGINT },
			{ "sequenceNumber", Types.BIGINT },
			{ "principalFirstName", Types.VARCHAR },
			{ "principalMiddleName", Types.VARCHAR },
			{ "principalLastName", Types.VARCHAR },
			{ "principalSSN", Types.VARCHAR },
			{ "principalHomePhoneNumber", Types.VARCHAR },
			{ "principalAddress1", Types.VARCHAR },
			{ "principalAddress2", Types.VARCHAR },
			{ "principalCity", Types.VARCHAR },
			{ "principalState", Types.VARCHAR },
			{ "principalZip", Types.VARCHAR },
			{ "principalEmail", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_CreditAppPrincipal (principalId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creditAppId LONG,sequenceNumber LONG,principalFirstName VARCHAR(75) null,principalMiddleName VARCHAR(75) null,principalLastName VARCHAR(75) null,principalSSN VARCHAR(75) null,principalHomePhoneNumber VARCHAR(75) null,principalAddress1 VARCHAR(75) null,principalAddress2 VARCHAR(75) null,principalCity VARCHAR(75) null,principalState VARCHAR(75) null,principalZip VARCHAR(75) null,principalEmail VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_CreditAppPrincipal";
	public static final String ORDER_BY_JPQL = " ORDER BY creditAppPrincipal.principalFirstName ASC, creditAppPrincipal.sequenceNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_CreditAppPrincipal.principalFirstName ASC, eCreekRidge_CreditAppPrincipal.sequenceNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.CreditAppPrincipal"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.CreditAppPrincipal"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.CreditAppPrincipal"),
			true);
	public static long CREDITAPPID_COLUMN_BITMASK = 1L;
	public static long PRINCIPALID_COLUMN_BITMASK = 2L;
	public static long SEQUENCENUMBER_COLUMN_BITMASK = 4L;
	public static long PRINCIPALFIRSTNAME_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.CreditAppPrincipal"));

	public CreditAppPrincipalModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _principalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPrincipalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _principalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppPrincipal.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppPrincipal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("principalId", getPrincipalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("principalFirstName", getPrincipalFirstName());
		attributes.put("principalMiddleName", getPrincipalMiddleName());
		attributes.put("principalLastName", getPrincipalLastName());
		attributes.put("principalSSN", getPrincipalSSN());
		attributes.put("principalHomePhoneNumber", getPrincipalHomePhoneNumber());
		attributes.put("principalAddress1", getPrincipalAddress1());
		attributes.put("principalAddress2", getPrincipalAddress2());
		attributes.put("principalCity", getPrincipalCity());
		attributes.put("principalState", getPrincipalState());
		attributes.put("principalZip", getPrincipalZip());
		attributes.put("principalEmail", getPrincipalEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long principalId = (Long)attributes.get("principalId");

		if (principalId != null) {
			setPrincipalId(principalId);
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

		String principalFirstName = (String)attributes.get("principalFirstName");

		if (principalFirstName != null) {
			setPrincipalFirstName(principalFirstName);
		}

		String principalMiddleName = (String)attributes.get(
				"principalMiddleName");

		if (principalMiddleName != null) {
			setPrincipalMiddleName(principalMiddleName);
		}

		String principalLastName = (String)attributes.get("principalLastName");

		if (principalLastName != null) {
			setPrincipalLastName(principalLastName);
		}

		String principalSSN = (String)attributes.get("principalSSN");

		if (principalSSN != null) {
			setPrincipalSSN(principalSSN);
		}

		String principalHomePhoneNumber = (String)attributes.get(
				"principalHomePhoneNumber");

		if (principalHomePhoneNumber != null) {
			setPrincipalHomePhoneNumber(principalHomePhoneNumber);
		}

		String principalAddress1 = (String)attributes.get("principalAddress1");

		if (principalAddress1 != null) {
			setPrincipalAddress1(principalAddress1);
		}

		String principalAddress2 = (String)attributes.get("principalAddress2");

		if (principalAddress2 != null) {
			setPrincipalAddress2(principalAddress2);
		}

		String principalCity = (String)attributes.get("principalCity");

		if (principalCity != null) {
			setPrincipalCity(principalCity);
		}

		String principalState = (String)attributes.get("principalState");

		if (principalState != null) {
			setPrincipalState(principalState);
		}

		String principalZip = (String)attributes.get("principalZip");

		if (principalZip != null) {
			setPrincipalZip(principalZip);
		}

		String principalEmail = (String)attributes.get("principalEmail");

		if (principalEmail != null) {
			setPrincipalEmail(principalEmail);
		}
	}

	@Override
	public long getPrincipalId() {
		return _principalId;
	}

	@Override
	public void setPrincipalId(long principalId) {
		_columnBitmask |= PRINCIPALID_COLUMN_BITMASK;

		if (!_setOriginalPrincipalId) {
			_setOriginalPrincipalId = true;

			_originalPrincipalId = _principalId;
		}

		_principalId = principalId;
	}

	public long getOriginalPrincipalId() {
		return _originalPrincipalId;
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
	public String getPrincipalFirstName() {
		if (_principalFirstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalFirstName;
		}
	}

	@Override
	public void setPrincipalFirstName(String principalFirstName) {
		_columnBitmask = -1L;

		_principalFirstName = principalFirstName;
	}

	@Override
	public String getPrincipalMiddleName() {
		if (_principalMiddleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalMiddleName;
		}
	}

	@Override
	public void setPrincipalMiddleName(String principalMiddleName) {
		_principalMiddleName = principalMiddleName;
	}

	@Override
	public String getPrincipalLastName() {
		if (_principalLastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalLastName;
		}
	}

	@Override
	public void setPrincipalLastName(String principalLastName) {
		_principalLastName = principalLastName;
	}

	@Override
	public String getPrincipalSSN() {
		if (_principalSSN == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalSSN;
		}
	}

	@Override
	public void setPrincipalSSN(String principalSSN) {
		_principalSSN = principalSSN;
	}

	@Override
	public String getPrincipalHomePhoneNumber() {
		if (_principalHomePhoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalHomePhoneNumber;
		}
	}

	@Override
	public void setPrincipalHomePhoneNumber(String principalHomePhoneNumber) {
		_principalHomePhoneNumber = principalHomePhoneNumber;
	}

	@Override
	public String getPrincipalAddress1() {
		if (_principalAddress1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalAddress1;
		}
	}

	@Override
	public void setPrincipalAddress1(String principalAddress1) {
		_principalAddress1 = principalAddress1;
	}

	@Override
	public String getPrincipalAddress2() {
		if (_principalAddress2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalAddress2;
		}
	}

	@Override
	public void setPrincipalAddress2(String principalAddress2) {
		_principalAddress2 = principalAddress2;
	}

	@Override
	public String getPrincipalCity() {
		if (_principalCity == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalCity;
		}
	}

	@Override
	public void setPrincipalCity(String principalCity) {
		_principalCity = principalCity;
	}

	@Override
	public String getPrincipalState() {
		if (_principalState == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalState;
		}
	}

	@Override
	public void setPrincipalState(String principalState) {
		_principalState = principalState;
	}

	@Override
	public String getPrincipalZip() {
		if (_principalZip == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalZip;
		}
	}

	@Override
	public void setPrincipalZip(String principalZip) {
		_principalZip = principalZip;
	}

	@Override
	public String getPrincipalEmail() {
		if (_principalEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalEmail;
		}
	}

	@Override
	public void setPrincipalEmail(String principalEmail) {
		_principalEmail = principalEmail;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CreditAppPrincipal.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CreditAppPrincipal toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CreditAppPrincipal)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CreditAppPrincipalImpl creditAppPrincipalImpl = new CreditAppPrincipalImpl();

		creditAppPrincipalImpl.setPrincipalId(getPrincipalId());
		creditAppPrincipalImpl.setCompanyId(getCompanyId());
		creditAppPrincipalImpl.setUserId(getUserId());
		creditAppPrincipalImpl.setUserName(getUserName());
		creditAppPrincipalImpl.setCreateDate(getCreateDate());
		creditAppPrincipalImpl.setModifiedDate(getModifiedDate());
		creditAppPrincipalImpl.setCreditAppId(getCreditAppId());
		creditAppPrincipalImpl.setSequenceNumber(getSequenceNumber());
		creditAppPrincipalImpl.setPrincipalFirstName(getPrincipalFirstName());
		creditAppPrincipalImpl.setPrincipalMiddleName(getPrincipalMiddleName());
		creditAppPrincipalImpl.setPrincipalLastName(getPrincipalLastName());
		creditAppPrincipalImpl.setPrincipalSSN(getPrincipalSSN());
		creditAppPrincipalImpl.setPrincipalHomePhoneNumber(getPrincipalHomePhoneNumber());
		creditAppPrincipalImpl.setPrincipalAddress1(getPrincipalAddress1());
		creditAppPrincipalImpl.setPrincipalAddress2(getPrincipalAddress2());
		creditAppPrincipalImpl.setPrincipalCity(getPrincipalCity());
		creditAppPrincipalImpl.setPrincipalState(getPrincipalState());
		creditAppPrincipalImpl.setPrincipalZip(getPrincipalZip());
		creditAppPrincipalImpl.setPrincipalEmail(getPrincipalEmail());

		creditAppPrincipalImpl.resetOriginalValues();

		return creditAppPrincipalImpl;
	}

	@Override
	public int compareTo(CreditAppPrincipal creditAppPrincipal) {
		int value = 0;

		value = getPrincipalFirstName()
					.compareTo(creditAppPrincipal.getPrincipalFirstName());

		if (value != 0) {
			return value;
		}

		if (getSequenceNumber() < creditAppPrincipal.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppPrincipal.getSequenceNumber()) {
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

		if (!(obj instanceof CreditAppPrincipal)) {
			return false;
		}

		CreditAppPrincipal creditAppPrincipal = (CreditAppPrincipal)obj;

		long primaryKey = creditAppPrincipal.getPrimaryKey();

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
		CreditAppPrincipalModelImpl creditAppPrincipalModelImpl = this;

		creditAppPrincipalModelImpl._originalPrincipalId = creditAppPrincipalModelImpl._principalId;

		creditAppPrincipalModelImpl._setOriginalPrincipalId = false;

		creditAppPrincipalModelImpl._originalCreditAppId = creditAppPrincipalModelImpl._creditAppId;

		creditAppPrincipalModelImpl._setOriginalCreditAppId = false;

		creditAppPrincipalModelImpl._originalSequenceNumber = creditAppPrincipalModelImpl._sequenceNumber;

		creditAppPrincipalModelImpl._setOriginalSequenceNumber = false;

		creditAppPrincipalModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CreditAppPrincipal> toCacheModel() {
		CreditAppPrincipalCacheModel creditAppPrincipalCacheModel = new CreditAppPrincipalCacheModel();

		creditAppPrincipalCacheModel.principalId = getPrincipalId();

		creditAppPrincipalCacheModel.companyId = getCompanyId();

		creditAppPrincipalCacheModel.userId = getUserId();

		creditAppPrincipalCacheModel.userName = getUserName();

		String userName = creditAppPrincipalCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			creditAppPrincipalCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			creditAppPrincipalCacheModel.createDate = createDate.getTime();
		}
		else {
			creditAppPrincipalCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			creditAppPrincipalCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			creditAppPrincipalCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		creditAppPrincipalCacheModel.creditAppId = getCreditAppId();

		creditAppPrincipalCacheModel.sequenceNumber = getSequenceNumber();

		creditAppPrincipalCacheModel.principalFirstName = getPrincipalFirstName();

		String principalFirstName = creditAppPrincipalCacheModel.principalFirstName;

		if ((principalFirstName != null) && (principalFirstName.length() == 0)) {
			creditAppPrincipalCacheModel.principalFirstName = null;
		}

		creditAppPrincipalCacheModel.principalMiddleName = getPrincipalMiddleName();

		String principalMiddleName = creditAppPrincipalCacheModel.principalMiddleName;

		if ((principalMiddleName != null) &&
				(principalMiddleName.length() == 0)) {
			creditAppPrincipalCacheModel.principalMiddleName = null;
		}

		creditAppPrincipalCacheModel.principalLastName = getPrincipalLastName();

		String principalLastName = creditAppPrincipalCacheModel.principalLastName;

		if ((principalLastName != null) && (principalLastName.length() == 0)) {
			creditAppPrincipalCacheModel.principalLastName = null;
		}

		creditAppPrincipalCacheModel.principalSSN = getPrincipalSSN();

		String principalSSN = creditAppPrincipalCacheModel.principalSSN;

		if ((principalSSN != null) && (principalSSN.length() == 0)) {
			creditAppPrincipalCacheModel.principalSSN = null;
		}

		creditAppPrincipalCacheModel.principalHomePhoneNumber = getPrincipalHomePhoneNumber();

		String principalHomePhoneNumber = creditAppPrincipalCacheModel.principalHomePhoneNumber;

		if ((principalHomePhoneNumber != null) &&
				(principalHomePhoneNumber.length() == 0)) {
			creditAppPrincipalCacheModel.principalHomePhoneNumber = null;
		}

		creditAppPrincipalCacheModel.principalAddress1 = getPrincipalAddress1();

		String principalAddress1 = creditAppPrincipalCacheModel.principalAddress1;

		if ((principalAddress1 != null) && (principalAddress1.length() == 0)) {
			creditAppPrincipalCacheModel.principalAddress1 = null;
		}

		creditAppPrincipalCacheModel.principalAddress2 = getPrincipalAddress2();

		String principalAddress2 = creditAppPrincipalCacheModel.principalAddress2;

		if ((principalAddress2 != null) && (principalAddress2.length() == 0)) {
			creditAppPrincipalCacheModel.principalAddress2 = null;
		}

		creditAppPrincipalCacheModel.principalCity = getPrincipalCity();

		String principalCity = creditAppPrincipalCacheModel.principalCity;

		if ((principalCity != null) && (principalCity.length() == 0)) {
			creditAppPrincipalCacheModel.principalCity = null;
		}

		creditAppPrincipalCacheModel.principalState = getPrincipalState();

		String principalState = creditAppPrincipalCacheModel.principalState;

		if ((principalState != null) && (principalState.length() == 0)) {
			creditAppPrincipalCacheModel.principalState = null;
		}

		creditAppPrincipalCacheModel.principalZip = getPrincipalZip();

		String principalZip = creditAppPrincipalCacheModel.principalZip;

		if ((principalZip != null) && (principalZip.length() == 0)) {
			creditAppPrincipalCacheModel.principalZip = null;
		}

		creditAppPrincipalCacheModel.principalEmail = getPrincipalEmail();

		String principalEmail = creditAppPrincipalCacheModel.principalEmail;

		if ((principalEmail != null) && (principalEmail.length() == 0)) {
			creditAppPrincipalCacheModel.principalEmail = null;
		}

		return creditAppPrincipalCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{principalId=");
		sb.append(getPrincipalId());
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
		sb.append(", principalFirstName=");
		sb.append(getPrincipalFirstName());
		sb.append(", principalMiddleName=");
		sb.append(getPrincipalMiddleName());
		sb.append(", principalLastName=");
		sb.append(getPrincipalLastName());
		sb.append(", principalSSN=");
		sb.append(getPrincipalSSN());
		sb.append(", principalHomePhoneNumber=");
		sb.append(getPrincipalHomePhoneNumber());
		sb.append(", principalAddress1=");
		sb.append(getPrincipalAddress1());
		sb.append(", principalAddress2=");
		sb.append(getPrincipalAddress2());
		sb.append(", principalCity=");
		sb.append(getPrincipalCity());
		sb.append(", principalState=");
		sb.append(getPrincipalState());
		sb.append(", principalZip=");
		sb.append(getPrincipalZip());
		sb.append(", principalEmail=");
		sb.append(getPrincipalEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppPrincipal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>principalId</column-name><column-value><![CDATA[");
		sb.append(getPrincipalId());
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
			"<column><column-name>principalFirstName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalMiddleName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalLastName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalSSN</column-name><column-value><![CDATA[");
		sb.append(getPrincipalSSN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalHomePhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPrincipalHomePhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalAddress1</column-name><column-value><![CDATA[");
		sb.append(getPrincipalAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalAddress2</column-name><column-value><![CDATA[");
		sb.append(getPrincipalAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalCity</column-name><column-value><![CDATA[");
		sb.append(getPrincipalCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalState</column-name><column-value><![CDATA[");
		sb.append(getPrincipalState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalZip</column-name><column-value><![CDATA[");
		sb.append(getPrincipalZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalEmail</column-name><column-value><![CDATA[");
		sb.append(getPrincipalEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CreditAppPrincipal.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CreditAppPrincipal.class
		};
	private long _principalId;
	private long _originalPrincipalId;
	private boolean _setOriginalPrincipalId;
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
	private String _principalFirstName;
	private String _principalMiddleName;
	private String _principalLastName;
	private String _principalSSN;
	private String _principalHomePhoneNumber;
	private String _principalAddress1;
	private String _principalAddress2;
	private String _principalCity;
	private String _principalState;
	private String _principalZip;
	private String _principalEmail;
	private long _columnBitmask;
	private CreditAppPrincipal _escapedModel;
}