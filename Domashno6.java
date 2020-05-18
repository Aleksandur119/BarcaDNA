
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Domashno6 {


    static int[] mainNumbers;
    static String[] mainWords;
    static int length;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void  mainMenu() {

        int number=0;
        do {
            System.out.println("1. Работа с числа \r\n" +
                    "2. Работа с думи \r\n" +
                    "3. Изход от програмата");
            try {
                number=scanner.nextInt();


            }catch(Exception e) {
                scanner.next();
                continue;
            }

            switch(number) {
                case 1:
                    intMenu();
                    break;
                case 2:
                    stringMenu();
                    break;

            }

            if(number>3)continue;
            if(number==3)break;

        }while(number>=1||number<=2);

    }
    public static void intMenu() {
        int number=0;

        do {
            System.out.println("Въведете броя на числата");
            try {
                length=scanner.nextInt();

                System.out.println("Въведете числата:");
                fill();
            }catch(Exception e) {
                scanner.next();
                continue;
            }
        }while(length<=0);
        do {
            System.out.println("1. Извеждане само на простите числа от масива \r\n" +
                    "2. Извеждане на най-често срещан елемент в масива \r\n" +
                    "3. Извеждане на максимална редица от нарастващи елементи в масива \r\n" +
                    "4. Извеждане на максимална редица от намаляващи елементи в масива \r\n" +
                    "5. Извеждане на максимална редица от еднакви елементи в масива \r\n" +
                    "6. Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип \r\n" +
                    "7. Връщане назад към основното меню");
            try {
                number=scanner.nextInt();

            }catch(Exception e) {
                scanner.next();
                continue;
            }

            switch(number) {
                case 1:
                    findPrimeNumbers();
                    break;
                case 2:
                    getPopularElement(mainNumbers);
                    break;
                case 3:
                    najGolqmataVuzhodqshtaRedica();
                    break;
                case 4:
                    najGolqmataNizhodqshtaRedica();
                    break;
                case 5:
                    najGolqmataNizhodqshtaRedica();
                    break;
                case 6:
                    findNumbers();
                    break;
            }
            if(number>7)continue;
            if(number==7)break;

        }while(number>=1||number<=6);
    }
    public static void stringMenu() {
        int number=0;

        do {
            System.out.println("Въведете броя на думуте");
            try {
                length=scanner.nextInt();
                System.out.println("Въведете думите:");
                stringFill();
            }catch(Exception e) {
                scanner.next();
                continue;
            }
        }while(length<=0);

        do {

            System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата \r\n" +
                    "2. Изведете броя на повтарящите се символи за всяка една от думите в масива \r\n" +
                    "3. Изведете броя на символите за всяка една от думите в масива \r\n" +
                    "4. Изведете броя на повтарящите се думи от масива \r\n" +
                    "5. Връщане назад към основното меню");
            try {
                number=scanner.nextInt();

            }catch(Exception e) {
                scanner.next();
                continue;
            }

            switch(number) {
                case 1:
                    stringReverse();
                    break;
                case 2:
                    findDublicatesLetters();
                    break;
                case 3:
                    getLenght();
                    break;
                case 4:
                    findDublcates();
                    break;

            }
            if(number>5)continue;
            if(number==5)break;

        }while(number>=1||number<=4);

    }

    public static void najGolqmataVuzhodqshtaRedica() {
        int longestSeq = 0;
        int counter = 0;
        int endIndex = 0;
        for (int i = 1; i < mainNumbers.length; i++)
        {
            if (mainNumbers[i - 1] < mainNumbers[i])
            {
                counter++;
            }
            else
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i - 1;
                }
                counter = 0;
            }
            if (i == mainNumbers.length - 1)
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i;
                }
            }
        }
        for (int i = endIndex - longestSeq; i <= endIndex; i++)
        {
            System.out.println(mainNumbers[i]);
        }

    }

    public static void najGolqmataNizhodqshtaRedica() {
        int longestSeq = 0;
        int counter = 0;
        int endIndex = 0;

        for (int i = 1; i < mainNumbers.length; i++)
        {
            if (mainNumbers[i - 1] >mainNumbers[i])
            {
                counter++;
            }
            else
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i - 1;
                }
                counter = 0;
            }
            if (i == mainNumbers.length - 1)
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i;
                }
            }
        }
        for (int i = endIndex - longestSeq; i <= endIndex; i++)
        {
            System.out.println(mainNumbers[i]);
        }
    }
    public static void findPrimeNumbers() {
        for (int i = 0; i < mainNumbers.length; i++) {
            boolean isPrime = true;
            if (mainNumbers[i] == 1)
                isPrime = false;
            else {

                for (int j = 2; j <= mainNumbers[i] / 2; j++) {
                    if (mainNumbers[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime)
                System.out.println(mainNumbers[i] + " is a prime number in the array ");
        }
    }
    public static void getPopularElement(int[] a)
    {
        int count = 1, tempCount;
        int popular = a[0];
        int temp = 0;
        for (int i = 0; i < (a.length - 1); i++) {
            temp = a[i];
            tempCount = 0;
            for (int j = 1; j < a.length; j++) {
                if (temp == a[j])
                    tempCount++;
            }
            if (tempCount > count) {
                popular = temp;
                count = tempCount;

            }
        }
        System.out.println(popular);
    }
    public static  void findDublicateNumbers() {
        int longestSeq = 0;
        int counter = 0;
        int endIndex = 0;

        for (int i = 1; i < mainNumbers.length; i++)
        {
            if (mainNumbers[i - 1] ==mainNumbers[i])
            {
                counter++;
            }
            else
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i - 1;
                }
                counter = 0;
            }
            if (i == mainNumbers.length - 1)
            {
                if (counter > longestSeq)
                {
                    longestSeq = counter;
                    endIndex = i;
                }
            }
        }
        for (int i = endIndex - longestSeq; i <= endIndex; i++)
        {
            System.out.println(mainNumbers[i]);
        }
    }
    public static void findNumbers() {
        int longestSeq = 0;
        int counter = 0;
        int endIndex = 0;
        int sum=0;
        int rand;
        Random random =new Random();
        rand=random.nextInt(100);
        boolean found=false;

        for (int i = 0; i < mainNumbers.length; i++)
        {
            sum+=mainNumbers[i];

            if(sum==rand) {
                endIndex=i;
                found=true;
                break;

            }else if(sum>rand) {
                i-=1;

                sum=0;
                counter=0;

            }else {
                counter++;
            }
            
        }
        if(!found)System.out.println("Не е отрито такова число");
        else {


            for (int i = endIndex - counter; i <= endIndex; i++) {
                System.out.println(mainNumbers[i]);
            }
        }
    }
    public static void stringReverse() {

        for(int i=0;i<mainWords.length;i++) {
            byte [] strAsByteArray = mainWords[i].getBytes();

            byte [] result =
                    new byte [strAsByteArray.length];


            for (int j= 0; j<strAsByteArray.length; j++)
                result[j] =
                        strAsByteArray[strAsByteArray.length-j-1];

            System.out.println(new String(result));
        }
    }
    public static void getLenght() {
        for(int i=0;i<mainWords.length;i++) {
            System.out.println(mainWords[i]+" брой символи:"+mainWords[i].length());
        }

    }
    public static void findDublcates() {
        int br=1;
        for(int i=0;i<mainWords.length;i++) {
            for(int j=i+1;j<mainWords.length;j++) {

                if (mainWords[i].toLowerCase().equals(mainWords[j].toLowerCase())) {
                    br++;
                    mainWords[j]="";
                }
            }
            if(br!=1&&mainWords[i]!="")
                System.out.println(mainWords[i]+"-брой повторения:"+br);

            br=1;

        }
    }
    public static void findDublicatesLetters() {
        int br=1;
        for(int i=0;i<mainWords.length;i++) {
            for(int j=0;j<mainWords[i].length();j++) {
                for(int n=j+1;n<mainWords[i].length();n++) {
                    if (mainWords[i].charAt(j)==(mainWords[i].charAt(n))) {
                        char c = 0;
                        br++;
                        mainWords[i].replace(mainWords[i].charAt(j), c);
                    }
                }
                if(br!=1)
                    System.out.println(mainWords[i]+"-брой повторения:"+br+"-"+mainWords[i].charAt(j));

                br=1;
            }
        }
    }
    public static void numbersForInspection() {

        try {
            System.out.println("How many numbers do you want to enter:");
            length = scanner.nextInt();

            System.out.println("ENTER NUMBER");
            mainNumbers = new int[length];

            fill();
        }catch(Exception e) {
            System.out.println("Opss something went wrong :(");
        }
    }
    public static void fill() {
        mainNumbers=new int[length];
        for (int i = 0; i < length; i++) {
            mainNumbers[i] = scanner.nextInt();
            if(mainNumbers[i]<0||mainNumbers[i]>10000) {
                scanner.next();
                continue;
            }
        }
    }

    public static void stringFill() {
        mainWords=new String[length];
        for (int i = 0; i < length; i++) {
            mainWords[i] = scanner.next();
        }
    }
    public static void print(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
