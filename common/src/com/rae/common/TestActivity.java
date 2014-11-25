package com.rae.common;

import com.rae.common.log.Logger;

import android.app.Activity;
import android.os.Bundle;

public class TestActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		Logger log = Logger.getLogger(getClass());
		
		
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
