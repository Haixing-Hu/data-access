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
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.data.model.Entity;
import com.github.haixing_hu.data.model.tag.Tag;
import com.github.haixing_hu.data.model.tag.Taggable;

/**
 * The model of organizations.
 *
 * @author Haixing Hu
 */
public class Organization implements Entity<Long>, Taggable {

  private Long id;
  private String name;
  private City city;
  private String address;
  private String email;
  private Website website;
  private String description;
  private List<Tag> tags;

  /**
   * Default constructs an {@link Organization}.
   */
  public Organization() {
    id = null;
    name = null;
    city = null;
    address = null;
    email = null;
    website = null;
    description = null;
    tags = null;
  }

  /**
   * Constructs an {@link Organization}.
   *
   * @param name
   *          the name of the new institute.
   */
  public Organization(@Nullable final String name) {
    id = null;
    this.name = name;
    city = null;
    email = null;
    website = null;
    description = null;
    tags = null;
  }

  /**
   * Constructs an {@link Organization}.
   *
   * @param name
   *          the name of the new institute.
   * @param city
   *          the city of the new institute.
   */
  public Organization(@Nullable final String name, @Nullable final City city) {
    id = null;
    this.name = name;
    this.city = city;
    email = null;
    website = null;
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
   * Gets the city.
   *
   * @return the city.
   */
  public final City getCity() {
    return city;
  }

  /**
   * Sets the city.
   *
   * @param city
   *          the new city to set.
   */
  public final void setCity(@Nullable final City city) {
    this.city = city;
  }

  /**
   * Gets the address.
   *
   * @return the address.
   */
  public final String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   *
   * @param address the new address to set.
   */
  public final void setAddress(final String address) {
    this.address = address;
  }

  /**
   * Gets the email.
   *
   * @return the email.
   */
  public final String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email to set.
   */
  public final void setEmail(@Nullable final String email) {
    this.email = email;
  }

  /**
   * Gets the website.
   *
   * @return the website.
   */
  public final Website getWebsite() {
    return website;
  }

  /**
   * Sets the website.
   *
   * @param website
   *          the new website to set.
   */
  public final void setWebsite(@Nullable final Website website) {
    this.website = website;
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
   * @param description the new description to set.
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
    return ToStringBuilder.reflectionToString(this);
  }
}
