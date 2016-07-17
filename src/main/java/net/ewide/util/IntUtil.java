package net.ewide.util;

public class IntUtil {
	
	/**
	 * IntToBinString:整形转二进制类型. <br/>
	 *
	 * @author Alex
	 * @param int 整形数据
	 * @return binStr 二进制字符输出
	 * @since JDK 1.7
	 */
	public static String toBinStr(int x) {
		StringBuffer s = new StringBuffer();
		for (int i = 31; i >= 0; i--) {
			if (((1 << i) & x) != 0)
				s.append("1");
			else
				s.append("0");
		}
		return s.toString();
	}
	
	/**
	 * toBytes:整形转字节数组. <br/>
	 * @author Alex
	 * @param iSource 整形
	 * @param iArrayLen 数组长度
	 * @return 字节数组
	 * @since JDK 1.7
	 */
	public static byte[] toBytes(int iSource, int iArrayLen) {
		byte[] bLocalArr = new byte[iArrayLen];
		for (int i = 0; (i < 4) && (i < iArrayLen); i++) {
			bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
		}
		return bLocalArr;
	}
	
	/**
	 * toBytes:整形转字节数组. <br/>
	 * @author Alex
	 * @param i 整形
	 * @return 字节数组
	 * @since JDK 1.7
	 */
	public static byte[] toBytes(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

}
