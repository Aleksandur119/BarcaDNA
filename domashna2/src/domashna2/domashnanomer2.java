package domashna2;



public class domashnanomer2 {
    public static void main(String[] args) {
        liceiPerimetur();
        izvejdanenadniotmesec();
        skachaneot9tiqetaj();

    }


    public static void liceiPerimetur() {
        int stranaA = 2;
        int stranaB = 6;
        int liceS = stranaA + stranaB;
        System.out.println("Liceto na pravougulnika e: " + liceS);


        int perimeturP = (2*stranaA) + (2*stranaB);
        System.out.println("Perimeturut na pravougulnika e: " + perimeturP);
    }
    public static void izvejdanenadniotmesec() {
        String month = "february";
        if (month.equals("january")){
            System.out.println("31 dni");
        } else if (month.equals("february")){
            System.out.println("29 dni");
        }
        else if (month.equals("march")){
            System.out.println("31 dni");
        }
        else if (month.equals("april")){
            System.out.println("30 dni ");
        }
        else if (month.equals("may")){
            System.out.println("31 dni ");
        }
        else if (month.equals("june")){
            System.out.println("30 dni");
        }
        else if (month.equals("july")){
            System.out.println("31 dni");
        }
        else if (month.equals("august")){
            System.out.println("31 dni");
        }
        else if (month.equals("september")){
            System.out.println("30 dni");
        }
        else if (month.equals("october")){
            System.out.println("31 dni");
        }
        else if (month.equals("november")){
            System.out.println("30 dni");
        }
        else if (month.equals("december")){
            System.out.println("31 dni");
        }

    }
    public static void skachaneot9tiqetaj() {
        int nomerEtaj = 8;
        String imeSused;
        String death;

        switch (nomerEtaj){
            case 8:
                imeSused = "Zari";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 7:
                imeSused = "Nikol";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 6:
                imeSused = "Toshe";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 5:
                imeSused = "Petko";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 4:
                imeSused = "Pepi";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 3:
                imeSused = "Mitko";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 2:
                imeSused = "Bilqna";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 1:
                imeSused = "Mimi";
                System.out.println("Zdrasti " + imeSused);
                nomerEtaj--;
            case 0:
                death = "Ouch";
                System.out.println(death);
                break;
            default:
                System.out.println("Nqma takuv etaj");

        }
    }
}