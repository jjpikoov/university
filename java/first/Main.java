import java.util.HashMap;
import java.util.Map;
import java.lang.Math.*;
public class Main {
    public static void main(String[] args) {

        boolean isMinus = false;
        boolean minInt = false;
        int number;

        for (String argument : args) {
            if (czyInt(argument) == true) {
                minInt = false;
                if (argument.equals("-2147483648")) {
                    number = 2147483647;
                    minInt = true;
                    isMinus = true;
                }
                else if (argument.charAt(0) == '-') {
                    isMinus = true;
                    argument = argument.substring(1);
                    number = new Integer(argument);  
                }
                else {
                    number = new Integer(argument);  
                    isMinus = false;
                }

                String wynik = przeczytajLiczbe(number, isMinus, minInt);

                System.out.print(wynik);
                System.out.println();
            }
        }
    }

    public static String przeczytajLiczbe(int number, boolean isMinus, boolean minInt) {

        //f(n) = n
        String[] jednosci = new String[10];
        jednosci[0] = "zero";
        jednosci[1] = "jeden";
        jednosci[2] = "dwa";
        jednosci[3] = "trzy";
        jednosci[4] = "cztery";
        jednosci[5] = "pięć";
        jednosci[6] = "sześć";
        jednosci[7] = "siedem";
        jednosci[8] = "osiem";
        jednosci[9] = "dziewięć";

        //f(n) = n - 11
        String[] nastki = new String[9];
        nastki[0] = "jedenaście";
        nastki[1] = "dwanaście";
        nastki[2] = "trzynaście";
        nastki[3] = "czternaście";
        nastki[4] = "piętnaście";
        nastki[5] = "szesnaście";
        nastki[6] = "siedemnaśie";
        nastki[7] = "osiemnaście";
        nastki[8] = "dziewiętnaście";

        //f(n) = n / 10
        String[] dziesiatki = new String[10];
        dziesiatki[0] = "None";
        dziesiatki[1] = "dziesięć";
        dziesiatki[2] = "dwadzieścia";
        dziesiatki[3] = "trzydzieści";
        dziesiatki[4] = "czterdzieści";
        dziesiatki[5] = "pięćdziesiąt";
        dziesiatki[6] = "sześćdziesiąt";
        dziesiatki[7] = "siedemdziesiąt";
        dziesiatki[8] = "osiemdziesiąt";
        dziesiatki[9] = "dziewiećdziesiąt";


        //f(n) = n / 100
        String[] setki = new String[10];
        setki[0] = "NotDefined";
        setki[1] = "sto";
        setki[2] = "dwieście";
        setki[3] = "trzysta";
        setki[4] = "czterysta";
        setki[5] = "piećset";
        setki[6] = "sześćset";
        setki[7] = "siedemset";
        setki[8] = "osiemset";
        setki[9] = "dziewięćset";


        String[] tysiace = {"tysiąc", "tysiące", "tysięcy"};
        String[] miliony = {"milion", "miliony", "milionów"};
        String[] miliardy = {"miliard", "miliardy", "miliardów"};

        Map<String, Integer> liczba = rozlozLiczbe(number); 
        String napis = "";

        // ===================================== //

        if (isMinus == true) {
            napis += "minus ";
        }
        // ======================= MILIARDY =========================//
        //miliardy
        int mld = liczba.get("miliardy");
        if  (mld != 0) {
            napis += jednosci[mld] + " ";
        }

        if (mld != 0) {
            if (mld == 1)
                napis += miliardy[0] + " ";
            else if (mld == 2 || mld == 2 || mld == 4)
                napis += miliardy[1] + " ";
            else
                napis += miliardy[2] + " "; 

        }

        // ======================= MILIONY =========================//
        int mln = liczba.get("miliony");
        int dmln = liczba.get("dziesiatkimilionow");
        int smln = liczba.get("setkimilionow");

        //setki milionow
        if (smln != 0) {
            napis += setki[smln] + " ";
        }

        //dziesiatki milionow
        if ((dmln != 0 && dmln != 1) || (dmln == 1 && mln == 0)) {
            napis += dziesiatki[dmln] + " ";
        }

        int nastka_wartosc = 0;
        boolean nastka = false;
        if (dmln == 1 && mln != 0) {
            nastka = true;
            nastka_wartosc = dmln * 10 + mln;
            napis += nastki[nastka_wartosc - 11] + " ";
        }

        //jednosci milionow
        if (mln != 0 && nastka == false) {
            napis += jednosci[mln] + " ";
        }


        ///////
        if (smln != 0 && dmln == 0 && mln == 0)
            napis += miliony[2] + " ";
        else if (smln == 0 && dmln != 0 && mln == 0)
            napis += miliony[2] + " ";
        else if (smln == 0 && dmln == 0 && mln != 0) {
            if (mln == 1)
                napis +=  miliony[0] + " ";
            else if (mln == 2 || mln == 3 || mln == 4)
                napis += miliony[1] + " ";
            else
                napis += miliony[2] + " ";
        }
        else if (smln != 0 && dmln != 0 && mln == 0)
            napis += miliony[2] + " ";
        else if (smln == 0 && dmln != 0 && mln != 0) {
            if (nastka == true)
                napis += miliony[2] + " ";
            else {
                if (mln == 2 || mln == 3 || mln == 4)
                    napis += miliony[1] + " ";
                else
                    napis += miliony[2] + " ";
            }
        }
        else if (smln != 0 && dmln == 0 && mln != 0) {
            if (mln == 2 || mln == 3 || mln == 4)
                napis += miliony[1] + " ";
            else
                napis += miliony[2] + " ";
        }
        else if (smln != 0 && dmln != 0 && mln != 0) {
            if (nastka == false) {
                if (mln == 2 || mln == 3 || mln == 4)
                    napis += miliony[1] + " ";
                else
                    napis += miliony[2] + " ";
            }
            else
                napis += miliony[2] + " ";

        }




        // ======================= MILIONY =========================//
        int tys = liczba.get("tysiace");
        int dtys = liczba.get("dziesiatkitysiecy");
        int stys = liczba.get("setkitysiecy");

        //setki tysiecy
        if (stys != 0) {
            napis += setki[stys] + " ";
        }

        //dziesiatki tysiecy
        if ((dtys != 0 && dtys != 1) || (dtys == 1 && tys == 0)) {
            napis += dziesiatki[dtys] + " ";
        }

        nastka_wartosc = 0;
        nastka = false;
        if (dtys == 1 && tys != 0) {
            nastka = true;
            nastka_wartosc = dtys * 10 + tys;
            napis += nastki[nastka_wartosc - 11] + " ";
        }

        //jednosci tysiecy
        if (tys != 0 && nastka == false) {
            napis += jednosci[tys] + " ";
        }

        /////
        if (stys != 0 && dtys == 0 && tys == 0)
            napis += tysiace[2] + " ";
        else if (stys == 0 && dtys != 0 && tys == 0)
            napis += tysiace[2] + " ";
        else if (stys == 0 && dtys == 0 && tys != 0){
            if (tys == 1)
                napis += tysiace[0] + " ";
            else if (tys == 2 || tys == 3 || tys == 4)
                napis += tysiace[1] + " ";
            else
                napis += tysiace[2] + " ";
        }
        else if (stys != 0 && dtys != 0 && tys == 0) {
            napis += tysiace[2] + " ";
        }
        else if (stys == 0 && dtys != 0 && tys != 0){
            if (nastka == true)
                napis += tysiace[2] + " ";
            else {
                if (tys == 2 || tys == 3 || tys == 4)
                    napis += tysiace[1] + " ";
                else
                    napis += tysiace[2] + " ";
            }
        }
        else if (stys != 0 && dtys == 0 && tys != 0) {
            if (tys == 2 || tys == 3 || tys == 4)
                napis += tysiace[1];
            else
                napis += tysiace[2];
        }
        else if (stys != 0 && dtys != 0 && tys != 0) {
            if (nastka == false) {
                if (tys == 2 || tys == 3 || tys == 4)
                    napis += tysiace[1] + " ";
                else
                    napis += tysiace[2] + " ";
            }
            else
                napis += tysiace[2] + " ";

        }

        // ======================= RESZTA =========================//
        int s = liczba.get("setki");
        int d = liczba.get("dziesiatki");
        int j = liczba.get("jednosci");

        //setki
        if (s != 0) {
            napis += setki[s] + " ";
        }

        //dziesiatki
        if ((d != 0 && d != 1) || (d == 1 && j == 0)) {
            napis += dziesiatki[d] + " ";
        }

        nastka_wartosc = 0;
        nastka = false;
        if (d == 1 && j != 0) {
            nastka = true;
            nastka_wartosc = d * 10 + j;
            napis += nastki[nastka_wartosc - 11] + " ";
        }

        //jednosci
        if (j != 0 && nastka == false && minInt == false) {
            napis += jednosci[j] + " ";
        }

        if (minInt== true)
            napis += jednosci[8];

        if (napis.length() == 0)
            napis += "zero";


        return napis;
    }

