package service;

import models.ComplexNumber;
import view.ViewCalculator;

public class CreateComplexNumber {

    public ViewCalculator viewCalculator;

    public CreateComplexNumber(ViewCalculator viewCalculator) {
        this.viewCalculator = viewCalculator;
    }

    public ComplexNumber create() {
        double realPart = viewCalculator.promptDouble("Введите вещественную часть ");
        double imaginaryPart = viewCalculator.promptDouble("Введите мнимую часть ");
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
