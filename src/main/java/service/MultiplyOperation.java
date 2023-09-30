package service;

import calculator.Operation;
import modelCalculator.ComplexNumber;

public class MultiplyOperation implements Operation {

    private final Logger logger;

    public MultiplyOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String key() {
        return "*";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber firstNumber, ComplexNumber secondNumber) {
        logger.log("Выполняется умножение чисел " + firstNumber + " * " + secondNumber);
        double a = firstNumber.getRealPart();
        double b = firstNumber.getImaginaryPart();
        double c = firstNumber.getRealPart();
        double d = firstNumber.getImaginaryPart();
        double resultRealPart = a * c - b * d;
        double resultImaginaryPart = a * d + b * c;
        return new ComplexNumber(resultRealPart, resultImaginaryPart);

    }
}
