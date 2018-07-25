public class Polynomial {
    private int coefficient;
    private int exponent;
    public Polynomial() {
    }
    public Polynomial(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public int getCoefficient() {
        return coefficient;
    }
    public int getExponent() {
        return exponent;
    }
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    public void setExp(int exponent) {
         this.exponent = exponent;
    }
}