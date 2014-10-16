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
package com.github.haixing_hu.data.model;

import java.io.Serializable;

import javax.annotation.Nullable;

/**
 * Interface for hierarchical entities.
 * <p>
 * Hierarchical entities can be represented as trees. Each entity must have zero
 * or one parent and a collection of children.
 *
 * @param <ID>
 *          the type of the domain entities's identifiers, which must be
 *          serializable.
 * @author Haixing Hu
 */
public interface Hierarchical<ID extends Serializable> extends Entity<ID> {

  /**
   * Gets the identifier of the parent of this entity.
   *
   * @return the identifier of the parent of this entity, or {@code null} if
   *         this entity has no parent.
   */
  public ID getParentId();

  /**
   * Sets the identifier of the parent of this entity.
   *
   * @param parentId
   *          the identifier of the parent to be set to this entity, or
   *          {@code null} to set this entity has no parent.
   */
  public void setParentId(@Nullable final ID parentId);
}
