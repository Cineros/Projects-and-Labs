public class QuadrilateralTest {
    public static void main(String args[])
    {
        Quadrilateral quadrilateral = new Quadrilateral(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 10.0, 6.0);
        Trapezoid trapezoid = new Trapezoid(0.0, 1.0, 8.0, 2.0, 3.0, 4.0, 6.0, 6.0);
        Parallelogram parallelogram = new Parallelogram(2.0, 7.0, 2.0, 7.0, 4.0, 25.0, 64.0, 22.0 );
        Rectangle rectangle = new Rectangle(2.0, 4.0, 10.0, 0.0, 0.0, 7.0, 0.0, 52.0);
        Square square = new Square(0.0, 0.0, 2.0, 0.0, 0.0, 2.0, 2.0, 2.0);

        System.out.printf("%s %s %s %s %s\n", quadrilateral, trapezoid, parallelogram, rectangle, square);
    }
}