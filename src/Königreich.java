import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Einwohner könig, adel, bauer, leibeigen;
        String beenden;
        do{
            System.out.println("Wählen Sie die Bevölkerungsgruppe");
            System.out.println("1 - König");
            System.out.println("2 - Adel");
            System.out.println("3 - Bauer");
            System.out.println("4 - Leibeigen");
            int bevölgerungsgruppe = eingabe.nextInt();

            System.out.println("Geben Sie den Namen an: ");
            String name = eingabe.next();

            System.out.println("Geben Sie das Einkommen an: ");
            int einkommen = eingabe.nextInt();

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
                default -> {
                    System.out.println("""
                            Abfrage nicht möglich.
                            Ungültige Eingabe.
                            """);
                }
            }

            System.out.println("Möchten Sie das Programm beenden? (j/n)");
            beenden = eingabe.next();

        }while ( ! beenden.equalsIgnoreCase("j"));
    }
}
