package com.rae.common.log;

import android.util.Log;

public class DefaultLogger extends Logger {

	public DefaultLogger(Class<?> cls) {
		super(cls);
	}

	public DefaultLogger(String tag) {
		super(tag);
	}

	public DefaultLogger() {
		super();
	}

	@Override
	public void log(int level, String tag, String msg) {
		log(level, tag, msg, null);
	}

	private void log(int level, String tag, String msg, Throwable e) {
		if (!enable) {
			return;
		}

		LogMessage message = getLogMessage(msg, e);
		message.Level = LogMessage.getLevelName(level);
		message.Tag = tag;
		msg = message.Msg;

		switch (level) {
			case Log.VERBOSE:
				Log.v(tag, msg);
				break;
			case Log.DEBUG:
				Log.d(tag, msg);
				break;
			case Log.INFO:
				Log.i(tag, msg);
				break;
			case Log.WARN:
				Log.w(tag, msg);
				break;
			case Log.ERROR:
				Log.e(tag, msg);
				break;
			default:
				System.out.println(msg);
				break;
		}

		notifyLog(message);

	}

	@Override
	public void error(String tag, String msg, Throwable e) {
		log(Log.ERROR, tag, msg, e);
	}

	@Override
	public void warn(String tag, String msg, Throwable e) {
		log(Log.WARN, tag, msg, e);
	}

	private void notifyLog(LogMessage message) {
		message.RecTime = System.currentTimeMillis();
		for (LogAppender appender : getLogAppenderList()) {
			appender.append(message);
		}
	}

	/**
	 * 获取出错位置详情
	 * @param msg
	 * @param e
	 * 
	 * @return
	 */
	private LogMessage getLogMessage(String msg, Throwable e) {
		LogMessage result = new LogMessage();
		if (e != null) {
			Thread thread = Thread.currentThread();
			for (StackTraceElement element : thread.getStackTrace()) {
				String className = element.getClassName();
				if (!mTag.equals(className)) {
					continue;
				}

				result.FileName = element.getFileName();
				result.ClassName = className + "." + element.getMethodName();
				result.LineNumber = element.getLineNumber();
				result.Msg = msg + " - [" + result.ClassName + "(" + result.FileName + ":" + result.LineNumber + ")]\r\n" + Log.getStackTraceString(e);
				break;
			}
		}
		else {
			result.Msg = msg;
		}
		result.RecTime = System.currentTimeMillis();
		return result;
	}

}
