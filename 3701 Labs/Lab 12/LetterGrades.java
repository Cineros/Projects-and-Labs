import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class LetterGrades{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		ArrayList <Integer> grades = new ArrayList<>();

		System.out.print("Enter grade or -1 to quit:");
		int entry = input.nextInt();

		while(entry != -1){
			grades.add(entry);
			
			System.out.print("Enter grade or -1 to quit:");
			entry = input.nextInt();
		}
		List<String> letterGrades = grades.stream()
										  .map(x->{
											  if(x >= 90){return "A";}
											  else if(x>= 80){return "B";}
											  else if(x>= 70){return "C";}
											  else if (x>= 60){return "D";}
											  else{return "F";}
										  })
										 .collect(Collectors.toList());
		System.out.printf("Letter grades are: %s%n", letterGrades);
	}
}