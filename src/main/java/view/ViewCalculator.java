package view;

import java.util.Scanner;

public class ViewCalculator {


    public ViewCalculator() {

    }
    // метод для отправки сообщения пользователю
    public void sendMessage(String message) {
        System.out.println(message);
    }

    // метод ввода команды
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
     * Метод корректного ввода типа double
     */
    public double promptDouble(String message) {
        double result;
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        try {
            result = Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа. Введите число еще раз");
            result = promptDouble(message);
        }
        return result;
    }
}
