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

import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.github.haixing_hu.data.model.Entity;
import com.github.haixing_hu.data.model.tag.Tag;
import com.github.haixing_hu.data.model.tag.Taggable;

/**
 * A {@link City} represents a city. It's an entity.
 *
 * @author Haixing Hu
 */
public class City implements Entity<Long>, Taggable {

  private Long id;
  private String name;
  private String abbreviation;
  private String province;
  private Country country;
  private String description;
  private List<Tag> tags;

  /**
   * Constructs a city.
   */
  public City() {
    this(null, null, null);
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   */
  public City(@Nullable final String name) {
    this(name, null, null);
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param country
   *          the country of the new city.
   */
  public City(@Nullable final String name, @Nullable final Country country) {
    this(name, null, country);
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param abbreviation
   *          the abbreviation of the new city.
   */
  public City(@Nullable final String name, @Nullable final String abbreviation) {
    this(name, abbreviation, null);
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param abbreviation
   *          the abbreviation of the new city.
   * @param country
   *          the country of the new city.
   */
  public City(@Nullable final String name, @Nullable final String abbreviation,
      @Nullable final Country country) {
    id = null;
    this.name = name;
    this.abbreviation = abbreviation;
    this.country = country;
    description = null;
    tags = null;
  }

  @Override
  public final Long getId() {
    return id;
  }

  @Override
  public final void setId(@Nullable final Long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name.
   */
  public final String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name to set.
   */
  public final void setName(@Nullable final String name) {
    this.name = name;
  }

  /**
   * Gets the abbreviation.
   *
   * @return the abbreviation.
   */
  public final String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets the abbreviation.
   *
   * @param abbreviation
   *          the new abbreviation to set, which may be {@code null}.
   */
  public final void setAbbreviation(@Nullable final String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the province.
   *
   * @return the province.
   */
  public final String getProvince() {
    return province;
  }

  /**
   * Sets the province.
   *
   * @param province
   *          the new province to set, which may be {@code null}.
   */
  public final void setProvince(@Nullable final String province) {
    this.province = province;
  }

  /**
   * Gets the country.
   *
   * @return the country.
   */
  public final Country getCountry() {
    return country;
  }

  /**
   * Sets the country.
   *
   * @param country
   *          the new country to set, which may be {@code null}.
   */
  public final void setCountry(@Nullable final Country country) {
    this.country = country;
  }

  /**
   * Gets the description.
   *
   * @return the description.
   */
  public final String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description
   *          the new description to set.
   */
  public final void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Override
  public final List<Tag> getTags() {
    return tags;
  }

  @Override
  public final void setTags(@Nullable final List<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
