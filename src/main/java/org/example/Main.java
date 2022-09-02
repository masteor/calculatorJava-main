package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        //noinspection InfiniteLoopStatement
        do {
            System.out.println("Введите арифметическое выражение: ");
            String input = in.nextLine();

            System.out.println("Результат: " + calc(input));
        } while (true);

    }

    static String calc(String input) throws Exception {

        Calculator calc = new Calculator();

        Boolean isRoman = calc.IsRomanExpression(input);
        Boolean isArabic = calc.IsArabicExpression(input);

        String _input = input;
        if (isRoman == isArabic) throw new Exception("не пройдена валидация ни по одному из наборов цифр либо арифметических операторов");
        if (isRoman) {
            _input = calc.convertRomanToArabic(_input);
            if (!calc.IsArabicExpression(_input)) throw new Exception("не удалось преобразовать римские цифры в арабские");
        }

        String result = calc.calculate(_input);
        if (result == null) throw new Exception("не удалось вычислить выражение");

        if (isRoman)
            if (Integer.parseInt(result) > 0) {
                result = calc.convertArabicToRoman(result);
                if (result == null) throw new Exception("не удалось преобразовать арабские цифры в римские");
                return result;
            } else return "";

        return result;
    }
}