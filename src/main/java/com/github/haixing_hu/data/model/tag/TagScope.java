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

/**
 * The enumeration of predefined tag scopes.
 *
 * @author Haixing Hu
 */
public enum TagScope {

  /**
   * Represents an UNKNOWN tag scope.
   */
  UNKNOWN,

  /**
   * The tags in the this scope represent the domain of the entity.
   */
  DOMAIN,

  /**
   * The tags in the this scope represent the type of the entity.
   */
  TYPE,

  /**
   * The tags in the this scope represent the category of the entity.
   */
  CATEGORY,

  /**
   * The tags in the this scope represent the keyword of the entity.
   */
  KEYWORD,

  /**
   * The tags in the this scope represent the status of the entity.
   */
  STATUS,

  /**
   * The tags in the this scope represent the color label of the entity.
   */
  COLOR_LABEL,

  /**
   * The tags in the this scope represent the access mode of the entity.
   */
  ACCESS_MODE,
}
