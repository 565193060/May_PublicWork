package com.gauss.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.gauss.hello.utils.myLog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MianActivity extends Activity implements OnClickListener {
	Button conLog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        conLog=(Button) findViewById(R.id.conLog);
        
        myLog.isDebug=true;
        
        conLog.setOnClickListener(this);
    }
    
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			readLog("W");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author ��С��
	 * @throws IOException 
	 * @exception �ռ���־
	 */
	private void readLog(String type) throws IOException {
		// TODO Auto-generated method stub
		myLog.iLog("INFO", "Hey!Here is a loginfo!");
		myLog.eLog("ERROR", "this is a bug!"); //��ҵ2��1��
		StringBuffer sb=new StringBuffer();
		ArrayList<String> cmdLine=new ArrayList<String>();
		cmdLine.add("logcat");
		cmdLine.add("-d");
		//cmdLine.add("-s");
		cmdLine.add("*:" + type);
		Process exec = Runtime.getRuntime().exec(cmdLine.toArray(new String[cmdLine.size()]));
		//��ȡִ��������������
		InputStream inputStream=exec.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//ֱ�Ӷ��ַ���
		String str = null;
		while((str = bufferedReader.readLine())!=null){
			sb.append(str);
			sb.append("\n");
		}
		//��˾
		Toast.makeText(this, sb.toString(), 10000).show();
		
	}
}