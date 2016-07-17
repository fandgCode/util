/**
 * Project Name:util
 * File Name:DateUtil.java
 * Package Name:net.ewide.process.util
 * Date:2014-2-2下午7:00:00
 *
 */

package net.ewide.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName:DateUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-2-2 下午7:00:00 <br/>
 * 
 * @author Alex(yaohao@gmail.com)
 * @version
 * @since JDK 1.6
 * @see
 */
public class DateUtil {

	/**
	 * 计算时间相差值-秒数
	 */
	public static final int DIFF_TYPE_SECOND = 1;

	/**
	 * 计算时间相差值-分钟数
	 */
	public static final int DIFF_TYPE_MINUTE = 2;

	/**
	 * 计算时间相差值-小时数
	 */
	public static final int DIFF_TYPE_HOUR = 3;

	/**
	 * 计算时间相差值-天数
	 */
	public static final int DIFF_TYPE_DAY = 4;

	/**
	 * 计算时间差值-周数
	 */
	public static final int DIFF_TYPE_WEEK = 5;

	/**
	 * 计算时间差值-月数
	 */
	public static final int DIFF_TYPE_MONTH = 6;

	/**
	 * 计算时间差值-年数
	 */
	public static final int DIFF_TYPE_YEAR = 7;

	/* 秒的毫秒数 */
	private static final int SECOND = 1000;

	/* 分钟毫秒数 */
	private static final int MINUTE = SECOND * 60;

	/* 小时毫秒数 */
	private static final int HOUR = MINUTE * 60;

	/* 天毫秒数 */
	private static final int DAY = HOUR * 24;

	/* 周毫秒数 */
	private static final int WEEK = DAY * 7;

	/**
	 * 产生时间的小时和分中的组合
	 * 
	 * @param calendar
	 * @return "04:24"
	 */
	public static String generateHourMinutes(Calendar calendar) {
		if (calendar == null)
			return "";
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		String strHour = String.valueOf(hour);
		String strMinute = String.valueOf(minute);
		if (hour < 10) {
			strHour = "0" + strHour;
		}
		if (minute < 10) {
			strMinute = "0" + strMinute;
		}
		return strHour + ":" + strMinute;
	}

	/**
	 * 产生时间的小时和分中的组合
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String generateHourMinutes(Timestamp timestamp) {
		if (timestamp == null)
			return "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		return generateHourMinutes(calendar);
	}

	/**
	 * 将日期转换成"yyyy-MM-dd"格式字符
	 * 
	 * @param calendar
	 * @return
	 */
	public static String generateStandardDateFormat(Calendar calendar) {
		return generateStandardDateFormat(new Date(calendar.getTimeInMillis()));

	}

