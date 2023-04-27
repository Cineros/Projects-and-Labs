import java.security.SecureRandom;

public class Randoms{
	public static void main(String [] args){
		SecureRandom random = new SecureRandom();
		random.ints(50,1,1000)
			  .filter(x->x%2 == 1)
			  .sorted()
			  .forEach(x->System.out.printf("%d%n",x));
	}
}