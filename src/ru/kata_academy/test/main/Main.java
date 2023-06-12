package ru.kata_academy.test.main;

import ru.kata_academy.test.calculator.Calc;
import ru.kata_academy.test.calculator.Calculator;
import ru.kata_academy.test.roman_number.RomanNumberFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = readMathExample();
        System.out.println(cal(input));
    }

    public static String cal(String input) throws Exception {

        String[] arithmeticExample = input.split(" ");
        exampleCorrectness(arithmeticExample);
        boolean isArabicNumber = isArabicNumber(arithmeticExample);
        int number1;
        int number2;
        int result = 0;

        if (isArabicNumber) {
            number1 = Integer.parseInt(arithmeticExample[0]);
            number2 = Integer.parseInt(arithmeticExample[2]);
        } else {
            number1 = RomanNumberFunction.romanToArabic(arithmeticExample[0]);
            number2 = RomanNumberFunction.romanToArabic(arithmeticExample[2]);
        }

        correctnessNumbers(number1, number2);
        Calc calc = Calculator.getCalculator();
        switch (arithmeticExample[1]) {
            case "+":
                result = calc.sum(number1, number2);
                break;
            case "-":
                result = calc.subtraction(number1, number2);
                break;
            case "*":
                result = calc.multiplication(number1, number2);
                break;
            case "/":
                result = calc.division(number1, number2);
                break;
            default:

                throw new Exception("//т.к. формат математической операции не удовлетворяет заданию.");
        }

        if (isArabicNumber) {
            return String.valueOf(result);
        } else {
            return RomanNumberFunction.arabicToRoman(result);
        }

    }

    public static String readMathExample() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e + "Ошибка ввода!");
        }
    }

    public static void exampleCorrectness(String[] arithmeticExample) throws Exception {

        Pattern mathematicalOperator = Pattern.compile("^[+|\\-|*|/]$");
        Pattern arabicNumber = Pattern.compile("^\\d{1,2}$");
        Pattern romanNumber = Pattern.compile("^M{0,3}(X|IX|IV|V?I{0,3})?$");

        if (arithmeticExample.length > 3) {

            if (arithmeticExample[3].matches(mathematicalOperator.pattern())) {
                throw new Exception("//т.к. формат математической операции не удовлетворяет заданию." +
                        " - два операнда и один оператор (+, -, /,*).");
            } else {
                throw new Exception("//т.к. формат математической операции не удовлетворяет заданию.");
            }

        } else if (arithmeticExample.length < 3) {
            throw new Exception("//т.к. строка не является математической операцией.");

        } else if (arithmeticExample.length == 3) {

            if (!arithmeticExample[1].matches(mathematicalOperator.pattern())) {
                throw new Exception("//т.к. формат математической операции не удовлетворяет заданию." +
                        " Не соотвествует оператору (+, -, /,*).");

            } else if ((!arithmeticExample[0].matches(arabicNumber.pattern()))
                    && (arithmeticExample[2].matches(arabicNumber.pattern()))
                    ||
                    ((arithmeticExample[0].matches(arabicNumber.pattern()))
                            && (!arithmeticExample[2].matches(arabicNumber.pattern())))) {

                if ((arithmeticExample[0].matches(romanNumber.pattern()))
                        || (arithmeticExample[2].matches(romanNumber.pattern()))) {
                    throw new Exception("//т.к. используются одновременно разные системы счисления.");

                } else {
                    throw new Exception("//т.к. используются не верные данные.");
                }
            }
        }

    }

    public static void correctnessNumbers(int number1, int number2) throws Exception {
        if (number1 > 10 || number2 > 10) {
            throw new Exception("//т.к. введенные числа n больше 10 (n <= 10).");
        }
    }

    public static boolean isArabicNumber(String[] arithmeticExample) {
        Pattern arabicNumber = Pattern.compile("^\\d{1,2}$");

        if ((arithmeticExample[0].matches(arabicNumber.pattern()))
                && (arithmeticExample[0].matches(arabicNumber.pattern()))) {
            return true;
        } else {
            return false;
        }
    }
}