	/**
	 * 将日期转换成"yyyy-MM-dd"格式字符
	 * 
	 * @param date
	 * @return
	 */
	public static String generateStandardDateFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = format.format(date);
		return formattedDate;
	}

	/**
	 * 将日期转换成"yyyy-MM-dd HH:mm"格式字符
	 * 
	 * @param date
	 * @return
	 */
	public static String generateStandardDateTimeFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate = format.format(date);
		return formattedDate;
	}

	/**
	 * 将日期转换成"yyyyMMddHHmmss"格式字符
	 * 
	 * @param date
	 * @return
	 */
	public static String generateStandardDateTimeFormat2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formattedDate = format.format(date);
		return formattedDate;
	}

	/**
	 * 将日期转换成"yyyy-MM-dd HH:mm:ss"格式字符
	 * 
	 * @param date
	 * @return
	 */
	public static String generateStandardDateTimeFormat3(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = format.format(date);
		return formattedDate;
	}

	/**
	 * 将日期转换成"yyyy-MM-dd HH:mm:ss"格式字符
	 * 
	 * @param String
	 * @return
	 */
	public static Timestamp generateStandardTimestampFormat(String strDate) {
		Date date = parseToDateByDateTime(strDate);
		return new Timestamp(date.getTime());
	}

	/**
	 * 将日期转换成"yyyy-MM-dd"格式字符
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String generateStandardDateFormat(Timestamp timestamp) {
		if (timestamp == null)
			return "";
		return generateStandardDateFormat(new Date(timestamp.getTime()));
	}

	/**
	 * 获取起始时间
	 * 
	 * @param dateSrc
	 *            "2005-09-11"
	 * @return
	 */
	public static Date generateStartDate(String dateSrc) {
		Date retDate = null;
		dateSrc = dateSrc + " 00:00";
		retDate = parseToDateByDateTime(dateSrc);
		return retDate;

	}

	/**
	 * 获取结束时间
	 * 
	 * @param dateSrc
	 * @return
	 */
	public static Date generateEndDate(String dateSrc) {
		Date retDate = null;
		dateSrc = dateSrc + " 23:59";
		retDate = parseToDateByDateTime(dateSrc);
		return retDate;
	}

	/**
	 * 将标准年月日时分 转化成Date类型
	 * 
	 * @param dateSrc
	 *            "2005-09-11 12:23"
	 * @return
	 */
	public static Date parseToDateByDateTime(String dateSrc) {
		Date retDate = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			retDate = df.parse(dateSrc);
			return retDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDate;
	}
	
	public static void main(String argv[]){
		DateUtil utils = new DateUtil();
		String dateUtil = utils.generateStandardDateTimeFormat3(new Date());
		System.out.println(dateUtil);
	}

	/**
	 * 将标准年月日 转化成Date类型
	 * 
	 * @param dateSrc
	 *            "2005-09-11
	 * @return
	 */
	public static Date parseToDateByStandardDate(String dateSrc) {
		Date retDate = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			retDate = df.parse(dateSrc);
			return retDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDate;
	}
	
	/**
	 * 将日期转换成"yyyy-MM-dd HH:mm:ss"格式字符
	 * 
	 * @param date
	 * @return
	 */
	public static String generateDateTimeFormat(Date date,String formatValue) {
		SimpleDateFormat format = new SimpleDateFormat(formatValue);
		String formattedDate = format.format(date);
		return formattedDate;
	}
	
	/**
	 * 将自定义的日期类型String转换为Date. <br/>
	 * @author Alex
	 * @param dateStr 需要转换的string
	 * @param formatValue 转换格式
	 * @return
	 * @since JDK 1.7
	 */
	public static Date generateDateTimeFormat(String dateStr,String formatValue) {
		Date retDate = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat(formatValue);
			retDate = df.parse(dateStr);
			return retDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDate;
	}
	
	/**
	 * 通过传递的时间和需要增加或减少的天数，计算出这一天的第一时间和最后时间
	 * 列如：传递date为当前时间，20150201 ，day为2 返回20150203 00:00:00 和20150203 23:59:59
	 * @param date 为空，则取的当前时间
	 * @param day 增加或减少的天数
	 * @return 返回date数组，第一个为20150203 00:00:00，第二个为20150203 23:59:59
	 */
	public static Date[] generateBeginAndEndDate(Date date,Integer day){
		Date [] dateArr = new Date[2];
		Calendar rightNow = null;
		if(null == date){
			rightNow = Calendar.getInstance();
			if(null != day){
				rightNow.add(Calendar.DATE, day);
			}
			
		}else{
			rightNow = Calendar.getInstance();
			rightNow.setTime(date);
		}
		rightNow.set(Calendar.HOUR_OF_DAY, 0);
		rightNow.set(Calendar.MINUTE, 0);
		rightNow.set(Calendar.SECOND, 0);
		dateArr[0] = rightNow.getTime();
		rightNow.set(Calendar.HOUR_OF_DAY, 23);
		rightNow.set(Calendar.MINUTE, 59);
		rightNow.set(Calendar.SECOND, 59);
		dateArr[1] = rightNow.getTime();
		return dateArr;
	}
	/**
	 * 获得去年今天日期
	 * @param thisYear
	 * @return
	 */
	public static Date lastYear(Date thisYear) {
        Calendar c = Calendar.getInstance();
        c.setTime(thisYear);
        c.add(Calendar.YEAR, -1);
        return c.getTime();
    }


//	public static void main(String[] args) {
//		Date[] d = new DateUtil().generateBeginAndEndDate(null, null);
//		System.err.println(d);
//		Date[] ds = new DateUtil().generateBeginAndEndDate(new Date(), null);
//		System.err.println(d);
//		Date[] dss = new DateUtil().generateBeginAndEndDate(null, 0);
//		System.err.println(d);
//	}
}
