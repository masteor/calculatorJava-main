package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("должен корректно вычислять выражения с арабскими цифрами")
    void calculate() {

        Calculator calc = new Calculator();

        assertAll(
                () -> assertEquals("10", calc.calculate("10 / 1")),
                () -> assertEquals("0", calc.calculate("1 / 10")),
                () -> assertEquals("11", calc.calculate("10 + 1")),
                () -> assertEquals("11", calc.calculate("1 + 10")),
                () -> assertEquals("9", calc.calculate("10 - 1")),
                () -> assertEquals("-9", calc.calculate("1 - 10")),
                () -> assertEquals("100", calc.calculate("10 * 10")),
                () -> assertEquals("1", calc.calculate("1 * 1")),
                () -> assertEquals("6", calc.calculate("2 * 3")),
                () -> assertEquals("101", calc.calculate("100 + 1")),

                () -> assertNull(calc.calculate("")),
                () -> assertNull(calc.calculate(" ".repeat(1))),
                () -> assertNull(calc.calculate(" ".repeat(2))),
                () -> assertNull(calc.calculate(" ".repeat(3))),
                () -> assertNull(calc.calculate(null))
        );
    }

    @Test
    @DisplayName("должен определять допустимые арифметические выражения с арабскими цифрами")
    void IsArabicExpression() {

        Calculator calc = new Calculator();

        assertAll(
                () -> assertTrue(calc.IsArabicExpression("1 / 10")),
                () -> assertTrue(calc.IsArabicExpression("2 / 10")),
                () -> assertTrue(calc.IsArabicExpression("3 / 10")),
                () -> assertTrue(calc.IsArabicExpression("4 / 10")),
                () -> assertTrue(calc.IsArabicExpression("5 / 10")),
                () -> assertTrue(calc.IsArabicExpression("6 / 10")),
                () -> assertTrue(calc.IsArabicExpression("7 / 10")),
                () -> assertTrue(calc.IsArabicExpression("8 / 10")),
                () -> assertTrue(calc.IsArabicExpression("9 / 10")),

            () -> assertTrue(calc.IsArabicExpression("10 / 1")),
                () -> assertTrue(calc.IsArabicExpression("10 / 2")),
                () -> assertTrue(calc.IsArabicExpression("10 / 3")),
                () -> assertTrue(calc.IsArabicExpression("10 / 4")),
                () -> assertTrue(calc.IsArabicExpression("10 / 5")),
                () -> assertTrue(calc.IsArabicExpression("10 / 6")),
                () -> assertTrue(calc.IsArabicExpression("10 / 7")),
                () -> assertTrue(calc.IsArabicExpression("10 / 8")),
                () -> assertTrue(calc.IsArabicExpression("10 / 9")),

                () -> assertTrue(calc.IsArabicExpression("10 / 10")),

            () -> assertTrue(calc.IsArabicExpression("10 + 1")),
            () -> assertTrue(calc.IsArabicExpression("1 + 10")),
            () -> assertTrue(calc.IsArabicExpression("10 - 1")),
            () -> assertTrue(calc.IsArabicExpression("1 - 10")),
            () -> assertTrue(calc.IsArabicExpression("10 * 10")),
            () -> assertTrue(calc.IsArabicExpression("1 * 1")),
            () -> assertTrue(calc.IsArabicExpression("2 * 3")),


                () -> assertFalse(calc.IsArabicExpression("10 ** 1")),
                () -> assertFalse(calc.IsArabicExpression("10 **1")),
                () -> assertFalse(calc.IsArabicExpression("10**1")),
                () -> assertFalse(calc.IsArabicExpression("10** 1")),
                () -> assertFalse(calc.IsArabicExpression("")),
                () -> assertFalse(calc.IsArabicExpression(null)),
                () -> assertFalse(calc.IsArabicExpression(" ")),
                () -> assertFalse(calc.IsArabicExpression("  ")),
                () -> assertFalse(calc.IsArabicExpression("2*3")),
                () -> assertFalse(calc.IsArabicExpression(" * 3")),
                () -> assertFalse(calc.IsArabicExpression("2 * ")),
                () -> assertFalse(calc.IsArabicExpression("2")),
                () -> assertFalse(calc.IsArabicExpression(" * ")),
                () -> assertFalse(calc.IsArabicExpression(" 3")),
                () -> assertFalse(calc.IsArabicExpression("2 ")),
                () -> assertFalse(calc.IsArabicExpression("2 ^ 3")),
                () -> assertFalse(calc.IsArabicExpression("2 & 3")),
                () -> assertFalse(calc.IsArabicExpression("11 + 1")),
                () -> assertFalse(calc.IsArabicExpression("1 + 11")),
                () -> assertFalse(calc.IsArabicExpression("0 + 10")),
                () -> assertFalse(calc.IsArabicExpression("10 + 0"))
        );
    }

    @Test
    @DisplayName("должен определять допустимые арифметические выражения с римскими цифрами")
    void IsRomanExpression() {

        Calculator calc = new Calculator();

        assertAll(
                () -> assertTrue(calc.IsRomanExpression("I / X")),
                () -> assertTrue(calc.IsRomanExpression("II / X")),
                () -> assertTrue(calc.IsRomanExpression("III / X")),
                () -> assertTrue(calc.IsRomanExpression("IV / X")),
                () -> assertTrue(calc.IsRomanExpression("V / X")),
                () -> assertTrue(calc.IsRomanExpression("VI / X")),
                () -> assertTrue(calc.IsRomanExpression("VII / X")),
                () -> assertTrue(calc.IsRomanExpression("VIII / X")),
                () -> assertTrue(calc.IsRomanExpression("IX / X")),

                () -> assertTrue(calc.IsRomanExpression("X / I")),
                () -> assertTrue(calc.IsRomanExpression("X / II")),
                () -> assertTrue(calc.IsRomanExpression("X / III")),
                () -> assertTrue(calc.IsRomanExpression("X / IV")),
                () -> assertTrue(calc.IsRomanExpression("X / V")),
                () -> assertTrue(calc.IsRomanExpression("X / VI")),
                () -> assertTrue(calc.IsRomanExpression("X / VII")),
                () -> assertTrue(calc.IsRomanExpression("X / VIII")),
                () -> assertTrue(calc.IsRomanExpression("X / IX")),

                () -> assertTrue(calc.IsRomanExpression("X / X")),

                () -> assertTrue(calc.IsRomanExpression("X + I")),
                () -> assertTrue(calc.IsRomanExpression("I + X")),
                () -> assertTrue(calc.IsRomanExpression("X - I")),
                () -> assertTrue(calc.IsRomanExpression("I - X")),
                () -> assertTrue(calc.IsRomanExpression("X * X")),
                () -> assertTrue(calc.IsRomanExpression("I * I")),
                () -> assertTrue(calc.IsRomanExpression("II * III")),


                () -> assertFalse(calc.IsRomanExpression("X ** I")),
                () -> assertFalse(calc.IsRomanExpression("")),
                () -> assertFalse(calc.IsRomanExpression(null)),
                () -> assertFalse(calc.IsRomanExpression(" ")),
                () -> assertFalse(calc.IsRomanExpression("  ")),
                () -> assertFalse(calc.IsRomanExpression("II*III")),
                () -> assertFalse(calc.IsRomanExpression(" * III")),
                () -> assertFalse(calc.IsRomanExpression("II * ")),
                () -> assertFalse(calc.IsRomanExpression("II")),
                () -> assertFalse(calc.IsRomanExpression(" * ")),
                () -> assertFalse(calc.IsRomanExpression(" III")),
                () -> assertFalse(calc.IsRomanExpression("II ")),
                () -> assertFalse(calc.IsRomanExpression("II ^ III")),
                () -> assertFalse(calc.IsRomanExpression("II & III")),
                () -> assertFalse(calc.IsRomanExpression("XI + I")),
                () -> assertFalse(calc.IsRomanExpression("I + XI"))
        );
    }


    @Test
    @DisplayName("должен преобразовать строку с римскими символами в строку с арабскими символами")
    void convertRomanToArabic() {

        Calculator calc = new Calculator();

        assertAll(
                () -> assertEquals("1", calc.convertRomanToArabic("I")),
                () -> assertEquals("2", calc.convertRomanToArabic("II")),
                () -> assertEquals("3", calc.convertRomanToArabic("III")),
                () -> assertEquals("4", calc.convertRomanToArabic("IV")),
                () -> assertEquals("5", calc.convertRomanToArabic("V")),
                () -> assertEquals("6", calc.convertRomanToArabic("VI")),
                () -> assertEquals("7", calc.convertRomanToArabic("VII")),
                () -> assertEquals("8", calc.convertRomanToArabic("VIII")),
                () -> assertEquals("9", calc.convertRomanToArabic("IX")),
                () -> assertEquals("10", calc.convertRomanToArabic("X")),

                () -> assertEquals("1 / 10", calc.convertRomanToArabic("I / X")),
                () -> assertEquals("2 / 10", calc.convertRomanToArabic("II / X")),
                () -> assertEquals("3 / 10", calc.convertRomanToArabic("III / X")),
                () -> assertEquals("4 / 10", calc.convertRomanToArabic("IV / X")),
                () -> assertEquals("5 / 10", calc.convertRomanToArabic("V / X")),
                () -> assertEquals("6 / 10", calc.convertRomanToArabic("VI / X")),
                () -> assertEquals("7 / 10", calc.convertRomanToArabic("VII / X")),
                () -> assertEquals("8 / 10", calc.convertRomanToArabic("VIII / X")),
                () -> assertEquals("9 / 10", calc.convertRomanToArabic("IX / X")),

                () -> assertEquals("10 / 1", calc.convertRomanToArabic("X / I")),
                () -> assertEquals("10 / 2", calc.convertRomanToArabic("X / II")),
                () -> assertEquals("10 / 3", calc.convertRomanToArabic("X / III")),
                () -> assertEquals("10 / 4", calc.convertRomanToArabic("X / IV")),
                () -> assertEquals("10 / 5", calc.convertRomanToArabic("X / V")),
                () -> assertEquals("10 / 6", calc.convertRomanToArabic("X / VI")),
                () -> assertEquals("10 / 7", calc.convertRomanToArabic("X / VII")),
                () -> assertEquals("10 / 8", calc.convertRomanToArabic("X / VIII")),
                () -> assertEquals("10 / 9", calc.convertRomanToArabic("X / IX")),

                () -> assertEquals("1 / 1", calc.convertRomanToArabic("I / I")),
                () -> assertEquals("2 / 2", calc.convertRomanToArabic("II / II")),
                () -> assertEquals("3 / 3", calc.convertRomanToArabic("III / III")),
                () -> assertEquals("4 / 4", calc.convertRomanToArabic("IV / IV")),
                () -> assertEquals("5 / 5", calc.convertRomanToArabic("V / V")),
                () -> assertEquals("6 / 6", calc.convertRomanToArabic("VI / VI")),
                () -> assertEquals("7 / 7", calc.convertRomanToArabic("VII / VII")),
                () -> assertEquals("8 / 8", calc.convertRomanToArabic("VIII / VIII")),
                () -> assertEquals("9 / 9", calc.convertRomanToArabic("IX / IX")),
                () -> assertEquals("10 / 10", calc.convertRomanToArabic("X / X"))
        );
    }


    @Test
    @DisplayName("должен преобразовать арабское число от 1 до 100 в римскоеарабскими символами")
    void convertArabicToRoman() {

        Calculator calc = new Calculator();

        assertAll(
                () -> assertEquals("I", calc.convertArabicToRoman("1")),
                () -> assertEquals("II", calc.convertArabicToRoman("2")),
                () -> assertEquals("III", calc.convertArabicToRoman("3")),
                () -> assertEquals("IV", calc.convertArabicToRoman("4")),
                () -> assertEquals("V", calc.convertArabicToRoman("5")),
                () -> assertEquals("VI", calc.convertArabicToRoman("6")),
                () -> assertEquals("VII", calc.convertArabicToRoman("7")),
                () -> assertEquals("VIII", calc.convertArabicToRoman("8")),
                () -> assertEquals("IX", calc.convertArabicToRoman("9")),
                () -> assertEquals("X", calc.convertArabicToRoman("10")),
                () -> assertEquals("XI", calc.convertArabicToRoman("11")),
                () -> assertEquals("XXVIII", calc.convertArabicToRoman("28")),
                () -> assertEquals("XXXVII", calc.convertArabicToRoman("37")),
                () -> assertEquals("XLVI", calc.convertArabicToRoman("46")),
                () -> assertEquals("LIV", calc.convertArabicToRoman("54")),
                () -> assertEquals("LXIII", calc.convertArabicToRoman("63")),
                () -> assertEquals("LXXII", calc.convertArabicToRoman("72")),
                () -> assertEquals("LXXXI", calc.convertArabicToRoman("81")),
                () -> assertEquals("XCIX", calc.convertArabicToRoman("99")),
                () -> assertEquals("C", calc.convertArabicToRoman("100")),

                () -> assertNull(calc.convertArabicToRoman("101")),
                () -> assertNull(calc.convertArabicToRoman("0")),
                () -> assertNull(calc.convertArabicToRoman(null))
        );
    }

}