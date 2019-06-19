/**
 * Copyright 2016 Joint Wisdom Inc. All Rights Reserved.
 * You may use it ONLY by accepting the License unless writing permission or applicable law is required. 
 * Other un-authorized conditions shall not use freely. 
*/
package cn.newbie.rabbitmq.project_use.util;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ## 类说明：
 * 	日期工具类
 */
public class DateUtil {

	// private static final String[] NUMBERS = { "零", "壹", "贰", "叁", "肆",
	// "伍","陆", "柒", "捌", "玖" };
	private static final String[] NUMBERS = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	/** 日期分割符：- */
	public static final String CONCAT_Y = "-";

	/** 日期分割符：/ */
	public static final String CONCAT_X = "/";

	/** 日期分割符：: */
	public static final String CONCAT_M = ":";

	/** 逗号分割符：: */
	public static final String CONCAT_comma = ",";

	/** 格式字符串：年月日 */
	public static final String FMT_YMD = "yyyyMMdd";

	/** 格式字符串：年/月/日 */
	public static final String FMT_YMD_S = "yyyy/MM/dd";

	/** 格式字符串：yyyy-MM-dd */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	/** 格式字符串：yyMM */
	public static final String DATE_YYMM_FORMAT = "yyMM";

	/** 格式字符串：yyyy-MM-dd HH:mm:ss */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/** 格式字符串：yyyy-MM-dd HH:mm:ss */
	public static final String DATE_TIME_FORMAT2 = "yyyy-MM-dd_HH-mm-ss";
	
	/** 格式字符串：yyyy-MM-dd HH:mm */
	public static final String DATE_HHMM_FORMAT = "yyyy-MM-dd HH:mm";

	/** 格式字符串：HH:mm */
	public static final String TIME_FORMAT = "HH:mm";
	/** 格式字符串：HH:mm:ss */
	public static final String TIME_HHMMSS_FORMAT = "HH:mm:ss";
	/** 格式字符串：MM-dd */
	public static final String DATE_FORMAT_MM_DD = "MM-dd";
	/** 格式字符串：yyyy-MM */
	public static final String DATE_YYYYMM_FORMAT= "yyyy-MM";
	/** 格式字符串：yyyy-MM-dd'T'HH:mm:ss.SSSXXX */
	public static final String DATE_Timestamp_FORMAT= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String DATE_MINDT = "00:00";
	public static final String DATE_MAXDT = "23:59";
	
	public static final String ISNUMERIC_PATTERN = "[0-9]*";
	
	public static final String MAX_DATE = "2099-12-31"  ;

