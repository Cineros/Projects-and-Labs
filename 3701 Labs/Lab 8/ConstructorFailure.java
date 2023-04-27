class TClass{
    public TClass() throws Exception{
        throw new Exception();
    }
}

public class ConstructorFailure{
    public static void main(String[] args){
        try {
            TClass tc = new TClass();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}