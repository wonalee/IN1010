public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol) {
        Celle nyCelle = new Celle();
        if (Math.random() <= 0.3333) {
            nyCelle.settLevende();
        }

        this.rutene[rad][kol] = nyCelle;
    }

    public void fyllMedTilfeldigeCeller() {
        for (int rad = 0; rad < this.antRader; rad++) {
            for (int kol = 0; kol < this.antKolonner; kol++) {
                this.lagCelle(rad, kol);
            }
        }
    }

    public Celle hentCelle(int rad, int kol) {
        boolean erGyldigRad = rad >= 0 && rad < this.antRader;
        boolean erGyldigKol = kol >= 0 && kol < this.antKolonner;

        if (erGyldigRad && erGyldigKol) {
            return this.rutene[rad][kol];
        } else {
            return null;
        }
    }

    public void tegnRutenett() {
        System.out.println("\n".repeat(10));

        for (int rad = 0; rad < this.antRader; rad++) {
            String radString = "";

            for (int kol = 0; kol < this.antKolonner; kol++) {
                radString += rutene[rad][kol].hentStatusTegn();
            }
            System.out.println(radString);
        }
    }

    public void settNaboer(int rad, int kol) {
        for (int naboRad : new int[]{rad-1, rad, rad+1}) {
            for (int naboKol : new int[]{kol - 1, kol, kol + 1}) {
                if (naboRad == rad && naboKol == kol) {
                    // Ikke en nabo
                    continue;
                }

                Celle nabo = this.hentCelle(naboRad, naboKol);
                if (nabo != null) {
                    rutene[rad][kol].leggTilNabo(nabo);
                }
            }
        }
    }

    public void kobleAlleCeller() {
        for (int rad = 0; rad < this.antRader; rad++) {
            for (int kol = 0; kol < this.antKolonner; kol++) {
                this.settNaboer(rad, kol);
            }
        }
    }

    public int antallLevende() {
        int antLevende = 0;

        for (int rad = 0; rad < this.antRader; rad++) {
            for (int kol = 0; kol < this.antKolonner; kol++) {
                if (rutene[rad][kol].erLevende()) {
                    antLevende++;
                }
            }
        }

        return antLevende;
    }
}
