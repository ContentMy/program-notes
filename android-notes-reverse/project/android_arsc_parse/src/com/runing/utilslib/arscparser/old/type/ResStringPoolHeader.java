package com.runing.utilslib.arscparser.old.type;

import com.runing.utilslib.arscparser.old.util.Bytes;

/*
struct ResStringPool_header
{
    struct ResChunk_header header;

    // Number of strings in this pool (number of uint32_t indices that follow
    // in the data).
    uint32_t stringCount;

    // Number of style span arrays in the pool (number of uint32_t indices
    // follow the string indices).
    uint32_t styleCount;

    // Flags.
    enum {
        // If set, the string index is sorted by the string values (based
        // on strcmp16()).
        SORTED_FLAG = 1<<0,

        // String pool is encoded in UTF-8
        UTF8_FLAG = 1<<8
    };
    uint32_t flags;

    // Index from header of the string data.
    uint32_t stringsStart;

    // Index from header of the style data.
    uint32_t stylesStart;
};
 */

/**
 * 字符串池头部。
 */
public class ResStringPoolHeader {

  public static final int BYTES = ResChunkHeader.BYTES + Integer.BYTES * 5;

  public static final int SORTED_FLAG = 1;
  public static final int UTF8_FLAG = 1 << 8;

  /**
   * {@link ResChunkHeader#type} = {@link ResourceTypes#RES_STRING_POOL_TYPE}
   * <p>
   * {@link ResChunkHeader#headerSize} ={@link #BYTES} 表示头部大小。
   * <p>
   * {@link ResChunkHeader#size} = 整个字符串 Chunk 的大小，包括 headerSize 的大小。
   */
  public ResChunkHeader header;
  /** 字符串的数量 */
  public int stringCount;
  /** 字符串样式的数量 */
  public int styleCount;
  /** 0, SORTED_FLAG, UTF8_FLAG or bitwise or value */
  public int flags;
  /** 字符串内容块相对于其头部的距离 */
  public int stringStart;
  /** 字符串样式块相对于其头部的距离 */
  public int styleStart;


  public ResStringPoolHeader(ResChunkHeader header, int stringCount, int styleCount, int flags, int stringStart, int styleStart) {
    this.header = header;
    this.stringCount = stringCount;
    this.styleCount = styleCount;
    this.flags = flags;
    this.stringStart = stringStart;
    this.styleStart = styleStart;
  }

  public static ResStringPoolHeader valueOfBytes(byte[] arsc, ResChunkHeader header, int stringPoolIndex) {
    int index = stringPoolIndex;
    return new ResStringPoolHeader(
        header,
        Bytes.getInt(arsc, index += ResChunkHeader.BYTES),
        Bytes.getInt(arsc, index += Integer.BYTES),
        Bytes.getInt(arsc, index += Integer.BYTES),
        Bytes.getInt(arsc, index += Integer.BYTES),
        Bytes.getInt(arsc, index + Integer.BYTES)
    );
  }

  @Override
  public String toString() {
    return Config.BEAUTIFUL ?
        "{" +
            "header=" + header +
            ", stringCount=" + stringCount +
            ", styleCount=" + styleCount +
            ", flags=" + flags +
            ", stringStart=" + stringStart +
            ", styleStart=" + styleStart +
            '}'
        :
        "ResStringPoolHeader{" +
            "header=" + header +
            ", stringCount=" + stringCount +
            ", styleCount=" + styleCount +
            ", flags=" + flags +
            ", stringStart=" + stringStart +
            ", styleStart=" + styleStart +
            '}';
  }
}