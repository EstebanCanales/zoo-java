package zoojava;

public class leon extends mammal {

    private double tamMelena;
    private double decibelesRugido;
    private boolean esAlfa;

    public leon(double tamMelena, double decibelesRugido, boolean esAlfa) {
        this.tamMelena = tamMelena;
        this.decibelesRugido = decibelesRugido;
        this.esAlfa = esAlfa;
    }

    public leon(double period, String coatType, int lactation, double tamMelena, double decibelesRugido, boolean esAlfa) {
        super(period, coatType, lactation);
        this.tamMelena = tamMelena;
        this.decibelesRugido = decibelesRugido;
        this.esAlfa = esAlfa;
    }

    public double getTamMelena() {
        return tamMelena;
    }

    public void setTamMelena(double tamMelena) {
        this.tamMelena = tamMelena;
    }

    public double getDecibelesRugido() {
        return decibelesRugido;
    }

    public void setDecibelesRugido(double decibelesRugido) {
        this.decibelesRugido = decibelesRugido;
    }

    public boolean isEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(boolean esAlfa) {
        this.esAlfa = esAlfa;
    }
}
