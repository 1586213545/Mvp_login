package com.seedmorn.utility;

import android.content.Context;


public class Log {

	/** 是否输出日志 */
	private final static boolean DEBUG = true;
	
	public void init(Context context) {
		if (!DEBUG) {
			LogcatHelper.getInstance(context).start();
		}
	}
	
	public static void e(String TAG, String msg) {
		if (DEBUG) {
			android.util.Log.e(TAG, msg);
		}
	}
	public static void w(String TAG, String msg) {
		if (DEBUG) {
			android.util.Log.w(TAG, msg);
		}
	}
	public static void i(String TAG, String msg) {
		if (DEBUG) {
			android.util.Log.i(TAG, msg);
		}
	}
	public static void d(String TAG, String msg) {
		if (DEBUG) {
			android.util.Log.d(TAG, msg);
		}
	}
	public static void v(String TAG, String msg) {
		if (DEBUG) {
			android.util.Log.v(TAG, msg);
		}
	}
}
