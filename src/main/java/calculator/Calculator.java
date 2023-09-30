package calculator;

import modelCalculator.ComplexNumber;
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
     * Конструктор класса собирающий сервисы вычислений в Мар по ключу операции при реализации Spring  (ветка Spring)сам
     * собирает нужные сервисы в List. В результате добавления операций не нарушаеться принцип ОСР
     */
    public Calculator(List<Operation> allOperation, ViewCalculator viewCalculator, Logger logger) {
        operationMap = allOperation.stream()
                .collect(Collectors.toMap(Operation::key, Function.identity()));
        this.viewCalculator = viewCalculator;
        this.logger = logger;
    }

    /**
     * Метод определяющий переданную операцию и направляющий комплексные числа в определенный сервис для вычислений
     */
    public ComplexNumber calculate(ComplexNumber firstNumber, ComplexNumber secondNumber, String operationKey) throws UnsupportedOperationException {
        Operation operation = operationMap.get(operationKey);
        if (operation != null) {
            return operation.calculate(firstNumber, secondNumber);
        }
        throw new UnsupportedOperationException();
    }

    public void run(ComplexNumber firstNumber, ComplexNumber secondNumber) {
        String opr = viewCalculator.prompt("Введите выполняемую операцию ").trim();
        logger.log("Передаем для вычисления выражение" + firstNumber + " " + opr + " " + secondNumber);
        try {
            String message = "Результат вычмслений " + firstNumber + " " + opr + " " + secondNumber + " = "
                    + calculate(firstNumber, secondNumber, opr);
            viewCalculator.sendMessage(message);
            logger.log(message);
        } catch (UnsupportedOperationException e) {
            String msg = "Введенная операция не поддерживается";
            viewCalculator.sendMessage(msg);
            logger.log(msg);
        }
    }
}


