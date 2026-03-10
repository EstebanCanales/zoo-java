package zoojava;

public class elefante extends mammal {

    private double tamanhoOrejaIzquierda;
    private double tamanhoOrejaDerecha;
    private double tamanhoColmilloIzquierda;
    private double tamanhoColmilloDerecha;
    private double tamanhoTrompa;

    public elefante(double tamanhoOrejaIzquierda, double tamanhoOrejaDerecha, double tamanhoColmilloIzquierda, double tamanhoColmilloDerecha, double tamanhoTrompa) {
        this.tamanhoOrejaIzquierda = tamanhoOrejaIzquierda;
        this.tamanhoOrejaDerecha = tamanhoOrejaDerecha;
        this.tamanhoColmilloIzquierda = tamanhoColmilloIzquierda;
        this.tamanhoColmilloDerecha = tamanhoColmilloDerecha;
        this.tamanhoTrompa = tamanhoTrompa;
    }

    public elefante(double period, String coatType, int lactation, double tamanhoOrejaIzquierda, double tamanhoOrejaDerecha, double tamanhoColmilloIzquierda, double tamanhoColmilloDerecha, double tamanhoTrompa) {
        super(period, coatType, lactation);
        this.tamanhoOrejaIzquierda = tamanhoOrejaIzquierda;
        this.tamanhoOrejaDerecha = tamanhoOrejaDerecha;
        this.tamanhoColmilloIzquierda = tamanhoColmilloIzquierda;
        this.tamanhoColmilloDerecha = tamanhoColmilloDerecha;
        this.tamanhoTrompa = tamanhoTrompa;
    }

    public double tamanhoOrejaIzquierda() {
        return tamanhoOrejaIzquierda;
    }

    public void setTamanhoOrejaIzquierda(double tamanhoOrejaIzquierda) {
        this.tamanhoOrejaIzquierda = tamanhoOrejaIzquierda;
    }

    public double tamanhoOrejaDerecha() {
        return tamanhoOrejaDerecha;
    }

    public void setTamanhoOrejaDerecha(double tamanhoOrejaDerecha) {
        this.tamanhoOrejaDerecha = tamanhoOrejaDerecha;
    }

    public double tamanhoColmilloIzquierda() {
        return tamanhoColmilloIzquierda;
    }

    public void setTamanhoColmilloIzquierda(double tamanhoColmilloIzquierda) {
        this.tamanhoColmilloIzquierda = tamanhoColmilloIzquierda;
    }

    public double tamanhoColmilloDerecha() {
        return tamanhoColmilloDerecha;
    }

    public void setTamanhoColmilloDerecha(double tamanhoColmilloDerecha) {
        this.tamanhoColmilloDerecha = tamanhoColmilloDerecha;
    }

    public double tamanhoTrompa() {
        return tamanhoTrompa;
    }

    public void setTamanhoTrompa(double tamanhoTrompa) {
        this.tamanhoTrompa = tamanhoTrompa;
    }
}
