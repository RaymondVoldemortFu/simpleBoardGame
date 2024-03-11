/*
 * 2024.3.11 RaymondFu
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        String buffer;
        Scanner input = new Scanner(System.in);
        String regex = "at \\d+ \\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        System.out.println("enter 'print' to print the chess board");
        System.out.println("enter 'at x y' to print a list of the chess piece at (x,y) along with its adjacent pieces");
        System.out.println("enter 'exit' to quit");

        while(true){
            buffer = input.nextLine();
            matcher = pattern.matcher(buffer);

            if(buffer.equals("print")){
                board.printBoard();
            }
            else if(buffer.equals("exit")){
                System.exit(0);
            }
            else if(matcher.find()){
                String[] parts = buffer.split("\\s+");
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                if(x<0||y<0||x>4||y>4){
                    System.out.println("invalid input");
                    continue;
                }
                String output = board.findPoint(x,y);
                System.out.println(output);
            }
            else {
                System.out.println("invalid input");
            }
        }
    }
}
