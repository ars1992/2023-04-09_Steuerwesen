public abstract class Einwohner {
    private final String NAME;
    private final int EINKOMMEN;

    public Einwohner(String name, int einkommen) {
        this.NAME = name;
        this.EINKOMMEN = einkommen;
    }

    public int zuVersteuern(){
        return this.EINKOMMEN;
    }

    public int steuer(){
       int steuer = (int) (this.zuVersteuern() * 0.10);
       if (steuer < 1) return 1;
       return steuer;
    }
}
