/**
 * Copyright 2011 Nube Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package co.nubetech.crux.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.nubetech.crux.model.ValueType;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class ValueTypeDAO {

	@SessionTarget
	public Session session;
	@TransactionTarget
	public Transaction transaction;

	public ValueType findById(Long id) {
		ValueType hbaseColumnType = (ValueType) session
				.get(ValueType.class, id);
		return hbaseColumnType;
	}

	public List<ValueType> findAll() {
		List<ValueType> result = session.createQuery("from ValueType").list();
		return result;
	}
}
