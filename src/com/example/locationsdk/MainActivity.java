package com.example.locationsdk;

import java.util.Date;
import com.custom.locationsdk.MyLocation;
import com.custom.locationsdk.MyLocationClient;
import com.custom.locationsdk.MyLocationClientOption;
import com.custom.locationsdk.MyLocationListener;
import com.example.loactionsdk.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/** 
 * All Rights Reserved.
 * Create at：2015-4-13 下午5:01:05 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MainActivity.java 
 * 
 * 定位SDK必须注册GPS和网络的使用权限。
     使用定位SDK请保证网络连接通畅（GPS定位方式不需要连网）。
     我们强烈建议您设置自己的prodName，并保管好，这样方便我们为您提供更好的定位服务。
     若需要返回的定位结果里包含地址信息，请保证网络连接。
     定位SDK可以返回bd09、bd09ll、gcj02三种类型坐标，若需要将定位点的位置通过百度Android地图 SDK进行地图展示，请返回bd09ll，将无偏差的叠加在百度地图上。
     有的移动设备锁屏后为了省电会自动关闭网络连接，此时网络定位模式的定位失效。此外，锁屏后移动设备若进入cpu休眠，定时定位功能也失效。若您需要实现在cpu休眠状态仍需定时定位，可以用alarmManager 实现1个cpu可叫醒的timer，定时请求定位。
 * Hight_Accuracy  Battery_Saving  Device_Sensors
 * 
 */
public class MainActivity extends Activity{

	private MyLocationClient mLocationClient;
	private MyLocationClientOption mLocationClientOption;
	private MyLocationListener mMyLocationListener;
	private String tempcoor="gcj02";
	private String modeString = "Hight_Accuracy";
	private TextView infoTextView;
	public static Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		infoTextView = (TextView)findViewById(R.id.textView3);
		handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if (msg.what == 1) {
					MyLocation myLocation = (MyLocation)msg.obj;
					System.out.println("HandlerLocationInfo:　" + myLocation.toString());
					infoTextView.setText(myLocation.toString());
					mLocationClient.stop();
				}
			}
			
		};
		
		mLocationClientOption = new MyLocationClientOption("com.baidu.location.LocationClientOption");
		mLocationClientOption.setLocationMode(modeString);
		mLocationClientOption.setCoorType(tempcoor);
		mLocationClientOption.setScanSpan(1000 * 1);
		mLocationClientOption.setIsNeedAddress(true);
		
		mMyLocationListener = new MyLocationListener();
		mLocationClient = new MyLocationClient(MainActivity.this);
    	mLocationClient.registerLocationListener(mMyLocationListener);
		mLocationClient.setLocOption(mLocationClientOption);
		
	    findViewById(R.id.textView1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("start " +  new Date());
				mLocationClient.start();
			}
		});
		
	}
	
	@Override
	protected void onStop() {
		mLocationClient.stop();
		super.onStop();
	}
	
}

