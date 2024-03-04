package com.jspiders.serializationAndDeserialization.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationAndDeserialization.object.User;

public class Serialization {
	public static void main(String[] args) throws IOException {
		File file = new File("D:/File/demo.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream  objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new User(1,"Ram","ram@gmail.com",935914047));
		System.out.println("Object has been serialized");
		objectOutputStream.close();
		fileOutputStream.close();
		
	}
}
