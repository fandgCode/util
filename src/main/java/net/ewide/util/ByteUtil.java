package net.ewide.util;

public class ByteUtil {
	
	/**
	 * toInt:字节数组转整形. <br/>
	 *
	 * @author Alex
	 * @param b 字节数组转整形
	 * @return 整形数据
	 * @since JDK 1.7
	 */
//	public static int toInt(byte[] b) {
//		byte[] a = new byte[4];
//		for (int i = 0; i < b.length; i++) {
//			a[i] = b[i];
//		}
//		int result;
//		result = a[0];
//		result &= 0xff;
//		result |= ((long) a[1] << 8);
//		result &= 0xffff;
//		result |= ((long) a[2] << 16);
//		result &= 0xffffff;
//		result |= ((long) a[3] << 24);
//		return result;
//	}
	/**
	 * toInt:字节数组转整形. <br/>
	 *
	 * @author Alex
	 * @param b 字节数组转整形
	 * @return 整形数据
	 * @since JDK 1.7
	 */
	public static int toInt(byte[] b) {
	    int iOutcome = 0;
	    byte bLoop;
	    for (int i = 0; i < b.length; i++) {
	        bLoop = b[i];
	        iOutcome += (bLoop & 0xFF) << (8 * i);
	    }
	    return iOutcome;
	}
	
	/**
	 * toInt:转为整形. <br/>
	 * @author Alex
	 * @param src byte数组
	 * @param reverse [true]地位在前高位在后,[false]高位在前地位在后
	 * @return 整形
	 * @since JDK 1.7
	 */
	public static int toInt(byte[] src,boolean reverse) {
		if(reverse){
			src = reverse(src);
		}
		int value=0;
	    byte bLoop;
	    for (int i = 0; i < src.length; i++) {
	        bLoop = src[i];
	        value |= (bLoop & 0xFF) << (8 * (src.length-1-i));
	    }
	    return value;
	}
	
	/**
	 * toShort:(这里用一句话描述这个方法的作用). <br/>
	 * @author Alex
	 * @param b byte
	 * @return short型
	 * @since JDK 1.7
	 */
	public static short toShort(byte b) {
		return (short) (b & 0xFF);
	}
	
	/**
	 * toFloat:字节数组转float. <br/>
	 * @author Alex
	 * @param b1
	 * @return
	 * @since JDK 1.7
	 */
	public static float toFloat(byte[] b1) {
		float result = Float.intBitsToFloat(ByteUtil.toInt(b1));
		return result;
	}
	
