package zoojava;

public class mammal extends animal {

    private double period;
    private String coatType;
    private int lactation;


    public void eat() {
        System.out.println("Eating...");
    }

    public mammal() {
    }

    public mammal(double period, String coatType, int lactation) {
        this.period = period;
        this.coatType = coatType;
        this.lactation = lactation;
    }

    public double period() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public String coatType() {
        return coatType;
    }

    public void setCoatType(String coatType) {
        this.coatType = coatType;
    }

    public int lactation() {
        return lactation;
    }

    public void setLactation(int lactation) {
        this.lactation = lactation;
    }
}
