package com.rae.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

/**
 * Logger 日志入口
 * 
 * @author ChenRui
 * 
 */
public abstract class Logger {

	private static LogConfig	Config;
	private static LogFilter	Filter;

	static {
		Config = LogConfig.buildDefaultConfig();
		Filter = new LogFilter();
	}

	public static LogConfig getConfig() {
		return Config;
	}

	public static LogFilter getFilter() {
		return Filter;
	}

	private String	mTag;	// 默认Tag，一般为类名

	public Logger(String tag) {
		this.mTag = tag;
	}

	public Logger(Class<?> cls) {
		this(cls.getName());
	}

	public void v(String tag, String msg) {
		log(Log.VERBOSE, tag, msg);
	}

	public void d(String tag, String msg) {
		log(Log.DEBUG, tag, msg);
	}

	public void i(String tag, String msg) {
		log(Log.INFO, tag, msg);
	}

	public void w(String tag, String msg) {
		log(Log.WARN, tag, msg);
	}

	public void e(String tag, String msg) {
		log(Log.ERROR, tag, msg);
	}

	public void e(String tag, String msg, Throwable e) {
		error(tag, msg, e);
	}

	public void v(String msg) {
		log(Log.VERBOSE, mTag, msg);
	}

	public void d(String msg) {
		log(Log.DEBUG, mTag, msg);
	}

	public void i(String msg) {
		log(Log.INFO, mTag, msg);
	}

	public void w(String msg) {
		log(Log.WARN, mTag, msg);
	}

	public void e(String msg) {
		log(Log.ERROR, mTag, msg);
	}

	public void e(String msg, Throwable e) {
		error(mTag, msg, e);
	}

	public void e(Throwable e) {
		error(mTag, "", e);
	}

	public abstract void log(int level, String tag, String msg);

	public abstract void error(String tag, String msg, Throwable e);

	/**
	 * 格式化字符串
	 * 
	 * @param format
	 * @param args
	 * @exception RuntimeException
	 *                参数个数不一样时抛出
	 * @return
	 */
	public String format(String format, Object... args) {
		Pattern pattern = Pattern.compile("{.?}");
		Matcher matcher = pattern.matcher(format);
		if (args.length != matcher.groupCount()) {
			throw new RuntimeException("格式化参数个数不匹配！");
		}

		// 按照顺序替换

		for (int i = 0; i < args.length; i++) {
			format = format.replace("{" + i + "}", matcher.group(i));
		}

		return format;
	}
}
