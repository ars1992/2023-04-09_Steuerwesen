public abstract class Einwohner {
    private final String NAME;
    private final int EINKOMMEN;

    public Einwohner(String name, int einkommen) {
        this.NAME = name;
        this.EINKOMMEN = einkommen;
    }

    /**
     * Gibt das Einkommen zurück
     * @return EINKOMMEN
     */
     public int zuVersteuern(){
         return this.EINKOMMEN;
    }

    /**
     * Gibt die zu zahlenden Steuern zurück
     * @return berechneteSteuer
     */
    public int steuer(){
       int berechneteSteuer = (int) (this.zuVersteuern() * 0.10);
       if (berechneteSteuer < 1) return 1;
       return berechneteSteuer;
    }
}
