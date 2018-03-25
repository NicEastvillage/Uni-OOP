package week6.assignment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;

public class CalculatorInputManager {

    private static final char UNSET_OPERATOR = '#';

    private class InputNumber {
        private String string = "";
        private boolean comma = false;

        // Cheesy getters
        public String getString() { return string; }
        public boolean isEmpty() { return string.length() == 0; }
        public boolean containsComma() { return comma; }

        public boolean canAddChar(char c) {
            if (isDigit(c)) return true;
            if (isComma(c)) return !comma;
            return false;
        }

        public void set(double value) {
            string = "" + value;
            comma = string.indexOf('.') >= 0;
        }

        public void addChar(char c) {
            if (!canAddChar(c)) throw new RuntimeException();
            if (isComma(c)) comma = true;
            string += c;
        }

        public void removeChar() {
            // TODO: When removing comma, set containsComma = false
        }
    }

    private OptionalDouble lastResult = OptionalDouble.empty();
    private char operator;
    private InputNumber firstNum, secondNum;

    public CalculatorInputManager() {
        clear();
    }

    public void clear() {
        operator = UNSET_OPERATOR;
        firstNum = new InputNumber();
        secondNum = new InputNumber();
    }

    public void addCharacter(char c) {
        if (!isValidChar(c)) throw new IllegalArgumentException("The character '" + c + "' is not valid in a calculator.");

        // Set operator
        if (isOperator(c)) {
            // Use last result if first num is empty. If no last result, then ignore
            if (firstNum.isEmpty()) {
                if (lastResult.isPresent()) {
                    firstNum.set(lastResult.getAsDouble());
                } else {
                    return;
                }
            }

            operator = c;
            return;
        }

        // Ignore if double comma
        if (getCurrentNumber().containsComma() && c == '.') return;

        if (getCurrentNumber().canAddChar(c)) {
            // Add to current part
            getCurrentNumber().addChar(c);
        }
    }

    private InputNumber getCurrentNumber() {
        return operator == UNSET_OPERATOR ? firstNum : secondNum;
    }

    public double calculate() {
        if (canCalculate()) {
            // Collect parts

            double first = Double.valueOf(firstNum.string);
            double second = Double.valueOf(secondNum.string);

            double res = evaluateExpression(first, second, operator);
            lastResult = OptionalDouble.of(res);
            return res;
        } else {
            throw new InvalidExpressionException("Cannot calculate current expression: \"" + getInputString() + "\".");
        }
    }

    private boolean canCalculate() {
        return !firstNum.isEmpty() && !secondNum.isEmpty() && operator != UNSET_OPERATOR;
    }

    private double evaluateExpression(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? Double.NaN : a / b;
            default: return Double.NaN;
        }
    }

    public String getInputString() {
        if (operator == UNSET_OPERATOR) {
            return firstNum.string;
        }
        return firstNum.string + operator + secondNum.string;
    }

    private boolean isValidChar(char c) {
        return isDigit(c) || isComma(c) || isOperator(c);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isComma(char c) {
        return c == '.';
    }
}
