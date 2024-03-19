public class Verden {
    Rutenett rutenett;
    int genNr;

    Verden(int rader, int kolonner) {
        this.rutenett = new Rutenett(rader, kolonner);
        this.rutenett.fyllMedTilfeldigeCeller();
        this.rutenett.kobleAlleCeller();
        this.genNr = 0;
    }

    public void tegn() {
        this.rutenett.tegnRutenett();
        System.out.println("Generasjon: " + this.genNr);
        System.out.println("Ant. levende celler: " + this.rutenett.antallLevende());
    }

    public void oppdatering() {
        for (int rad = 0; rad < this.rutenett.antRader; rad++) {
            for (int kol = 0; kol < this.rutenett.antKolonner; kol++) {
                this.rutenett.hentCelle(rad, kol).oppdaterStatus();
            }
        }
        this.genNr++;
    }
}
