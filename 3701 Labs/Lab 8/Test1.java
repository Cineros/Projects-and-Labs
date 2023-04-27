public class Test1{
	public static void main(String[] args){
		try{
			throw new Exception3();
		}catch(Exception1 exception1){
				System.err.println("First exception subclass caught\n");
		}
		try{
			throw new Exception2();
		}catch(Exception1 exception2){
			System.err.println("Second exception subclass caught\n");
		}
	}
}

class Exception1 extends Exception
	{
		
	}

class Exception2 extends Exception1
	{
		
	}

class Exception3 extends Exception2
	{
		
	}