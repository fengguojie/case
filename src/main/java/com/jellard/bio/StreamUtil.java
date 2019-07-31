package com.jellard.bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
	
	public static void main(String[] args) throws Exception {
		fileInput();
		fileCopy();
	}

}
