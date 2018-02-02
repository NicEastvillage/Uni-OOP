package week0.problem15;

public class Match {

    private Team teamRed;
    private Team teamBlue;

    public Match(Team teamRed, Team teamBlue) {
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
    }

    public float averageAge() {
        return (teamRed.averageAge() + teamBlue.averageAge()) / 2f;
    }

    public Player getBestWinratePlayer() {
        Player redBest = teamRed.getBestWinratePlayer();
        Player blueBest = teamBlue.getBestWinratePlayer();

        if (redBest.getWinrate() > blueBest.getWinrate()) {
            return redBest;
        } else {
            return blueBest;
        }
    }

    public void concludeMatch(Team winner) {
        if (winner == teamBlue || winner == teamRed) {
            Team loser = winner == teamBlue ? teamRed : teamBlue;

            
        }
    }
}
