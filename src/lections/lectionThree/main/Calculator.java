package lections.lectionThree.main;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Резкльтат операции: " + result);
    }
    public static char getOperator() {
        System.out.println("Введите операцию: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Введите число: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте ещё раз.");
            if (scanner.hasNextInt()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка в вводимых данных.");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operation: " + operator);
        }
        return result;
    }

    public static double computeAreaCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}
