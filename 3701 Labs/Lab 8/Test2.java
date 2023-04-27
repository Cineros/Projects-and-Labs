import java.io.IOException;

public class Test2{
    public static void main (String[] args){
        try{
            throw new ExceptionThis();
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            throw new ExceptionThat();
        }catch(Exception e2){
            System.out.println(e2);
        }

        try{
            throw new NullPointerException();
        }catch(Exception e3){
            System.out.println(e3);
        }

        try{
            throw new IOException();
        }catch(Exception e4){
            System.out.println(e4);
        }
    }
}

class ExceptionThis extends Exception
{

}

class ExceptionThat extends ExceptionThis
{

}