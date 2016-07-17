/**
 * Project Name:util
 * File Name:ExceptionUtil.java
 * Package Name:com.ctp.util
 * Date:2014-3-22下午5:20:36
 *
*/

package net.ewide.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * ClassName:ExceptionUtil <br/>
 * Function: 异常公用类. <br/>
 * Date:     2014-3-22 下午5:20:36 <br/>
 * @author   Alex(yaohao@gmail.com)
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ExceptionUtil {
	
	/**
	 * getStackTrace:获取堆栈信息. <br/>
	 * @author Alex(yaohao@gmail.com)
	 * @param e
	 * @return 
	 * @since JDK 1.6
	 */
	public static String getStackTrace(Exception e){
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		e.printStackTrace(new PrintWriter(buf, true));
		return buf.toString();
	}
	
	public static String getStackTrace(Throwable e){
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		e.printStackTrace(new PrintWriter(buf, true));
		return buf.toString();
	}

}

