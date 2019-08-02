package com.jellard.bio;

import java.io.File;
import java.io.RandomAccessFile;
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
	
	
	public static void main(String[] args) throws Exception {
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
		System.out.println("--------------------");
		RandomAccessFile raf = new RandomAccessFile(new File(realPath("test.txt")), "rw");
		System.out.println("current position: "+raf.getFilePointer());
		raf.seek(raf.length());//一个中文 5个字节
		System.out.println("after seek current position: "+raf.getFilePointer());
		raf.write("\nhello random access file".getBytes());
		System.out.println("after write current position: "+raf.getFilePointer());
		raf.seek(0);
		StringBuffer sBuffer = new StringBuffer();
		byte[] buffer = new byte[1024];
		int hasRead;
		for(;;) {
			hasRead = raf.read(buffer);
			if (hasRead == -1) {
				break;
			}
			sBuffer.append(new String(buffer));
			System.out.println("after for one current position: "+raf.getFilePointer());
		}
		System.out.println("after for current position: "+raf.getFilePointer());
		System.out.println(sBuffer.toString());
		System.out.println("the program executed");
		
	}

}
