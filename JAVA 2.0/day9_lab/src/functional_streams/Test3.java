
package functional_streams;
import  com.app.core.Student;
import com.app.core.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static utils.StudentCollectionUtils.*;
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] data = { 1, 2, 3, 55, 45, -100, 10 };
//		Arrays.stream(data).filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
		
		Subject sub = Subject.JAVA;
		List<Student> list = populateList();
		list.stream().filter(s -> s.getSubject() == sub).forEach(s->System.out.println(s));
		

	}

}
