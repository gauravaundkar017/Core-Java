package com.app.runnable;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import com.app.core.Student;

public class SortByDob implements Runnable {
	private Map<String, Student> studentList;
	private String fName;
	
	public SortByDob(Map<String, Student> studentList,String fName) {
		this.studentList=studentList;
		this.fName=fName;
	}
	

	@Override
	public void run() {

		Comparator<Student> comp = (s1,s2)->s1.getDob().compareTo(s2.getDob());
		Stream<Student> sortedDob = studentList.values().stream().sorted(comp);
		try(PrintWriter pw = new PrintWriter(new FileWriter(fName))){
			sortedDob.forEach(s-> pw.println(s));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
