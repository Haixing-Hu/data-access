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
 * A {@link Person} represents a person. It's an entity.
 *
 * @author Haixing Hu
 */
public class Person implements Entity<Long>, Taggable {

  private Long id;
  private Name name;
  private String email;
  private String phone;
  private String address;
  private String url;
  private Country country;
  private List<Tag> tags;

  /**
   * Constructs a {@link Person}.
   */
  public Person() {
    this(null);
  }

  /**
   * Constructs a {@link Person}.
   *
   * @param name
   *          the name of the person, or {@code null} if none.
   */
  public Person(@Nullable final Name name) {
    id = null;
    this.name = name;
    email = null;
    url = null;
    phone = null;
    address = null;
    country = null;
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
   * Gets the name of this person.
   *
   * @return the name of this person, or {@code null} if it has none.
   */
  public final Name getName() {
    return name;
  }

  /**
   * Sets the name of this person.
   *
   * @param name
   *          the new name to set, or {@code null} to set none.
   */
  public final void setName(@Nullable final Name name) {
    this.name = name;
  }

  /**
   * Gets the email of this person.
   *
   * @return the email of this person, or {@code null} if it has none.
   */
  public final String getEmail() {
    return email;
  }

  /**
   * Sets the email of this person.
   *
   * @param email
   *          the new email to set, or {@code null} to set none.
   */
  public final void setEmail(@Nullable final String email) {
    this.email = email;
  }

  /**
   * Gets the URL of this person.
   *
   * @return the URL of this person, or {@code null} if it has none.
   */
  public final String getUrl() {
    return url;
  }

  /**
   * Sets the URL of this person.
   *
   * @param url
   *          the new URK to set, or {@code null} to set none.
   */
  public final void setUrl(@Nullable final String url) {
    this.url = url;
  }

  /**
   * Gets the phone number of this person.
   *
   * @return the phone number of this person, or {@code null} if it has none.
   */
  public final String getPhone() {
    return phone;
  }

  /**
   * Sets the phone number of this person.
   *
   * @param phone
   *          the new phone number to set, or {@code null} to set none.
   */
  public final void setPhone(@Nullable final String phone) {
    this.phone = phone;
  }

  /**
   * Gets the address of this person.
   *
   * @return the address of this person, or {@code null} if it has none.
   */
  public final String getAddress() {
    return address;
  }

  /**
   * Sets the address of this person.
   *
   * @param address
   *          the new address to set, or {@code null} to set none.
   */
  public final void setAddress(@Nullable final String address) {
    this.address = address;
  }

  /**
   * Gets the country of this person.
   *
   * @return the country of this person, or {@code null} if it has none.
   */
  public final Country getCountry() {
    return country;
  }

  /**
   * Sets the country of this person.
   *
   * @param country
   *          the new country to set, or {@code null} to set none.
   */
  public final void setCountry(@Nullable final Country country) {
    this.country = country;
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
