package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public interface IOUtils {
//add a static method for storing student details
	static void writeDetails(Map<String, Student> students, String fileName) throws IOException {
		// Java App --> PW --> FW -- dest text file
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			students.values().forEach(s -> pw.println(s));
		} // JVM : pw.close --pw.flush(data will sent to FW) --fw.close
	}

	static void showStudents(String fName) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
			br.lines().forEach(s -> System.out.println(s));
		}
	}
}
