package com.rae.common.log;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

public class UnHanderExceptionHandler implements UncaughtExceptionHandler {

	private UncaughtExceptionHandler	defaultHandler;

	private Context						context;

	private Logger						log		= Logger.getLogger(getClass());

	private String						tag		= "SystemRuntime";

	private Handler						mhander	= new Handler(new Handler.Callback() {

													@Override
													public boolean handleMessage(Message msg) {
														// Toast.makeText(context,
														// "程序异常退出！",
														// Toast.LENGTH_SHORT).show();
														Process.killProcess(Process.myPid());
														return false;
													}
												});

	public UnHanderExceptionHandler(Context context) {
		this.context = context;
		defaultHandler = Thread.getDefaultUncaughtExceptionHandler(); // 默认处理异常
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {

		// 如果用户没有处理则让系统默认的异常处理器来处理
		if (!handleException(ex) && defaultHandler != null) {
			defaultHandler.uncaughtException(thread, ex);
		}

		android.os.Process.killProcess(android.os.Process.myPid()); // 杀死该进程
		System.exit(0); // 退出
	}

	/**
	 * 用户处理异常
	 * 
	 * @param ex
	 * @return
	 */
	private boolean handleException(Throwable ex) {
		if (ex == null) {
			return false;
		}

		// log.e(tag, "程序异常退出！", ex);
		Log.e(tag, ex.getMessage());
		return true;
	}

}
