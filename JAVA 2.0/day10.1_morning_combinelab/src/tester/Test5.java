package tester;

import static utils.StudentCollectionUtils.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get populated map of student
		// accept sub name from client

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> studentMap = populateMap(populateList());

			studentMap.forEach((k, v) -> System.out.println(v));
			
			System.out.println("display student details from specified sub");
			System.out.println("Enter the name of subject : ");
			Subject choosenSub = Subject.valueOf(sc.next().toUpperCase());
			// display student details from specified sub
//			studentMap.values() //collection of student // map to collection
//			.stream() //stream of student : all /streaming data
//			.filter(s-> s.getSubject() == choosenSub) //stream of filter student // Stream<Student> //itremidate op
//			.forEach(i -> System.out.println(i));// treminal op
			
			//display passed student gpa > 5 and display student details from specified sub
			// && bhi chalega but multiple ops
			studentMap.values().stream()
			.filter(s->s.getSubject() == choosenSub)
			.filter(s->s.getGpa() > 6)
			.forEach(s->System.out.println(s));
			
			
		}

	}

}
