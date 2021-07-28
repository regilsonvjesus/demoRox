package com.example.demo.batch;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BaseConfiguration {
	
	public static final String localeFiles = "files/"; 
	
	public static final int CHUNK = 10;
	
	public String[] getAttributesMap(Class<?> clazz) {	
		 
		List<String> list = new ArrayList<String>();
		Method[] methods = clazz.getMethods();
 
		for(Method method : methods) {
			if(method.getName().startsWith("set") && method.getReturnType() == void.class)
				list.add(getAttributeName(method.getName()));
		}
		
		String[] array = new String[list.size()];
        array = list.toArray(array);
 
		return array;
	}
 
	private static String getAttributeName(String name) {
		return name.substring(3);
	}

}
