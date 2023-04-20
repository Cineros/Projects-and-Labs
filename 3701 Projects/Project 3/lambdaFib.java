import java.math.BigInteger;
import java.util.stream.Stream;

public class lambdaFib {
    public static void main(String[] args) {   
        // use a stream to generate the Fibonacci sequence
        Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, fib -> new BigInteger[]{fib[1], fib[0].add(fib[1])})
        .limit(40)
        .forEach(fib -> System.out.printf("%d%n", fib[0].intValue(), fib[1]));
    }
}
