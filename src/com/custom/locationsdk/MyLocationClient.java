package com.custom.locationsdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.content.Context;


/** 
 * All Rights Reserved.
 * Create at：2015-4-20 下午3:38:21 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyLocationClient.java 
 */
public class MyLocationClient {

	private Class<?> locationClinetClass;
	private Object objLocationClient;
	
	
	
	public Class<?> getLocationClinetClass() {
		return locationClinetClass;
	}


	public Object getObjLocationClient() {
		return objLocationClient;
	}


	public MyLocationClient(Context context){
		try {
			locationClinetClass = Class.forName("com.baidu.location.LocationClient");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	Constructor cons = null;
    	try {
			 cons = locationClinetClass.getDeclaredConstructor(new Class[]{Context.class});
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
    		objLocationClient = cons.newInstance(context);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}
	
	public void stop() {
		Method stopMethod = null;
		try {
			stopMethod = locationClinetClass.getMethod("stop", null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stopMethod.invoke(objLocationClient, null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		Method startMethod = null;
		try {
			startMethod = locationClinetClass.getMethod("start", null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			startMethod.invoke(objLocationClient, null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setLocOption(MyLocationClientOption myLocationClientOption) {
		Method locMethod = null;
    	try {
			locMethod = locationClinetClass.getMethod("setLocOption", myLocationClientOption.getLocationClientOptionClass());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			locMethod.invoke(objLocationClient, myLocationClientOption.getObjLocationClientOption());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void registerLocationListener(MyLocationListener myLocationListener) {
		Method registerMethod = null;
    	try {
		    registerMethod = locationClinetClass.getMethod("registerLocationListener", myLocationListener.getLocationListionClass());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
    	try {
		    registerMethod.invoke(objLocationClient, myLocationListener.getObjlocationListion());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}

