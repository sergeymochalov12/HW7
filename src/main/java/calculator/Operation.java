package calculator;

import models.ComplexNumber;

public interface Operation {
    String operator();
    ComplexNumber calculate (ComplexNumber Z1, ComplexNumber Z2);
}
