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

import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.model.TermModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Term service. Represents a row in the &quot;eCreekRidge_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.TermModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TermImpl}.
 * </p>
 *
 * @author pmacha
 * @see TermImpl
 * @see com.tamarack.creekridge.model.Term
 * @see com.tamarack.creekridge.model.TermModel
 * @generated
 */
public class TermModelImpl extends BaseModelImpl<Term> implements TermModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a term model instance should use the {@link com.tamarack.creekridge.model.Term} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_Term";
	public static final Object[][] TABLE_COLUMNS = {
			{ "termId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "termMonths", Types.BIGINT },
			{ "termName", Types.VARCHAR },
			{ "sequenceNumber", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_Term (termId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,termMonths LONG,termName VARCHAR(75) null,sequenceNumber LONG)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_Term";
	public static final String ORDER_BY_JPQL = " ORDER BY term.sequenceNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_Term.sequenceNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.Term"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.Term"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.Term"),
			true);
	public static long TERMID_COLUMN_BITMASK = 1L;
	public static long SEQUENCENUMBER_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.Term"));

	public TermModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _termId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTermId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _termId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Term.class;
	}

	@Override
	public String getModelClassName() {
		return Term.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("termMonths", getTermMonths());
		attributes.put("termName", getTermName());
		attributes.put("sequenceNumber", getSequenceNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
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

		Long termMonths = (Long)attributes.get("termMonths");

		if (termMonths != null) {
			setTermMonths(termMonths);
		}

		String termName = (String)attributes.get("termName");

		if (termName != null) {
			setTermName(termName);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}
	}

	@Override
	public long getTermId() {
		return _termId;
	}

	@Override
	public void setTermId(long termId) {
		_columnBitmask |= TERMID_COLUMN_BITMASK;

		if (!_setOriginalTermId) {
			_setOriginalTermId = true;

			_originalTermId = _termId;
		}

		_termId = termId;
	}

	public long getOriginalTermId() {
		return _originalTermId;
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
	public long getTermMonths() {
		return _termMonths;
	}

	@Override
	public void setTermMonths(long termMonths) {
		_termMonths = termMonths;
	}

	@Override
	public String getTermName() {
		if (_termName == null) {
			return StringPool.BLANK;
		}
		else {
			return _termName;
		}
	}

	@Override
	public void setTermName(String termName) {
		_termName = termName;
	}

	@Override
	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_columnBitmask = -1L;

		_sequenceNumber = sequenceNumber;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Term.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Term toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Term)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TermImpl termImpl = new TermImpl();

		termImpl.setTermId(getTermId());
		termImpl.setCompanyId(getCompanyId());
		termImpl.setUserId(getUserId());
		termImpl.setUserName(getUserName());
		termImpl.setCreateDate(getCreateDate());
		termImpl.setModifiedDate(getModifiedDate());
		termImpl.setTermMonths(getTermMonths());
		termImpl.setTermName(getTermName());
		termImpl.setSequenceNumber(getSequenceNumber());

		termImpl.resetOriginalValues();

		return termImpl;
	}

	@Override
	public int compareTo(Term term) {
		int value = 0;

		if (getSequenceNumber() < term.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > term.getSequenceNumber()) {
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

		if (!(obj instanceof Term)) {
			return false;
		}

		Term term = (Term)obj;

		long primaryKey = term.getPrimaryKey();

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
		TermModelImpl termModelImpl = this;

		termModelImpl._originalTermId = termModelImpl._termId;

		termModelImpl._setOriginalTermId = false;

		termModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Term> toCacheModel() {
		TermCacheModel termCacheModel = new TermCacheModel();

		termCacheModel.termId = getTermId();

		termCacheModel.companyId = getCompanyId();

		termCacheModel.userId = getUserId();

		termCacheModel.userName = getUserName();

		String userName = termCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			termCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			termCacheModel.createDate = createDate.getTime();
		}
		else {
			termCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			termCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			termCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		termCacheModel.termMonths = getTermMonths();

		termCacheModel.termName = getTermName();

		String termName = termCacheModel.termName;

		if ((termName != null) && (termName.length() == 0)) {
			termCacheModel.termName = null;
		}

		termCacheModel.sequenceNumber = getSequenceNumber();

		return termCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{termId=");
		sb.append(getTermId());
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
		sb.append(", termMonths=");
		sb.append(getTermMonths());
		sb.append(", termName=");
		sb.append(getTermName());
		sb.append(", sequenceNumber=");
		sb.append(getSequenceNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.Term");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
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
			"<column><column-name>termMonths</column-name><column-value><![CDATA[");
		sb.append(getTermMonths());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termName</column-name><column-value><![CDATA[");
		sb.append(getTermName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNumber</column-name><column-value><![CDATA[");
		sb.append(getSequenceNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Term.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Term.class };
	private long _termId;
	private long _originalTermId;
	private boolean _setOriginalTermId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _termMonths;
	private String _termName;
	private long _sequenceNumber;
	private long _columnBitmask;
	private Term _escapedModel;
}