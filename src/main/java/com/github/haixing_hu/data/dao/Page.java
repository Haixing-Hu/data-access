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
package com.github.haixing_hu.data.dao;

import java.util.List;

import javax.annotation.concurrent.Immutable;

import com.github.haixing_hu.lang.Equality;
import com.github.haixing_hu.lang.Hash;
import com.github.haixing_hu.text.tostring.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNegative;
import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link Page} is a sublist of a list of objects. It allows gain information
 * about the position of it in the containing entire list.
 *
 * @param <T>
 *          the type of entities.
 * @author Haixing Hu
 */
@Immutable
public final class Page<T> {

  private final long totalEntities;
  private final long totalPages;
  private final PageRequest pageRequest;
  private final List<T> content;

  /**
   * Constructs a {@link Page}.
   *
   * @param totalEntities
   *      the total number of entities in the query result, which may be an
   *      estimation. It must be non-negative.
   * @param totalPages
   *      the estimated total number of pages in the query result, according
   *      to the specified page pageRequest. It must be non-negative.
   * @param pageRequest
   *      the pagination requirements of the query.
   * @param content
   *      the content of the query result in this page.
   */
  public Page(long totalEntities, long totalPages, PageRequest pageRequest,
      List<T> content) {
    this.totalEntities = requireNonNegative("totalEntities", totalEntities);
    this.totalPages = requireNonNegative("totalPages", totalPages);
    this.pageRequest = requireNonNull("pageRequest", pageRequest);
    this.content = requireNonNull("content", content);
  }

  /**
   * Tests whether the content of this page is empty.
   *
   * @return {@code true} if the content of this page is empty; {@code false}
   *         otherwise.
   */
  public boolean isEmpty() {
    return content.isEmpty();
  }

  /**
   * Gets the number of entities in the content of this page.
   *
   * @return the number of entities in the content of this page.
   */
  public int getSize() {
    return content.size();
  }

  /**
   * Gets the total number of entities in the query result, which may be an
   * estimation.
   *
   * @return the total number of entities in the query result, which may be an
   *         estimation.
   */
  public long getTotalEntities() {
    return totalEntities;
  }

  /**
   * Gets the estimated total number of pages in the query result, according to
   * the specified page pageRequest.
   *
   * @return the estimated total number of pages in the query result, according
   *         to the specified page pageRequest.
   */
  public long getTotalPages() {
    return totalPages;
  }

  /**
   * Gets the pagination requirements of the query.
   *
   * @return the pagination requirements of the query.
   */
  public PageRequest getPageRequest() {
    return pageRequest;
  }

  /**
   * Gets the content of the query result in this page.
   *
   * @return the content of the query result in this page.
   */
  public List<T> getContent() {
    return content;
  }

  @Override
  public int hashCode() {
    final int multiplier = 13;
    int code = 2;
    code = Hash.combine(code, multiplier, totalEntities);
    code = Hash.combine(code, multiplier, totalPages);
    code = Hash.combine(code, multiplier, pageRequest);
    code = Hash.combine(code, multiplier, content);
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    @SuppressWarnings("unchecked")
    final Page<T> other = (Page<T>) obj;
    return (totalEntities == other.totalEntities)
        && (totalPages == other.totalPages)
        && Equality.equals(pageRequest, other.pageRequest)
        && Equality.equals(content, other.content);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
                .append("totalEntities", totalEntities)
                .append("totalPages", totalPages)
                .append("pageRequest", pageRequest)
                .append("content", content)
                .toString();
  }
}
