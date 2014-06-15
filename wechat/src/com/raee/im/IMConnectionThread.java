package com.raee.im;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.XMPPError;

import android.os.AsyncTask;
import android.util.Log;

/**
 * 聊天服务器连接线程
 * 
 * @author ChenRui
 * 
 */
public class IMConnectionThread extends AsyncTask<Boolean, Integer, Void>
{

	private XMPPConnection	mXmppConnection	= null;

	private String			tag				= "IMConnectionThread";

	public IMConnectionThread(XMPPConnection connection)
	{
		this.mXmppConnection = connection;
	}

	private void connect()
	{
		Log.i(tag, "聊天服务开始运行");
		try
		{
			// 连接必须运行在线程上
			this.mXmppConnection.connect();
		}
		catch (XMPPException e)
		{
			IMException.except(e);
		}
	}

	/**
	 * 取消聊天服务器连接
	 */
	public void cancle()
	{
		mXmppConnection.disconnect();
	}

	@Override
	protected Void doInBackground(Boolean... params)
	{
		connect();
		return null;
	}

	/**
	 * 开始运行线程
	 */
	public void start()
	{
		if ( this.getStatus() == Status.PENDING ) // 没有运行，则开始运行
		{
			this.execute(true);
		}
	}
}
