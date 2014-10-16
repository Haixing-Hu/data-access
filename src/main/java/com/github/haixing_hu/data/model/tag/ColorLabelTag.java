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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.haixing_hu.data.model.tag.TagScope.COLOR_LABEL;

/**
 * A {@link ColorLabelTag} is a tag representing a color label.
 * <p>
 * A tag representing a color label have the scope equals to the name of the
 * {@link TagScope#COLOR_LABEL}.
 *
 * @author Haixing Hu
 */
public class ColorLabelTag extends Tag {

  /**
   * This tag represents the label {@link ColorLabel#RED}.
   */
  public static final ColorLabelTag RED =
      new ColorLabelTag(ColorLabel.RED);

  /**
   * This tag represents the label {@link ColorLabel#ORANGE}.
   */
  public static final ColorLabelTag ORANGE =
      new ColorLabelTag(ColorLabel.ORANGE);

  /**
   * This tag represents the label {@link ColorLabel#YELLOW}.
   */
  public static final ColorLabelTag YELLOW =
      new ColorLabelTag(ColorLabel.YELLOW);

  /**
   * This tag represents the label {@link ColorLabel#GREEN}.
   */
  public static final ColorLabelTag GREEN =
      new ColorLabelTag(ColorLabel.GREEN);

  /**
   * This tag represents the label {@link ColorLabel#BLUE}.
   */
  public static final ColorLabelTag BLUE =
      new ColorLabelTag(ColorLabel.BLUE);

  /**
   * This tag represents the label {@link ColorLabel#PURPLE}.
   */
  public static final ColorLabelTag PURPLE =
      new ColorLabelTag(ColorLabel.PURPLE);

  /**
   * This tag represents the label {@link ColorLabel#BLACK}.
   */
  public static final ColorLabelTag BLACK =
      new ColorLabelTag(ColorLabel.BLACK);

  /**
   * Gets the label from a list of tags.
   * <p>
   * This function will check the tags in the tag list, and returns the name of
   * the first tag in the scope {@link TagScope#LABEL}. If there is no
   * such tag, this function will return the name of {@link ColorLabel#NONE}.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the label get from the tag list, or {@link ColorLabel#NONE} if not
   *         found.
   */
  public static ColorLabel getLabel(@Nullable final List<Tag> tags) {
    if (tags == null) {
      return ColorLabel.NONE;
    }
    final String scope = TagScope.ACCESS_MODE.name();
    final Tag tag = TagUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return ColorLabel.NONE;
    } else {
      final String name = tag.getName();
      try {
        return ColorLabel.valueOf(name);
      } catch (final Exception e) {
        final Logger logger = LoggerFactory.getLogger(ColorLabelTag.class);
        logger.error("Invalid label name: {}", name);
        return ColorLabel.NONE;
      }
    }
  }

  /**
   * Sets the label to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a label will
   * be removed, and a new tag representing the specified label will be added to
   * the tag list.
   *
   * @param tags
   *          the list of tags, where to update the label. It could be null. If
   *          it is {@code null}, this function will create a new tag list, put
   *          the tag of the label to the new tag list, and return the new tag
   *          list.
   * @param label
   *          the label to be set, which cannot be {@code null}.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is {@code null}.
   */
  public static List<Tag> setLabel(@Nullable final List<Tag> tags,
      final ColorLabel label) {
    return TagUtils.updateTagInScope(COLOR_LABEL.name(), tags, label.name());
  }

  /**
   * Constructs a tag representing a label.
   *
   * @param label
   *          the label to be represented, which cannot be {@code null}.
   */
  public ColorLabelTag(final ColorLabel label) {
    super(COLOR_LABEL.name(), label.name());
  }
}
