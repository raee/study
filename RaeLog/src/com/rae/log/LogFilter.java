package com.rae.log;

import android.text.TextUtils;
import android.util.SparseArray;

/**
 * ÈÕ¼Ç¹ýÂËÆ÷
 * 
 * @author ChenRui
 * 
 */
public final class LogFilter {

	private static final String			DEFAULT_FILTER_NAME	= "DEFAULT_FILTER_NAME";
	private static SparseArray<String>	FilterArrays		= new SparseArray<String>();

	public void remove(int level) {
		FilterArrays.remove(level * 100);
	}

	public void put(int level) {
		FilterArrays.put(level * 100, DEFAULT_FILTER_NAME);
	}

	public void put(int level, String tag) {
		FilterArrays.put(level, tag);
	}

	public boolean isFilter(int level) {
		String value = FilterArrays.get(level * 100);
		return !TextUtils.isEmpty(value);
	}

	public boolean isFilter(int level, String tag) {
		String value = FilterArrays.get(level);
		return tag.equals(value);
	}
}
