/**
 * 
 */
package net.ewide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class ConfigUtil {
	
	private static Map<String, Properties> configs = new HashMap<String,Properties>();
	private Properties propertie;

	/**
	 * Creates a new instance of ConfigUtil.
	 * 
	 * @param fileName
	 */
	private ConfigUtil(String fileName) {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			propertie = new Properties();
			propertie.load(in);
		} catch (IOException e) {
			System.out.println(fileName + "文件加载失败!");
		}
	}

	public static Properties getProperties(String fileName) {
		if (configs.get(fileName) == null) {
			System.out.println("[ewide]配置文件初始化");
			ConfigUtil util = new ConfigUtil(fileName);
			configs.put(fileName, util.getPropertie());
		}
		return configs.get(fileName);
	}
	
	public static Properties reload(String fileName) {
		ConfigUtil util = new ConfigUtil(fileName);
		configs.put(fileName, util.getPropertie());
		System.out.println("[ewide]配置文件重载成功");
		return configs.get(fileName);
	}

	/**
	 * propertie.
	 * 
	 * @return the propertie
	 * @since JDK 1.6
	 */
	public Properties getPropertie() {
		return propertie;
	}

	/**
	 * propertie.
	 * 
	 * @param propertie
	 *            the propertie to set
	 * @since JDK 1.6
	 */
	public void setPropertie(Properties propertie) {
		this.propertie = propertie;
	}

	/**
	 * main:(这里用一句话描述这个方法的作用). <br/>
	 * @author Alex(yaohao@gmail.com)
	 * @param args
	 * @since JDK 1.6
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			System.out.println(ConfigUtil.getProperties("config.properties").get("sys.sendbuffersize"));
		}
		ConfigUtil.reload("config.properties");
	}

}
