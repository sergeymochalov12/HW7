package service;


import calculator.Operation;
import modelCalculator.ComplexNumber;

public class SumOperation implements Operation {
    private final Logger logger;

    public SumOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String key() {
        return "+";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber firstNumber, ComplexNumber secondNumber) {
        logger.log("Выполняется сложение чисел " + firstNumber + " + " + secondNumber);
        double resultRealPart = firstNumber.getRealPart() + secondNumber.getRealPart();
        double resultImaginaryPart = firstNumber.getImaginaryPart() + secondNumber.getImaginaryPart();
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}
