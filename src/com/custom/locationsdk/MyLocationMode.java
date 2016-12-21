package com.custom.locationsdk;

import java.lang.reflect.Field;
import com.baidu.location.LocationClientOption.LocationMode;

/** 
 * All Rights Reserved.
 * Create at：2015-4-15 上午10:44:35 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyLocationMode.java 
 */
public class MyLocationMode {

	Class<?> classMode;
	public MyLocationMode() {
		try {
			classMode =  Class.forName("com.baidu.location.LocationClientOption.LocationMode");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Object getHight_Accuracy() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field mem = classMode.getDeclaredField("Hight_Accuracy");
		mem.setAccessible(true);
		return mem.get(null);
	}
	public Object getBattery_Saving() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field mem = classMode.getDeclaredField("Battery_Saving");
		mem.setAccessible(true);
		return mem.get(null);
	}
	public Object getDevice_Sensors() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field mem = classMode.getDeclaredField("Device_Sensors");
		mem.setAccessible(true);
		return mem.get(null);
	}
}

