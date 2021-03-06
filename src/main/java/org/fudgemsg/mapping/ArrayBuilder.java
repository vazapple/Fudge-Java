/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fudgemsg.mapping;

import java.lang.reflect.Array;
import java.util.List;

import org.fudgemsg.FudgeMsg;
import org.fudgemsg.MutableFudgeMsg;

/**
 * Builder for Java arrays, stored as a sub-message.
 * <p>
 * This builder is immutable and thread safe.
 *
 * @param <E> the element type of the array
 */
/* package */final class ArrayBuilder<E> implements FudgeBuilder<E[]> {

  /**
   * The array element class.
   */
  private final Class<E> _clazz;

  /**
   * @param clazz type of the array element
   */
  /* package */ArrayBuilder(Class<E> clazz) {
    _clazz = clazz;
  }

  @Override
  public MutableFudgeMsg buildMessage(FudgeSerializer serializer, Object[] array) {
    final MutableFudgeMsg msg = serializer.newMessage();
    for (Object entry : array) {
      serializer.addToMessage(msg, null, null, entry);
    }
    return msg;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E[] buildObject(FudgeDeserializer deserializer, FudgeMsg message) {
    final List<?> list = ListBuilder.INSTANCE.buildObject(deserializer, message);
    return list.toArray((E[]) Array.newInstance(_clazz, list.size()));
  }

}
