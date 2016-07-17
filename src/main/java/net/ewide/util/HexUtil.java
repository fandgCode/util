/**
 * Project Name:util
 * File Name:HexUtil.java
 * Package Name:net.ewide.util
 * Date:2014年10月22日下午12:01:44
 *
 */
package net.ewide.util;

/**
 * ClassName: HexUtil <br/>
 * Function: 16进制转换公用类. <br/>
 * date: 2014年10月22日 下午12:01:44 <br/>
 * 
 * @author Alex
 * @version
 * @since JDK 1.7
 */
public class HexUtil {

	/**
	 * HexString2Int:16进制字符串转整形. <br/>
	 *
	 * @author Alex
	 * @param src
	 * @return
	 * @since JDK 1.7
	 */
	public static int toInt(String src) {
		byte[] b1 = toBytes(src);
		return ByteUtil.toInt(b1);
	}

	/**
	 * toFloat:16进制字符串转float. <br/>
	 *
	 * @author Alex
	 * @param src
	 * @return
	 * @since JDK 1.7
	 */
	public static float toFloat(String src) {
		byte[] b1 = toBytes(src);
		return ByteUtil.toFloat(b1);
	}

	/**
	 * HexString2Bytes:将字符串转换成16进制 如:5582--->0x55 0X. <br/>
	 * 
	 * @author Alex
	 * @param src
	 *            16进制转byte
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] toBytes(String src) {
		int len = src.length() / 2;
		byte[] ret = new byte[len];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < len; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	/**
	 * uniteBytes:将两个ASCII字符合成一个字节 如："EF"--> 0xEF. <br/>
	 * 
	 * @author Alex
	 * @param src0
	 * @param src1
	 * @return
	 * @since JDK 1.7
	 */
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

}
