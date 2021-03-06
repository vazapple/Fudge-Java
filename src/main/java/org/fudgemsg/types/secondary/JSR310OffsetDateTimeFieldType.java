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
package org.fudgemsg.types.secondary;

import javax.time.calendar.OffsetDateTime;

import org.fudgemsg.types.FudgeDateTime;
import org.fudgemsg.types.SecondaryFieldType;
import org.fudgemsg.wire.types.FudgeWireType;

/**
 * Secondary type for JSR-310 object conversion.
 */
public class JSR310OffsetDateTimeFieldType extends SecondaryFieldType<OffsetDateTime,FudgeDateTime> {
  
  /**
   * Singleton instance of the type.
   */
  public static final JSR310OffsetDateTimeFieldType INSTANCE = new JSR310OffsetDateTimeFieldType ();
  
  /**
   * Restricted constructor.
   */
  private JSR310OffsetDateTimeFieldType () {
    super (FudgeWireType.DATETIME, OffsetDateTime.class);
  }

  //-------------------------------------------------------------------------
  @Override
  public FudgeDateTime secondaryToPrimary(final OffsetDateTime object) {
    return new FudgeDateTime (object);
  }
  
  @Override
  public OffsetDateTime primaryToSecondary (final FudgeDateTime object) {
    return object.toOffsetDateTime ();
  }

}