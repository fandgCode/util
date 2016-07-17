package net.ewide.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * ClassName: BinUtil <br/>
 * Function: 二进制转换工具类. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2014年9月29日 上午10:03:53 <br/>
 *
 * @author Alex
 * @version
 * @since JDK 1.7
 */
public class BinUtil {

	/**
	 * printHexString:打印16进制字符. <br/>
	 * 
	 * @author Alex
	 * @param b
	 * @since JDK 1.7
	 */
	public static void printHexString(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex.toUpperCase());
		}
	}

	// 
	

//	public static void main(String[] s) {
//		int i = HexString2Int("E3F80200");
//		byte[] b = HexString2Bytes("0B020102");
//		System.out.println(HexString2Float("0B020102") + "");
//	}

	/**
	 * 将int转为低字节在前，高字节在后的byte数组
	 * 
	 * @param n
	 *            int
	 * @return byte[]
	 */
	public static byte[] intToBytesHH(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	/**
	 * 将int转为高字节在前，低字节在后的byte数组
	 * Java和一些windows编程语言如c、c++、delphi所写的网络程序进行通讯时，需要进行相应的转换 windows的字节序为低字节开头
	 * linux,unix的字节序为高字节开头 java则无论平台变化，都是高字节开头
	 * 
	 * @param n
	 *            int
	 * @return byte[]
	 */
	public static byte[] intToBytesLH(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) (i & 0xFF);
		result[1] = (byte) ((i >> 8) & 0xFF);
		result[2] = (byte) ((i >> 16) & 0xFF);
		result[3] = (byte) ((i >> 24) & 0xFF);
		return result;
	}

	/**
	 * 将short转为低字节在前，高字节在后的byte数组
	 * 
	 * @param n
	 *            short
	 * @return byte[]
	 */
	public static byte[] float2BytesLH(short n) {
		byte[] b = new byte[2];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/**
	 * 将short转为高字节在前，低字节在后的byte数组
	 * 
	 * @param n
	 *            short
	 * @return byte[]
	 */
	public static byte[] float2BytesHH(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/*
	 * Convert byte[] to hex
	 * string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int
	 * )来转换成16进制字符串(用","作为分割符号)。
	 * 
	 * @param src byte[] data
	 * 
	 * @return hex string
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			if (i != src.length - 1) {
				stringBuilder.append(hv.toUpperCase());
			} else {
				stringBuilder.append(hv.toUpperCase());
			}
		}
		return stringBuilder.toString();
	}

	

	/**
	 * 返回YYYYMMDDHHMISS格式时间字符串(例如:20141201131400)
	 * 
	 * @param dateFormat日期格式类型
	 *            ： 1>>14201201131400;2>>141201131400
	 * @return String
	 * */
	public static String getDateStr(int dateFormat) {
		String dateStr = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		dateStr = sdf.format(date);
		if (dateFormat == 1) {
			String s1 = dateStr.substring(0, 2);
			String s2 = dateStr.substring(2, 4);
			dateStr = dateStr.substring(4);
			dateStr = s2 + s1 + dateStr;
		} else if (dateFormat == 2) {
			dateStr = dateStr.substring(0, 1);
		}
		// System.out.println("dateStr>>"+dateStr);
		return dateStr;

	}

	/**
	 * 将BCD编码的多个字节Byte[]，转为高位在前，低位在后
	 * 
	 * @param Byte
	 *            []
	 * @return Byte[]
	 * **/
	public static byte[] Bytes2BytesHH_BCD(byte[] inBytes) {
		int len = inBytes.length;
		byte[] rtnBytes = new byte[len];
		for (int i = (len - 1); i >= 0; i--) {
			rtnBytes[len - 1 - i] = inBytes[i];
		}
		return rtnBytes;
	}

	/**
	 * 判断字符串是不是纯数字
	 * 
	 * @param String
	 * @return boolen
	 * **/
	public static boolean isNumeric(String str) {
		int len = str.length();
		for (int i = len; --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// 将byte数组bRefArr转为一个整数,字节数组的低位是整型的低字节位
	public static int ByteArrayToInt(byte[] bRefArr) {
		int iOutcome = 0;
		byte bLoop;

		for (int i = 0; i < bRefArr.length; i++) {
			bLoop = bRefArr[i];
			iOutcome += (bLoop & 0xFF) << (8 * i);
		}
		return iOutcome;
	}

	public static byte[] LongToBytes(long x) {
		byte[] bb = new byte[8];
		bb[0] = (byte) (x >> 56);
		bb[1] = (byte) (x >> 48);
		bb[2] = (byte) (x >> 40);
		bb[3] = (byte) (x >> 32);
		bb[4] = (byte) (x >> 24);
		bb[5] = (byte) (x >> 16);
		bb[6] = (byte) (x >> 8);
		bb[7] = (byte) (x >> 0);
		return bb;
	}

}
