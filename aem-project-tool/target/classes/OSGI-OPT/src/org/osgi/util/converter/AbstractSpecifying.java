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

/**
 * @author $Id: 7d2d62548b7eba757b3a938619bc9cf489d43c09 $
 */
abstract class AbstractSpecifying<T extends Specifying<T>>
		implements Specifying<T> {
	protected volatile Object		defaultValue;
	protected volatile boolean		hasDefault			= false;
	protected volatile boolean		liveView			= false;
	protected volatile boolean		keysIgnoreCase		= false;
	protected volatile Class< ? >	sourceAsClass;
	protected volatile boolean		sourceAsDTO			= false;
	protected volatile boolean		sourceAsJavaBean	= false;
	protected volatile Class< ? >	targetAsClass;
	protected volatile boolean		targetAsDTO			= false;
	protected volatile boolean		targetAsJavaBean	= false;

	@SuppressWarnings("unchecked")
	private T castThis() {
		return (T) this;
	}

	@Override
	public T defaultValue(Object defVal) {
		defaultValue = defVal;
		hasDefault = true;
		return castThis();
	}

	@Override
	public T keysIgnoreCase() {
		keysIgnoreCase = true;
		return castThis();
	}

	@Override
	public T sourceAs(Class< ? > cls) {
		sourceAsClass = cls;
		return castThis();
	}

	@Override
	public T sourceAsBean() {
		// To avoid ambiguity, reset any instruction to sourceAsDTO
		sourceAsDTO = false;
		sourceAsJavaBean = true;
		return castThis();
	}

	@Override
	public T sourceAsDTO() {
		// To avoid ambiguity, reset any instruction to sourceAsJavaBean
		sourceAsJavaBean = false;
		sourceAsDTO = true;
		return castThis();
	}

	@Override
	public T targetAs(Class< ? > cls) {
		targetAsClass = cls;
		return castThis();
	}

	@Override
	public T targetAsBean() {
		// To avoid ambiguity, reset any instruction to targetAsDTO
		targetAsDTO = false;
		targetAsJavaBean = true;
		return castThis();
	}

	@Override
	public T targetAsDTO() {
		// To avoid ambiguity, reset any instruction to targetAsJavaBean
		targetAsJavaBean = false;
		targetAsDTO = true;
		return castThis();
	}

	@Override
	public T view() {
		liveView = true;
		return castThis();
	}
}
