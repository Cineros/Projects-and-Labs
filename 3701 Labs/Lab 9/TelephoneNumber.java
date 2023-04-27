import java.util.Scanner;

public class TelephoneNumber{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String inNum;
        String tempString1[];
        String tempString2[];
        String areaCode;
        String firstThree;
        String lastFour;
        String allSeven;
        String fullNumber;

        System.out.print("Enter a telephone number as '(XXX) XXX-XXXX': ");
        inNum = input.nextLine();
        System.out.println();
        tempString1 = inNum.split(" ");
        areaCode = tempString1[0].substring(1, 4);
        tempString2 = tempString1[1].split("-");
        firstThree = tempString2[0];
        lastFour = tempString2[1];
        allSeven = firstThree + lastFour;
        fullNumber = areaCode + " " + allSeven;

        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + allSeven);
        System.out.println("Full Phone number: " + fullNumber);
    }
}