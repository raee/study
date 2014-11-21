package com.rae.log;

public class DefaultLogger extends Logger {

	public DefaultLogger(Class<?> cls) {
		super(cls);
	}

	public DefaultLogger(String tag) {
		super(tag);
	}

	@Override
	public void log(int level, String tag, String msg) {

		// ÈÕÖ¾¹ıÂË
		boolean levelFilter = getFilter().isFilter(level);
		boolean isFilter = getFilter().isFilter(level, tag);
		if (levelFilter || isFilter) {
			return;
		}

	}

	@Override
	public void error(String tag, String msg, Throwable e) {

	}

}
