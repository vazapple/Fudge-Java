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
package org.fudgemsg.wire.types;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.fudgemsg.taxonomy.FudgeTaxonomy;

/**
 * The type definition for arrays of 32-bit integers.
 */
final class IntArrayWireType extends FudgeWireType {

  /**
   * Standard Fudge field type: array of 32-bit integers.
   * See {@link FudgeWireType#INT_ARRAY_TYPE_ID}.
   */
  public static final IntArrayWireType INSTANCE = new IntArrayWireType();

  /**
   * Restricted constructor.
   */
  private IntArrayWireType() {
    super(FudgeWireType.INT_ARRAY_TYPE_ID, int[].class);
  }

  //-------------------------------------------------------------------------
  @Override
  public int getSize(Object value, FudgeTaxonomy taxonomy) {
    int[] data = (int[]) value;
    return data.length * 4;
  }

  @Override
  public int[] readValue(DataInput input, int dataSize) throws IOException {
    int nInts = dataSize / 4;
    int[] result = new int[nInts];
    for (int i = 0; i < nInts; i++) {
      result[i] = input.readInt();
    }
    return result;
  }

  @Override
  public void writeValue(DataOutput output, Object value) throws IOException {
    int[] data = (int[]) value;
    for (int i : data) {
      output.writeInt(i);
    }
  }

}
