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

import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.RateFactorRuleModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RateFactorRule service. Represents a row in the &quot;eCreekRidge_RateFactorRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.RateFactorRuleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RateFactorRuleImpl}.
 * </p>
 *
 * @author tamarack
 * @see RateFactorRuleImpl
 * @see com.tamarack.creekridge.model.RateFactorRule
 * @see com.tamarack.creekridge.model.RateFactorRuleModel
 * @generated
 */
public class RateFactorRuleModelImpl extends BaseModelImpl<RateFactorRule>
	implements RateFactorRuleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rate factor rule model instance should use the {@link com.tamarack.creekridge.model.RateFactorRule} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_RateFactorRule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "rateFactorRuleId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "productId", Types.BIGINT },
			{ "termId", Types.BIGINT },
			{ "purchaseOptionId", Types.BIGINT },
			{ "vendorId", Types.BIGINT },
			{ "minPrice", Types.DOUBLE },
			{ "rateFactor", Types.DOUBLE },
			{ "effectiveDate", Types.TIMESTAMP },
			{ "active_", Types.BOOLEAN },
			{ "expirationDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_RateFactorRule (rateFactorRuleId LONG not null primary key,companyId LONG,userId LONG,groupId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,productId LONG,termId LONG,purchaseOptionId LONG,vendorId LONG,minPrice DOUBLE,rateFactor DOUBLE,effectiveDate DATE null,active_ BOOLEAN,expirationDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_RateFactorRule";
	public static final String ORDER_BY_JPQL = " ORDER BY rateFactorRule.rateFactorRuleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_RateFactorRule.rateFactorRuleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.RateFactorRule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.RateFactorRule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.RateFactorRule"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PRODUCTID_COLUMN_BITMASK = 4L;
	public static long PURCHASEOPTIONID_COLUMN_BITMASK = 8L;
	public static long RATEFACTORRULEID_COLUMN_BITMASK = 16L;
	public static long TERMID_COLUMN_BITMASK = 32L;
	public static long VENDORID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.RateFactorRule"));

	public RateFactorRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rateFactorRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRateFactorRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rateFactorRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RateFactorRule.class;
	}

	@Override
	public String getModelClassName() {
		return RateFactorRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("vendorId", getVendorId());
		attributes.put("minPrice", getMinPrice());
		attributes.put("rateFactor", getRateFactor());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("active", getActive());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
		}

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Double minPrice = (Double)attributes.get("minPrice");

		if (minPrice != null) {
			setMinPrice(minPrice);
		}

		Double rateFactor = (Double)attributes.get("rateFactor");

		if (rateFactor != null) {
			setRateFactor(rateFactor);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	@Override
	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_columnBitmask |= RATEFACTORRULEID_COLUMN_BITMASK;

		if (!_setOriginalRateFactorRuleId) {
			_setOriginalRateFactorRuleId = true;

			_originalRateFactorRuleId = _rateFactorRuleId;
		}

		_rateFactorRuleId = rateFactorRuleId;
	}

	public long getOriginalRateFactorRuleId() {
		return _originalRateFactorRuleId;
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_columnBitmask |= PRODUCTID_COLUMN_BITMASK;

		if (!_setOriginalProductId) {
			_setOriginalProductId = true;

			_originalProductId = _productId;
		}

		_productId = productId;
	}

	public long getOriginalProductId() {
		return _originalProductId;
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
	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_columnBitmask |= PURCHASEOPTIONID_COLUMN_BITMASK;

		if (!_setOriginalPurchaseOptionId) {
			_setOriginalPurchaseOptionId = true;

			_originalPurchaseOptionId = _purchaseOptionId;
		}

		_purchaseOptionId = purchaseOptionId;
	}

	public long getOriginalPurchaseOptionId() {
		return _originalPurchaseOptionId;
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_columnBitmask |= VENDORID_COLUMN_BITMASK;

		if (!_setOriginalVendorId) {
			_setOriginalVendorId = true;

			_originalVendorId = _vendorId;
		}

		_vendorId = vendorId;
	}

	public long getOriginalVendorId() {
		return _originalVendorId;
	}

	@Override
	public double getMinPrice() {
		return _minPrice;
	}

	@Override
	public void setMinPrice(double minPrice) {
		_minPrice = minPrice;
	}

	@Override
	public double getRateFactor() {
		return _rateFactor;
	}

	@Override
	public void setRateFactor(double rateFactor) {
		_rateFactor = rateFactor;
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			RateFactorRule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RateFactorRule toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RateFactorRule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RateFactorRuleImpl rateFactorRuleImpl = new RateFactorRuleImpl();

		rateFactorRuleImpl.setRateFactorRuleId(getRateFactorRuleId());
		rateFactorRuleImpl.setCompanyId(getCompanyId());
		rateFactorRuleImpl.setUserId(getUserId());
		rateFactorRuleImpl.setGroupId(getGroupId());
		rateFactorRuleImpl.setUserName(getUserName());
		rateFactorRuleImpl.setCreateDate(getCreateDate());
		rateFactorRuleImpl.setModifiedDate(getModifiedDate());
		rateFactorRuleImpl.setProductId(getProductId());
		rateFactorRuleImpl.setTermId(getTermId());
		rateFactorRuleImpl.setPurchaseOptionId(getPurchaseOptionId());
		rateFactorRuleImpl.setVendorId(getVendorId());
		rateFactorRuleImpl.setMinPrice(getMinPrice());
		rateFactorRuleImpl.setRateFactor(getRateFactor());
		rateFactorRuleImpl.setEffectiveDate(getEffectiveDate());
		rateFactorRuleImpl.setActive(getActive());
		rateFactorRuleImpl.setExpirationDate(getExpirationDate());

		rateFactorRuleImpl.resetOriginalValues();

		return rateFactorRuleImpl;
	}

	@Override
	public int compareTo(RateFactorRule rateFactorRule) {
		long primaryKey = rateFactorRule.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RateFactorRule)) {
			return false;
		}

		RateFactorRule rateFactorRule = (RateFactorRule)obj;

		long primaryKey = rateFactorRule.getPrimaryKey();

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
		RateFactorRuleModelImpl rateFactorRuleModelImpl = this;

		rateFactorRuleModelImpl._originalRateFactorRuleId = rateFactorRuleModelImpl._rateFactorRuleId;

		rateFactorRuleModelImpl._setOriginalRateFactorRuleId = false;

		rateFactorRuleModelImpl._originalGroupId = rateFactorRuleModelImpl._groupId;

		rateFactorRuleModelImpl._setOriginalGroupId = false;

		rateFactorRuleModelImpl._originalProductId = rateFactorRuleModelImpl._productId;

		rateFactorRuleModelImpl._setOriginalProductId = false;

		rateFactorRuleModelImpl._originalTermId = rateFactorRuleModelImpl._termId;

		rateFactorRuleModelImpl._setOriginalTermId = false;

		rateFactorRuleModelImpl._originalPurchaseOptionId = rateFactorRuleModelImpl._purchaseOptionId;

		rateFactorRuleModelImpl._setOriginalPurchaseOptionId = false;

		rateFactorRuleModelImpl._originalVendorId = rateFactorRuleModelImpl._vendorId;

		rateFactorRuleModelImpl._setOriginalVendorId = false;

		rateFactorRuleModelImpl._originalActive = rateFactorRuleModelImpl._active;

		rateFactorRuleModelImpl._setOriginalActive = false;

		rateFactorRuleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RateFactorRule> toCacheModel() {
		RateFactorRuleCacheModel rateFactorRuleCacheModel = new RateFactorRuleCacheModel();

		rateFactorRuleCacheModel.rateFactorRuleId = getRateFactorRuleId();

		rateFactorRuleCacheModel.companyId = getCompanyId();

		rateFactorRuleCacheModel.userId = getUserId();

		rateFactorRuleCacheModel.groupId = getGroupId();

		rateFactorRuleCacheModel.userName = getUserName();

		String userName = rateFactorRuleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			rateFactorRuleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			rateFactorRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			rateFactorRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			rateFactorRuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			rateFactorRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		rateFactorRuleCacheModel.productId = getProductId();

		rateFactorRuleCacheModel.termId = getTermId();

		rateFactorRuleCacheModel.purchaseOptionId = getPurchaseOptionId();

		rateFactorRuleCacheModel.vendorId = getVendorId();

		rateFactorRuleCacheModel.minPrice = getMinPrice();

		rateFactorRuleCacheModel.rateFactor = getRateFactor();

		Date effectiveDate = getEffectiveDate();

		if (effectiveDate != null) {
			rateFactorRuleCacheModel.effectiveDate = effectiveDate.getTime();
		}
		else {
			rateFactorRuleCacheModel.effectiveDate = Long.MIN_VALUE;
		}

		rateFactorRuleCacheModel.active = getActive();

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			rateFactorRuleCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			rateFactorRuleCacheModel.expirationDate = Long.MIN_VALUE;
		}

		return rateFactorRuleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{rateFactorRuleId=");
		sb.append(getRateFactorRuleId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", termId=");
		sb.append(getTermId());
		sb.append(", purchaseOptionId=");
		sb.append(getPurchaseOptionId());
		sb.append(", vendorId=");
		sb.append(getVendorId());
		sb.append(", minPrice=");
		sb.append(getMinPrice());
		sb.append(", rateFactor=");
		sb.append(getRateFactor());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.RateFactorRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rateFactorRuleId</column-name><column-value><![CDATA[");
		sb.append(getRateFactorRuleId());
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
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaseOptionId</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minPrice</column-name><column-value><![CDATA[");
		sb.append(getMinPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rateFactor</column-name><column-value><![CDATA[");
		sb.append(getRateFactor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = RateFactorRule.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			RateFactorRule.class
		};
	private long _rateFactorRuleId;
	private long _originalRateFactorRuleId;
	private boolean _setOriginalRateFactorRuleId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _productId;
	private long _originalProductId;
	private boolean _setOriginalProductId;
	private long _termId;
	private long _originalTermId;
	private boolean _setOriginalTermId;
	private long _purchaseOptionId;
	private long _originalPurchaseOptionId;
	private boolean _setOriginalPurchaseOptionId;
	private long _vendorId;
	private long _originalVendorId;
	private boolean _setOriginalVendorId;
	private double _minPrice;
	private double _rateFactor;
	private Date _effectiveDate;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private Date _expirationDate;
	private long _columnBitmask;
	private RateFactorRule _escapedModel;
}