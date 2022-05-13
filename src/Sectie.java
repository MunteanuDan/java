public class Sectie implements Comparable<Sectie>{

    private String denumireSectie;
    public int numarPacienti;

    public Sectie(String denumireSectie) {
        this.denumireSectie = denumireSectie;
    }

    public String getDenumireSectie() {
        return denumireSectie;
    }

    @Override
    public int compareTo(Sectie sectie) {
        return -Integer.compare(this.numarPacienti, sectie.numarPacienti);
    }

    @Override
    public String toString() {
        return denumireSectie + " - " + numarPacienti + " pacienti";
    }
}
