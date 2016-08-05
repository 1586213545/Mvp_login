package com.seedmorn.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date(System.currentTimeMillis()));
		return date;// 2016Äê10ÔÂ03ÈÕ 23:41:31
	}

	public static String getDateAndTime() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;// 2016-10-03 23:41:31
	}

}