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
 * The model of web sites.
 *
 * @author Haixing Hu
 */
public class Website implements Entity<Long>, Taggable {

  private Long id;
  private String title;
  private String url;
  private Language language;
  private String description;
  private List<Tag> tags;

  /**
   * Default constructs a {@link Website}.
   */
  public Website() {
    id = null;
    title = null;
    url = null;
    language = null;
    description = null;
    tags = null;
  }

  /**
   * Constructs a {@link Website}.
   *
   * @param url
   *          the URL of the new web site.
   */
  public Website(@Nullable final String url) {
    id = null;
    title = null;
    this.url = url;
    language = null;
    description = null;
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
   * Gets the title.
   *
   * @return the title.
   */
  public final String getTitle() {
    return title;
  }

  /**
   * Sets the title.
   *
   * @param title
   *          the new title to set.
   */
  public final void setTitle(@Nullable final String title) {
    this.title = title;
  }

  /**
   * Gets the url.
   *
   * @return the url.
   */
  public final String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url
   *          the new url to set.
   */
  public final void setUrl(@Nullable final String url) {
    this.url = url;
  }

  /**
   * Gets the language.
   *
   * @return the language.
   */
  public final Language getLanguage() {
    return language;
  }

  /**
   * Sets the language.
   *
   * @param language
   *          the new language to set.
   */
  public final void setLanguage(@Nullable final Language language) {
    this.language = language;
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
  public final void setDescription(final String description) {
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
