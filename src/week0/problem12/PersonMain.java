package week0.problem12;

public class PersonMain {
    public static void main(String[] args) {

        Person anders = new Person("Anders", "And", 28);
        Person cena = new Person("John", "Cena", 40);
        Person kurt = new Person("Kurt", "Nørmark", 57);

        System.out.println(anders.toString());
        System.out.println(cena.toString());
        System.out.println(kurt.toString());
    }
}
