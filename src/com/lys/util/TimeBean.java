package com.lys.util;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBean {	
	/**
	 * 静态方法,获取系统当前时间,返回值类型为Timestamp
	 */
	public static Timestamp getCurrenTime()throws Exception{
		Timestamp currentTime = null;
		//HH：24小时制时间显示  hh:12小时制时间显示
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String systemTime = f.format(date);
		currentTime = Timestamp.valueOf(systemTime);
		return currentTime;
	}
}
