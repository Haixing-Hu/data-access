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
package com.github.haixing_hu.data.model.tag;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.data.model.Hierarchical;

import static com.github.haixing_hu.lang.Argument.requireNonEmpty;

/**
 * A {@link Tag} represents a hierarchical tag. It's a hierarchical entity.
 *
 * @author Haixing Hu
 */
public class Tag implements Hierarchical<Long> {

  /**
   * The default scope of a tag.
   */
  public static final String DEFAULT_SCOPE = TagScope.UNKNOWN.name();

  /**
   * The default name of a tag.
   */
  public static final String DEFAULT_NAME = "Untitled";

  private Long id;
  private Long parentId;
  private String scope;
  private String name;
  private String description;

  /**
   * Constructs an empty {@link Tag}.
   */
  public Tag() {
    id = null;
    parentId = null;
    scope = DEFAULT_SCOPE;
    name = DEFAULT_NAME;
    description = null;
  }

  /**
   * Constructs a {@link Tag}.
   *
   * @param scope
   *          the scope of the tag, which cannot be {@code null} nor empty.
   * @param name
   *          the name of the tag, which cannot be {@code null} nor empty.
   */
  public Tag(final String scope, final String name) {
    id = null;
    parentId = null;
    this.scope = requireNonEmpty("scope", scope);
    this.name = requireNonEmpty("name", name);
    description = null;
  }

  /**
   * Constructs a {@link Tag}.
   *
   * @param scope
   *          the scope of the tag, which cannot be {@code null} nor empty.
   * @param name
   *          the name of the tag, which cannot be {@code null} nor empty.
   * @param description
   *          the description of the tag, or {@code null} if it has none.
   */
  public Tag(final String scope, final String name,
      @Nullable final String description) {
    id = null;
    parentId = null;
    this.scope = requireNonEmpty("scope", scope);
    this.name = requireNonEmpty("name", name);
    this.description = description;
  }

  /**
   * Constructs a {@link Tag}.
   *
   * @param id
   *          the ID of the tag, or {@code null} if it has none.
   * @param parentId
   *          the ID of the parent of the tag, or {@code null} if it has none.
   * @param scope
   *          the scope of the tag, which cannot be {@code null} nor empty.
   * @param name
   *          the name of the tag, which cannot be {@code null} nor empty.
   * @param description
   *          the description of the tag, or {@code null} if it has none.
   */
  public Tag(@Nullable final Long id, @Nullable final Long parentId,
      final String scope, final String name,
      @Nullable final String description) {
    this.id = id;
    this.parentId = parentId;
    this.scope = requireNonEmpty("scope", scope);
    this.name = requireNonEmpty("name", name);
    this.description = description;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(@Nullable final Long id) {
    this.id = id;
  }

  @Override
  public Long getParentId() {
    return parentId;
  }

  @Override
  public void setParentId(@Nullable final Long parentId) {
    this.parentId = parentId;
  }

  /**
   * Gets the scope of this tag.
   *
   * @return the scope of this tag.
   */
  public String getScope() {
    return scope;
  }

  /**
   * Sets the scope of this tag.
   *
   * @param scope
   *          the new scope to set, which cannot be {@code null} nor empty.
   */
  public void setScope(final String scope) {
    this.scope = requireNonEmpty("scope", scope);
  }

  /**
   * Gets the name of this tag.
   *
   * @return the name of this tag.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this tag.
   *
   * @param name
   *          the new name to set, which cannot be {@code null} nor empty.
   */
  public void setName(final String name) {
    this.name = requireNonEmpty("name", name);
  }

  /**
   * Gets the description of this tag.
   *
   * @return the description, or {@code null} if it has none.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of this tag.
   *
   * @param description
   *          the new description to set, or {@code null} to set none.
   */
  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 13)
        .append(id)
        .append(parentId)
        .append(scope)
        .append(name)
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
    final Tag rhs = (Tag) obj;
    return new EqualsBuilder()
        .append(id, rhs.id)
        .append(parentId, rhs.parentId)
        .append(scope, rhs.scope)
        .append(name, rhs.name)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("parentId", parentId)
        .append("scope", scope)
        .append("name", name)
        .build();
  }
}
