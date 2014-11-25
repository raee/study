package com.rae.common.log;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 错误信息写入数据库
 * @author ChenRui
 * 
 */
public class SqliteLogAppender extends LogAppender {

	private SqliteLogAppenderDatabaseOpenHelper	mdb;

	public SqliteLogAppender(Context context, String name) {
		mdb = new SqliteLogAppenderDatabaseOpenHelper(context, name);
	}

	@Override
	public void append(LogMessage message) {

		// 数据库只是记录错误信息。
		if (LogMessage.WARN.equals(message.Level) || LogMessage.ERROR.equals(message.Level)) {
			mdb.insert(message);
		}
	}

	class SqliteLogAppenderDatabaseOpenHelper extends SQLiteOpenHelper {

		public SqliteLogAppenderDatabaseOpenHelper(Context context, String name) {
			super(context, name, null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql = "CREATE TABLE logs(logid INTEGER NOT NULL,lv VARCHAR(5)NOT NULL,tag VARCHAR(120)NOT NULL,msg VARCHAR(2048)NOT NULL,class_name VARCHAR(1024),file_name VARCHAR(120),line_number int,rec_time int NOT NULL,PRIMARY KEY(logid));";
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("delete from logs");
		}

		public void insert(LogMessage m) {
			getWritableDatabase().insert("logs", null, getValues(m));
		}

		public void update(LogMessage m) {
			getWritableDatabase().update("logs", getValues(m), "logid=?", new String[] { String.valueOf(m.LogId) });
		}

		public List<LogMessage> getList() {
			List<LogMessage> result = new ArrayList<LogMessage>();
			Cursor cursor = getReadableDatabase().rawQuery("select * from logs", null);
			while (cursor.moveToNext()) {
				LogMessage m = new LogMessage();
				m.LogId = cursor.getInt(cursor.getColumnIndex("logid"));
				m.Level = cursor.getString(cursor.getColumnIndex("lv"));
				m.Tag = cursor.getString(cursor.getColumnIndex("tag"));
				m.Msg = cursor.getString(cursor.getColumnIndex("msg"));
				m.ClassName = cursor.getString(cursor.getColumnIndex("class_name"));
				m.FileName = cursor.getString(cursor.getColumnIndex("file_name"));
				m.LineNumber = cursor.getInt(cursor.getColumnIndex("line_number"));
				m.RecTime = cursor.getInt(cursor.getColumnIndex("rec_time"));
				result.add(m);
			}
			return result;
		}

		private ContentValues getValues(LogMessage m) {
			ContentValues values = new ContentValues();
			values.put("lv", m.Level);
			values.put("tag", m.Tag);
			values.put("msg", m.Msg);
			values.put("class_name", m.ClassName);
			values.put("file_name", m.FileName);
			values.put("line_number", m.LineNumber);
			values.put("rec_time", m.RecTime);
			return values;
		}

	}
}
