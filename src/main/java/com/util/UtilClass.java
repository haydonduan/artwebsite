package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilClass {
	
	private static java.text.SimpleDateFormat fromat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static String formatTime(Date time){
		return fromat.format(time);
	}
}
