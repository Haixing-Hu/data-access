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

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonEmpty;
import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link Property} object represents the descriptor of a property of a bean.
 * <p>
 * There are three kinds of properties supported by this library:
 * <ul>
 * <li><b>Simple</b> - Simple, or scalar, properties have a single value that
 * may be retrieved or modified. The underlying property type might be a Java
 * language primitive (such as {@code int}, a simple object (such as a
 * {@code String}), or a more complex object whose class is defined either by
 * the Java language, by the application, or by a class library included with
 * the application.</li>
 * <li><b>Indexed</b> - An indexed property stores an ordered collection of
 * objects (all of the same type) that can be individually accessed by an
 * integer-valued, non-negative index (or subscript). Alternatively, the entire
 * set of values may be set or retrieved using an array. As an extension to the
 * JavaBeans specification, the BeanUtils package considers any property whose
 * underlying data type is java.util.List (or an implementation of List) to be
 * indexed as well.</li>
 * <li><b>Mapped</b> - As an extension to standard JavaBeans APIs, this library
 * considers any property whose underlying value is a {@link java.util.Map} to
 * be "mapped". You can set and retrieve individual values via a {@link String}
 * valued key.</li>
 * </ul>
 *
 * @author Haixing Hu
 */
public final class Property implements Serializable {

  private static final long serialVersionUID = 3888156978033183567L;

  /**
   * The enumeration of types of properties.
   *
   * @author Haixing Hu
   */
  enum Kind {

    /**
     * Represents a simple property.
     */
    SIMPLE,

    /**
     * Represents an indexed property.
     */
    INDEXED,

    /**
     * Represents a mapped property.
     */
    MAPPED,
  }

  private static final Pattern NAME_PATTERN = Pattern
      .compile("[a-zA-Z_][a-zA-Z_0-9-]*");

  /**
   * Tests whether a name is a valid property name.
   * <p>
   * A valid property name should starts with an ASCII alphabetic character or
   * an underscore, and followed by zero or more alphabetic characters, digital
   * characters, underscores, or hyphens. Formally, its syntax is as follows:
   *
   * <pre>
   * <code>
   * name ::= [a-zA-Z_][a-zA-Z_0-9-]*
   * </code>
   * </pre>
   *
   * @param name
   *          the name to be test.
   * @return {@code true} if the name is a valid property name; {@code false}
   *         otherwise.
   */
  public static boolean isValidName(final String name) {
    if ((name == null) || (name.length() == 0)) {
      return false;
    }
    if (NAME_PATTERN.matcher(name).matches()) {
      return true;
    } else {
      return false;
    }
  }

  private final String name;
  private final Kind kind;
  private final Class<?> type;
  private final Class<?> contentType;

  /**
   * Constructs a {@link Property}.
   * <p>
   * The constructor will determine the kind of the new property according to
   * the value type. If the value type is the class of an Java build-in array,
   * or a sub-class of the {@link java.util.List}, the new property will be an
   * indexed property; if the value type is the sub-class of
   * {@link java.util.Map}, the new property is a mapped property; otherwise,
   * the new property is a simple property.
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
   * @see #isValidName(String)
   */
  public Property(final String name, final Class<?> type) {
    this(name, type, null);
  }

  /**
   * Constructs a {@link Property}.
   * <p>
   * The constructor will determine the kind of the new property according to
   * the value type. If the value type is the class of an Java build-in array,
   * or a sub-class of the {@link java.util.List}, the new property will be an
   * indexed property; if the value type is the sub-class of
   * {@link java.util.Map}, the new property is a mapped property; otherwise,
   * the new property is a simple property.
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
   * @see #isValidName(String)
   */
  public Property(final String name, final Class<?> type,
      @Nullable final Class<?> contentType) {
    this.name = requireNonEmpty("name", name);
    this.type = requireNonNull("type", type);
    this.contentType = contentType;
    if (!isValidName(name)) {
      throw new IllegalArgumentException("Invalid property name: " + name);
    }
    if (Map.class.isAssignableFrom(type)) {
      kind = Kind.MAPPED;
    } else if (List.class.isAssignableFrom(type)) {
      kind = Kind.INDEXED;
    } else if (type.isArray()) {
      kind = Kind.INDEXED;
    } else {
      kind = Kind.SIMPLE;
    }
    if ((kind != Kind.SIMPLE) && (contentType == null)) {
      throw new NullPointerException(
          "The contentType cannot be null for non-simple property.");
    }
  }

  /**
   * Gets the name of this property.
   *
   * @return the name of this property.
   */
  public String getName() {
    return name;
  }

  /**
   * Tests whether this property is a simple property.
   *
   * @return {@code true} if this property is a simple property; {@code false}
   *         otherwise.
   */
  public boolean isSimple() {
    return kind == Kind.SIMPLE;
  }

  /**
   * Tests whether this property is an indexed property.
   *
   * @return {@code true} if this property is an indexed property; {@code false}
   *         otherwise.
   */
  public boolean isIndexed() {
    return kind == Kind.INDEXED;
  }

  /**
   * Tests whether this property is a mapped property.
   *
   * @return {@code true} if this property is a mapped property; {@code false}
   *         otherwise.
   */
  public boolean isMapped() {
    return kind == Kind.MAPPED;
  }

  /**
   * Gets the kind of this property.
   *
   * @return the kind of this property.
   */
  public Kind getKind() {
    return kind;
  }

  /**
   * Gets the type of values stored in this property.
   *
   * @return the type of values stored in this property.
   */
  public Class<?> getType() {
    return type;
  }

  /**
   * Gets the type of contents stored in the value of this property.
   * <p>
   * The content type is only meaningful for indexed or mapped properties. The
   * simple property has no content type, therefore calling this function on a
   * simple property will returns {@code null}.
   *
   * @return the type of contents stored in the value of this property; or
   *         {@code null} if this property is a simple property.
   */
  public Class<?> getContentType() {
    return contentType;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 13)
        .append(name)
        .append(kind)
        .append(type)
        .append(contentType)
        .build();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    final Property rhs = (Property) obj;
    return new EqualsBuilder()
        .append(name, rhs.name)
        .append(kind, rhs.kind)
        .append(type, rhs.type)
        .append(contentType, rhs.contentType)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("kind", kind)
        .append("type", type)
        .append("contentType", contentType)
        .build();
  }
}
