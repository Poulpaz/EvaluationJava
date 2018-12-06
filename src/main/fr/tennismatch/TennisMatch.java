package fr.tennismatch;

public class TennisMatch {

    private MatchType matchType;
    private Player player1;
    private Player player2;
    private Boolean tieBreakInLastSet;
    private JeuTennis jeuTennis;

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreakInLastSet, JeuTennis jeuTennis) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.jeuTennis = jeuTennis;
    }

    public void updateWithPointWonBy(Player player) {
        if(jeuTennis != null) {
            player.
        } else { return; }
    }

    public String pointsForPlayer(Player player) {

    }

    public int currentSetNumber() {

    }

    public int gamesInCurrentSetForPlayer(Player player) {

    }

    public int gamesInSetForPlayer(int setNumber, Player player) {

    }

    public boolean isFinished() {

    }
}
