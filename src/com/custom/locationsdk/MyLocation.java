package com.custom.locationsdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 * All Rights Reserved.
 * Create at：2015-4-17 下午6:48:21 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyLocation.java 
 */
public class MyLocation {
	
	private String AddStr;//获取详细地址信息
	private double Altitude;//获得高度信息，目前没有实现
	private String city; //获取城市
	private float direction;//获取手机当前方向
	private String district;//获取区/县信息
	private String floor;//获取楼层信息,仅室内定位时有效
	private double latitude; // 获取纬度坐标
	private double longitude;//   获取经度坐标
    private String networkLocationType;//      在网络定位结果的情况下，获取网络定位结果是通过基站定位得到的还是通过wifi定位得到的
    private int  operators;//    获取运营商信息
    private String province;//    获取省份
    private float radius;//    获取定位精度
    private int satelliteNumber;//    gps定位结果时，获取gps锁定用的卫星数
    private float speed;//       获取速度，仅gps定位结果时有速度信息
    private boolean hasAddr;//    是否有地址信息
    private String time;//    server返回的当前定位时间
    private String streetNumber;//    获取街道号码
    private String street;//    获取街道信息
    private int locType;//    获取定位类型: 参考 定位结果描述 相关的字段
	public int getLocType() {
		return locType;
	}
	public void setLocType(int locType) {
		this.locType = locType;
	}
	public String getAddStr() {
		return AddStr;
	}
	public void setAddStr(String addStr) {
		AddStr = addStr;
	}
	public double getAltitude() {
		return Altitude;
	}
	public void setAltitude(double altitude) {
		Altitude = altitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getNetworkLocationType() {
		return networkLocationType;
	}
	public void setNetworkLocationType(String networkLocationType) {
		this.networkLocationType = networkLocationType;
	}
	public int getOperators() {
		return operators;
	}
	public void setOperators(int operators) {
		this.operators = operators;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public int getSatelliteNumber() {
		return satelliteNumber;
	}
	public void setSatelliteNumber(int satelliteNumber) {
		this.satelliteNumber = satelliteNumber;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public boolean isHasAddr() {
		return hasAddr;
	}
	public void setHasAddr(boolean hasAddr) {
		this.hasAddr = hasAddr;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "MyLocation [AddStr=" + AddStr + ", Altitude=" + Altitude + ", city=" + city + ", direction=" + direction + ", district=" + district
				+ ", floor=" + floor + ", latitude=" + latitude + ", longitude=" + longitude + ", networkLocationType=" + networkLocationType
				+ ", operators=" + operators + ", province=" + province + ", radius=" + radius + ", satelliteNumber=" + satelliteNumber + ", speed="
				+ speed + ", hasAddr=" + hasAddr + ", time=" + time + ", streetNumber=" + streetNumber + ", street=" + street + ", locType="
				+ locType + "]";
	}
	
	public MyLocation(Object[] args) {
		Class<?> locationClass = null;
		try {
			locationClass = Class.forName("com.baidu.location.BDLocation");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	Method longitudeMethod = null;
    	Method operatorsMethod = null;
    	Method provinceMethod = null;
    	Method radiusMethod = null;
    	Method satelliteNumberMethod = null;
    	Method speedMethod = null;
    	Method streetMethod = null;
    	Method streetNumberMethod = null;
    	Method hasAddrMethod = null;
    	Method timeMethod = null;
    	Method locTypeMethod = null;
    	Method AddrMethod = null;
    	Method cityMethod = null;
    	Method directionMethod = null;
    	Method districtMethod = null;
    	Method floorMethod = null;
    	Method latitudeMethod = null;
    	
    	try {
    		longitudeMethod = locationClass.getMethod("getLongitude");
    		operatorsMethod = locationClass.getMethod("getOperators");
    		provinceMethod = locationClass.getMethod("getProvince");
    		radiusMethod = locationClass.getMethod("getRadius");
    		satelliteNumberMethod = locationClass.getMethod("getSatelliteNumber");
    		speedMethod = locationClass.getMethod("getSpeed");
    		streetMethod = locationClass.getMethod("getStreet");
    		streetNumberMethod = locationClass.getMethod("getStreetNumber");
    		hasAddrMethod = locationClass.getMethod("hasAddr");
    		timeMethod = locationClass.getMethod("getTime");
    		locTypeMethod = locationClass.getMethod("getLocType");
    		AddrMethod = locationClass.getMethod("getAddrStr");
    		cityMethod = locationClass.getMethod("getCity");
    		directionMethod = locationClass.getMethod("getDirection");
    		districtMethod = locationClass.getMethod("getDistrict");
    		floorMethod = locationClass.getMethod("getFloor");
    		latitudeMethod = locationClass.getMethod("getLatitude");
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		}
    	
    	try {
			longitude = (Double)longitudeMethod.invoke(args[0]);
			operators = (Integer)operatorsMethod.invoke(args[0]);
			province = (String)provinceMethod.invoke(args[0]);
			radius = (Float)radiusMethod.invoke(args[0]);
			satelliteNumber = (Integer)satelliteNumberMethod.invoke(args[0]);
			speed = (Float)speedMethod.invoke(args[0]);
			street = (String)streetMethod.invoke(args[0]);
			streetNumber = (String)streetNumberMethod.invoke(args[0]);
			hasAddr = (Boolean)hasAddrMethod.invoke(args[0]);
			time = (String)timeMethod.invoke(args[0]);
			locType = (Integer)locTypeMethod.invoke(args[0]);
			AddStr = (String)AddrMethod.invoke(args[0]);
			city = (String)cityMethod.invoke(args[0]);
			direction = (Float)directionMethod.invoke(args[0]);
			district = (String)districtMethod.invoke(args[0]);
			floor = (String)floorMethod.invoke(args[0]);
			latitude = (Double)latitudeMethod.invoke(args[0]);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}
    	
}