    public static Map<String, Integer> rozlozLiczbe(int liczba) {
        
        Map<String, Integer> rozklad  = new HashMap<String, Integer>();
        liczba = Math.abs(liczba);

        int iterator = 0;
        int[] num = new int[10];
        while(liczba > 0) {
            num[iterator++] = liczba % 10;
            liczba /= 10;
        }

        rozklad.put("jednosci", num[0]);
        rozklad.put("dziesiatki", num[1]);
        rozklad.put("setki", num[2]);
        rozklad.put("tysiace", num[3]);
        rozklad.put("dziesiatkitysiecy", num[4]);
        rozklad.put("setkitysiecy", num[5]);
        rozklad.put("miliony", num[6]);
        rozklad.put("dziesiatkimilionow", num[7]);
        rozklad.put("setkimilionow", num[8]);
        rozklad.put("miliardy", num[9]);

        return rozklad;


    }

    public static boolean czyInt(String number) {
        Integer max = new Integer(Integer.MAX_VALUE);
        Integer min = new Integer(Integer.MIN_VALUE); 
        if (number.charAt(0) == '-'){
            if (number.compareTo(min.toString()) > 0 && number.length() >= min.toString().length()) {
                System.err.println("ERROR with " + number + " Out of int range");
                return false;
            }
            
        }
        else {
            if (number.compareTo(max.toString()) > 0 && number.length() >= max.toString().length()) {
                System.err.println("ERROR with " + number + " Out of int range");
                return false;
            }
        }

        return true;
    }
}
