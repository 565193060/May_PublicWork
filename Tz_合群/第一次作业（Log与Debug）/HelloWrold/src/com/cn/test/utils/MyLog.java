package com.cn.test.utils;

import android.util.Log;

/**
 * Created on2015-5-18 ����6:48:54 MyLog.java<br/>
 * Author ZhuHequn 1363790125@qq.com <br/>
 * version 1.0 TODO
 */
public class MyLog {

	public static boolean isDebug; // Log��־����

	public static int println(int priority, String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.println(priority, tag, msg);
		}
		return 0;
	}

	// VERBOSE ��־ ����
	public static int v(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.v(tag, msg);
		}
		return 0;
	}

	// DEBUG ��־����
	public static int d(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.d(tag, msg);
		}
		return 0;
	}

	// INFO ��־����
	public static int i(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.i(tag, msg);
		}
		return 0;
	}

	// WARN ��־����
	public static int w(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.w(tag, msg);
		}
		return 0;
	}

	// ERROR ��־����
	public static int e(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.e(tag, msg);
		}
		return 0;
	}

	// ASSERT ��־����
	public static int a(String tag, String msg) {
		if (isDebug) {
			// ��isDebugΪtrueʱִ��Log��־
			return Log.ASSERT;
		}
		return 0;
	}
}
