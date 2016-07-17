/**
 * Project Name:cherry-chain-http
 * File Name:JsonUtil.java
 * Package Name:net.ewide.transmission.util
 * Date:2013年10月24日上午10:59:46
 *
 */

package net.ewide.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * ClassName:JsonUtil. <br/>
 * JSON工具类.
 * <p/>
 * Date: 2013年10月24日 上午10:59:46 <br/>
 * @author Alex
 * @version 1.0.0
 * @since JDK 1.6
 */
public class JsonUtil {
	private static SerializeConfig mapping = new SerializeConfig();
	private static String dateFormat;
	private static String timeFormat;
	static {
		timeFormat = "yyyy-MM-dd HH:mm:ss";
		dateFormat = "yyyy-MM-dd";
	    mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
	    mapping.put(java.sql.Date.class, new SimpleDateFormatSerializer(dateFormat));
	    mapping.put(java.sql.Timestamp.class, new SimpleDateFormatSerializer(timeFormat));
	}

	/**
	 * readObject: 从json字符串中读取一个对象. <br/>
	 * 
	 * @author Alex
	 * @param json
	 *            需要转换成对象的json字符串
	 * @param clazz
	 *            要读取的对象类型
	 * @return
	 * @since JDK 1.6
	 */
	public static <T> T readObject(String json, Class<T> clazz) {
		if (null == json || "".equals(json)) {
			return null;
		}
		try {
			return JSON.parseObject(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * readObject:用于json的序列化和反序列化. <br/>
	 * @author Alex
	 * @param jsonbytes json的byte数组
	 * @param clazz 转换的类
	 * @return
	 * @since JDK 1.7
	 */
	public static <T> T readObject(byte[] jsonbytes, Class<T> clazz) {
		if (null == jsonbytes) {
			return null;
		}
		try {
			String json = new String(jsonbytes, "UTF-8");
			return JSON.parseObject(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * readArray:(将Json格式的数据转成List). <br/>
	 *
	 * @author SJ
	 * @param str 要转换成json的对象
	 * @param clazz 要转换成的对象类型
	 * @return List<clazz>
	 * @since JDK 1.6
	 */
	public static <T> List<T> readArray(String json, Class<T> clazz) {
		if (null == json || "".equals(json)) {
			return null;
		}
		try {
			return JSON.parseArray(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * writeObject: 将一个对象转换成json字符串. <br/>
	 * 
	 * @author Alex
	 * @param obj 要转换成json的对象
	 * @return 转换之后的json字符串
	 * @since JDK 1.6
	 */
	public static String writeObject(Object obj) {
		if (null == obj) {
			return null;
		}
		try {
			return JSON.toJSONString(obj, mapping);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * writeObject:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author Alex
	 * @param obj
	 * @return
	 * @since JDK 1.7
	 */
	public static byte[] writeObject2Byte(Object obj) {
		if (null == obj) {
			return null;
		}
		try {
			String str =  JSON.toJSONString(obj, mapping);
			return str.getBytes("UTF-8"); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//==============华丽的分割线=========================
	//==============主要用于transmission中的json封装，对其他系统没有功用性
	
	/**
	 * convertObjectTable:使用object进行封装. <br/>
	 * @author Administrator
	 * @param data
	 * @return
	 * @since JDK 1.6
	 */
	public static String convertObjectTable(List<Map> data,Long count){
		Map d = new HashMap();
		d.put("rows", data);
		d.put("total", count);
		return writeObject(d);
	}
	
	public static void main(String[] args) {
		List l = new ArrayList();
		User u = new User();
		u.setU("1");
		u.setUu("2");
		u.setUuu("3");
		l.add(u);
		User d = JsonUtil.readArray(JsonUtil.writeObject(l),User.class).get(0);
		System.out.println(d.getU());
		System.out.println(d.getUu());
		System.out.println(d.getUuu());
		
		
	}
	
}
class User{
	private String u;
	private String uu;
	private String uuu;
	/**
	 * u.
	 *
	 * @return  the u
	 * @since   JDK 1.7
	 */
	public String getU() {
		return u;
	}
	/**
	 * u.
	 *
	 * @param   u    the u to set
	 * @since   JDK 1.7
	 */
	public void setU(String u) {
		this.u = u;
	}
	/**
	 * uu.
	 *
	 * @return  the uu
	 * @since   JDK 1.7
	 */
	public String getUu() {
		return uu;
	}
	/**
	 * uu.
	 *
	 * @param   uu    the uu to set
	 * @since   JDK 1.7
	 */
	public void setUu(String uu) {
		this.uu = uu;
	}
	/**
	 * uuu.
	 *
	 * @return  the uuu
	 * @since   JDK 1.7
	 */
	public String getUuu() {
		return uuu;
	}
	/**
	 * uuu.
	 *
	 * @param   uuu    the uuu to set
	 * @since   JDK 1.7
	 */
	public void setUuu(String uuu) {
		this.uuu = uuu;
	}
}
