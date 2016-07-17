/**
 * Project Name:jmeter
 * File Name:RandomUtil.java
 * Package Name:net.ewide.jmeter.util
 * Date:2014年9月15日下午11:48:35
 *
 */

package net.ewide.util;

import java.util.Random;

/**
 * ClassName:RandomUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2014年9月15日 下午11:48:35 <br/>
 * 
 * @author Alex
 * @version
 * @since JDK 1.7
 * @see
 */
public class RandomUtil {

	public static void main(String[] args) {
		int max = 20;
		int min = 10;
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(s);
		System.out.println(genNum(1, 82000));
	}
	
	/**
	 * genNum:随机生成某个范围值. <br/>
	 * @author Alex
	 * @param min
	 * @param max
	 * @return
	 * @since JDK 1.7
	 */
	public static int genNum(int min,int max){
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}
	
	/**
	 * genBoolean:随机生成boolean值. <br/>
	 * @author Alex
	 * @return
	 * @since JDK 1.7
	 */
	public static boolean genBoolean(){
		Random random = new Random();
		return random.nextBoolean();
	}

}
