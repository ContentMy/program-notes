package com.runing.utilslib.arscparser.core2;

import com.runing.utilslib.arscparser.type.ResTableType;
import com.runing.utilslib.arscparser.type.ResTableTypeSpec;
import com.runing.utilslib.arscparser.util.Bytes;

public class TableTypeChunkParser {

  @SuppressWarnings("Duplicates")
  public static int[] parseSpecEntryArray(byte[] arsc, ResTableTypeSpec tableTypeSpec, int typeSpecIndex) {
    int[] entryArray = new int[tableTypeSpec.entryCount];
    int index = typeSpecIndex + tableTypeSpec.header.headerSize;
    for (int i = 0; i < entryArray.length; i++) {
      entryArray[i] = Bytes.getInt(arsc, index);
      index += Integer.BYTES;
    }
    return entryArray;
  }

  @SuppressWarnings("Duplicates")
  public static int[] parseTypeOffsetArray(byte[] arsc, ResTableType tableType, int typeIndex) {
    int[] entryArray = new int[tableType.entryCount];
    int index = typeIndex + tableType.header.headerSize;
    for (int i = 0; i < entryArray.length; i++) {
      entryArray[i] = Bytes.getInt(arsc, index);
      index += Integer.BYTES;
    }
    return entryArray;
  }
}
