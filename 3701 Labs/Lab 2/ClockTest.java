import java.util.Scanner;
public class ClockTest {
    public static void displayTime(Clock a){
        System.out.printf("%d:%d:%d",a.getHour(), a.getMin(), a.getSec());

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the hour.%n");
        int tempHour = input.nextInt();
        System.out.printf("Please enter the minute.%n");
        int tempMin = input.nextInt();
        System.out.printf("Please enter the second.%n");
        int tempSec = input.nextInt();
        Clock A = new Clock(0, 0, 0);
        A.setClock(tempHour, tempMin, tempSec);
        displayTime(A);
    }
}
