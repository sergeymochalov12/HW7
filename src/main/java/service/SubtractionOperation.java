package service;

import calculator.Operation;
import models.ComplexNumber;
// класс для вычисления разницы двух комплексных чисел Z1 и Z2
public class SubtractionOperation implements Operation {
    private final Logger logger;

    public SubtractionOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String operator() {
        return "-";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber Z1, ComplexNumber Z2) {
        logger.log("Выполняется вычитание чисел " + Z1 + " - " + Z2);
        double resultRealPart = Z1.getRealPart() - Z2.getRealPart();
        double resultImaginaryPart = Z1.getImaginaryPart() - Z2.getImaginaryPart();
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}
