package com.custom.locationsdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import android.os.Message;
import com.example.locationsdk.MainActivity;

/** 
 * All Rights Reserved.
 * Create at：2015-4-15 下午3:52:04 
 * Project name：LoactionSDK 
 * @author wangguangshun 
 * @version 1.0  
 * File name：MyInvocationHandler.java 
 */
public class MyInvocationHandler implements InvocationHandler {

	public Object bind(Class<?> class1) {
    	Class[] interfaces = new Class[1];
    	interfaces[0] = class1;
    	
    	return Proxy.newProxyInstance(class1.getClassLoader(), interfaces, this);
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
    	// Object temp = null;
    	System.out.println("start-->>" + method.getName());
    	if (method.getName().equals("onReceiveLocation")) {
    		
        	MyLocation myLocation = new MyLocation(args);
        	
        	Message msg = new Message();
        	msg.what = 1;
        	msg.obj = myLocation;
        	MainActivity.handler.sendMessage(msg);
		}
        return args[0];
    }
}
