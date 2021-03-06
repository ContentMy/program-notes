package com.runing.utilslib.arscparser.old.type;

import com.runing.utilslib.arscparser.old.util.Bytes;

/*
struct ResChunk_header
{
    // Type identifier for this chunk.  The meaning of this value depends
    // on the containing chunk.
    uint16_t type;

    // Size of the chunk header (in bytes).  Adding this value to
    // the address of the chunk allows you to find its associated data
    // (if any).
    uint16_t headerSize;

    // Total size of this chunk (in bytes).  This is the chunkSize plus
    // the size of any data associated with the chunk.  Adding this value
    // to the chunk allows you to completely skip its contents (including
    // any child chunks).  If this value is the same as chunkSize, there is
    // no data associated with the chunk.
    uint32_t size;
};
 */

/**
 * 资源表 Chunk 基础结构。
 */
public class ResChunkHeader {

  public static final int BYTES = Short.BYTES + Short.BYTES + Integer.BYTES;

  /** Chunk 类型 */
  public short type;
  /** Chunk 头部大小 */
  public short headerSize;
  /** Chunk 大小 */
  public int size;

  public ResChunkHeader(short type, short headerSize, int size) {
    this.type = type;
    this.headerSize = headerSize;
    this.size = size;
  }

  public static ResChunkHeader valueOfBytes(byte[] arsc, int chunkIndex) {
    int index = chunkIndex;
    return new ResChunkHeader(
        Bytes.getShort(arsc, index),
        Bytes.getShort(arsc, index += Short.BYTES),
        Bytes.getInt(arsc, index + Short.BYTES)
    );
  }

  @Override
  public String toString() {
    return Config.BEAUTIFUL ?
        "{" +
            "type=" + type + "(" + ResourceTypes.nameOf(type) + ")" +
            ", headerSize=" + headerSize +
            ", size=" + size +
            '}'
        :
        "ResChunkHeader{" +
            "type=" + type +
            ", headerSize=" + headerSize +
            ", size=" + size +
            '}';
  }
}
