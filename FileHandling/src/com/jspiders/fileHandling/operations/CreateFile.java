package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		try {
			boolean status=file.createNewFile();
			if(status) {
				System.out.println("File Created Successfully");
			}else {
				System.out.println("File Alredy Exist");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
