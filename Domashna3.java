import java.util.Scanner;
import java.util.Random;

public class Domashna3 {
    public static void main(String[] args) {

        navigationControl();
        battleSystems();
        razgovor();

    }

     static int battery = 4;
     static Random rand=new Random();



    public  static void navigationControl() {
        Scanner prepqdstie = new Scanner(System.in);
        String predmet;
        System.out.print("Vuvedi prepqdstvie ");
        predmet = prepqdstie.nextLine();
        if (predmet.equals("wall")) {
            System.out.println("Go sideway");
        } else if (predmet.equals("chair")) {
            System.out.println("Jump");
        } else if (predmet.equals("nothing")) {
            System.out.println("Forward");
        }
    }

    public  static void battleSystems() {
        Scanner chislo = new Scanner(System.in);
        int chisloAtaka;
        do {
            System.out.println("Vuvedete pixelite ");
            chisloAtaka = chislo.nextInt();
            if (chisloAtaka % 2 == 0) {
                System.out.println("Mouse detected and ready to attack ");
                battery--;
                if (battery<=0)

                    if (!mehanizumZarejdane())
                        break;
                    else
                        battery=4;
                int stairDestroyer = rand.nextInt(9) + 1;

                if (stairDestroyer == 5)
                    System.out.println("Troshi vsichko ");
                else
                    System.out.println("Dead mouse ");

            } else {
                System.out.println("Atakata ne e uspeshna");
                break;
            }


        } while (true);



    }

    public static void razgovor() {

        System.out.println("chetni");
        for (int i=10; i>0; i--) {
            System.out.print(i +" ");
            if(i%2==0)System.out.print("-I am a Robottttt\n ");
            else
                System.out.print("\n");
        }



    }




    public static boolean mehanizumZarejdane() {
        Random chislo = new Random();
        int chislo_1 = chislo.nextInt(999)+1;
        int chislo_2 = chislo.nextInt(999)+1;
        if (chislo_1 > chislo_2) {
            System.out.println("Ima tok ");
            return true;

        } else if (chislo_2 > chislo_1) {
            System.out.println("Nqma tok");
            return false;
        } else if (chislo_1 == chislo_2) {
            mehanizumZarejdane();
        }
        return false;
    }

}