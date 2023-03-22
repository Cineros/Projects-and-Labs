import java.util.Scanner;

public class temp {

    enum POB{X,O,N;};

    private static POB turn = POB.X;
    private static POB[][] board = new POB[3][3];

    public static void setBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = POB.N;
            }
        }
    }

    public static void displayBoard(){
        System.out.println("_______");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("|" + board[i][j]);
                if(j == 2){
                    System.out.print("|");
                }
            }
            System.out.printf("%n");
        }
        System.out.println("-------");
    }

    public static int positionSelect(){
        System.out.println("Enter a number for a position");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void switchTurn(){
        turn = (turn == POB.X)?POB.O:POB.X;
    }

    public static void play(int i){
        switch(i){
            case 1:
                if(board[0][0] == POB.N){
                    board[0][0] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 2:
                if(board[0][1] == POB.N){
                    board[0][1] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 3:
                if(board[0][2] == POB.N){
                    board[0][2] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 4:
                if(board[1][0] == POB.N){
                    board[1][0] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 5:
                if(board[1][1] == POB.N){
                    board[1][1] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 6:
                if(board[1][2] == POB.N){
                    board[1][2] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 7:
                if(board[2][0] == POB.N){
                    board[2][0] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 8:
                if(board[2][1] == POB.N){
                    board[2][1] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            case 9:
                if(board[2][2] == POB.N){
                    board[2][2] = turn;
                    switchTurn();
                }else{
                    System.out.println("Invalid value please enter a position");
                    play(positionSelect());
                }
                break;
            
        }
    }
    public static boolean checkWin(){
        for(int n = 0; n < 8; n++){
            switch(n){
                case 1:
                    if(board[0][0] == board[0][1] && board[0][0] == board[0][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 2:
                    if(board[1][0] == board[1][1] && board[1][0] == board[1][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 3:
                    if(board[2][0] == board[2][1] && board[2][0] == board[2][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 4:
                    if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 5:
                    if(board[2][2] == board[1][1] && board[2][2] == board[0][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 6:
                    if(board[0][0] == board[1][0] && board[0][0] == board[2][0]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 7:
                    if(board[0][1] == board[1][1] && board[0][1] == board[2][1]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
                case 8:
                    if(board[0][2] == board[1][2] && board[0][2] == board[2][2]){
                        switchTurn();
                        System.out.printf(turn + " Has won!%n");
                        return(true);
                    }
            }
        }
        return(false);
    }

    public static void game(){
        setBoard();
        displayBoard();
        for(int i = 0; i < 9; i++){
            play(positionSelect());
            displayBoard();
            if(i > 3){
                if(checkWin()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        String answer;
        while(true){
            System.out.printf("Would you like to play? y/n%n");
            Scanner input = new Scanner(System.in);
            answer = input.next();
            if(answer.equalsIgnoreCase("y")){
                game();
            }else{
                break;
            }
        }
    }
}
