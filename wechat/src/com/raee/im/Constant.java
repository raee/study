package com.raee.im;

/**
 * 一些常量
 * 
 * @author ChenRui
 * 
 */
public final class Constant
{

	// 302
	public static final String	ERROR_IM_CONNECTION_REDIRECT				= "服务器连接被重置";

	// 400
	public static final String	ERROR_IM_CONNECTION_SERVER_JID				= "发生了意外错误";

	// 401
	public static final String	ERROR_IM_CONNECTION_PASSWORD				= "登录失败，用户名或密码错误！";

	// 403
	public static final String	ERROR_IM_CONNECTION_FORBIDDEN				= "服务器禁止登录";

	// 404
	public static final String	ERROR_IM_CONNECTION_SERVER_NOT_FOND			= "没有找到聊天服务器";

	// 405
	public static final String	ERROR_IM_CONNECTION_SERVER_NOT_ALLOW		= "服务器不允许操作";

	// 406
	public static final String	ERROR_IM_CONNECTION_SERVER_NOT_ACCEPT		= "服务器不允许访问";

	// 407
	public static final String	ERROR_IM_CONNECTION_SERVER_REQUEST_REGEDIT	= "服务器要求登录";

	// 408
	public static final String	ERROR_IM_CONNECTION_SERVER_TIME_OUT			= "连接服务器超时";

	// 409-conflict
	public static final String	ERROR_IM_CONNECTION_SERVER_CONFLICT			= "服务器冲突";

	// 500-501-502-503-interna
	public static final String	ERROR_IM_CONNECTION_SERVER_INTERNA			= "服务器内部错误";
}
