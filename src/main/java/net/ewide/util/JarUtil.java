/**
 * Project Name:util
 * File Name:JarUtil.java
 * Package Name:com.ctp.util
 * Date:2014-3-22下午4:10:30
 *
 */

package net.ewide.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * ClassName:JarUtil <br/>
 * Function: jar包功用类. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-3-22 下午4:10:30 <br/>
 * 
 * @author Alex(yaohao@gmail.com)
 * @version
 * @since JDK 1.6
 * @see
 */
public class JarUtil {
	/**
	 * loader:class load类.
	 * 
	 * @since JDK 1.6
	 */
	ClassLoader loader;

	/**
	 * load:载入一个jar包. <br/>
	 * 
	 * @author Alex(yaohao@gmail.com)
	 * @param jar
	 * @return
	 * @since JDK 1.6
	 */
	public boolean load(String jar) {
		File f = new File(jar);
		if (!(f.exists())) {
			System.out.println("jar file \"" + jar + "\"not exist!");
			return false;
		}
		try {
			loader = new URLClassLoader(new URL[] { f.toURI().toURL() }, this
					.getClass().getClassLoader());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * findClass:查找类所在的jar. <br/>
	 * 
	 * @author Alex(yaohao@gmail.com)
	 * @param className
	 * @return
	 * @since JDK 1.6
	 */
	public Class findClass(String className) {
		try {
			return loader.loadClass(className);
		} catch (ClassNotFoundException e) {
			System.out.println("class \"" + className + "\" not exist!");
		}
		return null;
	}

	public Object invokeMethodOfClassInExtJarFile(String jarName,String classFullName, String MethodName, Class paramClasses[],
			Object paramValue[]) {
		if (!load(jarName)) {
			System.out.println("Exception in Load Jar file!");
			return null;
		}
		Class clazz = findClass(classFullName);
		Object obj;
		try {
			obj = clazz.newInstance();
			Object result = clazz.getMethod(MethodName, paramClasses).invoke(obj, paramValue);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		String stra = "MaGic_VV";
		String strb = "Grevin";
		Object paramValue[] = { stra, strb };
		Class paramClass[] = { String.class, String.class };
		new JarUtil()
				.invokeMethodOfClassInExtJarFile(
						"C://Documents and Settings//Administrator//workspace//Discuz//2.jar",
						"Nes.Discuz", "kick", paramClass, paramValue);
	}

}
