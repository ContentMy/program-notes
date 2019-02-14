package com.runing.utilslib.arscparser.type;

import com.runing.utilslib.arscparser.util.Bytes;

/*
struct ResTable_map_entry : public ResTable_entry
{
    // Resource identifier of the parent mapping, or 0 if there is none.
    // This is always treated as a TYPE_DYNAMIC_REFERENCE.
    ResTable_ref parent;
    // Number of name/value pairs that follow for FLAG_COMPLEX.
    uint32_t count;
};
 */
public class ResTableMapEntry extends ResTableEntry {

  /**
   * 指向父 ResTable_map_entry 的资源 ID，如果没有父 ResTable_map_entry，则等于 0。
   */
  public ResTableRef parent;
  /** bag 项的个数。 */
  public int count;

  public ResTableMapEntry(short size, short flags, ResStringPoolRef key, ResTableRef parent, int count) {
    super(size, flags, key);
    this.parent = parent;
    this.count = count;
  }

  public static ResTableMapEntry valueOfBytes(byte[] arsc, int tableMapEntryIndex) {
    final ResTableEntry tableEntry = ResTableEntry.valueOfBytes(arsc, tableMapEntryIndex);
    return new ResTableMapEntry(
        tableEntry.size,
        tableEntry.flags,
        tableEntry.key,
        new ResTableRef(Bytes.getInt(arsc, tableMapEntryIndex + ResTableEntry.BYTES)),
        Bytes.getInt(arsc, tableMapEntryIndex + ResTableEntry.BYTES + Integer.BYTES)
    );
  }

  @Override
  public String toString() {
    return Config.BEAUTIFUL ?
        "{" +
            "parent=" + parent +
            ", count=" + count +
            ", size=" + size +
            ", flags=" + flags +
            ", key=" + key +
            '}'
        :
        "ResTableMapEntry{" +
            "parent=" + parent +
            ", count=" + count +
            ", size=" + size +
            ", flags=" + flags +
            ", key=" + key +
            '}';
  }
}
