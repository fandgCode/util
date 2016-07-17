/*
 * (#)StringUtil.java 1.0 2009-9-25 2009-9-25 下午02:32:12
 */
package net.ewide.util;

import java.io.UnsupportedEncodingException;


/**
 * @author Alex
 * @version $1.0, 2009-9-25 2009-9-25 下午02:32:12
 * @since JDK5
 */
public class StringUtil {
	/*
	 * 取得包路径下xml文件的绝对路径 com.sef ==> com/sef
	 * 或者com.sef.Test ==> com/sef/Test
	 * @param filePathName
	 *            包路径
	 * @return String 文件路径
	 */
	public static String getPackagePath(String filePathName) {
		return filePathName.replace('.', '/');
	}

	/**


	/**
	 * 首字母小写.
	 * @param str str
	 * @return String
	 */
	public static String firstLowerCase(String str) {
		String temp = str.substring(1, str.length());
		String first = str.substring(0, 1).toLowerCase();
		return first.concat(temp);
	}

	/**
	 * 首字母大写.
	 * @param str str
	 * @return String
	 */
	public static String firstUpperCase(String str) {
		String temp = str.substring(1, str.length());
		String first = str.substring(0, 1).toUpperCase();
		return first.concat(temp);
	}

	/**
	 * 
	 * strMakeUp:将字符串格式化成指定长度，字符串前补零. <br/>
	 * 
	 * @author chenxiao
	 * @param str
	 * @param length
	 * @return String:补齐之后的字符串
	 * @since JDK 1.6
	 */
	public static String strMakeUp(String str, int length) {
		int ln = str.trim().length();
		for (int i = 0; i < length - ln; i++) {
			str = "0" + str.trim();
		}
		return str;
	}
	
	/**
	 * toBCD:将string类型转换为bcd形式的byte数组. <br/>
	 *
	 * @author Alex
	 * @param str
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] toBCD(String asc){
		int len = asc.length();  
        int mod = len % 2;  
        if (mod != 0) {  
            asc = "0" + asc;  
            len = asc.length();  
        }  
        byte abt[] = new byte[len];  
        if (len >= 2) {  
            len = len / 2;  
        }  
        byte bbt[] = new byte[len];  
        abt = asc.getBytes();  
        int j, k;  
        for (int p = 0; p < asc.length() / 2; p++) {  
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {  
                j = abt[2 * p] - '0';  
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {  
                j = abt[2 * p] - 'a' + 0x0a;  
            } else {  
                j = abt[2 * p] - 'A' + 0x0a;  
            }  
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {  
                k = abt[2 * p + 1] - '0';  
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {  
                k = abt[2 * p + 1] - 'a' + 0x0a;  
            } else {  
                k = abt[2 * p + 1] - 'A' + 0x0a;  
            }  
            int a = (j << 4) + k;  
            byte b = (byte) a;  
            bbt[p] = b;  
        }  
        return bbt;
	}
	
	/**
	 * String to ASCII byte[]
	 */
	public static byte[] stringToAsc(String s){
		byte[] cascii = null ;
		try {
			cascii = s.getBytes("US-ASCII");
		} catch (UnsupportedEncodingException e) {
			
			
		}
		return cascii;
	}
	
	public static void main(String[] args) {
//		System.out.println(toBCD("9999"));
	}
	
}