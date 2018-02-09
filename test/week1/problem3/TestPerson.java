package week1.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPerson {

    @Test
    void getClassification01() {
        Person p = new Person("Dummy", 1.80, 68);
        assertEquals(BMIClassification.NORMAL, p.getClassification());
    }

    @Test
    void getClassification02() {
        Person p = new Person("Dummy", 1.64, 55);
        assertEquals(BMIClassification.NORMAL, p.getClassification());
    }

    @Test
    void getClassification03() {
        Person p = new Person("Dummy", 1.90, 55);
        assertEquals(BMIClassification.UNDER_WEIGHT, p.getClassification());
    }


    @Test
    void getClassification04() {
        Person p = new Person("Dummy", 1.60, 80);
        assertEquals(BMIClassification.OBESE, p.getClassification());
    }


    @Test
    void getClassification05() {
        Person p = new Person("Dummy", 1.75, 100);
        assertEquals(BMIClassification.OBESE, p.getClassification());
    }


    @Test
    void getClassification06() {
        Person p = new Person("Dummy", 1.85, 89);
        assertEquals(BMIClassification.OVER_WEIGHT, p.getClassification());
    }


    @Test
    void getClassification07() {
        Person p = new Person("Dummy", 1.40, 50);
        assertEquals(BMIClassification.OVER_WEIGHT, p.getClassification());
    }


    @Test
    void getClassification08() {
        Person p = new Person("Dummy", 1.46, 71);
        assertEquals(BMIClassification.OBESE, p.getClassification());
    }


}
