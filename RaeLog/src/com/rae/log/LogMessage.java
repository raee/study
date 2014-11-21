package com.rae.log;

/**
 * Log 消息实体
 * 
 * @author ChenRui
 * 
 */
public class LogMessage {
	public static LogMessage buildMessage(int level, String tag, String msg) {
		LogMessage message = new LogMessage();
		message.setLevel(level);
		message.setTag(tag);
		message.setMessage(msg);
		return message;
	}

	private String		tag;			// 标志
	private String		className;		// 出错类名
	private String		lineNumber;	// 出错行号
	private int			level;			// 日志等级
	private String		message;		// 错误消息
	private String		stackInfo;		// 堆栈信息
	private String		recordTime;	// 日志记录时间
	private String		versionInfo;	// 版本信息
	private Throwable	throwableInfo;	// 堆栈记录

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackInfo() {
		return stackInfo;
	}

	public void setStackInfo(String stackInfo) {
		this.stackInfo = stackInfo;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Throwable getThrowableInfo() {
		return throwableInfo;
	}

	public void setThrowableInfo(Throwable throwableInfo) {
		this.throwableInfo = throwableInfo;
	}
}
