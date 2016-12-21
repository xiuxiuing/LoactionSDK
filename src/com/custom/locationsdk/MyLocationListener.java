package com.custom.locationsdk;

/** 
 * All Rights Reserved.
 * Create at：2015-4-16 下午6:00:48 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyLocationListener.java 
 */
public class MyLocationListener{

	private Class<?> locationListionClass;
	private Object objlocationListion;
	
	private MyInvocationHandler invocationHandler;
	
	
	public Object getObjlocationListion() {
		return objlocationListion;
	}

	public Class<?> getLocationListionClass() {
		return locationListionClass;
	}

	public MyLocationListener(){
		try {
			locationListionClass = Class.forName("com.baidu.location.BDLocationListener");
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		invocationHandler = new MyInvocationHandler();
		objlocationListion = invocationHandler.bind(locationListionClass);
	}
}

