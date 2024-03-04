package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AllInOne {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
	
	boolean status = true;
	while(status) {
		System.out.println("Enter operation to perform");
		System.out.println("1) Create new file \n2)Delete File \n3)Enter Information in File.\n4)Exit");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			createFile();
			break;
		case 2:
			deleteFile();
			break;
		case 3:
			addInfo();
			break;
		case 4:
			System.out.println("Thank You For Performing File handling Operations...");
			status = false;
			break;
		}
	}//end while
	}
	public static void createFile() {
		System.out.println("Enter Name of File: ");
		String name = scanner.next();
		File file = new File(name);
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
	public static void deleteFile() {
		System.out.println("Enter Name of File to delete");
		String name = scanner.next();
		File file = new File(name);
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
	public static void addInfo() throws IOException {
		System.out.println("Enter name of file to edit data");
		String name = scanner.next();
		File file = new File(name);
		if (file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
//			System.out.println("Enter Information to store: ");
//			String info = scanner.nextLine();
//			scanner.nextLine();
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

