package com.runing.utilslib.arscparser.old.type;

import com.runing.utilslib.arscparser.old.util.Bytes;

/*
struct Res_value
{
    // Number of bytes in this structure.
    uint16_t size;

    // Always set to 0.
    uint8_t res0;

    // Type of the data value.
    enum {
        // The 'data' is either 0 or 1, specifying this resource is either
        // undefined or empty, respectively.
        TYPE_NULL = 0x00,
        // The 'data' holds a ResTable_ref, a reference to another resource
        // table entry.
        TYPE_REFERENCE = 0x01,
        // The 'data' holds an attribute resource identifier.
        TYPE_ATTRIBUTE = 0x02,
        // The 'data' holds an index into the containing resource table's
        // global value string pool.
        TYPE_STRING = 0x03,
        // The 'data' holds a single-precision floating point number.
        TYPE_FLOAT = 0x04,
        // The 'data' holds a complex number encoding a dimension value,
        // such as "100in".
        TYPE_DIMENSION = 0x05,
        // The 'data' holds a complex number encoding a fraction of a
        // container.
        TYPE_FRACTION = 0x06,
        // The 'data' holds a dynamic ResTable_ref, which needs to be
        // resolved before it can be used like a TYPE_REFERENCE.
        TYPE_DYNAMIC_REFERENCE = 0x07,

        // Beginning of integer flavors...
        TYPE_FIRST_INT = 0x10,

        // The 'data' is a raw integer value of the form n..n.
        TYPE_INT_DEC = 0x10,
        // The 'data' is a raw integer value of the form 0xn..n.
        TYPE_INT_HEX = 0x11,
        // The 'data' is either 0 or 1, for input "false" or "true" respectively.
        TYPE_INT_BOOLEAN = 0x12,

        // Beginning of color integer flavors...
        TYPE_FIRST_COLOR_INT = 0x1c,

        // The 'data' is a raw integer value of the form #aarrggbb.
        TYPE_INT_COLOR_ARGB8 = 0x1c,
        // The 'data' is a raw integer value of the form #rrggbb.
        TYPE_INT_COLOR_RGB8 = 0x1d,
        // The 'data' is a raw integer value of the form #argb.
        TYPE_INT_COLOR_ARGB4 = 0x1e,
        // The 'data' is a raw integer value of the form #rgb.
        TYPE_INT_COLOR_RGB4 = 0x1f,

        // ...end of integer flavors.
        TYPE_LAST_COLOR_INT = 0x1f,

        // ...end of integer flavors.
        TYPE_LAST_INT = 0x1f
    };
    uint8_t dataType;

    // Structure of complex data values (TYPE_UNIT and TYPE_FRACTION)
    enum {
        // Where the unit type information is.  This gives us 16 possible
        // types, as defined below.
        COMPLEX_UNIT_SHIFT = 0,
        COMPLEX_UNIT_MASK = 0xf,

        // TYPE_DIMENSION: Value is raw pixels.
        COMPLEX_UNIT_PX = 0,
        // TYPE_DIMENSION: Value is Device Independent Pixels.
        COMPLEX_UNIT_DIP = 1,
        // TYPE_DIMENSION: Value is a Scaled device independent Pixels.
        COMPLEX_UNIT_SP = 2,
        // TYPE_DIMENSION: Value is in points.
        COMPLEX_UNIT_PT = 3,
        // TYPE_DIMENSION: Value is in inches.
        COMPLEX_UNIT_IN = 4,
        // TYPE_DIMENSION: Value is in millimeters.
        COMPLEX_UNIT_MM = 5,

        // TYPE_FRACTION: A basic fraction of the overall size.
        COMPLEX_UNIT_FRACTION = 0,
        // TYPE_FRACTION: A fraction of the parent size.
        COMPLEX_UNIT_FRACTION_PARENT = 1,

        // Where the radix information is, telling where the decimal place
        // appears in the mantissa.  This give us 4 possible fixed point
        // representations as defined below.
        COMPLEX_RADIX_SHIFT = 4,
        COMPLEX_RADIX_MASK = 0x3,

        // The mantissa is an integral number -- i.e., 0xnnnnnn.0
        COMPLEX_RADIX_23p0 = 0,
        // The mantissa magnitude is 16 bits -- i.e, 0xnnnn.nn
        COMPLEX_RADIX_16p7 = 1,
        // The mantissa magnitude is 8 bits -- i.e, 0xnn.nnnn
        COMPLEX_RADIX_8p15 = 2,
        // The mantissa magnitude is 0 bits -- i.e, 0x0.nnnnnn
        COMPLEX_RADIX_0p23 = 3,

        // Where the actual value is.  This gives us 23 bits of
        // precision.  The top bit is the sign.
        COMPLEX_MANTISSA_SHIFT = 8,
        COMPLEX_MANTISSA_MASK = 0xffffff
    };

    // Possible data values for TYPE_NULL.
    enum {
        // The value is not defined.
        DATA_NULL_UNDEFINED = 0,
        // The value is explicitly defined as empty.
        DATA_NULL_EMPTY = 1
    };

    // The data for this item, as interpreted according to dataType.
    typedef uint32_t data_type;
    data_type data;

    void copyFrom_dtoh(const Res_value& src);
};
 */
