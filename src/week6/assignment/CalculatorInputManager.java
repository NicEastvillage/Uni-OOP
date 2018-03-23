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
            if (type == InputPartType.EMPTY) return true;
            if (type == InputPartType.NUMBER) {
                if (Character.isDigit(c)) return true;
                if (c == '.') return !comma;
            }
            // Return false if type == OPERATOR or c is anything else
            return false;
        }

        public void addChar(char c) {
            if (!canAddChar(c)) throw new RuntimeException();
            if (c == '.') comma = true;
            string += c;
            length++;

            if (type == InputPartType.EMPTY) {
                if (Character.isDigit(c) || c == '.') type = InputPartType.NUMBER;
                else if (c == '+' || c == '-' || c == '*' || c == '/') type = InputPartType.OPERATOR;
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
        // Ignore request if double comma
        if (currentPart.containsComma() && c == '.') return;

        try {
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
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("The character '" + c + "' is not valid in a calculator.");
        }
    }

    public double calculate() {
        return 0;
    }

    private boolean canCalculate() {
        // Input must be at least 3 parts long and last one cannot be an operator
        return false;
    }

    public String getInputString() {
        return input;
    }
}
