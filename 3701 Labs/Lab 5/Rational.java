import java.util.Scanner;


class Fraction{
    public int num;
    public int den;

    // Removed to use default constructors.
    // public Fraction(int num, int den){
    //     this.num = num;
    //     this.den = den;
    // }

    // Sets Numerator
    public void setNum(int num){
        this.num = num;
    }

    // Set Denominator.
    public void setDen(int den){
        this.den = den;
    }

    // Getters.
    public int getNum(){return num;}
    public int getDen(){return den;}

    
}

public class Rational{
    public static int gcd(int a, int b){
        int r = 0;

        //Swap signs if negative.
        a = (a < 0) ? -a : a;
		b = (b < 0) ? -b : b;

        //Reduce till gcd is found.
        while (b != 0){
			r = a % b;
			a = b;
			b = r;
		}

        //Return gcd.
        return a;
    }
    public static void printFrac(Fraction A){
        //Get fraction vars and prints to console.
        int tempNum = A.getNum();
        int tempDen = A.getDen();
        System.out.println(tempNum + " / " + tempDen);
    }

    public static Fraction makeFrac(Scanner input, int f){
        //This function handles the creation of new fractions with user input.
        Fraction temp = new Fraction();

        // User input.
        System.out.printf("Please enter the numerator of the fraction #%d.%n", f);
        int tempNum = input.nextInt();
        System.out.printf("Please enter the denominator of fraction #%d.%n", f);
        int tempDen = input.nextInt();

        // Reduces fraction.
        temp.num = tempNum/gcd(tempNum, tempDen);
        temp.den = tempDen/gcd(tempNum, tempDen);

        // Returns fraction.
        return(temp);

    }

    public static Fraction addFrac(Fraction a, Fraction b){
        //Create temp vars to hold information.
        Fraction temp = new Fraction();
        int oldDen = a.getDen();
        int newNum = 0;
        int newDen = 1;

        //Math operations
        a.num *= b.getDen();
        a.den *= b.getDen();
        b.num *= oldDen;
        b.den *= oldDen;
        newNum = a.getNum() + b.getNum();
        newDen = a.getDen();
        temp.num = newNum/gcd(newNum,newDen);
        temp.den = newDen/gcd(newNum,newDen);


        // Reset old fractions.
        a.num = a.num/b.getDen();
        a.den = a.den/b.getDen();
        b.num = b.num/oldDen;
        b.den = b.den/oldDen;

        //return new fraction
        return(temp);
    }

    public static Fraction subFrac(Fraction a, Fraction b){
        //Create temp vars to hold information.
        Fraction temp = new Fraction();
        int oldDen = a.getDen();
        int newNum = 0;
        int newDen = 1;

        //Math operations.
        a.num *= b.getDen();
        a.den *= b.getDen();
        b.num *= oldDen;
        b.den *= oldDen;
        newNum = a.getNum() - b.getNum();
        newDen = a.getDen();
        temp.num = newNum/gcd(newNum,newDen);
        temp.den = newDen/gcd(newNum,newDen);

        // Reset old fractions.
        a.num = a.num/b.getDen();
        a.den = a.den/b.getDen();
        b.num = b.num/oldDen;
        b.den = b.den/oldDen;

        //return new fraction
        return(temp);
    }

    public static Fraction multiFrac(Fraction a, Fraction b){
        // Multiplies two fractions.
        Fraction temp = new Fraction();
        temp.num = a.num * b.num;
        temp.den = a.den * b.den;
        return(temp);
    }

    public static Fraction divFrac(Fraction a, Fraction b){
        //Divides two fractions.
        Fraction temp = new Fraction();
        temp.num = a.num * b.den;
        temp.den = a.den * b.num;
        return(temp);
    }
    public static void printFloat(Fraction a){
        float tempNum = a.num;
        float tempDen = a.den;

        //Prints Float values.
        float temp = tempNum / tempDen;
     
        System.out.println("Here is your fraction in floating point: " + temp);
    }


    public static void main(String[] args) {
        Fraction[] fractions = new Fraction[10];
        Fraction newFrac = new Fraction();
        Scanner input = new Scanner(System.in);


        System.out.println("How many fractions would you like to make? 2-10");
        int ans = input.nextInt();

        for(int i = 0; i < ans; i++){
            fractions[i] = makeFrac(input, i+1);
        }

        for(int i = 0; i < ans; i++){
            printFrac(fractions[i]);
        }

        System.out.println("What would you like to do with your fractions?");
        System.out.printf(" 1. Addition %n 2. Subtraction%n 3. Multiplication%n 4. Division%n");
        int op = input.nextInt();

        switch(op){
            case 1:
                System.out.println("Which fractions would you like to add?");
                ans = input.nextInt();
                System.out.println("and?");
                op = input.nextInt();
                newFrac = addFrac(fractions[ans-1], fractions[op-1]);
                printFrac(newFrac);
                printFloat(newFrac);
                break;
            case 2:
                System.out.println("Which fractions would you like to subtract?");
                ans = input.nextInt();
                System.out.println("and?");
                op = input.nextInt();
                newFrac = subFrac(fractions[ans-1], fractions[op-1]);
                printFrac(newFrac);
                printFloat(newFrac);
                break;
            case 3:
                System.out.println("Which fractions would you like to multiply?");
                ans = input.nextInt();
                System.out.println("and?");
                op = input.nextInt();
                newFrac = multiFrac(fractions[ans-1], fractions[op-1]);
                printFrac(newFrac);
                printFloat(newFrac);
                break;
            case 4:
                System.out.println("Which fractions would you like to divide?");
                ans = input.nextInt();
                System.out.println("and?");
                op = input.nextInt();
                newFrac = divFrac(fractions[ans-1], fractions[op-1]);
                printFrac(newFrac);
                printFloat(newFrac);
                break;
        }
        
        
    }
}