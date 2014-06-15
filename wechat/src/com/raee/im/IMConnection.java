package com.raee.im;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 * 聊天服务器连接
 * 
 * @author ChenRui
 * 
 */
public class IMConnection
{

	private XMPPConnection	mXmppConnection	= null;

	public IMConnection()
	{
		String host = IMConfig.ServerHost;
		int port = IMConfig.ServerPost;
		String name = IMConfig.ServerName;
		ConnectionConfiguration config = new ConnectionConfiguration(host,
				port, name);
		mXmppConnection = new XMPPConnection(config);
	}

	public void connect()
	{
		try
		{
			this.mXmppConnection.connect();
		}
		catch (XMPPException e)
		{
			e.printStackTrace();
		}
	}
}
