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

import javax.annotation.Nullable;

import com.github.haixing_hu.reflect.FieldNotExistException;

/**
 * The interface for beans.
 * <p>
 * This interface provides a uniform way to access the properties of a bean.
 * Although we could access the properties of a bean through reflections, there
 * are still some situations that we need a uniform way to access the properties
 * of beans.
 * <p>
 * For example, suppose we have a {@code Article} class, which consists of a
 * list of {@code Field} objects. Each {@code Field} has a unique name. We want
 * to access a {@code Field} of a {@code Article} by the field's name, as if the
 * document has a property with that name. The {@link Bean} interface provides
 * getter and setter functions to access the internal property of a
 * {@code Article}, as well as the internal properties of the {@code Article}.
 * <p>
 * A {@link Bean} object can also be used with the {@link PropertyExpression}.
 *
 * @author Haixing Hu
 */
public interface Bean {

  /**
   * Tests whether this bean has a specified property.
   *
   * @param name
   *          the name of the specified property.
   * @return {@code true} if this bean has a property with the specified name;
   *         {@code false} otherwise.
   * @throws ReflectionException
   *           if any error occurs during the reflection operation.
   */
  public boolean has(final String name);

  /**
   * Gets the value of a specified property of this bean.
   *
   * @param name
   *          the name of the specified property.
   * @return the value of the property with the specified name, which could be
   *         {@code null}, depending on the implementation.
   * @throws FieldNotExistException
   *           if the specified property does not exist.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  public Object get(final String name);

  /**
   * Sets the value of a specified property of this bean.
   *
   * @param name
   *          the name of the specified property.
   * @param value
   *          the value to be set to the property with the specified name, which
   *          could be {@code null}, depending on the implementation.
   * @throws FieldNotExistException
   *           if the specified property does not exist.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of the
   *           specified property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation
   */
  public void set(final String name, @Nullable final Object value);

  /**
   * Gets the type of a specified property of this bean.
   *
   * @param name
   *          the name of the specified property.
   * @return the type of the property with the specified name.
   * @throws FieldNotExistException
   *           if the specified property does not exist.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation
   */
  public Class<?> getType(final String name);
}
