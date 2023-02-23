public class UrunTanımlama {

    private String urunİsmi;
    private String uretici;
    private int urunMiktar;
    private String birim;
    private String raf;

    public UrunTanımlama(String urunİsmi, String uretici, String birim, int urunMiktar, String raf) {
    }


    @Override
    public String toString() {
        return "UrunTanımlama{" +
                "urunİsmi='" + urunİsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + urunMiktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }

    public String getUrunİsmi() {
        return urunİsmi;
    }

    public void setUrunİsmi(String urunİsmi) {
        this.urunİsmi = urunİsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return urunMiktar;
    }

    public void setMiktar(int miktar) {
        this.urunMiktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public UrunTanımlama() {
    }

    public UrunTanımlama(String urunİsmi, String uretici, int miktar, String birim, String raf) {
        this.urunİsmi = urunİsmi;
        this.uretici = uretici;
        this.urunMiktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }
}
