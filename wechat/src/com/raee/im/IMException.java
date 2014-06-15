package com.raee.im;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.XMPPError;

import android.util.Log;

/**
 * 聊天连接错误
 * 
 * @author ChenRui
 * 
 */
public class IMException
{

	public static String except(XMPPException e)
	{
		String msg = "发生未知异常，请重试！";
		XMPPError error = e.getXMPPError();
		if ( e == null || error == null ) return msg;
		int errorCode = error.getCode();
		switch (errorCode)
		{
			case 300:
			case 301:
			case 302:
				msg = Constant.ERROR_IM_CONNECTION_REDIRECT;
				break;
			case 400:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_JID;
				break;
			case 401:
				msg = Constant.ERROR_IM_CONNECTION_PASSWORD;
				break;
			case 403:
				msg = Constant.ERROR_IM_CONNECTION_FORBIDDEN;
				break;
			case 404:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_NOT_FOND;
				break;
			case 405:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_NOT_ALLOW;
				break;
			case 406:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_NOT_ACCEPT;
				break;
			case 407:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_REQUEST_REGEDIT;
				break;
			case 408:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_TIME_OUT;
				break;
			case 409:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_CONFLICT;
				break;
			case 500:
			case 501:
			case 502:
			case 503:
			case 504:
				msg = Constant.ERROR_IM_CONNECTION_SERVER_INTERNA;
				break;
			default:
				break;
		}
		Log.e("IMException", msg);
		e.printStackTrace();
		return msg;
	}
}
