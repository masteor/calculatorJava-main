package org.example;

class Calculator {

    /**
     * Вычисляет валидное арифметическое выражение, записанное арабскими цифрами
     * пример: "1 + 2", между операндами и операцией должен быть 1 пробел
     * @return возвращает число, если удалось провести вычисление,
     * null - если не удалось
     */
    String calculate(String expression) {

        if (expression == null || expression.isBlank() || expression.isEmpty())
            return null;

        String[] _exp = expression.split(" ");

        if (_exp.length < 3) return null;

        int firstOperand = Integer.parseInt(_exp[0]);
        int secondOperand = Integer.parseInt(_exp[2]);

        return switch (_exp[1]) {
            case ("+") -> String.valueOf(firstOperand + secondOperand);
            case ("-") -> String.valueOf(firstOperand - secondOperand);
            case ("*") -> String.valueOf(firstOperand * secondOperand);
            case ("/") -> String.valueOf(firstOperand / secondOperand);
            default -> null;
        };

    }

    /**
     * Проверка на соответствие арифметическому выражению с арабскими цифрами
     * разрешенные операторы: "+ - * /"
     * разрешенные операнды: "1..10"
     * пример: "1 + 2"
     * @param expression арифметическое выражение с 2-мя операндами и 1 оператором
     * @return {boolean} возвращает true, если выражение валидно и используются арабские цифры
     * в противном случае - false
     */
     Boolean IsArabicExpression(String expression) {
        return expression != null && expression.matches("^([1-9]|10)\\s[-+*/]\\s([1-9]|10)$");
    }

    /**
     * Проверка на соответствие арифметическому выражению с римскими цифрами
     * разрешенные операторы: "+ - * /"
     * разрешенные операнды: "I..X"
     * пример: "I + II"
     * @param expression арифметическое выражение с 2-мя операндами и 1 оператором
     * @return {boolean} возвращает true, если выражение валидно и используются римские цифры
     * в противном случае - false
     */
    Boolean IsRomanExpression(String expression) {
        return expression != null && expression.matches("^(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s[-+*/]\\s(I|II|III|IV|V|VI|VII|VIII|IX|X)$");
    }

    /**
     * Заменяет в любой строке римские цифры в верхнем регистре на арабские (только цифры от 1 до 10)
     * @param stroka исходная строка, в которой надо заменить цифры
     * @return строка с арабскими цифрами
     */
    String convertRomanToArabic(String stroka) {

        String[][] numbers = {{"8", "VIII"}, {"3", "III"}, {"7", "VII"}, {"2", "II"}, {"4", "IV"}, {"6", "VI"}, {"9", "IX"}, {"1", "I"}, {"5", "V"}, {"10", "X"}};

        String finalResult = stroka;

        for (String[] number : numbers) {
            finalResult = finalResult.replace(number[1], number[0]);
        }

        return finalResult;
    }

    /**
     * Преобразует арабское число от 1 до 100 в римское
     * @param originalNumber исходное число для преобразования
     * @return римское число, либо null, если замена не удалась
     */
    String convertArabicToRoman(String originalNumber) {
        String[][] numbers = {
                {"C", "100" },{"XC","90"},{"L","50"},{"XL","40"},{"X","10"},{"IX","9"}, {"V","5"}, {"IV","4"}, {"I","1"}};

        if (originalNumber == null) return null;

        int _originalNumber = Integer.parseInt(originalNumber);

        if (_originalNumber < 1 || _originalNumber > 100) return null;

        StringBuilder result = new StringBuilder();
        for (String[] number : numbers) {
            int integerPart = _originalNumber / Integer.parseInt(number[1]);

            if (integerPart > 0) {
                result.append(number[0].repeat(integerPart));
                _originalNumber -= Integer.parseInt(number[1]) * integerPart;
            }
        }

        return result.toString();
    }
}