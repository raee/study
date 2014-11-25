package com.rae.common.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.util.Log;

/**
 * 文件记录，主要记录除了异常的信息。
 * 
 * @author ChenRui
 * 
 */
public class FileLogAppender extends LogAppender {

	private File	mFile;				// log 日志文件路径

	private boolean	enable	= false;	// 文件日志记录是否能够正常记录，如果文件不能写入这里为false.

	/**
	 * @param path
	 *            log 文件夹路径
	 */
	public FileLogAppender(String path) {
		File dir = new File(path);
		mFile = new File(path + File.separator + getDate() + ".log");

		// 文件夹存在并且可以写入的,并且没有今天的日志
		if (dir.exists() && dir.canWrite() && !mFile.exists()) {
			try {
				enable = mFile.createNewFile(); // 创建日志文件。
			}
			catch (IOException e) {
				e.printStackTrace();
				enable = false;
			}
		}

		// 日志文件已经存在
		if (mFile.canWrite() && mFile.exists()) {
			enable = true;
		}

	}

	private String getDate() {
		return getDate("yyyy-MM-dd");
	}

	@SuppressLint("SimpleDateFormat")
	private String getDate(String format) {
		String result = "";
		try {
			result = new SimpleDateFormat(format).format(System.currentTimeMillis()).toString();
		}
		catch (Exception e) {
			result = "日期获取异常！";
		}
		return result;
	}

	@Override
	public void append(LogMessage message) {
		// 文件日志不写入错误信息
		if (LogMessage.WARN.equals(message.Level) || LogMessage.ERROR.equals(message.Level)) {
			return;
		}

		if (!enable) {
			Log.w(message.Tag, "Log 文件不能写入请检查路径：" + mFile.getParent() + "。日志内容：" + message.Msg);
			return;
		}

		try {

			FileWriter writer = new FileWriter(mFile, true);
			String text = getLogString(message.Level, message.Tag, message.Msg);
			writer.append(text);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 获取Log日志
	private String getLogString(String level, String tag, String msg) {
		String result = "[" + level + "] " + "[" + getDate("yyyy-MM-dd HH:mm") + "] " + "[" + tag + "] \r\n" + msg + "\r\n\r\n";
		return result;
	}

}
