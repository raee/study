package com.raee.wechat;

import com.raee.im.IMConnection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener
{

	private IMConnection	mConn;

	private EditText		etUserName, etPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.etUserName = (EditText) findViewById(R.id.username);
		this.etPassword = (EditText) findViewById(R.id.password);
		mConn = new IMConnection();
		mConn.connect();
	}

	@Override
	public void onClick(View v)
	{
		mConn.connect();
		mConn.login(etUserName.getText().toString(), etPassword.getText().toString());
	}
}
