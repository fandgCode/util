package net.ewide.util;

public class CharUtil {
	
	/**
	 * charToByte:字符转byte. <br/>
	 * 
	 * @author Alex
	 * @param c
	 * @return
	 * @since JDK 1.7
	 */
	public static byte toByte(char c) {
		int index = "0123456789ABCDEF".indexOf(c);
		if (index == -1) {
			index = "0123456789abcdef".indexOf(c);
		}
		return (byte) index;
	}

}
