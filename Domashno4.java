import java.util.Scanner;

public class Domashno4 {

    static int bord[][] = new int[6][6];

        public static void main(String[] a) {
            suzdavaneNaPole();
            vuvediXod();
        }
        static int xod = 0;

        static Scanner input = new Scanner(System.in);
        static String[] imeNaFigura = { "", "Dw", "D", "Q", "K", "M", "Dw" };

        static int[] patternWhite = { 0, 0, -1, -1, -1, 1, 1, -1, 1, 1, -1, 0, -1, 0, 0, -1, 0, 1 };
        static int[] patternBlack = { 0, 0, 1, -1, 1, 1, -1, -1, 1, 1, 1, 0, 1, 0, 0, 1, 0, -1 };

        static String[] posoka = { "", "LeftD", "RightD", "BackLeftD", "BackRightD", "Up", "Down", "Left", "Right"

        };

        static int hodoveNaBelite = 0;
        static int hodoveNaChernite = 0;

        static int figuraID = 0;

        static boolean kraiNaIgrata = false;

        public static void suzdavaneNaPole() {
            for (int i = 1; i < bord.length - 1; i++) {
                for (int j = 0; j < bord[i].length; j++) {
                    bord[i][j] = 0;
                }
            }
            addFigure();
        }
        public static void addFigure() {
            int count = 1;
            for (int i = 0; i < bord.length; i += bord.length - 1) {
                for (int j = 0; j < bord[i].length; j++) {

                    if (i < 1) {
                        bord[i][j] = count;
                        count++;
                    } else {
                        bord[i][j] = count + 10;
                        count--;
                    }
                }
                count = 6;
            }
        }

        public static void vuvediXod() {

            String input;
            do {
                xod();
                System.out.println("Vyvedi figura:");
                input = Domashno4.input.nextLine();
                figuraID = idNaFigura(input);

                if (leftRightDwarf(figuraID)) {
                    System.out.println("Lqvo ili Dqsno:");
                    input = Domashno4.input.nextLine();
                    figuraID = dwarfSide(input);

                }
                System.out.println("Vyvedi posoka:");
                input = Domashno4.input.nextLine();
                System.out.println(vzemiPosoka(input));

                if (boardMovement(vzemiPosoka(input)))
                    xod = xod == 10 ? 0 : 10;

                izvejdaneNaPoleto();

            } while (figuraID != 0 && !kraiNaIgrata);

            Domashno4.input.close();
        }

        public static int dwarfSide(String input) {

            int number = 0;
            number = input.equals("Lqvo") ? 1 + xod : 6 + xod;
            return number;
        }

        public static boolean leftRightDwarf(int number) {
            return ((number == 1) || (number == 11));
        }

        public static boolean boardMovement(int direction) {
            if (figuraID == 11 || figuraID == 1 || figuraID == 16 || figuraID == 6) {
                return dvijenieNaDw(direction);
            }
            if (figuraID == 12 || figuraID == 2) {
                if (hodoveNaChernite % 3 == 0)
                    return dvijenieNaFigura(direction, 8, 0);
            }
            if (figuraID == 13 || figuraID == 3) {
                return dvijenieNaFigura(direction, 4, 0);
            }
            if (figuraID == 14 || figuraID == 4) {
                return dvijenieNaFigura(direction, 8, 0);
            }
            if (figuraID == 15 || figuraID == 5) {
                return dvijenieNaFigura(direction, 8, 5);
            }
            return false;

        }

        public static boolean dvijenieNaFigura(int direction, int start, int end) {
            int position = poziciaNaFigura(figuraID);
            int number;
            int i = position / 10;
            int j = position % 10;
            if (position < 10) {
                i = 0;
                j = position;
            }
            number = direction > start || direction < end ? 0 : (direction * 2);
            if (xod > 1) {
                dvijenie(i, j, patternWhite[number], patternWhite[number + 1]);
            } else {
                dvijenie(i, j, patternBlack[number], patternBlack[number + 1]);
            }

            return number != 0;
        }

        public static boolean dvijenieNaDw(int direction) {
            if (direction == 5) {
                int offset = 1;

                int i = 0;
                int j = 0;

                if (xod > 1)
                    offset = -1;

                int position = poziciaNaFigura(figuraID);
                if (position > 0) {
                    i = position / 10;
                    j = position % 10;
                }
                dvijenie(i, j, offset, 0);
                return true;
            }
            return false;
        }

        public static void dvijenie(int i, int j, int offsetI, int offsetJ) {
            bord[i][j] = 0;
            try {

                igrataSvurshi(bord[i + offsetI][j + offsetJ]);

                bord[i + offsetI][j + offsetJ] = figuraID;
            } catch (ArrayIndexOutOfBoundsException aobe) {
                bord[i][j] = figuraID;
            }
        }

        public static int vzemiPosoka(String input) {
            for (int i = 0; i < posoka.length; i++) {
                if (posoka[i].toLowerCase().equals(input.toLowerCase())) {
                    return i;
                }
            }
            return 0;
        }

        public static void igrataSvurshi(int number) {
            if (number == 14) {
                System.out.println("Game Over");
                System.out.println("White wins");
                kraiNaIgrata = true;
            } else if (number == 4) {
                System.out.println("Game Over");
                System.out.println("Black wins");
                kraiNaIgrata = true;
            }
        }

        public static int poziciaNaFigura(int number) {

            for (int i = 0; i < bord.length; i++) {
                for (int j = 0; j < bord[i].length; j++) {

                    if (bord[i][j] == number) {

                        return (i * 10) + j;
                    }
                }
            }
            return -1;
        }

        public static void xod() {
            if (xod < 1) {
                System.out.println("Belite sa na hod:");
                hodoveNaBelite++;
            } else {
                System.out.println("Chernite sa na hod:");
                hodoveNaChernite++;
            }
        }

        public static int idNaFigura(String figure) {

            for (int i = 0; i < imeNaFigura.length; i++) {
                if (imeNaFigura[i].toLowerCase().equals(figure.toLowerCase())) {
                    if (xod > 1)
                        return i + 10;
                    else
                        return i;
                }
            }
            return 0;
        }

        public static void izvejdaneNaPoleto() {
            for (int i = 0; i < bord.length; i++) {
                for (int j = 0; j < bord[i].length; j++) {

                    int x = bord[i][j];
                    String bW = (bord[i][j] - 10) > 0 ? "b" + imeNaFigura[x - 10]
                            : bord[i][j] == 0 ? "X" : "w" + imeNaFigura[x];
                    System.out.print(bW + "\t");

                }
                System.out.println();

            }
        }
    }

