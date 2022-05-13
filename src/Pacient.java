public final class Pacient implements Comparable<Pacient>{

    private int cod;
    private String nume;
    private String denumire_sectie;

    public Pacient(int cod, String nume, String denumire_sectie) {
        this.cod = cod;
        this.nume = nume;
        this.denumire_sectie = denumire_sectie;
    }

    public Pacient(String linie) {
        this.cod = Integer.parseInt(linie.split(",")[0]);
        this.nume = linie.split(",")[1];
        this.denumire_sectie = linie.split(",")[2];
    }

    public Pacient(int cod) {
        this.cod = cod;
    }

    public Pacient(int cod, String nume) {
        this.cod = cod;
        this.nume = nume;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDenumire_sectie() {
        return denumire_sectie;
    }

    public void setDenumire_sectie(String denumire_sectie) {
        this.denumire_sectie = denumire_sectie;
    }

    @Override
    public int compareTo(Pacient pacient) {
        return Integer.compare(this.cod, pacient.cod);
    }

    @Override
    public String toString() {
        return "Cod pacient " +
                 + cod +
                " - " + nume;
    }


}
