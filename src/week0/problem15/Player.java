package week0.problem15;

public class Player {

    private String firstName;
    private String lastName;
    private int age;
    private int wins;
    private int losses;
    private String sponsor;

    public Player(String firstName, String lastName, int age, int wins, int losses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wins = wins;
        this.losses = losses;
        sponsor = "None";
    }

    public Player(String firstName, String lastName, int age, int wins, int losses, String sponsor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wins = wins;
        this.losses = losses;
        this.sponsor = sponsor;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + age;
    }

    public float getWinrate() {
        return (float) wins / losses;
    }

    public int getAge() {
        return age;
    }

    public void awardWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getSponsor() {
        return sponsor;
    }
}
