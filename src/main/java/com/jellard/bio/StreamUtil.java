package com.jellard.bio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.omg.CORBA.PRIVATE_MEMBER;

public class StreamUtil {
	
	public static void fileInput() throws Exception {
		FileInputStream fis = new FileInputStream(new File(FileUtil.realPath(".gitignore")));
		byte[] buffer = new byte[1024];
		int len;
		StringBuffer sBuffer = new StringBuffer();
		for(;;) {
			len = fis.read(buffer);
			if (len == -1) {
				break;
			}
			sBuffer.append(new String(buffer));
		}
		fis.close();
		System.out.println(sBuffer.toString());
	}
	
	public static void fileCopy() throws Exception {
		File file = new File(FileUtil.realPath("test.txt"));
		FileInputStream fis = new FileInputStream(file);
		File filecopy = new File(file.getAbsolutePath()+".copy");
		if (!filecopy.exists()) {
			filecopy.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(filecopy);
		byte[] buffer = new byte[5];
		int len;
		for(;;) {
			len = fis.read(buffer);
			if (len == -1) {
				break;
			}
			fos.write(buffer);
		}
		fis.close();
		fos.close();
		System.out.println("copy finashed");
	}
	public static void byteArrayInput() throws Exception {
		String str = "hello";
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
		byte[] buffer = new byte[1024];
		int len;
		StringBuffer sBuffer = new StringBuffer();
		for(;;) {
			len = bis.read(buffer);
			if (len == -1) {
				break;
			}
			sBuffer.append(new String(buffer,"UTF-8"));
		}
		bis.close();
		System.out.println(sBuffer.toString());
	}
	
	public static void ObjectStreamTest() throws Exception {
		Student student = new Student(2015);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(student);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Student student2 = (Student)ois.readObject();
		System.out.println(student2);
		ois.close();
		bis.close();
		oos.close();
		bos.close();
	}
	
	public static void main(String[] args) throws Exception {
//		fileInput();
//		fileCopy();
		byteArrayInput();
//		ObjectStreamTest();
	}

}

class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int sno;
	
	public Student() {}
	
	public Student(int sno) {
		this.sno = sno;
	}
	
	public int getSno() {
		return sno;
	}
	
	@Override
	public String toString() {
		return "student number: "+sno;
	}
	
}
