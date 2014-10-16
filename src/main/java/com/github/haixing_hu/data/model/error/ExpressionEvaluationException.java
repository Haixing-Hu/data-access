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
package com.github.haixing_hu.data.model.error;

/**
 * An exception thrown to indicate an object is not a bean.
 *
 * @author Haixing Hu
 */
public class ExpressionEvaluationException extends BeanException {

  private static final long serialVersionUID = -3197420118128561242L;

  public ExpressionEvaluationException(final String message) {
    super(message);
  }
}