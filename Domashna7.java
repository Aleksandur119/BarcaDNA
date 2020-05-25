import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Domashna7 {

    static int[][] board;

    static int[] boardInfo = new int[3];

    static int[] configuration = new int[2];

    final static String enemyFile = "enemy_teritory.txt";
    final static String config = "configurations.txt";

    static Scanner input;

    static int sY, sX, fX, fY;

    static String[] legent = { "X ", "S ", "F ", "V ", "* ", "Y ", "N ", "X " };

    static String[] direction = { "Up", "Down", "Left", "Right" };
    static int[][] movement = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

    static Random random = new Random();

    static boolean running=true;

    int analysis[];

    public static void main(String[] a) {
        getEnemyInformation();
        getConfiguration();
        createBoard();
        startAndFinish();
        placeMines();

        menu();

    }

    private static void getEnemyInformation() {
        String line = "";
        try {
            input = new Scanner(new File(enemyFile));

            for (int i = 0; i < boardInfo.length; i++) {
                line = input.nextLine();
                boardInfo[i] = Integer.parseInt(line.split("=")[1]);
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

    }

    private static void getConfiguration() {
        String line = "";
        try {
            input = new Scanner(new File(config));

            for (int i = 0; i < configuration.length; i++) {
                line = input.nextLine();
                configuration[i] = Integer.parseInt(line.split("=")[1]);
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
    }

    private static void createBoard() {
        board = new int[boardInfo[0]][boardInfo[1]];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                board[i][j] = 0;
            }
        }
    }

    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {

                System.out.print(legent[board[i][j]]);

            }

            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

    }

    private static void startAndFinish() {

        int place;

        int[] layoutX = { 0, 0, board.length - 1, board.length - 1 };
        int[] layoutY = { 0, board[0].length - 1, 0, board[0].length - 1 };

        place = random.nextInt(layoutX.length - 1);

        board[layoutX[place]][layoutY[place]] = 1;
        sX = layoutX[place];
        sY = layoutY[place];

        place = (layoutX.length - 1) - place;

        board[layoutX[place]][layoutY[place]] = 2;
        fX = layoutX[place];
        fY = layoutY[place];

        printBoard();
    }

    private static void placeMines() {
        int layoutX, layoutY;

        for (int i = 0; i < boardInfo[2]; i++) {

            do {
                layoutX = random.nextInt(board.length - 1);
                layoutY = random.nextInt(board[0].length - 1);
            } while (board[layoutX][layoutY] != 0);
            board[layoutX][layoutY] = legent.length - 1;

        }


    }

    private static void movement(int i, int j, int offsetI, int offsetJ) {
        boolean b = board[i][j] != 1;


        board[i][j] = 3;
        try {

            if(board[i + offsetI][j + offsetJ]==7||board[i + offsetI][j + offsetJ]==5) {
                running=false;
                System.out.println("GAME OVER");
                legent[legent.length-1]="Y ";
            }else if(board[i + offsetI][j + offsetJ]==2) {
                running=false;
                System.out.println("You WIN");
                legent[legent.length-1]="Y ";

            }

            board[i + offsetI][j + offsetJ] = 4;

        } catch (ArrayIndexOutOfBoundsException aobe) {
            if (!b)
                board[i][j] = 1;
            else
                board[i][j] = 4;

            System.out.println("You fall out the board");
            return;
        }
        sX = i + offsetI;
        sY = j + offsetJ;

    }

    private static void move(int direction) {
        movement(sX, sY, movement[0][direction], movement[1][direction]);
        printBoard();
    }

    private static void outOfTheBoard(int i, int j, int x, int y) {

        if (i >= 0 && i < x && j >= 0 && j < y) {

            if (board[i][j] == 7)
                board[i][j] = 5;
            else if(board[i][j]!=1&&board[i][j]!=3&&board[i][j]!=4)
                board[i][j] = 6;
        }


    }
    private static boolean isOutOfBounds(int i,int j) {
        try {
            board[i][j] = board[i][j];
            return false;
        }catch(ArrayIndexOutOfBoundsException aobe) {
            return true;
        }

    }



    private static void analysis(int i, int j) {

        if(configuration[0]<=0) {
            System.out.println("Няма повече анализи");
            return;
        }
        configuration[0]--;
        outOfTheBoard(i, j, board.length, board[0].length);

        outOfTheBoard(i - 1, j , board.length, board[0].length);

        outOfTheBoard(i , j - 1, board.length, board[0].length);

        outOfTheBoard(i + 1, j , board.length, board[0].length);

        outOfTheBoard(i , j+1 , board.length, board[0].length);



    }
    private static void defuse(int i, int j) {

        if(configuration[1]<=0) {
            System.out.println("Свършиха сапьорите");
            return;
        }
        configuration[1]--;


        board[i][j]=0;
    }


    private static void menu() {
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Анализ\r\n"
                    + "2. обезвреждане\r\n"
                    + "3. придвижване, по бойното поле.");

            option = input.nextInt();
            switch (option) {

                case 1:
                    analysis(sX,sY);
                    printBoard();
                    break;
                case 2:
                    int dir = 0;
                    do {
                        System.out.println("1. На горе\r\n"
                                + "2. На долу\r\n"
                                + "3. На Ляво\r\n"
                                + "4. На Дясно");

                        dir = input.nextInt();
                    }while(isOutOfBounds(sX+movement[0][dir-1],sY+movement[1][dir-1]));
                    defuse(sX+movement[0][dir-1],sY+movement[1][dir-1]);
                    move(dir-1);

                    break;
                case 3:
                    int direction = 0;
                    do {
                        System.out.println("1. На горе\r\n"
                                + "2. На долу\r\n"
                                + "3. На Ляво\r\n"
                                + "4. На Дясно");

                        direction = input.nextInt();
                    }while(isOutOfBounds(sX+movement[0][direction-1],sY+movement[1][direction-1]));

                    System.out.println("1. Проба за мина\r\n"
                            + "2. Обезвреждане на мина\r\n"
                            + "3. (пре)Мини");

                    int option2;
                    option2= input.nextInt();

                    switch(option2) {
                        case 1:
                            analysis(sX+movement[0][direction-1],sY+movement[1][direction-1]);
                            printBoard();
                            break;
                        case 2:
                            defuse(sX+movement[0][direction-1],sY+movement[1][direction-1]);
                            move(direction-1);
                        case 3:
                            move(direction-1);
                            break;
                    }

                    break;
            }

        } while (running);

    }

}
