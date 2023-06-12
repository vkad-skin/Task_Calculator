package ru.kata_academy.test.roman_number;

import java.util.List;

public class RomanNumberFunction {

    public static int romanToArabic(String romanNumberLine) {

        List<RomanNumber> romanNumberList = RomanNumber.getRomanNumberList();
        int result = 0;
        int indexList = 0;

        while (indexList < romanNumberList.size() && romanNumberLine.length() > 0) {
            RomanNumber number = romanNumberList.get(indexList);

            if (romanNumberLine.startsWith(number.name())) {
                result += number.getValue();
                romanNumberLine = romanNumberLine.substring(number.name().length());
            } else {
                indexList++;
            }
        }

        return result;
    }

    public static String arabicToRoman(int arabicNumber) throws Exception {
        if (arabicNumber < 1) {
            throw new Exception(" //т.к. в римской системе нет отрицательных чисел.");
        }

        List<RomanNumber> romanNumberList = RomanNumber.getRomanNumberList();
        StringBuilder result = new StringBuilder();
        int indexList = 0;
        while (arabicNumber > 0 && indexList < romanNumberList.size()) {

            if (romanNumberList.get(indexList).getValue() <= arabicNumber) {
                result.append(romanNumberList.get(indexList).name());
                arabicNumber -= romanNumberList.get(indexList).getValue();
            } else {
                indexList++;
            }
        }

        return result.toString();
    }
}