	/**
	 * toHexString:将十六进制转换成字符串. <br/>
	 * 如：0x55;0x82--->5582 (不带格式)
	 * @author Alex
	 * @param b 字节数组
	 * @return 字符串
	 * @since JDK 1.7
	 */
	public static String toHexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}
	
	/**
	 * toHexStringSpace:将十六进制转换成串 如：0x55;0x82--->55 82. <br/>
	 * (带空格分隔)
	 * @author Alex
	 * @param b 字节数组
	 * @return 字符串
	 * @since JDK 1.7
	 */
	public static String toHexStringSpace(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase() + " ";
		}
		return ret;
	}
	
	/**
	 * bytesToBinString:byte转二进制字符串,位数不足前面补零. <br/>
	 * @author Alex
	 * @param src
	 * @return
	 * @since JDK 1.7
	 */
	public static String toBinStr(byte[] src) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < src.length; j++) {
			String bin = Integer.toBinaryString(src[j]);
			while (bin.length() < 8) {
				bin = '0' + bin;
			}
			sb.append(bin);
		}
		return sb.toString();
	}
	
	/**
	 * toAscll:将Byte[]转为ASCLL(不带格式)
	 * @param inBytes [] 字节数组
	 * @return String ascll码
	 * **/
	public static String toAscll(byte[] inBytes) {
		StringBuffer sbuffer = new StringBuffer();
		for (byte b : inBytes) {
			sbuffer.append((char) b);
		}
		sbuffer.insert(2, "-");
		sbuffer.insert(5, "-");
		sbuffer.insert(7, "-");
		return sbuffer.toString();
	}
	
	/**
	 * toLong:字节数组转long型. <br/>
	 * @author Alex
	 * @param bb 字节数组
	 * @return long
	 * @since JDK 1.7
	 */
	public static long toLong(byte[] bb) {
		return ((((long) bb[0] & 0xff) << 56) | (((long) bb[1] & 0xff) << 48)
				| (((long) bb[2] & 0xff) << 40) | (((long) bb[3] & 0xff) << 32)
				| (((long) bb[4] & 0xff) << 24) | (((long) bb[5] & 0xff) << 16)
				| (((long) bb[6] & 0xff) << 8) | (((long) bb[7] & 0xff) << 0));
	}

	/**
	 * toBCD:(这里用一句话描述这个方法的作用). <br/>
	 * @author Alex
	 * @param bytes
	 * @return
	 * @since JDK 1.7
	 */
	public static String toBCDStr(byte[] bytes){
	    StringBuffer temp=new StringBuffer(bytes.length*2);
	    for(int i=0;i<bytes.length;i++){
	    	temp.append((byte)((bytes[i]& 0xf0)>>>4));
	    	temp.append((byte)(bytes[i]& 0x0f));
	    }
	    return temp.toString();
	}
	
	/**
	 * toBCD:(这里用一句话描述这个方法的作用). <br/>
	 * @author Alex
	 * @param bytes
	 * @return
	 * @since JDK 1.7
	 */
	public static int toBCDInt(byte[] bytes){
	    return Integer.parseInt(toBCDStr(bytes));
	}
	
	/**
	 * reverse:数组高地位互转. <br/>
	 * @author Alex
	 * @param bytes
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] reverse(byte[] bytes) {
		byte[] b = new byte[bytes.length]; // 注意这是空串，不是null
		for (int i = 0; i < bytes.length; i++) {
			b[bytes.length - i-1] += bytes[i];
		}
		return b;
	}
	
	/**
	 * toIntStr:转换为整形字符串,位数不足补0. <br/>
	 * @author Alex
	 * @param b
	 * @param i
	 * @return
	 * @since JDK 1.7
	 */
	public static String toIntStr(byte[] b, int i) {
		String str = String.valueOf(toInt(b));
		int length = str.length();
		if(length<i){
			for (int j = 0; j < (i-length); j++) {
				str = "0"+str;
			}
		}
		return str;
	}
	
	/**
	 * merger:合并两个byte数组. <br/>
	 * @author Alex
	 * @param bytes1
	 * @param bytes2
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] merger(byte[] bytes1, byte[] bytes2){
		byte[] byte_3 = new byte[bytes1.length+bytes2.length];  
        System.arraycopy(bytes1, 0, byte_3, 0, bytes1.length);  
        System.arraycopy(bytes2, 0, byte_3, bytes1.length, bytes2.length);  
        return byte_3;
	}
	
	/**
	 * merger:将byte放入byte数组中. <br/>
	 * @author Alex
	 * @param bytes1
	 * @param bytes2
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] merger(byte[] bytes1, byte byte2){
		byte[] byte_3 = new byte[bytes1.length+1];  
        System.arraycopy(bytes1, 0, byte_3, 0, bytes1.length);
        System.arraycopy(byte2, 0, byte_3, 1, 1);  
        return byte_3;
	}
	
	public static void main(String[] args) {
//		byte[] b = {3,68};
		byte[] b = {01,10,99};
		System.out.println(toInt(b));
		System.out.println(toBCDStr(b));
		System.out.println(toBinStr(b));
		
		System.out.println();
//		byte[] b = new byte[]{1,2,3};
		System.out.println(toBinStr(b));
	}
	
}
