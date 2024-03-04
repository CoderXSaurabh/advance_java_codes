package com.jspiders.fileHandling.operations;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		if(file.exists()) {
			boolean status = file.delete();
			if(status) {
				System.out.println("File Deleted Successfully");
			}
			else {
				System.out.println("Unable to delete File");
			}
		}else {
			System.out.println("File not Present at Given Directory");
		}
	}
}
