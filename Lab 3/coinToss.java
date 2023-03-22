import java.util.Scanner;
import java.util.Random;

public class coinToss{
    public static boolean flipCoin(){
        Random rand = new Random();
        int face = rand.nextInt(1000001);
        face = face % 2;
        if(face == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int numH = 0;
        int numT = 0;
        try (Scanner input = new Scanner(System.in)) {
            while(true){
                System.out.printf("Would you like to flip the coin?%n");
                String answer = input.nextLine();
                //String answer = "Toss Coin";
                if(answer.equalsIgnoreCase("Toss Coin")){
                    if(flipCoin()){
                        System.out.println("It's Heads.");
                        numH++;
                    }else{
                        System.out.println("It's Tails.");
                        numT++;
                    }
                    System.out.printf("You have flipped heads: %d times and Tails: %d times.%n", numH, numT);
                }else{
                    System.out.println("Exiting...");
                    break;
                }
            }
            
        }

    }
}