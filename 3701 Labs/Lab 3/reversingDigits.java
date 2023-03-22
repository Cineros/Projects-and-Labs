import java.util.Scanner;
public class reversingDigits{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)){
            System.out.printf("Enter a number: %n");
            String numbers = input.nextLine();
            System.out.printf("Inverting %s...%n", numbers);
            String invert = "";
            for(int i = 0; i < numbers.length(); i++){
                invert += numbers.charAt(numbers.length() - i - 1);
            }
            System.out.printf("%s", invert);
        }
    }
}