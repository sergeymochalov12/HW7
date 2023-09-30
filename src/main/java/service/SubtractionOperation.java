package service;

import calculator.Operation;
import modelCalculator.ComplexNumber;

public class SubtractionOperation implements Operation {
    private final Logger logger;

    public SubtractionOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String key() {
        return "-";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber firstNumber, ComplexNumber secondNumber) {
        logger.log("Выполняется вычитание чисел " + firstNumber + " - " + secondNumber);
        double resultRealPart = firstNumber.getRealPart() - secondNumber.getRealPart();
        double resultImaginaryPart = firstNumber.getImaginaryPart() - secondNumber.getImaginaryPart();
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}
