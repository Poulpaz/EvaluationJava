package fr.tennismatch;

public class TennisMatch {

    private MatchType matchType;
    private Player player1;
    private Player player2;
    private Boolean tieBreak;

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreak) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreak = tieBreak;
    }
}
