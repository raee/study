package com.rae.log.test;

import android.annotation.SuppressLint;
import android.test.AndroidTestCase;

import com.rae.log.DefaultLogger;
import com.rae.log.Logger;

public class TestLog extends AndroidTestCase {
	@SuppressLint("SdCardPath")
	public void test() {
		Logger log = new DefaultLogger(TestLog.class);
		Logger.getConfig().setFormat("[%level] [%message]");
		Logger.getConfig().setApplicationContext(getContext());
		Logger.getConfig().setDirPath("/mnt/sdcard/rae/log");

		log.i("这是提示信息！");

	}
}
