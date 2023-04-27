import java.util.ArrayList;
import java.util.List;

public class Grades{
	public static void main(String [] args){
		List <List<Integer>> grades = List.of(
				   List.of(87, 96, 70),
                   List.of(68, 87, 90),
                   List.of(94, 100, 90),
                   List.of(100, 81, 82),
                   List.of(83, 65, 85),
                   List.of(78, 87, 65),
                   List.of(85, 75, 83),
                   List.of(91, 94, 100),
                   List.of(76, 72, 84),
                   List.of(87, 93, 73));
		grades.stream()
			  .forEach(row -> {
				  System.out.printf("The average of %s is %.2f%n", row, row.stream()
																		   .mapToInt(x -> x)
								   										   .average()
								   										   .orElse(0));
			  });
	}
}