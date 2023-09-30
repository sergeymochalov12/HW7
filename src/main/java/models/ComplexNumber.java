package models;
// Каласс описывающий объект КОМПЛЕКСНОЕ ЧИСЛО

public class ComplexNumber {
   private final double realPart; // значение вещественной части

   private final double imaginaryPart;// значение мнимой части

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    // геттер вещественной части
    public double getRealPart() {
        return realPart;
    }

    // геттер мнимой части
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return  realPart + "+" + imaginaryPart + "i";
    }
}
