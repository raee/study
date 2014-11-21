package com.rae.log.appender;

import android.util.Log;

import com.rae.log.LogMessage;

public class AndroidLogAppender extends LogAppender {

	@Override
	public void append(LogMessage message) {
		String tag = message.getTag();
		String msg = message.getTag();

		switch (message.getLevel()) {
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
				message.getThrowableInfo().printStackTrace();
				break;
			default:
				break;
		}
	}

}
