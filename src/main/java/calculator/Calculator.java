package calculator;

import models.ComplexNumber;
import service.Logger;
import view.ViewCalculator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculator {
    private final Map<String, Operation> operationMap;
    private final ViewCalculator viewCalculator;
    private final Logger logger;

    /**
     * Конструктор класса собирающий сервисы вычислений в Мар по ключу операции
     */
    public Calculator(List<Operation> allOperation, ViewCalculator viewCalculator, Logger logger)
    {
        operationMap = allOperation.stream().collect(Collectors.toMap(Operation::operator, Function.identity()));
        this.viewCalculator = viewCalculator;
        this.logger = logger;
    }

    /**
     * Метод определяющий переданную операцию и направляющий комплексные числа в определенный сервис для вычислений
     */
    public ComplexNumber calculate(ComplexNumber Z1, ComplexNumber Z2, String operationKey) throws UnsupportedOperationException {
        Operation operation = operationMap.get(operationKey);
        if (operation != null) {
            return operation.calculate(Z1, Z2);
        }
        throw new UnsupportedOperationException();
    }

    public void run(ComplexNumber Z1, ComplexNumber Z2) {
        String opr = viewCalculator.prompt("Введите выполняемую операцию ").trim();
        logger.log("Передаем для вычисления выражение" + Z1 + " " + opr + " " + Z2);
        try {
            String message = "РЕЗУЛЬТАТ  " + Z1 + " " + opr + " " + Z2 + " = "
                    + calculate(Z1, Z2, opr);
            viewCalculator.sendMessage(message);
            logger.log(message);
        } catch (UnsupportedOperationException e) {
            String msg = "Введенная операция не поддерживается";
            viewCalculator.sendMessage(msg);
            logger.log(msg);
        }
    }
}


