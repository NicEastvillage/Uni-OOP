package week0.problem15;

public class Team {

    private String name;
    private Player playerOne;
    private Player playerTwo;

    public Team(String name, Player playerOne, Player playerTwo) {
        this.name = name;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public float averageAge() {
        return (playerOne.getAge() + playerTwo.getAge()) / 2f;
    }

    public Player getBestWinratePlayer() {
        return playerOne.getWinrate() > playerTwo.getWinrate() ? playerOne : playerTwo;
    }

    public void addWin() {
        playerOne.awardWin();
        playerTwo.awardWin();
    }

    public void addLoss() {
        playerOne.addLoss();
        playerTwo.addLoss();
    }

    public String getName() {
        return name;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
