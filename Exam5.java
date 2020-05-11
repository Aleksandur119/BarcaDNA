package application;


import java.util.Random;
import java.util.Scanner;

public class Exam5 {

    public Exam5() {

    }

    static int[] numbers;
    static int n;

    static Scanner scan =new Scanner(System.in);

    public static void main(String[] a) {

        menu();

    }
    public static void getMax() {

        int max =numbers[0];

        for(int i=0;i<numbers.length;i++) {

            if(max<numbers[i]) max=numbers[i];
        }
        System.out.println("Най-голямото число е : "+max);
    }

    public static void getMin() {
        int min =numbers[0];

        for(int i=0;i<numbers.length;i++) {

            if(min>numbers[i]) min=numbers[i];

        }
        System.out.println("Най-малкото число е : "+min);
    }

    public static void getAverage() {
        int sum=0;
        for(int i=0;i<numbers.length;i++) {

            sum+=numbers[i];

        }

        System.out.println("Средно аретметичното е :"+(sum/numbers.length));
    }

    public static void getSum() {
        int sum=0;
        for(int i=0;i<numbers.length;i++) {

            sum+=numbers[i];

        }

        System.out.println("Сборът на числата е :"+(sum));
    }

    public static void turnArray() {
        int randomized[]=numbers;
        for(int i=0;i<(randomized.length-1)/2;i++) {
            int temp =randomized[i];
            randomized[i]=randomized[(randomized.length-1)-i];
            randomized[(randomized.length-1)-i]=temp;
        }
        numbers=randomized;
        printNumbers(randomized);
    }

    public static void getNumber(int number) {
        System.out.println("Намерено "+number +":");
        for(int i=0;i<numbers.length;i++) {

            if(numbers[i]==number) {
                System.out.print(i+" ");
            }

        }
    }

    public static void sortUp() {
        for(int i=0;i<numbers.length;i++) {
            for(int j=0;j<numbers.length;j++) {
                if(numbers[i]<numbers[j]) {

                    int temp =numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;

                }

            }

        }


    }

    public static void sortDown() {
        sortUp();
        turnArray();

    }

    public static void randomize() {
        Random r =new Random();
        int randomized[]=numbers;
        int random;
        for(int i=0;i<randomized.length;i++) {
            random =r.nextInt(randomized.length-1);

            int temp =randomized[i];
            randomized[i]=randomized[random];
            randomized[random]=temp;

        }
        numbers=randomized;
        printNumbers(numbers);

    }

    public static boolean test() {

        for(int i=0;i<numbers.length;i++) {
            if(numbers[i]!=numbers[(numbers.length-1)-i]) {
                return false;
            }
        }
        return true;
    }

    public static void numberCount() {
        Scanner s =new Scanner(System.in);

        do {
            System.out.println("Колко числа ще въведеш: ");
            n=s.nextInt();

            System.out.println("Може да ги въведете едно по едно от конзолата или всички заедно. ");
            numbers=new int[n];

            fillNumbers(n,s);
        }while(n<=0);

    }
    public static void menu() {
        numberCount();
        int number;

        do {
            System.out.println("1. Сортиране на въведените числа във възходящ ред \r\n" +
                    "2. Сортиране на въведените числа в низходящ ред \r\n" +
                    "3. Търсене на позиция на конкретно число \r\n" +
                    "4. Разбъркване на числата \r\n" +
                    "5. Изчисляване на сбора на всички числа \r\n" +
                    "6. Намиране на най-голямото число \r\n" +
                    "7. Намиране на най-малкото число \r\n" +
                    "8. Намиране средно-аритметично на числата \r\n" +
                    "9. Проверка за симетричност на масива от числа \r\n" +
                    "10. Обръщане на масива от числа \r\n" +
                    "11. Визуализирай въведените числа \r\n" +
                    "12. Изход ");

            number = scan.nextInt();

            switch(number) {
                case 1:
                    sortUp();
                    printNumbers(numbers);
                    break;
                case 2:
                    sortDown();
                    break;
                case 3:
                    System.out.println("Въведи число:");
                    int input = scan.nextInt();
                    getNumber(input);
                    break;
                case 4:
                    randomize();
                    break;
                case 5:
                    getSum();
                    break;
                case 6:
                    getMax();
                    break;
                case 7:
                    getMin();
                    break;
                case 8:
                    getAverage();
                    break;
                case 9:
                    String output = test() ? "Масива е симетричен":"Масива е не симетричен";
                    System.out.println(output);
                    printNumbers(numbers);
                    break;
                case 10:
                    turnArray();

                    break;
                case 11:
                    printNumbers(numbers);
                    break;
                case 12:
                    number=12;
                    break;


            } if (number<12) {
                System.out.println("\nИскате ли да продължите 1 за да и 0 за не");
                int x = scan.nextInt();

                if (x < 1) break;

            }else {
                break;
            }

        }while(number<12||number>0);

        scan.close();
    }

    public static void fillNumbers(int size,Scanner input) {
        for(int i=0;i<n;i++) {
            numbers[i]=input.nextInt();
        }

    }
    public static void printNumbers(int numbers[]) {
        for(int i=0;i<n;i++) {
            System.out.println(numbers[i]);

        }
    }
}
