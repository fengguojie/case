package com.jellard.bio;

import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;


public class FileUtil {
	public static final String basePath = System.getProperty("user.dir");
	
	public static void showAllSystemProperties() {
		Properties properties = System.getProperties();
		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			System.out.println("system默认的属性："+key+"="+value);
		}
	}
	
	public static String realPath(String fileName) {
		return realPath(basePath, fileName);
	}
	
	public static String realPath(String dir,String fileName) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(dir).append(File.separator).append(fileName);
		return buffer.toString();
	} 
	
	
	public static void main(String[] args) {
		//showAllSystemProperties();
		File file = new File(realPath(".gitignore"));
		if (!file.exists()) {
			System.out.println("file不存在");
			return;
		}
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		
	}

}
