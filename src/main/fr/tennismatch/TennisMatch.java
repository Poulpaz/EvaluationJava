package fr.tennismatch;

import java.util.ArrayList;
import java.util.List;

public class TennisMatch {

    private MatchType matchType;
    private Player player1;
    private Player player2;
    private Boolean tieBreakInLastSet;
    private List<TennisJeu> tennisJeux = new ArrayList<>();

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreakInLastSet) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;
    }

    public void updateWithPointWonBy(Player player) {
        if(player == player1) {
            if(pointsForPlayer(player2) == "A") {
                player2.setScore(player2.getScore() - 1);
            } else {
                player.setScore(player.getScore() + 1);
            }
        } else {
            if(pointsForPlayer(player1) == "A") {
                player1.setScore(player1.getScore() - 1);
            } else {
                player.setScore(player.getScore() + 1);
            }
        }
        if(player.getScore() > 4) {
            TennisJeu tennisJeu = new TennisJeu(player);
            tennisJeux.add(tennisJeu);
            player1.setScore(0);
            player2.setScore(0);
        } else { return; }
    }

    public String pointsForPlayer(Player player) {
        String pointsForPlayer;
        switch(player.getScore()) {
            case 0: pointsForPlayer = "0";
            break;
            case 1: pointsForPlayer = "15";
            break;
            case 2: pointsForPlayer = "30";
            break;
            case 3: pointsForPlayer = "40";
            break;
            case 4: pointsForPlayer = "A";
            break;
            default: pointsForPlayer = null;
        }
        return pointsForPlayer;
    }
/*
    public int currentSetNumber() {

    }

    public int gamesInCurrentSetForPlayer(Player player) {

    }

    public int gamesInSetForPlayer(int setNumber, Player player) {

    }

    public boolean isFinished() {

    }
    */

    public List<TennisJeu> getTennisJeux() {
        return tennisJeux;
    }
}
