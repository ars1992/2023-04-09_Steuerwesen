public abstract class Einwohner {
    private String name;
    private int einkommen;

    public Einwohner(String name, int einkommen) {
        this.name = name;
        this.einkommen = einkommen;
    }

    public int zuVersteuern(){
        return this.einkommen;
    }

    public int steuer(){
       int steuer = (int) (this.zuVersteuern() * 0.10);
       if (steuer < 1) return 1;
       return steuer;
    }
}
