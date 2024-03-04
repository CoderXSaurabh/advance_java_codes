package com.jspiders.JDBC.JDBCMain;

import java.util.Scanner;

import com.jspiders.JDBC.operations.JDBCServices;

public class JDBCMain1 {
	private static JDBCServices j = new JDBCServices();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println(" 1) To sign up \n 2) To Login \n 3)Exit \nEnter valid Choice : ");
			int choice= scanner.nextInt();
			switch(choice) {
			case 1:
				j.signUp();
				break;
			case 2:
				j.logIn();
				break;
			case 3:
				System.out.println("Thank You Visit Again");
				flag = false;
				break;
			default:
				break;
			}	
		}
		
	}
}
