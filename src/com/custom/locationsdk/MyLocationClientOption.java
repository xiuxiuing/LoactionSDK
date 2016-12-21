package com.custom.locationsdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 * All Rights Reserved.
 * Create at：2015-4-20 下午2:35:29 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyLocationClientOption.java 
 */
public class MyLocationClientOption {

	private Object objLocationClientOption;
	private Class<?> locationClientOptionClass;
	
	public Object getObjLocationClientOption() {
		return objLocationClientOption;
	}

	public Class<?> getLocationClientOptionClass() {
		return locationClientOptionClass;
	}

	public MyLocationClientOption() {
		try {
			locationClientOptionClass = Class.forName("com.baidu.location.LocationClientOption");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
    	try {
			objLocationClientOption = locationClientOptionClass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}
	
	public MyLocationClientOption(String className) {
		try {
			locationClientOptionClass = Class.forName(className);
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
    	try {
			objLocationClientOption = locationClientOptionClass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setIsNeedAddress(boolean b){
		
		Method isNeedAddressMethod = null;
		try {
			isNeedAddressMethod = locationClientOptionClass.getMethod("setIsNeedAddress", boolean.class);
		} catch (NoSuchMethodException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			isNeedAddressMethod.invoke(objLocationClientOption, b);
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public void setScanSpan(int scan){
		Method scanSpanMethod = null;
    	try {
    		scanSpanMethod = locationClientOptionClass.getMethod("setScanSpan", int.class);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
    		scanSpanMethod.invoke(objLocationClientOption, scan);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setCoorType(String s) {
		Method coorTypeMethod = null;
    	try {
			coorTypeMethod = locationClientOptionClass.getMethod("setCoorType", String.class);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			coorTypeMethod.invoke(objLocationClientOption, s);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setProdName(String s) {
		Method prodNameMethod = null;
    	try {
    		prodNameMethod = locationClientOptionClass.getMethod("setProdName", String.class);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
    		prodNameMethod.invoke(objLocationClientOption, s);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setLocationMode(String modeString) {
		Method locationModeMethod = null;
		Method locModeValueMethod = null;
		Class<?> locationModeClass = null;
		try {
			locationModeClass = Class.forName("com.baidu.location.LocationClientOption$LocationMode");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			locModeValueMethod = locationModeClass.getMethod("valueOf", String.class);
		} catch (NoSuchMethodException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			locationModeMethod = locationClientOptionClass.getMethod("setLocationMode", locationModeClass);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			locationModeMethod.invoke(objLocationClientOption, locModeValueMethod.invoke(locationModeClass, modeString));
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

