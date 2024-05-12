package io_utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import com.app.core.Student;

public interface IOFileHandling {

	static void storeData(Stream<Student> strm, String fileName) throws IOException{
//		use here functional progemaing chaining io
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			strm.forEach(s -> pw.println(s));
			System.out.println("Data stored successfully!");
		} 
	}
}
