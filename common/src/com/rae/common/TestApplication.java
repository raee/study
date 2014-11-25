package com.rae.common;

import com.rae.common.log.Logger;

import android.app.Application;

public class TestApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.initLogger(this.getApplicationContext());
	}
}