	/**
	 * ## 方法说明：
	 * 	日期增加指定类型数据
	 * @param
	 * @return
	 */
	public static final Date addByField(final Integer field, final Date date, final Integer amount){
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field,amount);
		return calendar.getTime();
	}
	
	/** 
	 * ## 方法说明：
	 *  获取指定类型的时间数据
	 * @param field
	 * @param date
	 * @return
	*/
	public static final Integer getByField(final Integer field, final Date date){
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
	}
	
	/** 
	 * ## 方法说明：
	 * 	计算两个日期相差星期
	 * @param date1
	 * @param date2
	 * @return
	*/
	public static final Integer getDaysOfTwoWeek(Date date1, final Date date2){
		Integer sum = 0;
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date1);
		Integer week = calendar.get(Calendar.WEEK_OF_YEAR);
		while(date1.compareTo(date2)<=0){
			calendar.setTime(date1);
			Integer week1 = calendar.get(Calendar.WEEK_OF_YEAR);
			if(!week.equals(week1)){
				sum ++;
				week = week1;
			}
			date1 = addDay(date1, 1);
		}
		return sum;
	}
	
	/**
	 * ## 方法说明：
	 * 	获取当月第一天
	 * @return
	 */
	public static Date getFirstDayOfMonth(final Integer year, final Integer month) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(year, month, 1, 0, 0, 0);
		lastDate.set(Calendar.MILLISECOND,0);
		return lastDate.getTime();
	}

	
	
	/**
	 * ## 方法说明：
	 * 	取得系统时间
	 * @return 系统时间
	 */
	public static Date getSystemTime() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	/**
	 * ## 方法说明：
	 * 	格式化日期
	 * @param date 日期
	 * @param fmt 格式
	 * @return
	 */
	public static String formatDate(Date date, String fmt) {
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}
	
	/**
	 * ## 方法说明：
	 * 	按照格式解析日期字符串
	 * @param str 字符串
	 * @param fmt 格式
	 * @return 日期
	 * @throws ParseException 解析异常
	 */
	public static Date parse(String str, String fmt) throws ParseException {
		if(StringUtils.isEmpty(str)){
			return null;
		}
		SimpleDateFormat dtf = new SimpleDateFormat(fmt);
		dtf.setLenient(true);
		return dtf.parse(str);
	}

	/**
	 * ## 方法说明：
	 * 	比较时间大小 
	 * dt1和dt2关系 >< = 分别返回 1 -1 0
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static int compareDate(Date dt1, Date dt2) {
        if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 0;
        }
    }
	/**
	 * ## 方法说明：
	 * 	比较时间大小 
	 * dt1和dt2关系 >< = 分别返回 1 -1 0
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static int compareDateStrong(Date dt1, Date dt2) {
		if(dt1 == null && dt2 == null){
			return 0;
		}else if(dt1 != null && dt2 == null){
			return 1;
		}else if(dt1 == null && dt2 != null){
			return -1;
		}else if (dt1.getTime() > dt2.getTime()) {
			return 1;
		} else if (dt1.getTime() < dt2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * ## 方法说明：
	 * 	计算给定日期的前/后几天
	 * @param dt 日期
	 * @param days 天数
	 * @return 相对时间
	 */
	public static Date addDay(Date dt, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();
	}
	
	/**
	 * ## 方法说明：
	 * 	设置当前时间为当天的最初时间（即00时00分00秒）
	 * @param cal
	 * @return
	 */
	public static Calendar setStartDay(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal;
	}

	/**
	 * ## 方法说明：
	 * 	设置当前时间为当天的最后时间（即23时59分59秒）
	 * @param cal
	 * @return
	 */
	public static Calendar setEndDay(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal;
	}

	/**
	 * ## 方法说明：
	 * 	获得两个时间差，秒
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Long getDateDifference(Date d1, Date d2) {
		long diff = d1.getTime() - d2.getTime();
		long days = diff / (1000 * 60);
		return days;
	}
	
	/**
	 * ## 方法说明：
	 * 	时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @throws ParseException 
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) throws ParseException {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		beginDate = format.parse(beginDateStr);
		endDate = format.parse(endDateStr);
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * ## 方法说明：
	 * 	把源日历的年月日设置到目标日历对象中
	 * @param destCal
	 * @param sourceCal
	 */
	public static void copyYearMonthDay(Calendar destCal, Calendar sourceCal) {
		destCal.set(Calendar.YEAR, sourceCal.get(Calendar.YEAR));
		destCal.set(Calendar.MONTH, sourceCal.get(Calendar.MONTH));
		destCal.set(Calendar.DAY_OF_MONTH, sourceCal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * ## 方法说明：
	 * 	格式化日期字符串(HHMM => HH:MM)
	 * @param dt 日期字符串
	 * @param concat ":" or "/"
	 * @return 格式化后的字符串
	 */
	public static String formatHhMm(String dt, String concat) {
		if (dt == null) {
			return "";
		}
		// 针对00:12,09:30特殊格式，前面进行先补0操作
		if (dt.length() == 2) {
			dt = "00" + dt;
		} else if (dt.length() == 3) {
			dt = "0" + dt;
		}
		return dt.substring(0, 2) + concat + dt.substring(2, 4);
	}

	/**
	 * ## 方法说明：
	 * 	获取当月第一天
	 * @param pattern 格式
	 * @return
	 */
	public static String getFirstDayOfMonth(String pattern) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * ## 方法说明：
	 * 	计算当月最后一天,返回字符串
	 * @param pattern 格式
	 * @return
	 */
	public static String getDefaultDay(String pattern) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}
	
	/**
	 * ## 方法说明：
	 * 	获取后几月第一天
	 * @param n 减n个月，变为下月的1号
	 * @param pattern 格式
	 * @return
	 */
	public static String getPreviousMonthFirst(Integer n, String pattern) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, n);// 减n个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}
	
	/**
	 * ## 方法说明：
	 * 	获得后几月最后一天的日期
	 * @param n 减n个月，变为下月的1号
	 * @param pattern 格式
	 * @return
	 */
	public static String getPreviousMonthEnd(Integer n,String pattern) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, n);// 加n个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * ## 方法说明：
	 * 	获得当前年份
	 * @return
	 */
	public static int getSysYear() {
		Calendar calendar = new GregorianCalendar();
		int iyear = calendar.get(Calendar.YEAR);
		return iyear;
	}
	/**
	 * 
	 * ## 方法说明：
	 * 获取制定日期的年份
	 * @param date
	 * @return
	 */
	public static int getDateYear(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int iyear = calendar.get(Calendar.YEAR);
		return iyear;
	}

	/**
	 * ## 方法说明：
	 * 	获得当前月份
	 * @return
	 */
	public static int getSysMonth() {
		Calendar calendar = new GregorianCalendar();
		int imonth = calendar.get(Calendar.MONTH) + 1;
		return imonth;
	}
	/**
	 * 
	 * ## 方法说明：
	 * 	获取指定日期的月份 
	 * @return
	 */
	public static int getDateMonth(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int imonth = calendar.get(Calendar.MONTH) + 1;
		return imonth;
	}

	/**
	 * ## 方法说明：
	 * 	获得当前Day
	 * @return
	 */
	public static int getSysDay() {
		Calendar calendar = new GregorianCalendar();
		int idate = calendar.get(Calendar.DAY_OF_MONTH);
		return idate;
	}

	 /**
	  * ## 方法说明：
	  * 	获取日期差
	  * @param startdt
	  * @param entdt
	  * @return
	  */
	public static long getDateSub(Date startdt, Date entdt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startdt);
		long time1 = cal.getTimeInMillis();
		cal.setTime(entdt);
		long time2 = cal.getTimeInMillis();
		return (time2 - time1) / (1000 * 3600 * 24);
	}
	
	/**
	 * ## 方法说明：
	 * 	获取时间差
	 * @param startdt
	 * @param entdt
	 * @return
	 */
	public static long getTimeSub(Date startdt, Date entdt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startdt);
		long time1 = cal.getTimeInMillis();
		cal.setTime(entdt);
		long time2 = cal.getTimeInMillis();
		return (time2 - time1);
	}

	/**
	 * ## 方法说明：
	 * 	得到某天的几小时后的时间 （24小时制）
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date getHourAfter(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) + day);
		return now.getTime();
	}
	
	/**
	 * ## 方法说明：
	 * 	得到某天的几天后的时间 
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date getDayAfter(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * ## 方法说明：
	 * 	得到某天的几个星期后的时间
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date getWeekAfter(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.WEEK_OF_YEAR, now.get(Calendar.WEEK_OF_YEAR) + day);
		return now.getTime();
	}

	/**
	 * ## 方法说明：
	 * 	得到某天的几年后的时间
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date getYearAfter(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.YEAR, now.get(Calendar.YEAR) + day);
		return now.getTime();
	}

	/**
	 * ## 方法说明：
	 * 	通过 yyyy-MM-dd 得到中文大写格式 yyyy MM dd 日期
	 * @param str 日期
	 * @return 中文大写格式 yyyy MM dd 日期
	 */
	public static String toChinese(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(getSplitDateStr(str, 0)).append("年").append(getSplitDateStr(str, 1)).append("月")
				.append(getSplitDateStr(str, 2)).append("日");
		return sb.toString();
	}

	/**
	 * ## 方法说明：
	 * 	分别得到年月日的大写 默认分割符 "-"
	 * @param str 日期
	 * @param unit 单位 0=年 1=月 2日
	 * @return 年月日的大写 默认分割符 "-"
	 */
	public static String getSplitDateStr(String str, int unit) {
		// unit是单位 0=年 1=月 2日
		String[] DateStr = str.split("-");
		if (unit > DateStr.length){
			unit = 0;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < DateStr[unit].length(); i++) {
			if ((unit == 1 || unit == 2) && Integer.valueOf(DateStr[unit]) > 9) {
				sb.append(convertNum(DateStr[unit].substring(0, 1))).append("十")
						.append(convertNum(DateStr[unit].substring(1, 2)));
				break;
			} else {
				sb.append(convertNum(DateStr[unit].substring(i, i + 1)));
			}
		}
		if (unit == 1 || unit == 2) {
			return sb.toString().replaceAll("^一", "").replace("〇", "");
		}
		return sb.toString();
	}

	/**
	 * ## 方法说明：
	 * 	转换数字为大写
	 * @param str 日期
	 * @return 大写数字
	 */
	private static String convertNum(String str) {
		return NUMBERS[Integer.valueOf(str)];
	}

	/**
	 * ## 方法说明：
	 * 	判断是否是零或正整数
	 * @param str 日期
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile(ISNUMERIC_PATTERN);
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}


	/**
	 * ## 方法说明：
	 * 	得到下一个月
	 * @param month 月份
	 * @return
	 */
	public static String getNextMonth(String month) {
		String lastYear = month.split("-")[0];
		String nextYear = "";
		String lastMonth = month.split("-")[1];
		String nextMonth = "";
		int lm = Integer.parseInt(lastMonth);
		if (lm + 1 > 12) {
			nextMonth = "01";
			nextYear = String.valueOf(Integer.parseInt(lastYear) + 1);
		} else if (lm + 1 < 10) {
			nextMonth = "0" + (lm + 1);
			nextYear = lastYear;
		} else {
			nextMonth = String.valueOf(lm + 1);
			nextYear = lastYear;
		}
		return nextYear + "-" + nextMonth;
	}

	/**
	 * ## 方法说明：
	 * 	得到月份的最后一天
	 * @param month 月份
	 * @return
	 */
	public static String getLastDay(String month) {
		String y = month.split("-")[0];
		String m = month.split("-")[1];
		String lastDate = "31";
		if ("04".equals(m) || "06".equals(m) || "09".equals(m) || "11".equals(m) || "4".equals(m) || "6".equals(m)
				|| "9".equals(m)) {
			lastDate = "30";
		} else if ("02".equals(m) || "2".equals(m)) {
			if (Integer.parseInt(y) % 4 == 0) {
				if (Integer.parseInt(y) % 100 == 0) {
					if (Integer.parseInt(y) % 400 == 0) {
						lastDate = "29";
					} else {
						lastDate = "28";
					}
				} else {
					lastDate = "29";
				}
			} else {
				lastDate = "28";
			}
		}
		return month + "-" + lastDate;
	}

	/**
	 * ## 方法说明：
	 * 	通过 yyyy-MM-dd 得到中文大写格式 yyyy年 MM月dd日
	 * @param str 日期字符串
	 * @return
	 */
	public static String formDate(String str) {
		String[] time = str.split("-");
		return time[0] + "年 " + time[1] + "月 " + time[2] + "日 ";
	}

	/**
	 * ## 方法说明：
	 * 	将MM/dd/yyyy字符串格式转换成date
	 * @param src 日期字符串
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseEnToDate(String src) throws ParseException {
		SimpleDateFormat srcFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = srcFormat.parse(src);
		return date1;
	}

	/**
	 * ## 方法说明：
	 * 	将date转换成MM/dd/yyyy字符串
	 * @param date
	 * @return
	 */
	public static String formatDateToEnStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}

	/**
	 * ## 方法说明：
	 * 	将MM/dd/yyyy字符串格式转换成yyyy/MM/dd字符串
	 * @param src 日期字符串
	 * @return
	 * @throws ParseException 
	 */
	public static String convertEnToCnStr(String src) throws ParseException {
		SimpleDateFormat enFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat cnFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date srcDate = enFormat.parse(src);
		return cnFormat.format(srcDate);
	}

	/**
	 * ## 方法说明：
	 * 	格式化日期字符串 {YYYY-MM-DD,YYYY/MM/DD => YYYYMMDD} {HH:MM => HHMM}
	 * @param dt 日期字符串
	 * @return 格式化后的字符串
	 */
	public static String formatDateRemoveCon(String dt) {
		if (dt == null) {
			return "";
		}
		String formatStr = dt.replaceAll(CONCAT_Y, "").replaceAll(CONCAT_X, "").replaceAll(CONCAT_M, "").replaceAll(" ", "");
		// 11位时的格式（如:20120505808 八点八分）时，在小时位前面补个0
//		if (formatStr.length() == 11) {
//			return formatStr.substring(0, 4) + formatStr.substring(4, 6) + formatStr.substring(6, 8) + "0"
//					+ formatStr.subSequence(8, 9) + formatStr.subSequence(9, 11);
//		}
		return formatStr;
	}
	
	/**
     * 获取本地默认时区id
     * @return string 本地时区id
     */
	public static String getLocalTimeId() {
		TimeZone defaultTimeZone = TimeZone.getDefault();
		String sourceId = defaultTimeZone.getID();
		return sourceId;
	}
    
    /**
     * 获取受支持的所有可用 ID
     * 用来作为页面显示的时区下拉列表
     * 以绝对时区显示（不考虑夏令时）
     * @return map 存储时区列表+偏移量的map(可用来显示如Hongkong,GMT+08:00)
     * 实际使用时，传给服务器是零时区，值传递时区id就可以了，不传递偏移量
     */
	public static Map<String, String> getZoneList() {
		String[] zoneIds = TimeZone.getAvailableIDs();
		int length = zoneIds.length;
		TimeZone timeZone = null;
		// 存储时区列表+偏移量到map中
		Map<String, String> map = new HashMap<String, String>(650);
		long offset = 0L;
		String diplayOffset = "";
		for (int i = 0; i < length; i++) {
			// 获取给定 ID 的 TimeZone
			timeZone = TimeZone.getTimeZone(zoneIds[i]);
			// 返回添加到 UTC 以获取此时区中的标准时间的时间偏移量（以毫秒为单位）。
			offset = timeZone.getRawOffset();
			// 对偏移量做显示，如GMT-09:30、GMT+09:30
			diplayOffset = appendZoneSuffix(offset);
			// 存储到map中，形式为Hongkong---GMT+08:00
			map.put(zoneIds[i], diplayOffset);
		}
		return map;
	}
    
    /**
     * 添加时区偏移量
     * @param offset 偏移量（以毫秒为单位）
     * @return 日期
     */
	public static String appendZoneSuffix(long offset) {
		// 将偏移量转化为小时（小数去除不要）
		long hour = Long.valueOf((offset / 3600000));
		// 偏移量对小时取余数，得到小数（以毫秒为单位）
		double decimals = offset % 3600000;
		// 显示为09:30分钟形式
		double decimalsZone = (decimals / 3600000) * 60 / 100;
		String sAdd = "";
		if (hour >= 0) {
			sAdd = "+";
		} else {
			sAdd = "-";
		}
		hour = hour > 0 ? hour : -hour;
		String sHour = hour + "";
		if (sHour.length() == 1) {
			sHour = '0' + sHour;
		}

		decimalsZone = decimalsZone < 0 ? -decimalsZone : decimalsZone;
		String sDecimalsZone = decimalsZone + "";
		sDecimalsZone = sDecimalsZone.substring(2);
		if (sDecimalsZone.length() == 1) {
			sDecimalsZone = sDecimalsZone + '0';
		} else if (sDecimalsZone.length() >= 3) {
			sDecimalsZone = sDecimalsZone.substring(0, 2);
		}
		return "GMT" + sAdd + sHour + ':' + sDecimalsZone;
	}
    
    /**
     * 时区 时间转换方法:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceTime 时间格式必须为：yyyy-MM-dd HH:mm:ss
     * @param sourceId 入参的时间的时区id GMT+08:00
     * @param targetId 要转换成目标时区id GMT+09:00（一般是是零时区：取值UTC）
     * @return string 转化时区后的时间
     */
	public static String timeConvert(String sourceTime, String sourceId, String targetId) {
		// 校验入参是否合法
		if (null == sourceId || "".equals(sourceId) || null == targetId || "".equals(targetId) || null == sourceTime
				|| "".equals(sourceTime)) {
			return "";
		}
		// 校验 时间格式必须为：yyyy-MM-dd HH:mm:ss
		String reg = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$";
		if (!sourceTime.matches(reg)) {
			return "";
		}

		try {
			// 时间格式
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 根据入参原时区id，获取对应的timezone对象
			TimeZone sourceTimeZone = TimeZone.getTimeZone(sourceId);
			// 设置SimpleDateFormat时区为原时区（否则是本地默认时区），目的:用来将字符串sourceTime转化成原时区对应的date对象
			df.setTimeZone(sourceTimeZone);
			// 将字符串sourceTime转化成原时区对应的date对象
			Date sourceDate = df.parse(sourceTime);

			// 开始转化时区：根据目标时区id设置目标TimeZone
			TimeZone targetTimeZone = TimeZone.getTimeZone(targetId);
			// 设置SimpleDateFormat时区为目标时区（否则是本地默认时区），目的:用来将字符串sourceTime转化成目标时区对应的date对象
			df.setTimeZone(targetTimeZone);
			// 得到目标时间字符串
			String targetTime = df.format(sourceDate);
			return targetTime;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
     * 时区 时间转换方法:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceTime 
     * @param sourceId 入参的时间的时区id GMT+08:00
     * @param targetId 要转换成目标时区id GMT+09:00
     * @return string 转化时区后的时间
     */
	public static String timeConvert(Date sourceTime, String sourceId, String targetId) {
		// 校验入参是否合法
		if (null == sourceId || "".equals(sourceId) || null == targetId || "".equals(targetId) || null == sourceTime || "".equals(sourceTime)) {
			return "";
		}
		try {
			// 时间格式
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 根据入参原时区id，获取对应的timezone对象
			TimeZone sourceTimeZone = TimeZone.getTimeZone(sourceId);
			// 设置SimpleDateFormat时区为原时区（否则是本地默认时区），目的:用来将字符串sourceTime转化成原时区对应的date对象
			df.setTimeZone(sourceTimeZone);
			
			// 开始转化时区：根据目标时区id设置目标TimeZone
			TimeZone targetTimeZone = TimeZone.getTimeZone(targetId);
			// 设置SimpleDateFormat时区为目标时区（否则是本地默认时区），目的:用来将字符串sourceTime转化成目标时区对应的date对象
			df.setTimeZone(targetTimeZone);
			// 得到目标时间字符串
			return df.format(sourceTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
    
    /**  
     * 将日期时间字符串根据转换为指定时区的日期时间.  
     * @param srcFormater 待转化的日期时间的格式.  
     * @param srcDateTime 待转化的日期时间.  
     * @param dstFormater 目标的日期时间的格式.  
     * @param dstTimeZoneId 目标的时区编号.  
     * @return 转化后的日期时间.  
     */  
	public static String string2Timezone(String srcFormater, String srcDateTime, String dstFormater,
			String dstTimeZoneId) {
		if (srcFormater == null || "".equals(srcFormater)){
			return null;
		}
		if (srcDateTime == null || "".equals(srcDateTime)){
			return null;
		}
		if (dstFormater == null || "".equals(dstFormater)){
			return null;
		}
		if (dstTimeZoneId == null || "".equals(dstTimeZoneId)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(srcFormater);
		try {
			int diffTime = getDiffTimeZoneRawOffset(dstTimeZoneId);
			Date d = sdf.parse(srcDateTime);
			long nowTime = d.getTime();
			long newNowTime = nowTime - diffTime;
			d = new Date(newNowTime);
			return date2String(dstFormater, d);
		} catch (ParseException e) {
			return null;
		} finally {
			sdf = null;
		}
	}
    
    /**  
     * 日期(时间)转化为字符串.  
     * @param formater 日期或时间的格式.  
     * @param aDate java.util.Date类的实例.  
     * @return 日期转化后的字符串.  
     */  
	public static String date2String(String formater, Date aDate) {
		if (formater == null || "".equals(formater)){
			return null;
		}
		if (aDate == null){
			return null;
		}
		return (new SimpleDateFormat(formater)).format(aDate);
	}
    
    /**  
     * 获取系统当前默认时区与UTC的时间差.(单位:毫秒)  
     * @return 系统当前默认时区与UTC的时间差.(单位:毫秒)  
     */  
	private static int getDefaultTimeZoneRawOffset() {
		return TimeZone.getDefault().getRawOffset();
	}
  
    /**  
     * 获取指定时区与UTC的时间差.(单位:毫秒)  
     * @param timeZoneId 时区Id  
     * @return 指定时区与UTC的时间差.(单位:毫秒)  
     */  
	private static int getTimeZoneRawOffset(String timeZoneId) {
		return TimeZone.getTimeZone(timeZoneId).getRawOffset();
	}
  
    /**  
     * 获取系统当前默认时区与指定时区的时间差.(单位:毫秒)  
     * @param timeZoneId 时区Id  
     * @return 系统当前默认时区与指定时区的时间差.(单位:毫秒)  
     */  
	private static int getDiffTimeZoneRawOffset(String timeZoneId) {
		return TimeZone.getDefault().getRawOffset() - TimeZone.getTimeZone(timeZoneId).getRawOffset();
	}
  
    /**  
     * 将日期时间字符串根据转换为指定时区的日期时间.  
     * @param srcDateTime 待转化的日期时间.  
     * @param dstTimeZoneId 目标的时区编号.  
     * @return 转化后的日期时间.  
     * @see #string2Timezone(String, String, String, String)  
     */  
	public static String string2TimezoneDefault(String srcDateTime, String dstTimeZoneId) {
		return string2Timezone("yyyy-MM-dd HH:mm:ss", srcDateTime, "yyyy-MM-dd HH:mm:ss", dstTimeZoneId);
	}
	
	/** 
	 * ## 方法说明：
	 * 	获取星期周一第一位  周一->周日  0-6
	 * @param dt
	 * @return
	*/
	public static Integer dayForWeek(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Integer weekDay = cal.get(Calendar.DAY_OF_WEEK) - 2;
		return weekDay < 0 ? weekDay + 7 : weekDay;
	}
	/** 
	 * ## 方法说明：
	 * 	获取星期周日第一位  周日->周六  0-6
	 * @param dt
	 * @return
	*/
	public static Integer dayForWeekSunFirst(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Integer weekDay = cal.get(Calendar.DAY_OF_WEEK) ;
		return weekDay -1;
	}
	
	public static Date toDate(Object obj, Date defaultValue){
		if (obj== null) {
			return defaultValue;
		}
		try {
			if(obj instanceof java.sql.Date){
				return new Date(((java.sql.Date)obj).getTime());
			}
			if(obj instanceof Date){
				return (Date)obj;
			}
			if(obj instanceof Long){
				return new Date((Long)obj);
			}
			return DateUtil.parse(obj.toString(), DATE_FORMAT);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
	public static Date toDate(Object obj) throws ParseException{
		if (obj== null) {
			return null;
		}
		if(obj instanceof java.sql.Date){
			return new Date(((java.sql.Date)obj).getTime());
		}
		if(obj instanceof Date){
			return (Date)obj;
		}
		if(obj instanceof Long){
			return new Date((Long)obj);
		}
		return DateUtil.parse(obj.toString(), DATE_FORMAT);
	}
	
	public static Date toTIMESTAMP(Object obj, Date defaultValue){
		if (obj== null) {
			return defaultValue;
		}
		try {
			if(obj instanceof Timestamp){
				return new Date(((Timestamp)obj).getTime());
			}
			if(obj instanceof Date){
				return (Date)obj;
			}
			if(obj instanceof Long){
				return new Date((Long)obj);
			}
			return DateUtil.parse(obj.toString(), DATE_TIME_FORMAT);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
	
	//获取年月的的特殊格式  0701 1201
	public static String getTimeSuffix(Date date){
		String timeSuffix = "";
		int sysYear = getDateYear(date);
		int sysMonth = getDateMonth(date);
		if(sysYear!=0&&sysMonth!=0){
			String year =String.valueOf(sysYear);
			year = year.substring(2);
			String month =String.valueOf(sysMonth);
			if(month.length()==1){
				month ="0"+month;
			}
			timeSuffix = year+month;
		}
		return timeSuffix;
	}
	
	/** 
	 * ## 方法说明：
	 * 	月最大天数
	 * @param yy
	 * @param mm 0~11
	 * @return
	*/
	public static Integer getMonthMaxDay(Integer yy,Integer mm) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(yy,mm,1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.set(Calendar.DAY_OF_MONTH, 0);
		return lastDate.get(Calendar.DAY_OF_MONTH);
	}
	
	/** 
	 * ## 方法说明：
	 * 	获取日期
	 * @param year
	 * @param month 0~11
	 * @return
	*/
	public static Date getDate(final Integer year, final Integer month, final Integer day) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(year, month, day, 0, 0, 0);
		lastDate.set(Calendar.MILLISECOND,0);
		return lastDate.getTime();
	}
	
	public static Date getDate() throws Exception {
		Date date = new Date();
		String str = DateUtil.formatDate(date, DateUtil.DATE_FORMAT);
		return DateUtil.parse(str, DateUtil.DATE_FORMAT);
	}
	
	/**
	 * ## 方法说明：
	 * 	获取默认最小日期
	 * @return
	 */
	public static Date getDefMinDate()throws Exception{
		return DateUtil.parse("2000-01-01", DateUtil.DATE_FORMAT);
	}
	
	/**
	 * ## 方法说明：
	 * 	获取默认最大日期
	 * @return
	 * @throws Exception
	 */
	public static Date getDefMaxDate()throws Exception{
		return DateUtil.parse("2700-01-01", DateUtil.DATE_FORMAT);
	}
	
	/**
	 * ## 方法说明：
	 * 	LocalDate转换为Date
	 * @param localDate
	 * @return
	 */
	public static Date LocalDateToUdate(LocalDate localDate) {
		if(localDate != null){
			ZoneId zone = ZoneId.systemDefault();
			Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
			Date date = Date.from(instant);
			return date;
		}else{
			return null;
		}
	}
	/**
	 * ## 方法说明：
	 * 	LocalDateTime转换为Date
	 * @param
	 * @return
	 */
	public static Date LocalDateTimeToUdate(LocalDateTime localDateTime) {
		if(localDateTime != null){
			ZoneId zone = ZoneId.systemDefault();
			Instant instant = localDateTime.atZone(zone).toInstant();
			Date date = Date.from(instant);
			return date;
		}else {
			return null;
		}
	}
	
	public static final Long daysOfTwo(Date fDate, Date oDate) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(fDate);
	    LocalDate day1 = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
		calendar.setTime(oDate);
	    LocalDate day2 = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
		return day2.toEpochDay() - day1.toEpochDay() ;
	}
	
	/**
	 * ## 方法说明：
	 * 	打散日期
	 * @param startDt
	 * @param endDt
	 * @return
	 * @throws Exception
	 */
	public static List<Long> breakDate(Date startDt, Date endDt) throws Exception {
		List<Long> resultList = new ArrayList<>();
		Long day = daysOfTwo(startDt, endDt);
		if(day != 0){
			for (int i = 0; i <= day; i++) {
				Date date = addDay(startDt, i);
				if(compareDateStrong(date, endDt) != 1){
					resultList.add(date.getTime());
				}else{
					break;
				}
			}
		}else{
			resultList.add(startDt.getTime());
		}
		return resultList;
	}


	/**
	 * ## 方法说明：
	 * 	将date转换成MM/dd/yyyy字符串
	 * @param date
	 * @return
	 */
	public static String formatTimezoneDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_Timestamp_FORMAT);
		return sdf.format(date);
	}

	public static String formatTimezoneDate(long date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_Timestamp_FORMAT);
		return sdf.format(date);
	}

	public static Date parseTimezoneDate(String text) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_Timestamp_FORMAT);
		return sdf.parse(text);
	}

	public static long parseTimezoneTime(String text) throws ParseException {
		return parseTimezoneDate(text).getTime();
	}

}