public class ResValue {
  public static final int BYTES = Short.BYTES + Byte.BYTES + Byte.BYTES + Integer.BYTES;

  /** {@link #BYTES} 大小 */
  public short size;
  /** 0, 保留 */
  public byte res0;

  public static final short TYPE_NULL = 0x00;
  public static final short TYPE_REFERENCE = 0x01;
  public static final short TYPE_ATTRIBUTE = 0x02;
  public static final short TYPE_STRING = 0x03;
  public static final short TYPE_FLOAT = 0x04;
  public static final short TYPE_DIMENSION = 0x05;
  public static final short TYPE_FRACTION = 0x06;
  public static final short TYPE_DYNAMIC_REFERENCE = 0x07;
  public static final short TYPE_FIRST_INT = 0x10;
  public static final short TYPE_INT_DEC = 0x10;
  public static final short TYPE_INT_HEX = 0x11;
  public static final short TYPE_INT_BOOLEAN = 0x12;
  public static final short TYPE_FIRST_COLOR_INT = 0x1c;
  public static final short TYPE_INT_COLOR_ARGB8 = 0x1c;
  public static final short TYPE_INT_COLOR_RGB8 = 0x1d;
  public static final short TYPE_INT_COLOR_ARGB4 = 0x1e;
  public static final short TYPE_INT_COLOR_RGB4 = 0x1f;
  public static final short TYPE_LAST_COLOR_INT = 0x1f;
  public static final short TYPE_LAST_INT = 0x1f;

  /** 数据类型 */
  public byte dataType;

  public static final int COMPLEX_UNIT_SHIFT = 0;
  public static final int COMPLEX_UNIT_MASK = 0xf;
  public static final int COMPLEX_UNIT_PX = 0;
  public static final int COMPLEX_UNIT_DIP = 1;
  public static final int COMPLEX_UNIT_SP = 2;
  public static final int COMPLEX_UNIT_PT = 3;
  public static final int COMPLEX_UNIT_IN = 4;
  public static final int COMPLEX_UNIT_MM = 5;
  public static final int COMPLEX_UNIT_FRACTION = 0;
  public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
  public static final int COMPLEX_RADIX_SHIFT = 4;
  public static final int COMPLEX_RADIX_MASK = 0x3;
  public static final int COMPLEX_RADIX_23p0 = 0;
  public static final int COMPLEX_RADIX_16p7 = 1;
  public static final int COMPLEX_RADIX_8p15 = 2;
  public static final int COMPLEX_RADIX_0p23 = 3;
  public static final int COMPLEX_MANTISSA_SHIFT = 8;
  public static final int COMPLEX_MANTISSA_MASK = 0xffffff;

  public static final int DATA_NULL_UNDEFINED = 0;
  public static final int DATA_NULL_EMPTY = 1;

  /** 数据 */
  public int data;

  public ResValue(short size, byte res0, byte dataType, int data) {
    this.size = size;
    this.res0 = res0;
    this.dataType = dataType;
    this.data = data;
  }

  public static ResValue valueOfBytes(byte[] arsc, int valueIndex) {
    return new ResValue(
        Bytes.getShort(arsc, valueIndex),
        arsc[valueIndex + Short.BYTES],
        arsc[valueIndex + Short.BYTES + Byte.BYTES],
        Bytes.getInt(arsc, valueIndex + Short.BYTES + Byte.BYTES * 2)
    );
  }

  @Override
  public String toString() {
    return Config.BEAUTIFUL ?
        "{" +
            "size=" + size +
            ", res0=" + res0 +
            ", dataType=" + dataType +
            ", data=" + data +
            '}'
        :
        "ResValue{" +
            "size=" + size +
            ", res0=" + res0 +
            ", dataType=" + dataType +
            ", data=" + data +
            '}';
  }
}
