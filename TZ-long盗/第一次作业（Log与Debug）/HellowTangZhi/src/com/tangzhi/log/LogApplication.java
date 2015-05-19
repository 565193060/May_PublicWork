package com.tangzhi.log;

import android.app.Application;

public class LogApplication extends Application{
    @Override  
    public void onCreate() {  
        super.onCreate();  
        CrashHandler crashHandler = CrashHandler.getInstance();  
        // ע��crashHandler  
        crashHandler.init(getApplicationContext());  
        // ������ǰû���͵ı���(��ѡ)  
        crashHandler.sendPreviousReportsToServer();  
    }

}
