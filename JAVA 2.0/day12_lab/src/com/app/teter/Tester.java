package com.app.teter;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.runnable.SortByDob;
import com.app.runnable.SortByGpaSubjectWise;

public class Tester {

	public static void main(String[] args) throws InterruptedException {

		
		
		try (Scanner sc = new Scanner(System.in)) {
			// get populated data
//			List<Student> list = populateList();
			Map<String, Student> studentList = populateMap(populateList());
			ArrayList<Thread> thrds = new ArrayList<>();
			// creating thrds
			System.out.println("Enter 3 file names for storing gpa sub dob subject based data");

			thrds.add(new Thread(new SortByGpaSubjectWise(studentList,sc.next(),sc.next()), "t1"));
			thrds.add(new Thread(new SortByDob(studentList,sc.next()), "t2"));
//			thrds.add(new Thread(new SubjectSorter(sc.next(), list), "t3"));//runnable thrds : 1
			// starting thrds
			for (Thread t : thrds)
				t.start(); //runnable : 4
			System.out.println("Main waiting for child thrds to finish exec");
			for (Thread t : thrds)
				t.join();
			System.out.println("main over.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		try(Scanner sc = new Scanner(System.in)){
//			System.out.print("Enter File Name (SortByDob) : ");
//			SortByDob sortByDob  = new SortByDob(studentList, sc.next());
//			
//			
//			Thread t1 = new Thread(sortByDob);
//			t1.start();
//			t1.join();
//			System.out.println("=============================================================");
//			System.out.print("SortByGpaSubjectWise ");
//			System.out.print("Enter File Name : ");
//			String fName = sc.next();
//			System.out.print("Enter Subject Name : ");
//			String sub = sc.next();
//			SortByGpaSubjectWise sortByGpaSubjectWise = new SortByGpaSubjectWise(studentList, fName, sub);
//			Thread t3 = new Thread(sortByGpaSubjectWise);
//			t3.start();
//			t3.join();
//			System.out.println("Main Over");
//		}
	}

}
