package service;

import calculator.Operation;
import models.ComplexNumber;
// класс для вычисления произведения двух комплексных чисел Z1 и Z2
public class MultiplyOperation implements Operation {

    private final Logger logger;

    public MultiplyOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String operator() {
        return "*";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber Z1, ComplexNumber Z2) {
        logger.log("Выполняется умножение чисел " + Z1 + " * " + Z2);


        double resultRealPart = Z1.getRealPart() * Z2.getRealPart() - Z1.getImaginaryPart() * Z2.getImaginaryPart();
        double resultImaginaryPart = Z1.getRealPart() * Z2.getImaginaryPart() + Z1.getImaginaryPart() * Z2.getRealPart();

        return new ComplexNumber(resultRealPart, resultImaginaryPart);

    }
}
