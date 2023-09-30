package calculator;

import modelCalculator.ComplexNumber;

public interface Operation {
    String key();
    ComplexNumber calculate (ComplexNumber firstNumber, ComplexNumber secondNumber);
}
