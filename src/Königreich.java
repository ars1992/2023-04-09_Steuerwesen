import java.util.InputMismatchException;
import java.util.Scanner;

public class Königreich {
    public static Scanner eingabe = new Scanner(System.in);

    /**
     * Bei änderungen von Bevölkerungsgruppen muss dieses Array abgändert werden
     * und das Array in ausgabeSteuern.
     */
    public static String[] bevölkerungsgruppen = new String[]{"König", "Adel", "Bauer", "Leibeigen"};

    public static void main(String[] args) {
        do{
            int bevölkerungsgruppe = bevölkerungsgruppe();
            if ( ! eingabeGültig(bevölkerungsgruppe)) continue;

            System.out.println("Geben Sie den Namen an: ");
            String name = eingabe.next();

            ausgabeSteuern(bevölkerungsgruppe, name, abfrageEinkommen());

        }while ( ! beenden().equalsIgnoreCase("j"));
    }

    /**
     * Dient zur bestimmung der Bevölgerungsgruppe durch den User
     * @return Art der Bevölkerungsgruppe
     */
    public static int bevölkerungsgruppe(){
        System.out.println("Wählen Sie eine Bevölkerungsgruppe");
        for (int i = 0; i < bevölkerungsgruppen.length; i++) {
            System.out.println((i + 1) + " - " + bevölkerungsgruppen[i]);
        }
        return eingabe.nextInt();
    }

    /**
     * Prüft ob Eingabe des Users valide ist
     * @param bevölkerungsgruppe
     * @return true bei valider eingabe
     */
    public static boolean eingabeGültig(int bevölkerungsgruppe){
        int anzahlBevölkerungsGruppen = bevölkerungsgruppen.length;
        if (bevölkerungsgruppe < 0 || bevölkerungsgruppe > anzahlBevölkerungsGruppen){
            System.out.println("""
                            Abfrage nicht möglich.
                            Ungültige Eingabe.
                            """);
            return false;
        }
        return true;
    }

    /**
     * Überprüft ob eingabe des Users eine gültige Zahl ist
     * @return einkommen
     */
    public static int abfrageEinkommen(){
        System.out.println("Geben Sie das Einkommen an: ");
        boolean eingabeNichtOk = true;
        int einkommen = 0;
        do {
            try {
                einkommen = eingabe.nextInt();
                eingabeNichtOk = false;
            } catch (InputMismatchException e) {
                eingabe.next();
                System.out.println("Fehlerhafte Eingabe");
                System.out.println("Geben Sie erneut das Einkommen an: ");
            }
        }while (eingabeNichtOk);
        return einkommen;
    }

    /**
     * Gibt die gewünschten Steuern aus
     * Welche der User abfrägt.
     * @param bevölkerungsgruppe
     * @param name
     * @param einkommen
     */
    public static void ausgabeSteuern(int bevölkerungsgruppe, String name, int einkommen){
        Einwohner[] gruppen = new Einwohner[]{
                new König(name, einkommen),
                new Adel(name, einkommen),
                new Bauer(name ,einkommen),
                new Leibeigen(name, einkommen)
        };
        for (int i = 0; i < bevölkerungsgruppen.length; i++) {
            if((i + 1) == bevölkerungsgruppe){
                System.out.println("Bevölkerungsgruppe: " + bevölkerungsgruppen[i]);
                System.out.println("Name: " + name);
                System.out.println("Einkommen: " + einkommen);
                System.out.println("Die Steuern betragen: " + gruppen[i].steuer() + " Taller");
            }
        }
    }

    /**
     * Dient zur Abfrage des Users ob das Programm beendet werden soll
     * @return eingabe des Users
     */
    public static String beenden(){
        System.out.println("Möchten Sie das Programm beenden? (j/n)");
        return eingabe.next();
    }
}
