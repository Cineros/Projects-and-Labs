public class ReThrowingExceptions {
    public static void main(String[] args){
        try {
            ReThrowingExceptions re = new ReThrowingExceptions();
            re.someMethod();
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void someMethod() throws Exception{
        try {
            someMethod2();
        }catch (Exception e){
            throw new Exception("This Exception thrown in someMethod.");
        }
    }

    private void someMethod2() throws Exception{
        throw new Exception("This Exception thrown in someMethod2.");
    }
}