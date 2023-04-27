public class PairTest {
    public static void main(String args[]){
        Pair<Integer, String> newPair = new Pair<Integer, String>(1, "First");
        System.out.printf("Original Pair: <%d, %s>\n", newPair.getFirst(), newPair.getSecond());

        newPair.setFirst(2);
        newPair.setSecond("Second");

        System.out.printf("New Pair: <%d, %s>\n", newPair.getFirst(), newPair.getSecond());
    } 
}