import java.util.Scanner;


class Fraction{
    private int num;
    private int den;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setDen(int den){
        this.den = den;
    }

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
        int tempNum = A.getNum();
        int tempDen = A.getDen();
        int gcd = gcd(tempNum, tempDen);
        tempNum = tempNum/gcd;
        tempDen = tempDen/gcd;
        System.out.println(tempNum + " / " + tempDen);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the numerator of the first fraction.%n");
        int tempNum = input.nextInt();
        System.out.printf("Please enter the denominator of the first fraction.%n");
        int tempDen = input.nextInt();
        Fraction A = new Fraction(tempNum, tempDen);
        printFrac(A);

        
    }




}