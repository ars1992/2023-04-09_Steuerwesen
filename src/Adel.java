public class Adel extends Einwohner{

    public Adel(String name, int einkommen) {
        super(name, einkommen);
    }

    @Override
    public int steuer() {
        if(super.steuer() < 20) return 20;
        return super.steuer();
    }
}
