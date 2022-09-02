package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Main.calc;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("должен работать с арабскими числами (сложение)")
    void arabicPlus() {

        assertAll(
                () -> assertEquals("2", calc("1 + 1")),
                () -> assertEquals("3", calc("1 + 2")),
                () -> assertEquals("7", calc("4 + 3")),
                () -> assertEquals("20", calc("10 + 10"))
                );
    }

    @Test
    @DisplayName("должен работать с арабскими числами (вычитание)")
    void arabicMinus() {

        assertAll(
                () -> assertEquals("9", calc("10 - 1")),
                () -> assertEquals("1", calc("5 - 4")),
                () -> assertEquals("0", calc("4 - 4")),
                () -> assertEquals("-9", calc("1 - 10")),
                () -> assertEquals("-1", calc("4 - 5"))
        );
    }

    @Test
    @DisplayName("должен работать с арабскими числами (умножение)")
    void arabicMultiplication() {

        assertAll(
                () -> assertEquals("100", calc("10 * 10")),
                () -> assertEquals("40", calc("4 * 10")),
                () -> assertEquals("5", calc("5 * 1")),
                () -> assertEquals("25", calc("5 * 5"))
        );
    }

    @Test
    @DisplayName("должен работать с арабскими числами (деление)")
    void arabicDivision() {

        assertAll(
                () -> assertEquals("10", calc("10 / 1")),
                () -> assertEquals("3", calc("6 / 2")),
                () -> assertEquals("1", calc("5 / 4")),
                () -> assertEquals("0", calc("2 / 4"))
        );
    }

    @Test
    @DisplayName("должен работать с римскими числами (сложение)")
    void romanPlus() {

        assertAll(
                () -> assertEquals("II", calc("I + I")),
                () -> assertEquals("III", calc("I + II")),
                () -> assertEquals("VII", calc("IV + III")),
                () -> assertEquals("XX", calc("X + X")),
                () -> assertEquals("XIX", calc("X + IX"))
        );
    }

    @Test
    @DisplayName("должен работать с римскими числами (вычитание)")
    void romanMinus() {

        assertAll(
                () -> assertEquals("IX", calc("X - I")),
                () -> assertEquals("I", calc("V - IV")),

                () -> assertEquals("", calc("IV - IV")),
                () -> assertEquals("", calc("I - X")),
                () -> assertEquals("", calc("IV - V"))
        );
    }

    @Test
    @DisplayName("должен работать с римскими числами (умножение)")
    void romanMultiplication() {

        assertAll(
                () -> assertEquals("C", calc("X * X")),
                () -> assertEquals("XL", calc("IV * X")),
                () -> assertEquals("V", calc("V * I")),
                () -> assertEquals("XXV", calc("V * V"))
        );
    }

    @Test
    @DisplayName("должен работать с римскими числами (деление)")
    void romanDivision() {

        assertAll(
                () -> assertEquals("X", calc("X / I")),
                () -> assertEquals("III", calc("VI / II")),
                () -> assertEquals("I", calc("V / IV")),

                () -> assertEquals("", calc("II / IV"))
                );
    }

    @Test
    @DisplayName("должен выбрасывать ошибку на некорректных выражениях")
    void incorrectExpression() {
        assertThrows(Exception.class, () -> calc(""));
        assertThrows(Exception.class, () -> calc(" "));
        assertThrows(Exception.class, () -> calc("     "));
        assertThrows(Exception.class, () -> calc("4"));
        assertThrows(Exception.class, () -> calc("+"));
        assertThrows(Exception.class, () -> calc("++1"));
        assertThrows(Exception.class, () -> calc("V"));
        assertThrows(Exception.class, () -> calc("3 % 4"));
        assertThrows(Exception.class, () -> calc("1 + 1 + 1"));
        assertThrows(Exception.class, () -> calc("11 + 1"));
        assertThrows(Exception.class, () -> calc("1 + 11"));
        assertThrows(Exception.class, () -> calc("XI + I"));
        assertThrows(Exception.class, () -> calc("I + XI"));
        assertThrows(Exception.class, () -> calc("1 + V"));
        assertThrows(Exception.class, () -> calc("I + 1"));
        assertThrows(Exception.class, () -> calc("5 / 0"));
        assertThrows(Exception.class, () -> calc("0 + 1"));
        assertThrows(Exception.class, () -> calc("1 + 0"));

    }
}



