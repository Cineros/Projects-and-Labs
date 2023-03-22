import java.util.Scanner;
import java.io.IOException;
public class ARS {
    static boolean capacity[] = {false, false, false, false, false, false, false, false, false, false};
    static int pCount = 0;
    public static void printPass(int a){
        for(int row = 0; row < 20; row++){
            if(row == 0){
                for(int i = 0; i < 40; i++){
                    System.out.printf("=");
                }
                System.out.printf("%n");
            }else if(row != 19){
                System.out.printf("|");
                if(row != 9){
                    for(int n = 0; n < 40; n++){
                        if(n != 39){
                            System.out.printf(" ");
                        }else{
                            System.out.printf("|");
                        }
                        
                    }
                    System.out.printf("%n");
                }else{
                    System.out.printf("%n");
                    System.out.printf("|             Seat Number: %d            |%n", a);
                }
            }else{
                for(int i = 0; i < 40; i++){
                    System.out.printf("=");
                }
                System.out.printf("%n");
            }
        }
    }
    public static void findSeat(int answer, Scanner input){
        input = new Scanner(System.in);
        String swap = "";
        if(answer == 1){
            for(int i = 0; i < 5; i++){
                System.out.println("Finding your seat...");
                if(capacity[i] != true && answer == 1){
                    System.out.printf("Your Seat has been found! You will be placed in position %d on the next flight...%n", i+1);
                    printPass(i+1);
                    capacity[i] = true;
                    i = 5;
                    answer = 0;
                    pCount++;
                }else if(i == 4 && capacity[i] == true && answer == 1){
                    System.out.println("We're sorry but we are sold out of first class on this flight...");
                    System.out.println("Would you like to fly economy instead? y/n");
                    swap = input.nextLine();
                    if(swap.equalsIgnoreCase("y")){
                        answer = 2;
                        findSeat(answer, input);
                    }else{
                        System.out.println("Next flight leaves in three hours...");
                        answer = 0;
                    }
                }
            }
        }else if (answer == 2){
            for(int i = 0; i < 5; i++){
                System.out.println("Finding your seat...");
                if(capacity[i+5] != true && answer == 2){
                    System.out.printf("Your Seat has been found! You will be placed in position %d on the next flight...%n", i+6);
                    printPass(i+6);
                    capacity[i+5] = true;
                    i = 5;
                    answer = 0;
                    pCount++;
                }else if(i == 4 && capacity[i+5] == true && answer == 1){
                    System.out.println("We're sorry but we are sold out of economy on this flight...");
                    System.out.println("Would you like to fly first class instead?");
                    swap = input.nextLine();
                    if(swap.equalsIgnoreCase("y")){
                        answer = 1;
                        findSeat(answer, input);
                    }else{
                        System.out.println("Next flight leaves in three hours...");
                        answer = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(pCount < 10){
            System.out.println("Please type 1 for First Class and Please type 2 for Economy.");
            int a = input.nextInt();
            while(a > 2 || a < 1){
                System.out.printf("Sorry, please enter a vaild input of 1 or 2.%n");
                a = input.nextInt();
            }
            if(a == 1){
                System.out.println("You have chosen first class please wait while we find you a seat...");
                findSeat(1, input);
            }else if(a == 2){
                System.out.println("You have chosen economy please wait while we find you a seat...");
                findSeat(2, input);
            }
        }
        input.close();
    }
}
