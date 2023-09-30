import calculator.Calculator;
import service.*;
import models.*;
import view.ViewCalculator;

import java.util.List;

public class Main {
    /**
     * Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
     * Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
      */
    public static void main(String[] args) {
        Logger logger = new Logger();

        ViewCalculator viewCalculator = new ViewCalculator();

       // собираем калькулятор из списка сервисов (+-*/) логгера и "вьюшки"
        Calculator calculator =

                new Calculator(List.of(

                        new SumOperation(logger),
                        new SubtractionOperation(logger),
                        new MultiplyOperation(logger),
                        new DevOperation(logger)),

                        viewCalculator,
                        logger);

        CreateComplexNumber factoryComplexNumber = new CreateComplexNumber(viewCalculator);
        System.out.println("Введите первое число ");
        ComplexNumber firstNumber = factoryComplexNumber.create();
        System.out.println("Введите второе число ");
        ComplexNumber secondNumber = factoryComplexNumber.create();
        calculator.run(firstNumber, secondNumber);

    }
}
