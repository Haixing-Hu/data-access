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

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.github.haixing_hu.lang.Equality;
import com.github.haixing_hu.lang.Hash;
import com.github.haixing_hu.sort.Sort;
import com.github.haixing_hu.text.tostring.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNegative;
import static com.github.haixing_hu.lang.Argument.requirePositive;

/**
 * A {@link PageRequest} encapsulates the pagination requirements of a query.
 *
 * @author Haixing Hu
 */
@Immutable
public final class PageRequest {

  private final long pageIndex;
  private final int pageSize;
  private final Sort sort;

  /**
   * Constructs a {@link PageRequest} requesting the first page.
   * <p>
   * The pages are indexed from 0.
   *
   * @param pageSize
   *          the number of entities of each page, which must be greater than
   *          zero.
   * @param sort
   *          the sort rule specifies the way to sort the query results. If it
   *          is {@code null}, the query result will be sorted in the default
   *          order decided by the database.
   * @throws IllegalArgumentException
   *           if the {@code pageSize} is less than or equal to zero.
   */
  public PageRequest(int pageSize, @Nullable Sort sort) {
    pageIndex = 0;
    this.pageSize = requirePositive("pageSize", pageSize);
    this.sort = sort;
  }

  /**
   * Constructs a {@link PageRequest}.
   * <p>
   * The pages are numbered from 0.
   *
   * @param pageIndex
   *          the index of the page required to be returned in this query
   *          request, which must be greater than or equal to zero.
   * @param pageSize
   *          the number of entities of each page, which must be greater than
   *          zero.
   * @param sort
   *          the sort rule specifies the way to sort the query results. If it
   *          is {@code null}, the query result will be sorted in the default
   *          order decided by the database.
   * @throws IllegalArgumentException
   *           if the {@code pageIndex} is less than zero or the
   *           {@code pageSize} is less than or equal to zero.
   */
  public PageRequest(long pageIndex, int pageSize, @Nullable Sort sort) {
    this.pageIndex = requireNonNegative("pageIndex", pageIndex);
    this.pageSize = requirePositive("pageSize", pageSize);
    this.sort = sort;
  }

  /**
   * Gets the page index.
   * <p>
   * The page index is the index of the page required to be returned in this
   * query request.
   *
   * @return the page index.
   */
  public long getPageIndex() {
    return pageIndex;
  }

  /**
   * Gets the page size.
   * <p>
   * The page size is number of entities of each page.
   *
   * @return the page size.
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Gets the sort rule.
   * <p>
   * The sort rule specifies the way to sort the query results. If it is
   * {@code null}, the query result will be sorted in the default order decided
   * by the database.
   *
   * @return the sort rule, or {@code null} if none.
   */
  public Sort getSort() {
    return sort;
  }

  /**
   * Gets the next page request.
   *
   * @return the next page request.
   */
  public PageRequest next() {
    return new PageRequest(pageIndex + 1, pageSize, sort);
  }

  @Override
  public int hashCode() {
    final int multiplier = 13;
    int code = 2;
    code = Hash.combine(code, multiplier, pageIndex);
    code = Hash.combine(code, multiplier, pageSize);
    code = Hash.combine(code, multiplier, sort);
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
    final PageRequest other = (PageRequest) obj;
    return (pageIndex == other.pageIndex) && (pageSize == other.pageSize)
        && Equality.equals(sort, other.sort);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("pageIndex", pageIndex)
        .append("pageSize", pageSize).append("sort", sort).toString();
  }

}
