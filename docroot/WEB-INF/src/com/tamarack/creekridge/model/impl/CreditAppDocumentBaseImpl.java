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

import com.liferay.portal.kernel.exception.SystemException;

import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;

/**
 * The extended model base implementation for the CreditAppDocument service. Represents a row in the &quot;eCreekRidge_CreditAppDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CreditAppDocumentImpl}.
 * </p>
 *
 * @author Tamarack Consulting
 * @see CreditAppDocumentImpl
 * @see com.tamarack.creekridge.model.CreditAppDocument
 * @generated
 */
public abstract class CreditAppDocumentBaseImpl
	extends CreditAppDocumentModelImpl implements CreditAppDocument {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a credit app document model instance should use the {@link CreditAppDocument} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppDocumentLocalServiceUtil.addCreditAppDocument(this);
		}
		else {
			CreditAppDocumentLocalServiceUtil.updateCreditAppDocument(this);
		}
	}
}