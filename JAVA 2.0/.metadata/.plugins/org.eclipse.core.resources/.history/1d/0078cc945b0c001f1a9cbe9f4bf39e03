package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.core.Student;

import io_utils.IOFileHandling;
public class TestIO implements IOFileHandling{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			  Map<String, Student> studentList = populateMap(populateList());
			  Comparator<Student> comp = (s1,s2) -> s1.getName().compareTo(s2.getName());
			   Stream<Student> sortedStream = studentList.values()
			  .stream()
			  .sorted(comp);
			  System.out.println("Enter the file name : ");
			  IOFileHandling.storeData(sortedStream, sc.nextLine());
			
		}

	}

}
