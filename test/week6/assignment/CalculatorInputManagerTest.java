package week6.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorInputManagerTest {

    @Test
    public void calculator01() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('+');
        cim.addCharacter('7');
        assertEquals(12, cim.calculate(), 1E-8);
    }

    @Test
    public void calculator02() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('8');
        cim.addCharacter('-');
        cim.addCharacter('2');
        assertEquals(6, cim.calculate(), 1E-8);
    }

    @Test
    public void calculator03() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('3');
        cim.addCharacter('*');
        cim.addCharacter('5');
        assertEquals(15, cim.calculate(), 1E-8);
    }

    @Test
    public void calculator04() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('9');
        cim.addCharacter('/');
        cim.addCharacter('2');
        assertEquals(4.5, cim.calculate(), 1E-8);
    }

    @Test
    public void calculator05() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('0');
        cim.addCharacter('+');
        cim.addCharacter('2');
        cim.addCharacter('3');
        assertEquals(73, cim.calculate(), 1E-8);
    }

    @Test
    public void calculator06() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('2');
        cim.addCharacter('.');
        cim.addCharacter('5');
        cim.addCharacter('*');
        cim.addCharacter('3');
        cim.addCharacter('.');
        cim.addCharacter('6');
        assertEquals(2.5 * 3.6, cim.calculate(), 1E-8);
    }

    @Test
    public void string01() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('4');
        cim.addCharacter('3');
        cim.addCharacter('+');
        cim.addCharacter('1');
        cim.addCharacter('7');
        assertEquals("43+17", cim.getInputString());
    }

    @Test
    public void string02() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('1');
        cim.addCharacter('2');
        cim.addCharacter('+');
        assertEquals("12+", cim.getInputString());
    }

    @Test
    public void invalidChar01() {
        CalculatorInputManager cim = new CalculatorInputManager();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cim.addCharacter('a'));
        assertNotNull(e);
    }

    @Test
    public void invalidChar02() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('+');
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cim.addCharacter('x'));
        assertNotNull(e);
    }

    @Test
    public void invalidChar03() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('+');
        cim.addCharacter('6');
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cim.addCharacter('='));
        assertNotNull(e);
    }

    @Test
    public void invalidExp01() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('+');
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> cim.calculate());
        assertNotNull(e);
    }

    @Test
    public void invalidExp02() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('3');
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> cim.calculate());
        assertNotNull(e);
    }

    @Test
    public void invalidExp03() {
        CalculatorInputManager cim = new CalculatorInputManager();
        cim.addCharacter('5');
        cim.addCharacter('-');
        cim.addCharacter('2');
        cim.addCharacter('+');
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> cim.calculate());
        assertNotNull(e);
    }
}