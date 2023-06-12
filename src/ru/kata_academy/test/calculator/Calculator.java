package ru.kata_academy.test.calculator;

public class Calculator implements Calc {

    private static Calculator calculator;
    private Calculator() {

    }

    public static Calculator getCalculator() {

        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    @Override
    public int sum(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public int subtraction(int value1, int value2) {
        return value1 - value2;
    }

    @Override
    public int multiplication(int value1, int value2) {
        return value1 * value2;
    }

    @Override
    public int division(int value1, int value2) {
        return value1 / value2;
    }
}
