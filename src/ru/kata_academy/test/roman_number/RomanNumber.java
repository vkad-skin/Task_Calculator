package ru.kata_academy.test.roman_number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum RomanNumber {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private int value;

    private RomanNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumber> getRomanNumberList() {
        List<RomanNumber> romanNumberList = Arrays.asList(values());
        Collections.reverse(romanNumberList);
        return romanNumberList;
    }

}
