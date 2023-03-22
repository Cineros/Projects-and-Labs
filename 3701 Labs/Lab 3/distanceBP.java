import java.util.Scanner;
import java.lang.Math;
public class distanceBP {
    public static double DistanceCalc(double x1, double y1, double x2, double y2){
        double temp = 0;
        temp = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        temp = Math.sqrt(temp);
        return temp;
    }
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("Please enter x1.%n");
            double x1 = input.nextDouble();
            System.out.printf("Please enter y1%n");
            double y1 = input.nextDouble();
            System.out.printf("Please enter x2%n");
            double x2 = input.nextDouble();
            System.out.printf("Please enter y2%n");
            double y2 = input.nextDouble();
            System.out.printf("The distance between the points is %f", DistanceCalc(x1, y1, x2, y2));
        }
    }
}
