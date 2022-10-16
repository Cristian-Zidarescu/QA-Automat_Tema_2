import java.util.Scanner;
import java.util.Random;
import static java.lang.System.in;

public class Tema_CURS2_Dungeon {
    public static void main(String[] args) {
        Scanner INT = new Scanner(in);
        Random rand = new Random();

        // Variabile ale JUCATORULUI
        int VIATA = 100;
        int atac_Distructiv = 50;
        int sanatate = 3;
        int valoare_Regener = 30;
        int sanse_sanatate = 75;

        // Variabile ale INAMICULUI
        String[] inamici = {"Zombie", "Skelet", "Razboinic", "Asasin"};
        int maxSanatateinamic = 75;
        int inamic_atac_Distructiv = 25;

        boolean running = true;
        System.out.println("Bine ai venit in carcera");

        GAME:
        while (running) {
            System.out.println("...............................................................................");

            int sanatate_Inamic = rand.nextInt(maxSanatateinamic);
            String inamic = inamici[rand.nextInt(inamici.length)];

            System.out.println("\t#" + inamic + " a aparut! #");

            while (sanatate_Inamic > 0) {
                System.out.println("\t Sanatatea ta este " + VIATA);
                System.out.println("\t Sanatatea inamicului " + inamic + " este " + sanatate_Inamic);
                System.out.println("\t\n Ce ai vrea sa faci?");
                System.out.println("\t1. Ataca");
                System.out.println("\t2. Ia sanatate si te faci bine");
                System.out.println("\t3. Paraseste campul de lupta ca esti terminat!");

                String input = INT.nextLine();
                if (input.equals("1")) {
                    // cod pentru atac
                    int deteriorare_inamic = rand.nextInt(atac_Distructiv);
                    int deteriorare_luata = rand.nextInt(inamic_atac_Distructiv);

                    sanatate_Inamic -= deteriorare_inamic;
                    VIATA -= deteriorare_luata;
                    System.out.println("\t L-ai lovit pe " +inamic+ " cu " +deteriorare_inamic+ " vatamare");
                    System.out.println("\t Ai primit " +deteriorare_luata+ " vatamare");

                    if (VIATA < 1 ){
                        System.out.println("\t Ai fost macelarit, este deja mort");
                        break;
                    }

                } else if (input.equals("2")) {
                    // cod pentru luat viata la pachet
                    if (sanatate >0) {
                    VIATA += valoare_Regener;
                    sanatate --;
                        System.out.println("\t Ai consumat o viata, te-ai vindecat cu " + valoare_Regener +
                                "\n\t Acum ai " +VIATA+ " viata " +
                                "\n\t Ti-au ramas " +sanatate+  " VIATA!" );
                    } else {
                        System.out.println("\t Nu mai ai sanatate! Macelareste un inamic ca sa ai sansa sa castigi SANATATE!");
                    }
                } else if (input.equals("3")) {
                    // cod pentru a o lua la fuga peste campie
                    System.out.println("\t Ai fugit de la locul faptei" );
                    continue GAME;
                } else {
                    // cod pentru varianta nevalida
                    System.out.println("\t Comanda invalida" );
                }

            }
            if (VIATA <1 ){
                System.out.println("\t Te-au macelarit bine in temnitza, esti terminat");
                break;

            }

            System.out.println("...............................................................................");
            System.out.println(" # " + inamic + " a fost batut mar! #");
            System.out.println(" Ai " + sanatate + " sanatate . # ");

            if (rand.nextInt( 75) < sanse_sanatate) {
                sanatate++;
                System.out.println(" # Ai castigat o sanatate pt ca l-ai macelarit pe inamicul " + inamic + "!. Bravo # ");
                System.out.println(" # Mai ai " + sanatate + " sanatate. # ");
            }

            System.out.println(" Ce ai vrea sa faci in continuare? ");
            System.out.println("1. Continua macelul");
            System.out.println("2. Termina partida");
            String input = INT.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("\t Comanda invalida" );
                input = INT.nextLine();
            }

            switch(input) {
                case "1": {
                    System.out.println("\t Continuam macelul! " );
                    break;
                }
                case "2": {
                    System.out.println("\n Ai parasit campul de bataie! " );
                    break GAME;
                }
            }
        }
        System.out.println(" ###    Aici se termina jocul dvs.    ### " );
        System.out.println(" Speram ca te-ai distrat bine si jocul a fost frumos" );
        System.out.println(" -------------------------------------------------------------------------------- " );
    }
}
