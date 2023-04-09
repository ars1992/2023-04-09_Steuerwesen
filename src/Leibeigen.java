public class Leibeigen extends Bauer{
    public Leibeigen(String name, int einkommen) {
        super(name, einkommen);
    }

    @Override
    public int zuVersteuern() {
        return super.zuVersteuern() - 12;
    }
}
