import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        String beenden;
        do{



            System.out.println("Möchten Sie das Programm beenden? (j/n)");
            beenden = eingabe.nextLine();

        }while (beenden.equalsIgnoreCase("j"));
    }
}
