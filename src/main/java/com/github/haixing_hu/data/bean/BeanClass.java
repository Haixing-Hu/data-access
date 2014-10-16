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
package com.github.haixing_hu.data.bean;

/**
 * A {@link BeanClass} is a simulation of the functionality of
 * {@link java.lang.Class} for classes implementing the {@link Bean} interface.
 * <p>
 * {@link Bean} instances that share the same {@link BeanClass] all have the
 * same set of available properties, along with any associated data types,
 * read-only states, and write-only states.
 *
 * @author Haixing Hu
 */
public interface BeanClass {

  /**
   * Gets the name of this bean class.
   * <p>
   * This function analogous to the {@code getName()} method of
   * {@link java.lang.Class}, and let {@link BeanClass} implementation class to
   * support different dynamic classes, with different sets of properties.
   *
   * @return the name of this bean class.
   */
  public String getName();

  /**
   * Gets all the properties defined in this bean class.
   *
   * @return the array of all the properties defined in this bean class, which
   *         will never be {@code null}.
   */
  public Property[] getProperties();

  /**
   * Test whether the beans created by this bean class have the specified
   * property.
   *
   * @param name
   *          the name of a property.
   * @return {@code true} if the beans created by this bean class have the
   *         specified property; {@code false} otherwise.
   */
  public boolean hasProperty(String name);

  /**
   * Gets the descriptor of a property.
   *
   * @param name
   *          the name of a property.
   * @return the descriptor of the property with the specified name, or
   *         {@code null} if no such property.
   */
  public Property getProperty(String name);

  /**
   * Creates a new {@link Bean} instance, associated with this bean class.
   *
   * @return a new {@link Bean} instance, associated with this bean class.
   * @throws ReflectionException
   *           if any error occurs.
   */
  public Bean newInstance();
}
