package week0.problem15;

import java.util.Random;

public class BadmintonMain {
    public static void main(String[] args) {

        /*
        =================================
        ==== Made by Nicolaj Østerby ====
        ======= 2018, AAU Datalogi ======
        =================================
         */

        Player john = new Player("John", "Sanderson", 23, 7, 7);
        Player frank = new Player("Frank", "Utsson", 24, 5, 16);
        Player alex = new Player("Alexander", "Jensen", 22, 4, 7);
        Player bjorn = new Player("Bjørn", "Christensen", 26, 9, 8);

        Team dyno = new Team("Dynamic Duo", john, frank);
        Team cool = new Team("Team super cool", alex, bjorn);

        Match match = new Match(dyno, cool);

        introduceMatch(match);
        System.out.println("\nPlayer with highest winrate: " + match.getBestWinratePlayer().getFirstName());

        Team winner = (new Random().nextInt(2) == 1) ? match.getTeamRed() : match.getTeamBlue();
        System.out.println("\n--- TEAM \"" + winner.getName() + "\" WINS THE MATCH ---\n");
        match.concludeMatch(winner);

        introduceMatch(match);
        System.out.println("\nPlayer with highest winrate: " + match.getBestWinratePlayer().getFirstName());
    }

    private static void introduceMatch(Match m) {
        System.out.println("\"" + m.getTeamRed().getName() + "\":");
        System.out.println("  " + m.getTeamRed().getPlayerOne().toString() + " (" + m.getTeamRed().getPlayerOne().getWinrate() + ")");
        System.out.println("  " + m.getTeamRed().getPlayerTwo().toString() + " (" + m.getTeamRed().getPlayerTwo().getWinrate() + ")");

        System.out.println("\"" + m.getTeamBlue().getName() + "\":");
        System.out.println("  " + m.getTeamBlue().getPlayerOne().toString() + " (" + m.getTeamBlue().getPlayerOne().getWinrate() + ")");
        System.out.println("  " + m.getTeamBlue().getPlayerTwo().toString() + " (" + m.getTeamBlue().getPlayerTwo().getWinrate() + ")");
    }
}
