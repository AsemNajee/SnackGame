/**
 *   >> Al-Reecha .~
 *   << BY : Asem Najee >>
 */
package game;

import java.util.Scanner;

public class SnackGame {

    static Scanner in = new Scanner(System.in);
    static int [] indexes = {1,2,3,4,5};
    static int head = 5;
    static int move = 4;
    static int rows = 15;
    static int cols = 15;
    static String[][] places = new String[15][15];
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        new Time().start(); // owful try
        do{
            print();
            menu();
        } while (true);
        
    }
    
    static void print(){
        clean();
        String array = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array += getItem((rows*i) + j);
            }
            array+= "\n";
        }
        System.out.println(array);
    }
    
    static String getItem(int position){
        return (inArray(position)? "=":" .");
    }
    
    static void clean(){
        System.out.println("\n".repeat(50));
    }
    
    static boolean inArray(int position){
        for (int k = 0; k < indexes.length; k++) {
            if(indexes[k] == position)
                return true;
        }
        return false;
    }
    
    static boolean isEmpty(int position){
        int length = places.length;
        int x = position/length;
        int y = position%length;
        return places[x][y].equals(" ");
    }
    
    static void reset(){
        indexes = new int []{1,2,3,4,5};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                places[i][j] = (inArray((i*rows)+j) ? "=":" ");
            }
        }
    }
    
    static void menu(){
        System.out.println("\t2\n4\t\t6\n\t8");
        System.out.print("Enter: ");
        int x = in.nextInt();
        if(x == 2 || x == 4 || x == 6 || x == 8)
            move = x;
        move(move);
    }
    
    static void move(int pos){
        if(pos > rows*cols-1)
            return;
        
        switch(pos){
            case 2:{
                shift(head - rows);
            }break;
            case 4:{
                shift(head - 1);
            }break;
            case 6:{
                shift(head + 1);
            }break;
            case 8:{
                shift(head + cols);
            }break;
            default:
                System.out.println("Invalid choose");
        }
    }
    
    static void shift(int pos){
        if(pos > rows*cols-1 || pos < 0)
            return;
        int temp []= new int [indexes.length];
        for (int i = 1; i < indexes.length ; i++) {
            temp[i-1] = indexes[i];
        }
        temp[temp.length-1] = pos;
        indexes = temp;
        head = pos;
    }
    
}

class Time extends Thread {
    
    @Override
    public void run() {
        while(true){
            try {
                SnackGame.move(SnackGame.move);
                Thread.sleep(1200);
                SnackGame.print();
            } catch (InterruptedException ex) {
                
            }
        }
    }

}

