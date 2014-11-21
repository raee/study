package com.rae.log.appender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.rae.log.LogMessage;

public class SqliteLogAppender extends LogAppender {

	@Override
	public void append(LogMessage msg) {

	}

	class LogAppenderOpenHelper extends SQLiteOpenHelper {

		public LogAppenderOpenHelper(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {

		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	}

}
