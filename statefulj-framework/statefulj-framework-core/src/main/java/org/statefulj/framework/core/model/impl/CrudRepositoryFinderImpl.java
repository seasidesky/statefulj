/***
 * 
 * Copyright 2014 Andrew Hall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.statefulj.framework.core.model.impl;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.statefulj.framework.core.model.Finder;

public class CrudRepositoryFinderImpl<T, CT> implements Finder<T, CT> {
	
	private CrudRepository<T, Serializable> repo;
	
	public CrudRepositoryFinderImpl(CrudRepository<T, Serializable> repo) {
		this.repo = repo;
	}

	@Override
	public T find(Class<T> clazz, Object id, String event, CT context) {
		return repo.findOne((Serializable)id);
	}

	@Override
	public T find(Class<T> clazz, String event, CT context) {
		return null;
	}

}
