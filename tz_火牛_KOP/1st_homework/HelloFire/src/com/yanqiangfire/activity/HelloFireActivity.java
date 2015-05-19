package com.yanqiangfire.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.yanqiangfire.util.CustomLog;

public class HelloFireActivity extends Activity implements OnClickListener {
	private static final String TAG = "HelloFireActivity";
	private Button mCollectBtn;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomLog.setNowDebugFlag(true);
        CustomLog.w(TAG, "into onCreate warn log");
        CustomLog.e(TAG, "into onCreate error log");
        setContentView(R.layout.main);
        mCollectBtn = (Button) findViewById(R.id.collect_btn);
        if(mCollectBtn!=null)
        {
            mCollectBtn.setOnClickListener(this);
        }
    }

	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		try
		{
			readSysLog();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ʹ��logcat��ȡϵͳ����־,Ȼ����ʾ��־
	 * @throws IOException 
	 */
	private void readSysLog() throws IOException
	{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		ArrayList<String> cmdLine = new ArrayList<String>();
		cmdLine.add("logcat");
		cmdLine.add("-d");//�ռ�һ����־ֹͣ
		cmdLine.add("-s");//����  TAG:��־����  (*Ϊͨ���)
		cmdLine.add("*:W");
		Process process= Runtime.getRuntime().exec(cmdLine.toArray(new String[cmdLine.size()]));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while((str = br.readLine())!=null)
		{
			sb.append(str);
			sb.append("\n");
		}
		Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
	}
}