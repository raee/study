package com.rae.common.log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

/**
 * Log Main
 * 
 * @author ChenRui
 * 
 */
public abstract class Logger {

	private static List<LogAppender>	LoggerAppenderList	= new ArrayList<LogAppender>();
	public static boolean				enable				= true;
	public static String				LogDirPath;
	public static String				LogDatabaseName		= "mylogger.db";
	private static Logger				DefaultLogger;

	/**
	 * 程序运行必须初始化Logger
	 */
	public static void initLogger(Context context) {
		DefaultLogger = new DefaultLogger();

		// Log 文件目录
		LogDirPath = Environment.getExternalStorageDirectory().getPath() + File.separator + context.getPackageName();

		File dir = new File(LogDirPath);

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && !dir.exists()) {
			dir.mkdir();
		}

		// Log appender
		LoggerAppenderList.add(new FileLogAppender(LogDirPath));
		LoggerAppenderList.add(new SqliteLogAppender(context, LogDatabaseName));

		// 程序异常处理
		
		UnHanderExceptionHandler handler = new UnHanderExceptionHandler(context);
		Thread.setDefaultUncaughtExceptionHandler(handler);
	}

	public static void addAppender(LogAppender appender) {
		LoggerAppenderList.add(appender);
	}

	public List<LogAppender> getLogAppenderList() {
		return LoggerAppenderList;
	}

	public static Logger getLogger(Class<?> cls) {
		DefaultLogger.setTag(cls);
		return DefaultLogger;
	}

	public static Logger getLogger() {
		return DefaultLogger;
	}

	protected String	mTag;

	public Logger(String tag) {
		setTag(tag);
	}

	public Logger(Class<?> cls) {
		setTag(cls);
	}

	public Logger() {

	}

	public void setTag(String tag) {
		this.mTag = tag;
	}

	public void setTag(Class<?> cls) {
		this.mTag = cls.getName();
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
		warn(tag, msg, null);
	}

	public void e(String tag, String msg) {
		error(tag, msg, null);
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
		warn(mTag, msg, null);
	}

	public void w(Throwable e) {
		warn(mTag, "", e);
	}

	public void w(String msg, Throwable e) {
		warn(mTag, msg, e);
	}

	public void e(String msg) {
		error(mTag, msg, null);
	}

	public void e(String msg, Throwable e) {
		error(mTag, msg, e);
	}

	public void e(Throwable e) {
		error(mTag, "", e);
	}

	public abstract void log(int level, String tag, String msg);

	public abstract void error(String tag, String msg, Throwable e);

	public abstract void warn(String tag, String msg, Throwable e);

}
