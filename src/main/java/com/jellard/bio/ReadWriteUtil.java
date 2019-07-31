package com.jellard.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
		System.out.println("copy advanced finashed");
	}
	
	public static String systemInput() throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("please input your name: ");
		String input = br.readLine();
		System.out.println("your name is "+input);
		br.close();
		ir.close();
		return input;
	}
	
	public static void systemOutput() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(systemInput());
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
//		fileInput();
//		fileCopy();
//		fileCopyAdvance();
//		systemInput();
		systemOutput();
	}

}
