package week6.assignment;

import java.awt.*;
import java.util.ArrayList;

public class CalculatorInputManager {

    private enum InputPartType {
        EMPTY, NUMBER, OPERATOR
    }

    private class InputPart {
        private String string = "";
        private InputPartType type = InputPartType.EMPTY;
        private int startIndex;
        private int length = 0;
        private boolean comma = false;

        public InputPart(int startIndex) {
            this.startIndex = startIndex;
        }

        // Cheesy getters
        public String getString() { return string; }
        public InputPartType getType() { return type; }
        public boolean isEmpty() { return type == InputPartType.EMPTY; }
        public int getStartIndex() { return startIndex; }
        public int getLength() { return length; }
        public int getEndIndex() { return startIndex + length; }
        public boolean containsComma() { return comma; }

        public boolean canAddChar(char c) {
            if (type == InputPartType.EMPTY && isValidChar(c)) return true;
            if (type == InputPartType.NUMBER) {
                if (isDigit(c)) return true;
                if (isComma(c)) return !comma;
            }
            // Return false if type == OPERATOR or c is anything else
            return false;
        }

        public void addChar(char c) {
            if (!canAddChar(c)) throw new RuntimeException();
            if (isComma(c)) comma = true;
            string += c;
            length++;

            if (type == InputPartType.EMPTY) {
                if (isDigit(c) || isComma(c)) type = InputPartType.NUMBER;
                else if (isOperator(c)) type = InputPartType.OPERATOR;
            }
        }

        public void removeChar() {
            // TODO: When removing comma, set containsComma = false
        }
    }

    private String input;
    private InputPart currentPart;
    private ArrayList<InputPart> parts;

    public CalculatorInputManager() {
        clear();
    }

    public void clear() {
        input = "";
        currentPart = new InputPart(0);
        parts = new ArrayList<>();
    }

    public void addCharacter(char c) {
        if (!isValidChar(c)) throw new IllegalArgumentException("The character '" + c + "' is not valid in a calculator.");

        // Ignore request if double comma
        if (currentPart.containsComma() && c == '.') return;

        if (currentPart.canAddChar(c)) {
            // Add to current part
            currentPart.addChar(c);
        } else {
            // Create new part
            parts.add(currentPart);
            currentPart = new InputPart(input.length());
            currentPart.addChar(c);
        }
        input += c;
    }

    public double calculate() {
        if (canCalculate()) {
            // Collect parts
            ArrayList<InputPart> calcParts = new ArrayList<>(parts);
            if (!currentPart.isEmpty()) calcParts.add(currentPart);

            double res = Double.valueOf(calcParts.get(0).getString());

            // Parts will always be NUMBER->OPERATOR->NUMBER->OPERATOR->...
            for (int i = 1; i < calcParts.size(); i += 2) {
                String operator = calcParts.get(i).getString();
                double value = Double.valueOf(calcParts.get(i+1).getString());
                res = evaluateExpression(res, value, operator);
            }

            return res;
        } else {
            throw new InvalidExpressionException("Cannot calculate current expression: \"" + input + "\".");
        }
    }

    private boolean canCalculate() {
        // Collect parts
        ArrayList<InputPart> calcParts = new ArrayList<>(parts);
        if (!currentPart.isEmpty()) calcParts.add(currentPart);

        // Input must be at least 3,5,7.. parts long and last one cannot be an operator
        return calcParts.size() >= 3 && calcParts.size() % 2 == 1 && calcParts.get(calcParts.size() - 1).getType() == InputPartType.NUMBER;
    }

    private double evaluateExpression(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? Double.NaN : a / b;
            default: return Double.NaN;
        }
    }

    public String getInputString() {
        return input;
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
