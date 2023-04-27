import java.util.*;

public class TreeSetTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text: ");
        String input = scanner.nextLine();

        Set<String> tree = new TreeSet<String>();
        StringTokenizer token = new StringTokenizer(input);

        while(token.hasMoreTokens()){
            tree.add(token.nextToken());
        }

        System.out.println("Elements in tree: " + tree);
    }
}
