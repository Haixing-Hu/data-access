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
import java.util.Date;

import javax.annotation.Nullable;

/**
 * Interface for auditable entities.
 * <p>
 * Allows storing and retrieving creation and modification information. The
 * changing instance (typically some user) is to be defined by a generic
 * definition.
 *
 * @param <U>
 *          the auditing type. Typically some kind of user.
 * @param <ID>
 *          the type of the audited type's identifier, which must be
 *          serializable.
 * @author Haixing Hu
 */
public interface Auditable<U, ID extends Serializable> {

  /**
   * Gets the user who created this entity.
   *
   * @return the user who created this entity, which will never be {@code null}.
   */
  public U getCreatedBy();

  /**
   * Sets the user who created this entity.
   *
   * @param createdBy
   *          the new user who created this entity, which cannot be {@code null}.
   */
  public void setCreatedBy(final U createdBy);

  /**
   * Gets the time when this entity was created.
   *
   * @return the time when this entity was created, which will never be
   *         {@code null}.
   */
  public Date getCreatedTime();

  /**
   * Sets the time when this entity was created.
   *
   * @param createdTime
   *          the new time when this entity was created, which cannot be
   *          {@code null}.
   */
  public void setCreatedTime(final Date createdTime);

  /**
   * Gets the user who modified this entity lastly.
   * <p>
   * If this entity has not been modified after creation, its last modified
   * user is the same as its creation user.
   *
   * @return the user who modified this entity lastly, which will never be
   *         {@code null}.
   */
  public U getLastModifiedBy();

  /**
   * Sets the user who modified this entity lastly.
   * <p>
   * If this entity has not been modified after creation, its last modified
   * user is the same as its creation user.
   *
   * @param lastModifiedBy
   *          the new user who modified this entity lastly, which cannot be
   *          {@code null}.
   */
  public void setLastModifiedBy(final U lastModifiedBy);

  /**
   * Gets the time of the last modification made to this entity.
   * <p>
   * If this entity has not been modified after creation, its last modified
   * time is the same as its creation time.
   *
   * @return the time of the last modification made to this entity, which will
   *         never be {@code null}.
   */
  public Date getLastModifiedTime();

  /**
   * Sets the time of the last modification made to this entity.
   * <p>
   * If this entity has not been modified after creation, its last modified
   * time is the same as its creation time.
   *
   * @param lastModifiedTime
   *          the new time of the last modification made to this entity, which
   *          cannot be {@code null}.
   */
  public void setLastModifiedTime(final Date lastModifiedTime);

  /**
   * Tests whether this entity has been deleted.
   *
   * @return {@code true} if this entity has been deleted; {@code false}
   *         otherwise.
   */
  public boolean isDeleted();

  /**
   * Sets whether this entity has been deleted.
   *
   * @param deleted
   *          {@code true} to set this entity has been deleted; {@code false}
   *          otherwise.
   */
  public void setDeleted(final boolean deleted);

  /**
   * Gets the user who deleted this entity.
   *
   * @return the user who deleted this entity, which could be {@code null} if
   *         the entity has not been deleted.
   */
  public U getDeletedBy();

  /**
   * Sets the user who deleted this entity.
   *
   * @param deletedBy
   *          the new user who deleted this entity, which could be {@code null}
   *          if the entity has not been deleted.
   */
  public void setDeletedBy(@Nullable final U deletedBy);

  /**
   * Gets the time when this entity was deleted.
   *
   * @return the new time when this entity was deleted, which could be
   *         {@code null} if the entity has not been deleted.
   */
  public Date getDeletedTime();

  /**
   * Sets the time when this entity was deleted.
   *
   * @param deletedTime
   *          the new time when this entity was deleted, which could be
   *          {@code null} if the entity has not been deleted.
   */
  public void setDeletedTime(@Nullable final Date deletedTime);
}
