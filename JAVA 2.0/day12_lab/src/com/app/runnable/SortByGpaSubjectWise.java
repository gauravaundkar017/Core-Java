package com.app.runnable;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import com.app.core.Student;
import com.app.core.Subject;

public class SortByGpaSubjectWise implements Runnable {
	private Map<String, Student> studentList;
	private String fName;
	private String subject;

	public SortByGpaSubjectWise(Map<String, Student> studentList, String fName, String subject) {
		this.studentList = studentList;
		this.fName = fName;
		this.subject = subject;
	}

	@Override
	public void run() {
		Comparator<Student> comp = (s1, s2) -> ((Double) s2.getGpa()).compareTo(s1.getGpa());
		Subject sub = Subject.valueOf(subject.toUpperCase());
		Stream<Student> sortedList = studentList.values().stream().filter(s -> sub == s.getSubject()).sorted(comp);
		try (PrintWriter pw = new PrintWriter(new FileWriter(fName))) {
			sortedList.forEach(s -> pw.println(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
