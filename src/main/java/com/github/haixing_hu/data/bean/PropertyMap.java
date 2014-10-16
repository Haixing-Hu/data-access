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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * The class represents a map of properties.
 *
 * @author Haixing Hu
 */
public final class PropertyMap {

  private final Map<String, Property> map;

  /**
   * Constructs a {@link PropertyMape}.
   */
  public PropertyMap() {
    map = new HashMap<>();
  }

  /**
   * Tests whether this property map is empty.
   *
   * @return {@code true} if this property map is empty; {@code false}
   *         otherwise.
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Gets the size of this property map.
   *
   * @return the size of this property map.
   */
  public int size() {
    return map.size();
  }

  /**
   * Tests whether this property map contains a property with the specified
   * name.
   *
   * @param name
   *          the name of a property.
   * @return {@code true} if this property map contains a property with the
   *         specified name; {@code false} otherwise.
   */
  public boolean contains(final String name) {
    return map.containsKey(name);
  }

  /**
   * Gets the property with the specified name.
   *
   * @param name
   *          the name of a property.
   * @return the property with the specified name, or {@code null} if no such
   *         property.
   */
  public Property get(final String name) {
    return map.get(name);
  }

  /**
   * Adds a property to this map.
   *
   * @param property
   *          the property to be added.
   * @throws NullPointerException
   *           if the {@code property} is {@code null}.
   */
  public void add(final Property property) {
    map.put(property.getName(), property);
  }

  /**
   * Adds a property to this map.
   *
   * @param name
   *          the name of the property, which cannot be {@code null} nor empty.
   * @param type
   *          the type of the values stored in the property, which cannot be
   *          {@code null}.
   * @throws NullPointerException
   *           if {@code name} or {@code type} is {@code null}; or if the new
   *           property is not simple.
   * @throws IllegalArgumentException
   *           if {@code name} is not a valid property name.
   * @see Property#isValidName(String)
   */
  public void add(final String name, final Class<?> type) {
    map.put(name, new Property(name, type));
  }

  /**
   * Adds a property to this map.
   *
   * @param name
   *          the name of the property, which cannot be {@code null} and must be
   *          a valid property name.
   * @param type
   *          the type of the values stored in the property, which cannot be
   *          {@code null}.
   * @param contentType
   *          the type of contents stored in the value of this property; or
   *          {@code null} if this property is a simple property. But if the
   *          property is not a simple property, this argument must be provided
   *          and cannot be {@code null}.
   * @throws NullPointerException
   *           if {@code name} or {@code type} is {@code null}; or if the new
   *           property is not simple, but {@code contentType} is {@code null}.
   * @throws IllegalArgumentException
   *           if {@code name} is not a valid property name.
   * @see Property#isValidName(String)
   */
  public void add(final String name, final Class<?> type,
      @Nullable final Class<?> contentType) {
    map.put(name, new Property(name, type, contentType));
  }

  /**
   * Removes a property from this map.
   *
   * @param name
   *          the name of the property to be removed.
   * @return the property just removed by this function, or {@code null} if no
   *         such property.
   */
  public Property remove(final String name) {
    return map.remove(name);
  }

  /**
   * Clears this property map.
   */
  public void clear() {
    map.clear();
  }

  @Override
  public int hashCode() {
    return map.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PropertyMap other = (PropertyMap) obj;
    return map.equals(other.map);
  }

  @Override
  public String toString() {
    return map.toString();
  }
}
