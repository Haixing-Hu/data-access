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

import java.io.IOException;

/**
 * Thrown to indicate a data access error.
 *
 * @author Haixing Hu
 */
public class DataAccessException extends IOException {

  private static final long serialVersionUID = 7227656515705509452L;

  public DataAccessException() {
    super();
  }

  public DataAccessException(final String message) {
    super(message);
  }

  public DataAccessException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public DataAccessException(final Throwable cause) {
    super(cause);
  }

}
