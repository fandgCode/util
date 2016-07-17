package net.ewide.util;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 * ClassName: SocketUtils <br/>
 * Function: 套接字工具类. <br/>
 * date: 2015年2月25日 下午11:30:51 <br/>
 *
 * @author Alex
 * @version 
 * @since JDK 1.7
 */
public class SocketUtils {
	
	/**
     * 检查监听TCP,UDP端口是否已经占用
     * @param listenPort
     * @return
     */
	public static boolean checkPort(int listenPort) {
		if (listenPort < 0 || listenPort > 65536) {
			throw new IllegalArgumentException("Invalid start port: "
					+ listenPort);
		}
		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(listenPort);
			ss.setReuseAddress(true);
			ds = new DatagramSocket(listenPort);
			ds.setReuseAddress(true);
			return true;
		} catch (IOException e) {
		} finally {
			if (ds != null) {
				ds.close();
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// should not be thrown, just detect port available.
				}
			}
		}
		return false;
	}

}
