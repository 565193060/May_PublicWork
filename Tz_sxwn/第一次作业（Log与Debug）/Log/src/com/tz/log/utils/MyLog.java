package com.tz.log.utils;

import android.util.Log;

public class MyLog {
	public static boolean isDebug;//日志的开关
	public static int i(String tag, String msg){
		if (isDebug) {
			//日志可以正常输出
			Log.i(tag, msg);
		}
		return 0;
	}
	
	public static int d(String tag,String msg){
		if (isDebug) {
			//debug日志可以正常输出
			return Log.d(tag, msg);
		}
		return 0;
	}
}
