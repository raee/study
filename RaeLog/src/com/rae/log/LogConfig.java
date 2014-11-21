package com.rae.log;

import android.content.Context;

/**
 * 日志配置
 * 
 * @author ChenRui
 * 
 */
public final class LogConfig {
	public static LogConfig buildDefaultConfig() {
		return new LogConfig();
	}

	private String	format;			// 格式为LogMessage定义的字段。
	private boolean	enableLog;
	private boolean	enableDebug;
	private Context	applicationContext;
	private String	dirPath;
	private String	url;

	private LogConfig() {
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public boolean isEnableLog() {
		return enableLog;
	}

	public void setEnableLog(boolean enableLog) {
		this.enableLog = enableLog;
	}

	public boolean isEnableDebug() {
		return enableDebug;
	}

	public void setEnableDebug(boolean enableDebug) {
		this.enableDebug = enableDebug;
	}

	public Context getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(Context applicationContext) {
		this.applicationContext = applicationContext;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String filePath) {
		this.dirPath = filePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
