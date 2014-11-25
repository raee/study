package com.rae.common.log;

import android.util.Log;

public class LogMessage {
	public static final String	VERBOSE	= "V";
	public static final String	DEBUG	= "D";
	public static final String	INFO	= "I";
	public static final String	WARN	= "W";
	public static final String	ERROR	= "E";

	public int					LogId, LineNumber;
	public long					RecTime;
	public String				Level, Tag, Msg, ClassName, FileName;

	public static String getLevelName(int level) {
		String result = "";
		switch (level) {
			case Log.VERBOSE:
				result = VERBOSE;
				break;
			case Log.DEBUG:
				result = DEBUG;
				break;
			case Log.INFO:
				result = INFO;
				break;
			case Log.WARN:
				result = WARN;
				break;
			case Log.ERROR:
				result = ERROR;
				break;
			default:
				result = "SYS";
				break;
		}
		return result;
	}
}
