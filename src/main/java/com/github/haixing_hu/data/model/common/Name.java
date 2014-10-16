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
package com.github.haixing_hu.data.model.common;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link Name} represents the name of a person. It's a value object.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "name")
public final class Name {

  @XmlElement(required = true)
  private String given;

  @XmlElement(required = false)
  private String middle;

  @XmlElement(required = true)
  private String family;

  @XmlElement(required = false)
  private String display;

  /**
   * Constructs an empty {@link Name}.
   */
  public Name() {
    given = StringUtils.EMPTY;
    middle = null;
    display = null;
    family = StringUtils.EMPTY;
  }

  /**
   * Constructs a {@link Name}.
   *
   * @param given
   *          the given name.
   * @param family
   *          the family name.
   */
  public Name(final String given, final String family) {
    this.given = requireNonNull("given", given);
    middle = null;
    this.family = requireNonNull("family", family);
    display = null;
  }

  /**
   * Constructs a {@link Name}.
   *
   * @param given
   *          the given name.
   * @param middle
   *          the middle name, or {@code null} if it has none.
   * @param family
   *          the family name.
   */
  public Name(final String given, @Nullable final String middle,
      final String family) {
    this.given = requireNonNull("given", given);
    this.middle = middle;
    this.family = requireNonNull("family", family);
    display = null;
  }

  /**
   * Constructs a {@link Name}.
   *
   * @param given
   *          the given name.
   * @param middle
   *          the middle name, or {@code null} if it has none.
   * @param family
   *          the family name.
   * @param display
   *          the display name, or {@code null} if it has none.
   */
  public Name(final String given, @Nullable final String middle,
      final String family, final String display) {
    this.given = requireNonNull("given", given);
    this.middle = middle;
    this.family = requireNonNull("family", family);
    this.display = display;
  }

  /**
   * Gets the given name.
   *
   * @return the given name, which cannot be {@code null}.
   */
  public String getGiven() {
    return given;
  }

  /**
   * Sets the given name.
   *
   * @param given
   *          the new given name to set, which cannot be {@code null}.
   */
  public void setGiven(final String given) {
    this.given = requireNonNull("given", given);
  }

  /**
   * Gets the middle name.
   *
   * @return the middle name, or {@code null} if it has none.
   */
  public String getMiddle() {
    return middle;
  }

  /**
   * Sets the middle name.
   *
   * @param middle
   *          the new middle name to set, or {@code null} to set none.
   */
  public void setMiddle(@Nullable final String middle) {
    this.middle = middle;
  }

  /**
   * Gets the family name.
   *
   * @return the family name, which cannot be {@code null}.
   */
  public String getFamily() {
    return family;
  }

  /**
   * Sets the family.
   *
   * @param family
   *          the new family to set.
   */
  public void setFamily(final String family) {
    this.family = requireNonNull("family", family);
  }

  /**
   * Gets the display name.
   * <p>
   * A display name specifies how the name are displayed. If it is not
   * specified, the application should use the default formating rule to format
   * name and display it.
   *
   * @return the display name, or {@code null} if it has none.
   */
  public String getDisplay() {
    return display;
  }

  /**
   * Sets the display name.
   * <p>
   * A display name specifies how the name are displayed. If it is not
   * specified, the application should use the default formating rule to format
   * name and display it.
   *
   * @param display
   *          the new display name to set, or {@code null} to set none.
   */
  public void setDisplay(@Nullable final String display) {
    this.display = display;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 3)
        .append(given)
        .append(middle)
        .append(family)
        .append(display)
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
    final Name rhs = (Name) obj;
    return new EqualsBuilder()
        .append(given, rhs.given)
        .append(middle, rhs.middle)
        .append(family, rhs.family)
        .append(display, rhs.display)
        .build();
  }

  @Override
  public String toString() {
    if ((display != null) && (display.length() > 0)) {
      return display;
    }
    final StringBuilder builder = new StringBuilder();
    builder.append(given);
    if ((middle != null) && (middle.length() > 0)) {
      builder.append(' ').append(middle);
    }
    builder.append(' ').append(family);
    return builder.toString();
  }
}
