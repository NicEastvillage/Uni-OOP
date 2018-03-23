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
        public int getStartIndex() { return startIndex; }
        public int getLength() { return length; }
        public int getEndIndex() { return startIndex + length; }
        public boolean isEmpty() { return type == InputPartType.EMPTY; }
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
    }

    private String input;
    private InputPart currentPart;
    private ArrayList<InputPart> parts;

    public CalculatorInputManager() {
        input = "";
        currentPart = new InputPart(0);
        parts = new ArrayList<>();
    }

    public void addCharacter(char c) {

    }

    public double calculate() {
        return 0;
    }
}
