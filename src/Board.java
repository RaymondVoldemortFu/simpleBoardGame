import java.util.Scanner;

public class Board {
    private final int BOARD_LENGTH = 5;     //the length of the chess board
    private char[][] chessBoard;//the chess board is a 2D array

    //build method
    Board(){
        chessBoard = new char[BOARD_LENGTH][BOARD_LENGTH];
        StringBuilder board = getChessBoardFromUser();
        //System.out.println(board.toString());
        String board_string = board.toString();
        setChessBoard(board_string);
        //System.out.println(board_string+"\n"+board_string.length());
    }


    private StringBuilder getChessBoardFromUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a 5x5 chess board like the following example: ");
        System.out.println("A,B,C,D,E\nB,C,D,E,A\nA,C,A,E,D\nB,C,C,D,A\nA,B,D,C,A");
        System.out.println("Please note that only uppercase letters A, B, C, D, and E are permitted");
        StringBuilder buffer = new StringBuilder();
        for(int i=0;i<BOARD_LENGTH;i++){
            buffer.append(input.nextLine());
            buffer.append(",");
        }
        return buffer;
    }

    private void setChessBoard(String boardString){
        if(boardString.length()!=(2*BOARD_LENGTH*BOARD_LENGTH)){
            System.out.println("invalid input");
            System.exit(1);
        }
        for(int i=0;i<BOARD_LENGTH;i++){
            int counter = 0;
            for(int j=0;j<BOARD_LENGTH*2;j++){
                if(boardString.charAt((i*10)+j)==','){
                    counter++;
                    continue;
                }
                switch (boardString.charAt(i*10+j)){
                    case 'A': {
                        chessBoard[i][j-counter] = 'A';
                        break;
                    }
                    case 'B':{
                        chessBoard[i][j-counter] = 'B';
                        break;
                    }
                    case 'C':{
                        chessBoard[i][j-counter] = 'C';
                        break;
                    }
                    case 'D':{
                        chessBoard[i][j-counter] = 'D';
                        break;
                    }
                    case 'E':{
                        chessBoard[i][j-counter] = 'E';
                        break;
                    }
                    default:{
                        System.out.println("invalid input");
                        System.exit(2);
                    }
                }
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<BOARD_LENGTH;i++){
            for(int j=0;j<BOARD_LENGTH;j++){
                System.out.print(chessBoard[i][j]);
                if(j<BOARD_LENGTH-1) System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public String findPoint(int x, int y){
        if(x<0||y<0||x>4||y>4){
            System.out.println("invalid input");
            System.exit(3);
        }
        StringBuilder output = new StringBuilder();
        output.append("[("+x+","+y+","+chessBoard[x][y]+")");
        if(y-1>=0) output.append(", ("+x+","+(y-1)+","+chessBoard[x][y-1]+")");
        if(y+1<=4) output.append(", ("+x+","+(y+1)+","+chessBoard[x][y+1]+")");
        if(x-1>=0) output.append(", ("+(x-1)+","+y+","+chessBoard[x-1][y]+")");
        if(x+1<=4) output.append(", ("+(x+1)+","+y+","+chessBoard[x+1][y]+")");
        output.append("]");
        return output.toString();
    }

}
