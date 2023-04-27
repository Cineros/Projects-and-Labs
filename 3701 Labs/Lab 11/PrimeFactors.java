import java.util.*;

public class PrimeFactors {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number or type -1 to quit");
        int input = scanner.nextInt();
        
        while(input != -1){
            HashSet<Integer> factorSet = new HashSet<Integer>();
            factorize(input, factorSet);

            if(factorSet.isEmpty()){
                System.out.println(input + " is a prime number");
            }else{
                System.out.println("Factors are " + factorSet);
            }
            System.out.println("Please enter a number or type -1 to quit");
            input = scanner.nextInt();
        }
    }

    public static Boolean factorize(int number, HashSet<Integer>set){
        if(number == 0 || number == 1){
            return false;
        }
        //loop through numbers that are less than or equal to number / 2
        for(int factor = 2; factor <= number/2; factor++){
            if(number % factor == 0){
                set.add(factor);
    
                if(!factorize(number/factor, set))
                    set.add(number/factor);
                    return true;
            }
        }
        return false;
    }
    
}