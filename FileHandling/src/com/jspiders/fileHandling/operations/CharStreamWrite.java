package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	public static void main(String[] args) throws IOException {
		File file = new File("demo.txt");
		if (file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Hello How are You");
			System.out.println("File Written Successfully");
			fileWriter.close();
		} else {
			boolean status = file.createNewFile();
			if(status) {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Hello How are You");
				System.out.println("File Created and  Written Successfully");
				fileWriter.close();
			}else {
				System.out.println("Unable to create file");
			}

		}
	}
}
