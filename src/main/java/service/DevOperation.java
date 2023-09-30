package service;
import calculator.Operation;
import models.ComplexNumber;

// класс для деления  двух комплексных чисел Z1 / Z2
public class DevOperation implements Operation {

    private final Logger logger;

    public DevOperation(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String operator() {
        return "/";
    }

    @Override
    public ComplexNumber calculate(ComplexNumber Z1, ComplexNumber Z2) {
        logger.log("Выполняется деление чисел " + Z1 + " / " + Z2);

        double denominator = Z2.getRealPart() * Z2.getRealPart() + Z2.getImaginaryPart() * Z2.getImaginaryPart();

        double resultRealPart = (Z1.getRealPart() * Z2.getRealPart() + Z1.getImaginaryPart() * Z2.getImaginaryPart()) / denominator;
        double resultImaginaryPart = (Z1.getImaginaryPart() * Z2.getRealPart() - Z1.getRealPart() * Z2.getImaginaryPart()) / denominator;
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}



