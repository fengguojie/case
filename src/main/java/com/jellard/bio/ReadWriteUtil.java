package com.jellard.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.sun.xml.internal.ws.Closeable;

public class ReadWriteUtil {
	
	public static void fileInput() throws Exception {
		FileReader fr = new FileReader(new File(FileUtil.realPath(".gitignore")));
		char[] buffer = new char[1024];
		int len;
		StringBuffer sBuffer = new StringBuffer();
		for(;;) {
			len = fr.read(buffer);
			if (len == -1) {
				break;
			}
			sBuffer.append(new String(buffer));
		}
		fr.close();
		System.out.println(sBuffer.toString());
	}
	
	public static void fileCopy() throws Exception {
		File file = new File(FileUtil.realPath("test.txt"));
		FileReader fr = new FileReader(file);
		File filecopy = new File(file.getAbsolutePath()+".copy2");
		if (!filecopy.exists()) {
			filecopy.createNewFile();
		}
		FileWriter fw = new FileWriter(filecopy);
		char[] buffer = new char[5];
		int len;
		for(;;) {
			len = fr.read(buffer);
			if (len == -1) {
				break;
			}
			fw.write(buffer);
		}
		fr.close();
		fw.close();
		System.out.println("copy finashed");
	}
	public static void fileCopyAdvance() throws Exception {
		File file = new File(FileUtil.realPath("test.txt"));
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		File filecopy = new File(file.getAbsolutePath()+".copy3");
		if (!filecopy.exists()) {
			filecopy.createNewFile();
		}
		FileWriter fw = new FileWriter(filecopy);
		BufferedWriter bw = new BufferedWriter(fw);
		String buf;
		for(;;) {
			buf = br.readLine();
			if (buf == null) {
				break;
			}
			bw.write(buf);
			bw.newLine();
		}
		br.close();
		fr.close();
		bw.close();
		fw.close();
		System.out.println("copy finashed");
	}
	
	public static void main(String[] args) throws Exception {
		fileInput();
		fileCopy();
		fileCopyAdvance();
	}

}
