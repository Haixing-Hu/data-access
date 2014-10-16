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
 * The basic interface for domain object entities.
 *
 * @param <ID>
 *          the type of the domain entities's identifiers, which must be
 *          serializable.
 * @author Haixing Hu
 */
public interface Entity<ID extends Serializable> {

  /**
   * Gets the ID of this entity.
   *
   * @return the ID of this entity, or {@code null} if the ID has not been set.
   */
  public ID getId();

  /**
   * Sets the ID of this entity.
   *
   * @param id
   *          the new ID to be set, or {@code null} to set none.
   */
  public void setId(@Nullable final ID id);
}
