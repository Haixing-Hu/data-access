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
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link Language} represents a language. It's a value object.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "language")
public final class Language {

  @XmlElement(required = true)
  private String code;

  @XmlElement(required = true)
  private String name;

  @XmlElement(required = false)
  private String abbreviation;

  @XmlElement(required = false)
  private String description;

  /**
   * Constructs an empty {@link Language}.
   */
  public Language() {
    code = StringUtils.EMPTY;
    name = StringUtils.EMPTY;
    abbreviation = null;
    description = null;
  }

  /**
   * Constructs a language.
   *
   * @param code
   *          the ISO 639-2 code of the language.
   * @param name
   *          the name of the language.
   */
  public Language(final String code, final String name) {
    this.code = requireNonNull("code", code);
    this.name = requireNonNull("name", name);
    abbreviation = null;
    description = null;
  }

  /**
   * Constructs a language.
   *
   * @param code
   *          the ISO 639-2 code of the language.
   * @param name
   *          the name of the language.
   * @param abbreviation
   *          the abbreviation of the language, or {@code null} if it has none.
   * @param description
   *          the description of the language, or {@code null} if it has none.
   */
  public Language(final String code, final String name,
      @Nullable final String abbreviation, @Nullable final String description) {
    this.code = requireNonNull("code", code);
    this.name = requireNonNull("name", name);
    this.abbreviation = abbreviation;
    this.description = description;
  }

  /**
   * Gets the ISO 639-2 code of this language.
   *
   * @return the ISO 639-2 code of this language.
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the ISO 639-2 code of this language.
   *
   * @param code
   *          the new ISO 639-2 code to set.
   */
  public void setCode(final String code) {
    this.code = requireNonNull("code", code);
  }

  /**
   * Gets the name of this language.
   *
   * @return the name of this language.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this language.
   *
   * @param name
   *          the new name to set.
   */
  public void setName(final String name) {
    this.name = requireNonNull("name", name);
  }

  /**
   * Gets the abbreviation of this language.
   *
   * @return the abbreviation of the language, or {@code null} if it has none.
   */
  public String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets the abbreviation of this language.
   *
   * @param abbreviation
   *          the new abbreviation to set, or {@code null} to set none.
   */
  public void setAbbreviation(@Nullable final String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the description of this language.
   *
   * @return the description of the language, or {@code null} if it has none.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of this language.
   *
   * @param description
   *          the new description to set, or {@code null} to set none.
   */
  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 2)
        .append(code)
        .append(name)
        .append(abbreviation)
        .append(description)
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
    final Language rhs = (Language) obj;
    return new EqualsBuilder()
        .append(code, rhs.code)
        .append(name, rhs.name)
        .append(abbreviation, rhs.abbreviation)
        .append(description, rhs.description)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("code", code)
        .append("name", name)
        .append("abbreviation", abbreviation)
        .append("description", description)
        .toString();
  }
}
