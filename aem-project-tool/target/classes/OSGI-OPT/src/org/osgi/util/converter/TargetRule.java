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

import java.lang.reflect.Type;

/**
 * Interface for custom conversion rules.
 *
 * @author $Id: 614df24bd93d3c5fa1151ae389f2d437a4e3fbae $
 */
public interface TargetRule {
	/**
	 * The function to perform the conversion.
	 * 
	 * @return The function.
	 */
	ConverterFunction getFunction();

	/**
	 * The target type of this rule. The conversion function is invoked for each
	 * conversion to the target type.
	 *
	 * @return The target type.
	 */
	Type getTargetType();
}
