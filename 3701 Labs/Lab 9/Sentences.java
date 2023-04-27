import java.util.Random;

public class Sentences {

    public static void main(String args[]){
        Random generator = new Random();

        String article[] = {"the", "a", "one", "some", "any"};
        String noun[] = {"boy", "girl", "dog", "town", "car"};
        String verb[] = {"drove", "jumped", "ran", "walked", "skipped"};
        String preposition[] = {"to", "from", "over", "under", "on"};

        for (int i = 0; i < 20; i++){
            int article1 = generator.nextInt(article.length);
            int noun1 = generator.nextInt(noun.length);
            int verb1 = generator.nextInt(verb.length);
            int preposition1 = generator.nextInt(preposition.length);
            int article2 = generator.nextInt(article.length);
            int noun2 = generator.nextInt(noun.length);

            StringBuilder buffer = new StringBuilder();
            buffer.append(article[article1] + " " + noun[noun1] + " " + verb[verb1] + " " + preposition[preposition1] + " " + article[article2] + " " + noun[noun2] + ".\n");
            buffer.setCharAt(0, Character.toUpperCase(buffer.charAt(0)));
            System.out.println(buffer.toString());
        }
    }
}