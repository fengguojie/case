package com.jellard.collect;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.plaf.synth.SynthStyle;

public class JellardClassloader extends ClassLoader{
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
        byte[] classData = getData();
        if (classData != null) {
            clazz = defineClass(name, classData, 0, classData.length);
        }
        return clazz;
    }
	
	private byte[] getData() {
		String classPath = "D:\\java\\gitrepo\\case\\target\\classes\\com\\jellard\\collect\\LinkedHashMapTest.class";
        File file = new File(classPath);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
 
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
 
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }
    }

	public static void main(String[] args) throws Exception {
		JellardClassloader jellard = new JellardClassloader();
		Class<?> clazz = jellard.loadClass("com.jellard.collect.LinkedHashMapTest");
		System.out.println(clazz.getClassLoader());
		
		System.out.println(new LinkedHashMapTest().getClass().getClassLoader());
		
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("main", String[].class);
		String[] params = {"123"};
		method.invoke(instance, (Object)params);
	}

}
