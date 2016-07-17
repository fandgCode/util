/**
 * Project Name:util
 * File Name:HttpUtil.java
 * Package Name:com.ctp.util
 * Date:2014-5-21下午1:50:24
 *
 */

package net.ewide.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ClassName:HttpUtil <br/>
 * Function: http请求公用类. <br/>
 * Reason: 用于发送http请求. <br/>
 * Date: 2014-5-21 下午1:50:24 <br/>
 * 
 * @author Alex(yaohao@gmail.com)
 * @version
 * @since JDK 1.6
 * @see
 */
public class HttpUtil {
	static Log logger = LogFactory.getLog(HttpUtil.class);

	/**
	 * getParameterMap:转换request的参数，封装成Map. <br/>
	 * 
	 * @author Alex(yaohao@gmail.com)
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	public static Map getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}
	
}
