package com.raee.wechat;

import com.raee.im.IMConnection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener
{

	private IMConnection	mConn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mConn = new IMConnection();
	}

	@Override
	public void onClick(View v)
	{
		mConn.connect();
	}
}
