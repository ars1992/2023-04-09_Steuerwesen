import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        do{
            int bevölgerungsgruppe = bevölgerungsgruppe();
            if ( ! eingabeGültig(bevölgerungsgruppe)) continue;

            System.out.println("Geben Sie den Namen an: ");
            String name = eingabe.next();

            System.out.println("Geben Sie das Einkommen an: ");
            int einkommen = eingabe.nextInt();

            ausgabeSteuern(bevölgerungsgruppe, name, einkommen);

        }while ( ! beenden().equalsIgnoreCase("j"));
    }

    public static int bevölgerungsgruppe(){
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Wählen Sie die Bevölkerungsgruppe");
        System.out.println("1 - König");
        System.out.println("2 - Adel");
        System.out.println("3 - Bauer");
        System.out.println("4 - Leibeigen");
        return eingabe.nextInt();
    }

    public static String beenden(){
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Möchten Sie das Programm beenden? (j/n)");
        return eingabe.next();
    }

    public static boolean eingabeGültig(int bevölgerungsgruppe){
        int anzahlBevölkerungsGruppen = 4;
        if (bevölgerungsgruppe < 0 || bevölgerungsgruppe > anzahlBevölkerungsGruppen){
            System.out.println("""
                            Abfrage nicht möglich.
                            Ungültige Eingabe.
                            """);
            return false;
        }
        return true;
    }

    public static void ausgabeSteuern(int bevölgerungsgruppe, String name, int einkommen){
        Einwohner könig, adel, bauer, leibeigen;
        switch (bevölgerungsgruppe) {
            case 1 -> {
                könig = new König(name, einkommen);
                System.out.println(könig.steuer());
            }
            case 2 -> {
                adel = new Adel(name, einkommen);
                System.out.println(adel.steuer());
            }
            case 3 -> {
                bauer = new Bauer(name, einkommen);
                System.out.println(bauer.steuer());
            }
            case 4 -> {
                leibeigen = new Leibeigen(name, einkommen);
                System.out.println(leibeigen.steuer());
            }
        }
    }
}
