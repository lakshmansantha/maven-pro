/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/

package org.osgi.util.converter;

import java.util.Collection;
import java.util.List;

/**
 * @author $Id: a0b9191404b1e05fddff45f2e1b15475c266db11 $
 */
class CollectionDelegate<T> extends AbstractCollectionDelegate<T>
		implements List<T> {
	private final Collection<T> delegate;

	CollectionDelegate(Collection<T> coll) {
		delegate = coll;
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		Object[] arr = toArray();
		if (index > arr.length)
			throw new IndexOutOfBoundsException("" + index);
		return (T) arr[index];
	}
}
