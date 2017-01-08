package com.tz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
	
	private static Properties prop;
	
	static{
		try {
			prop=new Properties();
			InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getBean(String beanname){
		Object obj=null;
		try {
			Class<?> c = Class.forName(prop.getProperty(beanname));
			obj=c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
		
	
	}
	
}
