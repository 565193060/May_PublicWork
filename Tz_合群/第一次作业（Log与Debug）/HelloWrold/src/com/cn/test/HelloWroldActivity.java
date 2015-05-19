package com.cn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.cn.test.utils.MyLog;

public class HelloWroldActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		Button log = (Button) findViewById(R.id.bt);
		Button bt=(Button) findViewById(R.id.bt2);
		MyLog.isDebug = true;
		log.setOnClickListener(this);
		bt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+10086));
			startActivity(intent);
			}
		});

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Toast.makeText(this, "������־��Ϣ", 2000).show();
		try {
			readLog();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// ����־
	private void readLog() throws IOException {
		// TODO Auto-generated method stub
		MyLog.i("WARN", "start connectLog");
		StringBuffer sb = new StringBuffer();
		// cmd����
		ArrayList<String> cmdLine = new ArrayList<String>();
		cmdLine.add("logcat");
		cmdLine.add("-d");	//�ռ�һ����־ֹͣ
		cmdLine.add("-s");//����  TAG:��־����  (*Ϊͨ���)
		cmdLine.add("*:W");
		cmdLine.add("WARN");
		Process exec = Runtime.getRuntime().exec(
				cmdLine.toArray(new String[cmdLine.size()]));
		InputStream is = exec.getInputStream();
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append("\n");

		}
		Toast.makeText(this, sb.toString(), 3000).show();
	}

}