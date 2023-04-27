import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;

public class Phone {
  
   private static final String[][] letters = { {" ", " ", " "}, 
											   {" ", " ", " "}, 
											   {"A", "B", "C"}, 
											   {"D", "E", "F"}, 
											   {"G", "H", "I"}, 
											   {"J", "K", "L"}, 
											   {"M", "N", "O"}, 
											   {"P", "R", "S"}, 
											   {"T", "U", "V"}, 
											   {"W", "X", "Y"} };

   private int[] phoneNumber;

   // output letter combinations to file
   public void calculate(int phoneNumber) {
	  
			int[] digits = new int[7];
            for (int i = 6; i >= 0; i--) {
                digits[i] = phoneNumber % 10;
                phoneNumber /= 10;
            }


	Formatter output = null;
   	
	try{
		int loop1;
		int loop2;
		int loop3;
		int loop4;
		int loop5;
		int loop6;
		int loop7;

	  output = new Formatter("output.txt");
		
	
		for (loop1 = 0; loop1 <= 2; loop1++){
			for (loop2 = 0; loop2 <= 2; loop2++){
				for (loop3 = 0; loop3 <=2 ; loop3++){
					for (loop4 = 0; loop4 <= 2; loop4++){
						for (loop5 = 0; loop5 <= 2; loop5++){
							for (loop6 = 0; loop6 <= 2; loop6++){
								for (loop7 = 0; loop7 <= 2; loop7++){
									output.format("%s%s%s%s%s%s%s\n",letters[digits[0]][loop1],
												 					letters[digits[1]][loop2],
												 					letters[digits[2]][loop3],
												 					letters[digits[3]][loop4],
												  					letters[digits[4]][loop5],
												  					letters[digits[5]][loop6],
												  					letters[digits[6]][loop7]);
																	}			
																}			
															}			
														}			
													}							
												}			
											}
	}
		catch(FormatterClosedException f){
			System.err.println("Error sending output");
			System.exit(1);
		}
	    catch(IllegalFormatException i){
			System.err.println("Error with the output");
			System.exit(1);
		}
		catch(FileNotFoundException f){
				System.err.println("File not found");
				System.exit(1);
		}
	    finally{
			output.close();
		}
   }
}
