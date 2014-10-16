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

import java.util.List;

import javax.annotation.Nullable;

/**
 * The interface for all objects with a tag list.
 *
 * @author Haixing Hu
 */
public interface Taggable {

  /**
   * Gets the list of tags attached to this object.
   *
   * @return the list of tags attached to this object, which <b>may</b> be
   *         {@code null}.
   */
  public List<Tag> getTags();

  /**
   * Sets the tags attached to this object.
   *
   * @param tags
   *          the new list of tags to set, which <b>may</b> be {@code null}.
   */
  public void setTags(@Nullable final List<Tag> tags);

}
