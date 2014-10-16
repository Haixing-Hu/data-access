/*
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.haixing_hu.data.model.error;

/**
 * An exception thrown to indicates a property does not exist.
 *
 * @author Haixing Hu
 */
public final class PropertyNotExistException extends BeanException {

  private static final long serialVersionUID = -4702301038198527918L;

  private final String property;

  /**
   * Constructs a {@link BeanException}.
   *
   * @param property
   *          the name of the non-existent property.
   */
  public PropertyNotExistException(final String property) {
    super("The property '" + property + "' does not exist.");
    this.property = property;
  }

  /**
   * Gets the name of the non-existent property.
   *
   * @return the name of the non-existent property.
   */
  public String getProperty() {
    return property;
  }
}
