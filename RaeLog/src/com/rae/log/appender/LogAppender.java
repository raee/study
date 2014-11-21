package com.rae.log.appender;

import com.rae.log.LogConfig;
import com.rae.log.LogFilter;
import com.rae.log.LogMessage;

public abstract class LogAppender {
	private LogConfig	config;
	private LogFilter	filter;
	
	protected LogConfig getConfig()
	{
		return config;
	}
	
	protected LogFilter getFilter()
	{
		return filter;
	}
	

	public abstract void append(LogMessage msg);
}
