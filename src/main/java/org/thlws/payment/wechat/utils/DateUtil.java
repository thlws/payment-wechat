package org.thlws.payment.wechat.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	public static void main(String[] args) {
//		String c1 = getDateMilliFormat(Calendar.getInstance());
//		System.out.println(c1);
		
		String r2 = getDateSecondFormat();
		System.out.println(r2);
	}

	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	public static final String DEFAULT_DATE_PATTERN2 = "yyyy-MM-dd HH:mm:ss";

	private static String[] format = { "yyyy-MM-dd HH:mm:ss,SSS", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH", "yyyy-MM-dd", "yyyy-MM", "yyyy", "yyyy/MM/dd" };

	public static Calendar getCalendar() {
		return GregorianCalendar.getInstance();
	}

	/**
	 * @return String
	 */
	public static String getDateMilliFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMilliFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateMilliFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateMilliFormat(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static String getDateSecondFormatII() {
		Calendar cal = Calendar.getInstance();
		return getDateSecondFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateSecondFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateSecondFormat(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String getDateSecondFormat() {
		String pattern = "yyyyMMddHHmmss";
		return getDateFormat(new Date(), pattern);
	}
	

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static String getDateMinuteFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMinuteFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateMinuteFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateMinuteFormat(Date date) {
		String pattern = "yyyy-MM-dd HH:mm";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarMinuteFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateMinuteFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static String getDateDayFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateDayFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateDayFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String formatCalendar(Calendar cal) {
		String pattern = "yyyyMMdd";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateDayFormat(Date date) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static String getDateFileFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateFileFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateFileFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateFileFormat(Date date) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @return String
	 */
	public static String getDateW3CFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateW3CFormat(cal);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateW3CFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateW3CFormat(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarW3CFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateW3CFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param cal
	 * @return String
	 */
	public static String getDateFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * @param date
	 * @return String
	 */
	public static String getDateFormat(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * @param strDate
	 * @return java.util.Date
	 */
	public static Date parseDateFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * @param cal
	 * @param pattern
	 * @return String
	 */
	public static String getDateFormat(Calendar cal, String pattern) {
		return getDateFormat(cal.getTime(), pattern);
	}

	/**
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static String getDateFormat(Date date, String pattern) {
		String str = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		if (date != null) {
			str = sdf.format(date);
		}
		return str;
	}

	public static String getDateFormat(String pattern) {
		Calendar cal = Calendar.getInstance();
		String str = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		str = sdf.format(cal.getTime());
		return str;

	}

	/**
	 * @param strDate
	 * @param pattern
	 * @return java.util.Calendar
	 */
	public static Calendar parseCalendarFormat(String strDate, String pattern) {

		Calendar cal = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		try {
			sdf.parse(strDate);
			cal = sdf.getCalendar();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return cal;

	}

	/**
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static Calendar parseFormat(String strDate) {

		Calendar cal = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		for (int i = 0; i < format.length; i++) {
			sdf.applyPattern(format[i]);
			try {
				sdf.parse(strDate);
				cal = sdf.getCalendar();
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return cal;

	}

	/**
	 * @param strDate
	 * @param pattern
	 * @return java.util.Date
	 */
	public static Date parseDateFormat(String strDate, String pattern) {

		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		try {
			date = sdf.parse(strDate);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return date;

	}

	public static int getLastDayOfMonth(int month) {
		if (month < 1 || month > 12) {
			return -1;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// int retn = 0;
		// if (month == 2)
		// {
		// if (isLeapYear())
		// {
		// retn = 29;
		// } else
		// {
		// retn = dayArray[month - 1];
		// }
		// } else
		// {
		// retn = dayArray[month - 1];
		// }
		// return retn;
	}

	public static int getLastDayOfMonth(int year, int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// int retn = 0;
		// if (month == 2)
		// {
		// if (isLeapYear(year))
		// {
		// retn = 29;
		// } else
		// {
		// retn = dayArray[month - 1];
		// }
		// } else
		// {
		// retn = dayArray[month - 1];
		// }
		// return retn;
	}

	public static boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(int year) {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.isLeapYear(year);
		// /**
		// * ��ϸ��ƣ� 1.��400��������꣬���� 2.���ܱ�4�����������
		// 3.�ܱ�4���ͬʱ���ܱ�100����������� 3.�ܱ�4���ͬʱ�ܱ�100�����������
		// */
		// if ((year % 400) == 0)
		// {
		// return true;
		// } else if ((year % 4) == 0)
		// {
		// if ((year % 100) == 0)
		// {
		// return false;
		// } else
		// {
		// return true;
		// }
		// } else
		// {
		// return false;
		// }
	}

	/**
	 * �ж�ָ�����ڵ�����Ƿ�������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return �Ƿ�����
	 */
	public static boolean isLeapYear(Date date) {
		/**
		 * ��ϸ��ƣ� 1.��400��������꣬���� 2.���ܱ�4�����������
		 * 3.�ܱ�4���ͬʱ���ܱ�100����������� 3.�ܱ�4���ͬʱ�ܱ�100�����������
		 */
		// int year = date.getYear();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.��400��������꣬���� 2.���ܱ�4�����������
		 * 3.�ܱ�4���ͬʱ���ܱ�100����������� 3.�ܱ�4���ͬʱ�ܱ�100�����������
		 */
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * �õ�ָ�����ڵ�ǰһ������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ�ǰһ������
	 */
	public static Date getPreviousWeekDay(Date date) {
		{
			GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
			gc.setTime(date);
			return getPreviousWeekDay(gc);
			// switch ( gc.get( Calendar.DAY_OF_WEEK ) )
			// {
			// case ( Calendar.MONDAY ):
			// gc.add( Calendar.DATE, -3 );
			// break;
			// case ( Calendar.SUNDAY ):
			// gc.add( Calendar.DATE, -2 );
			// break;
			// default:
			// gc.add( Calendar.DATE, -1 );
			// break;
			// }
			// return gc.getTime();
		}
	}

	public static Date getPreviousWeekDay(Calendar gc) {
		{
			/**
			 * ��ϸ��ƣ� 1.���date�������գ����3�� 2.���date�����������2��
			 * 3.�����1��
			 */
			switch (gc.get(Calendar.DAY_OF_WEEK)) {
			case (Calendar.MONDAY):
				gc.add(Calendar.DATE, -3);
				break;
			case (Calendar.SUNDAY):
				gc.add(Calendar.DATE, -2);
				break;
			default:
				gc.add(Calendar.DATE, -1);
				break;
			}
			return gc.getTime();
		}
	}

	/**
	 * �õ�ָ�����ڵĺ�һ������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵĺ�һ������
	 */
	public static Date getNextWeekDay(Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������壬���3�� 2.���date�����������2�� 3.�����1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 2);
			break;
		default:
			gc.add(Calendar.DATE, 1);
			break;
		}
		return gc.getTime();
	}

	public static Calendar getNextWeekDay(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.���date�������壬���3�� 2.���date�����������2�� 3.�����1��
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 2);
			break;
		default:
			gc.add(Calendar.DATE, 1);
			break;
		}
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ���µ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ���µ����һ��
	 */
	public static Date getLastDayOfNextMonth(Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ������getLastDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * @Method: getLastDayOfTopMonth
	 * @Description: 获取上个月的最后一天
	 * @param date
	 * @return : java.util.Date
	 */
	public static Date getLastDayOfTopMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getTopMonth(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ�����ڵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ�����ڵ����һ��
	 */
	public static Date getLastDayOfNextWeek(Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ������getLastDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ���µĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ���µĵ�һ��
	 */
	public static Date getFirstDayOfNextMonth(Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ������getFirstDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	public static Calendar getFirstDayOfNextMonth(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ������getFirstDayOfMonth
		 */
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ�����ڵĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ�����ڵĵ�һ��
	 */
	public static Date getFirstDayOfNextWeek(Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ������getFirstDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	public static Calendar getFirstDayOfNextWeek(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ������getFirstDayOfWeek
		 */
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ����
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ����
	 */
	public static Date getNextMonth(Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, 1);
		return gc.getTime();
	}

	/**
	 * @Method: getTopMonth
	 * @Description: 获取上一个月的时间
	 * @param date
	 * @return : java.util.Date
	 */
	public static Date getTopMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, -1);
		return gc.getTime();
	}

	public static Calendar getNextMonth(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1
		 */
		gc.add(Calendar.MONTH, 1);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ��
	 */
	public static Date getNextDay(Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 1);
		return gc.getTime();
	}

	public static Calendar getNextDay(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�1��
		 */
		gc.add(Calendar.DATE, 1);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ������
	 */
	public static Date getNextWeek(Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�7��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 7);
		return gc.getTime();
	}

	public static Calendar getNextWeek(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�7��
		 */
		gc.add(Calendar.DATE, 7);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ������ڵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������ڵ����һ��
	 */
	public static Date getLastDayOfWeek(Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����6�� 2.���date������һ�����5��
		 * 3.���date�����ڶ������4�� 4.���date�����������3��
		 * 5.���date�������ģ����2�� 6.���date�������壬���1��
		 * 7.���date�����������0��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 6);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, 5);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, 4);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, 2);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 1);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 0);
			break;
		}
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ������ڵĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������ڵĵ�һ��
	 */
	public static Date getFirstDayOfWeek(Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1��
		 * 3.���date�����ڶ������2�� 4.���date�����������3��
		 * 5.���date�������ģ����4�� 6.���date�������壬���5��
		 * 7.���date�����������6��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc.getTime();
	}

	public static Calendar getFirstDayOfWeek(Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1��
		 * 3.���date�����ڶ������2�� 4.���date�����������3��
		 * 5.���date�������ģ����4�� 6.���date�������壬���5��
		 * 7.���date�����������6��
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ����·ݵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ����·ݵ����һ��
	 */
	public static Date getLastDayOfMonth(Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date��1�£���Ϊ31�� 2.���date��2�£���Ϊ28��
		 * 3.���date��3�£���Ϊ31�� 4.���date��4�£���Ϊ30�� 5.���date��5�£���Ϊ31��
		 * 6.���date��6�£���Ϊ30�� 7.���date��7�£���Ϊ31�� 8.���date��8�£���Ϊ31��
		 * 9.���date��9�£���Ϊ30�� 10.���date��10�£���Ϊ31��
		 * 11.���date��11�£���Ϊ30�� 12.���date��12�£���Ϊ31��
		 * 1.���date�������2�£���Ϊ29��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY) && (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc.getTime();
	}

	public static Calendar getLastDayOfMonth(Calendar gc) {
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY) && (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc;
	}

	public static Date getFirstDayOfMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc.getTime();
	}

	public static Calendar getFirstDayOfMonth(Calendar gc) {
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc;
	}

	public static String toOraString(Date theDate, boolean hasTime) {
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getOraDateTimeFormat();
		} else {
			theFormat = getOraDateFormat();
		}
		return toString(theDate, theFormat);
	}

	public static String toString(Date theDate, boolean hasTime) {
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getDateTimeFormat();
		} else {
			theFormat = getDateFormat();
		}
		return toString(theDate, theFormat);
	}

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	// private static final SimpleDateFormat DATE_TIME_EXTENDED_FORMAT = new
	// SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

	private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

	// private static final SimpleDateFormat ORA_DATE_TIME_EXTENDED_FORMAT = new
	// SimpleDateFormat("yyyyMMddHHmmss");

	public static DateFormat getDateFormat() {
		SimpleDateFormat theDateFormat = (SimpleDateFormat) DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	public static DateFormat getDateTimeFormat() {
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	public static DateFormat getOraDateFormat() {
		SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	public static DateFormat getOraDateTimeFormat() {
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) ORA_DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	public static String toString(Date theDate, DateFormat theDateFormat) {
		if (theDate == null) {
			return "";
		}
		return theDateFormat.format(theDate);
	}

	public static String getIntervalYear() {
		return "";
	}

	public static String getIntervalMonth() {
		return "";
	}

	/**
	 * @Method: getIntervalDay
	 * @Description: 求2个字符日期相差多少天
	 * @param srcDate
	 * @param targetDate
	 * @return : String
	 */
	public static String getIntervalDay(Date srcDate, Date targetDate) {
		long src = srcDate.getTime();
		long target = targetDate.getTime();
		long result = target - src;
		if (result < 0) {
			return "0";
		}
		return String.valueOf(result / (1000 * 60 * 60 * 24));
	}

	/**
	 * @Method: getIntervalHour
	 * @Description: 求2个日期相差多少小时
	 * @param srcDate
	 * @param targetDate
	 * @return : String
	 */
	public static String getIntervalHour(Date srcDate, Date targetDate) {
		long src = srcDate.getTime();
		long target = targetDate.getTime();
		long result = target - src;
		if (result < 0) {
			return "0";
		}
		return String.valueOf(result / (1000 * 60 * 60));
	}

	/**
	 * @Method: getIntervalHour
	 * @Description: 求2个字符日期相差多少小时
	 * @param srcDate
	 * @param targetDate
	 * @return : String
	 */
	public static String getIntervalHour(String srcDate, String targetDate) {
		long src = DateUtil.parseDateFormat(srcDate).getTime();
		long target = DateUtil.parseDateFormat(targetDate).getTime();
		long result = target - src;
		if (result < 0) {
			return "0";
		}
		return String.valueOf(result / (1000 * 60 * 60));
	}

	/**
	 * @Method: getIntervalDay
	 * @Description: 求2个字符日期相差多少天
	 * @param srcDate
	 * @param targetDate
	 * @return : String
	 */
	public static String getIntervalDay(String srcDate, String targetDate) {
		long src = DateUtil.parseDateFormat(srcDate).getTime();
		long target = DateUtil.parseDateFormat(targetDate).getTime();
		long result = target - src;
		if (result < 0) {
			return "0";
		}
		return String.valueOf(result / (1000 * 60 * 60 * 24));
	}

	/**
	 * @Method: getDateInsertDays
	 * @Description: 获得时间后几天的日期
	 * @param strDate
	 * @param days
	 * @param pattern
	 * @return : String
	 */
	public static String getDateInsertDays(Date strDate, int days, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		long target = strDate.getTime();
		long result = target + (long) 1000 * 60 * 60 * 24 * days;
		return sdf.format(result);
	}

	public static Date parseDateInsertDays(Date strDate, int days) {
		long target = strDate.getTime();
		long result = target + (long) 1000 * 60 * 60 * 24 * days;
		return new Date(result);
	}

	/**
	 * @Method: getDateRemoveDays
	 * @Description: 获得时间前几天的日期
	 * @param strDate
	 * @param days
	 * @param pattern
	 * @return : String
	 */
	public static String getDateRemoveDays(Date strDate, int days, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		long target = strDate.getTime();
		long result = target - (long) 1000 * 60 * 60 * 24 * days;
		return sdf.format(result);
	}

	public static Date parseDateRemoveDays(Date strDate, int days) {
		long target = strDate.getTime();
		long result = target - (long) 1000 * 60 * 60 * 24 * days;
		return new Date(result);
	}

	/**
	 * @Method: getDaysBetween
	 * @Description: 求2个时间相差多少天
	 * @param startDate
	 * @param endDate
	 * @param pattern
	 * @return : Integer
	 */
	public static Integer getDaysBetween(String startDate, String endDate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Long quot = new Long(0);
		try {
			Date date1 = sdf.parse(startDate);
			Date date2 = sdf.parse(endDate);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return quot.intValue();
	}

	public static Integer getDaysBetween(Date startDate, Date endDate) {
		Long quot = new Long(0);
		if (startDate != null && endDate != null) {
			try {
				quot = endDate.getTime() - startDate.getTime();
				quot = quot / 1000 / 60 / 60 / 24;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return quot.intValue();
	}

	public static Integer getMonthsBetween(Date startDate, Date endDate) {
		GregorianCalendar gc1 = (GregorianCalendar) Calendar.getInstance();
		GregorianCalendar gc2 = (GregorianCalendar) Calendar.getInstance();
		gc1.setTime(startDate);
		gc2.setTime(endDate);
		return (gc2.get(Calendar.YEAR) - gc1.get(Calendar.YEAR)) * 12
				+ (gc2.get(Calendar.MARCH) - gc1.get(Calendar.MARCH));
	}

	public static Integer getWeekDayByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	public static String convert(int val) {
		String retStr = "";
		switch (val) {
		case 0:
			return "星期日";
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		default:
			break;
		}
		return retStr;
	}

	public static Calendar getCalendar(String stirng, String parttern) {
		Calendar calendar = Calendar.getInstance();
		Date date = parseDateFormat(stirng, parttern);
		calendar.setTime(date);
		return calendar;
	}

	public static float getSecondsBetween(String d1, String d2) {
		float d = 0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1;
		Date date2;
		try {
			date1 = df.parse(d1);
			date2 = df.parse(d2);
			d = (date1.getTime() - date2.getTime()) / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 求两个日期之间的间隔
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDisday(Date beginDate, Date endDate) {
		int day = 1000 * 3600 * 24;
		Long invalidDate = (endDate.getTime() - beginDate.getTime()) / day;
		return invalidDate.intValue();
	}

	/**
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date getDateFromString(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Date result = null;
		try {
			if (date != null && date.length() > 0) {
				result = sdf.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param dates
	 * @param pattern
	 * @return
	 */
	public static Calendar getCalendarFromString(String dates, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Calendar result = Calendar.getInstance();
		try {
			Date date = sdf.parse(dates);
			result.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author mgj
	 * @Version 1.0
	 * @date Mar 14, 2011
	 * @Description 计算起迄月份差异天数
	 * @return List<String>
	 */
	public static int getDaysBySelectMonth(String startYead, String startMonth, String endYear, String endMonth) {
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		startCalendar.set(Calendar.YEAR, Integer.parseInt(startYead));
		startCalendar.set(Calendar.MONTH, Integer.parseInt(startMonth) - 1);
		startCalendar.set(Calendar.DAY_OF_MONTH, 1);

		endCalendar.set(Calendar.YEAR, Integer.parseInt(endYear));
		endCalendar.set(Calendar.MONTH, Integer.parseInt(endMonth) - 1);
		endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		int days = 0;
		while (startCalendar.compareTo(endCalendar) <= 0) {
			startCalendar.set(Calendar.DAY_OF_MONTH, startCalendar.get(Calendar.DAY_OF_MONTH) + 1);
			days++;
		}
		return days;
	}

	/**
	 * @author zwl
	 * @Version 1.0
	 * @date Mar 02, 2011
	 * @Description 求指定日期的最后一天
	 * @return List<String>
	 */
	public static String lastDayOfMonth2(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDateDayFormat(date));
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return getDateDayFormat(cal.getTime());

	}

	/**
	 * @author zwl
	 * @Version 1.0
	 * @date Mar 02, 2011
	 * @Description 求指定日期的第一一天
	 * @return List<String>
	 */
	public static String getMonthBegin(String strDate) {
		String pattern = "yyyy-MM";
		return getDateDayFormat(parseDateFormat(strDate, pattern));
	}

	public static Date addYear(Date date, int add) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, add);
		return c.getTime();
	}

	public static Date addMonth(Date date, int add) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, add);
		return c.getTime();
	}

	public static Date addDate(Date date, int add) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, add);
		return c.getTime();
	}

	public static String getDate(Date d) {
		SimpleDateFormat gSimpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		return gSimpleDateFormat.format(d);
	}

	public static Date getDate(String dateString) {
		SimpleDateFormat gSimpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		try {
			return gSimpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static String getFormatDateStr(Date date) {
		SimpleDateFormat gSimpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		String dateStr = gSimpleDateFormat.format(date);
		return dateStr;
	}

	public static String addDate(String dateString, int add) {
		String rtv = null;
		if (dateString != null && dateString.trim().length() > 0) {
			try {
				Date origDate = getDate(dateString.trim());
				Date newDate = addDate(origDate, add);
				rtv = getFormatDateStr(newDate);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return rtv;
	}

	public static String getFormatDateStr(Date date, String pattern) throws Exception {
		SimpleDateFormat gSimpleDateFormat = new SimpleDateFormat(pattern);
		String dateStr = gSimpleDateFormat.format(date);
		return dateStr;
	}
}
