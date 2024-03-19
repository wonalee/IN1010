public class Celle {
    boolean status;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;
    boolean levende;

    public Celle() {
        // Konstruktoer for klassen som oppretter cellen med status doed
        this.status = false;
        this.levende = status;
        // Instansvariablene naboer som settes lik en array med aatte elementer
        this.naboer = new Celle[8];
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
    }

    // Metoden settDoed tar ikke noen parameter men setter statusen til cellen til doed
    public void settDoed() {
        this.status = false;
        this.levende = status;
    }

    // Metoden settLevende tar ikke noen parameter men setter statusen til cellen til levende
    public void settLevende() {
        this.status = true;
        this.levende = status;
    }

    //Metoden erLevende returnerer cellens status
    public boolean erLevende() {
        return this.status;
    }

    // Metoden hentStatusTegn returnerer en char-verdi som er en tegnrepresentasjon av cellens
    // status til buk i tegning av brettet
    public char hentStatusTegn() {
        if (this.status == true) return 'O';
        else return '.';
    }

    // Metoden leggTilNabo har en instans av klassen Celle som parameter (nabo) og legger nabo
    // til arrayen naboer og oeker antNaboer
    public void leggTilNabo(Celle nabo) {
        this.naboer[antNaboer] = nabo;
        antNaboer++;
    }

    // Metoden tellLevendeNaboer gaar gjennom naboer og teller antall levende naboer
    public void tellLevendeNaboer() {
        int teller = 0;
        for (int i = 0; i < antNaboer; i++) {
            if (naboer[i].erLevende()) {
                teller++;
            }
        }
        this.antLevendeNaboer = teller;
    }

    public void oppdaterStatus() {
        if (this.erLevende()) {

            if (this.antLevendeNaboer < 2 || this.antLevendeNaboer > 3) {
                settDoed();
            }
        }
        else {
            if (this.antLevendeNaboer == 3) {
                settLevende();
                }
        }
    }
}
