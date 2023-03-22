import java.util.*;
import java.util.Scanner;
public class DeckOfCardsTest {
    // execute application
    static DeckOfCards myDeckOfCards = new DeckOfCards();
    
    public static void sortHand(Card[] h){
        for(int i = 0; i < 5; i++){
            int j = i;
            while(j > 0 && h[j - 1].getValue() > h[j].getValue()){
                Card temp;
                temp = h[j -1];
                h[j -1] = h[j];
                h[j] = temp;
                j--;
            }
        }
    }
    public static void printHand(Card[] h){
        for(int i = 0; i < 5; i++){
            System.out.printf("%s, %s%n",h[i].getFace(), h[i].getSuit());
        }
    }

    public static void dealHand(Card[] h){
        for(int i = 0; i < 5; i++){
            myDeckOfCards.dealCard(i, h);
        }
    }

    public static int checkHand(Card[] h){
        boolean straight = true;
        int flush = 0;
        int pair = 0;
        for(int i = 0; i < 5; i++){
            if(i != 4){
                if(h[i].getSuit().equalsIgnoreCase(h[i+1].getSuit())){
                    flush++;
                }
            }
            if(i != 4){
                if(h[i].getValue() != h[i+1].getValue() - 1){
                    straight = false;
                }
            }
            for(int k = i + 1; k < 5; k++){
                if(h[i].getValue() == h[k].getValue()){
                    pair++;
                }
            }
        }
        if(flush == 4){
            if(straight){
                if(h[0].getValue() == 13){
                    return 10;
                }
                return 9;
            }
            return 6;
        }else if(straight){
            return 5;
        }
        switch(pair){
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4: 
                return 7;
            case 6:
                return 8;
            default:
                return 1;
        }
    }

    public static String printRank(int i){
        switch(i){
            case 2:
                return "Pair";
            case 3:
                return "Two Pair";
            case 4:
                return "Three of a Kind";
            case 5:
                return "Stright";
            case 6: 
                return "Flush";
            case 7:
                return "Full House";
            case 8:
                return "Four of a kind";
            case 9:
                return "Stright Flush!";
            case 10:
                return "Royal Straight Flush!";
            default:
                return "High Card";
        }
    }

    public static boolean tieBreaker(int a, Card[] h, Card[] j){
        switch(a){
            case 1:
                if(h[4].getValue() > j[4].getValue()){
                    return true;
                }else{
                    return false;
                }
            case 2:
                Card temp = h[0];
                Card temp2 = j[0];
                for(int i = 0; i < 5; i++){
                    for(int n = i+1; n < 5; n++){
                        if(h[i].getValue() == h[n].getValue()){
                            temp = h[i];
                        }
                        if(j[i].getValue() == j[n].getValue()){
                            temp2 = j[i];
                        }
                    }
                }
                if(temp.getValue() > temp2.getValue()){
                    return true;
                }else{
                    return false;
                }
            case 3:
                for(int i = 0; i < 5; i++){
                    for(int n = i+1; n < 5; n++){
                        if(h[i].getValue() == h[n].getValue()){
                            temp = h[i];
                        }
                        if(j[i].getValue() == j[n].getValue()){
                            temp2 = j[i];
                        }
                    }
                }
            case 4:
                if(h[2].getValue() > j[2].getValue()){
                    return true;
                }else{
                    return false;
                }
            case 5:
                if(h[4].getValue() > j[4].getValue()){
                    return true;
                }else{
                    return false;
                }
            case 6:
                if(h[4].getValue() > j[4].getValue()){
                    return true;
                }else{
                    return false;
                }

            case 7:
                if(h[2].getValue() > j[2].getValue()){
                    return true;
                }else{
                    return false;
                }
            case 8:
                if(h[2].getValue() > j[2].getValue()){
                    return true;
                }else{
                    return false;
                }

            case 9:
                return false;
            case 10:
                return false;
            default:
                return false;
        }
    }

    public static boolean whoWins(int a, int b, Card[] h, Card[] j){
        if(a > b){
            return true;
        }else if(b > a){
            return false;
        }else if(b == a){
            return tieBreaker(a, h, j);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Card[] Hand = new Card[5];
        Card[] Hand2 = new Card[5];
        int playerOneRank = 0;
        int playerTwoRank = 0;
        boolean winner = false;
        boolean play = true;
        while(play){
            myDeckOfCards.shuffle(); // place Cards in random order
            dealHand(Hand);
            sortHand(Hand);
            printHand(Hand);
            playerOneRank = checkHand(Hand);
            System.out.printf("Player 1 has: %s.%n", printRank(playerOneRank));
            dealHand(Hand2);
            sortHand(Hand2);
            printHand(Hand2);
            playerTwoRank = checkHand(Hand2);
            System.out.printf("Player 2 has: %s.%n", printRank(playerTwoRank));
            winner = whoWins(playerOneRank, playerTwoRank, Hand, Hand2);
            if(winner){
                System.out.printf("Player 1 wins with %s!. %n", printRank(playerOneRank));
            }else{
                System.out.printf("Player 2 wins with %s!. %n", printRank(playerTwoRank));
            }
            System.out.println("Play Again?: y/n");
            String again = input.nextLine();
            if(again.equalsIgnoreCase("n")){
                play = false;
            }

        }
        
        // print all 52 Cards in the order in which they are dealt
        /*for (int i = 1; i <= 52; i++) {
            // deal and display a Card
            System.out.printf("%-19s", myDeckOfCards.dealCard());
            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }*/
    }
}