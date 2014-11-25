package com.rae.test;

import com.rae.common.log.DefaultLogger;
import com.rae.common.log.Logger;

import android.test.AndroidTestCase;

public class LogTest extends AndroidTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Logger.initLogger(getContext());
	}

	public void testLog() {
		Logger log = new DefaultLogger(getClass());
		log.v("这是V！");
		log.d("这是D！");
		log.i("这是I！");
		log.w("这是W！");
		log.e("这是E！");

		// try {
		Integer.parseInt("abc");
		// }
		// catch (Exception e) {
		// log.w("转换错误", e);
		// }
	}
}
