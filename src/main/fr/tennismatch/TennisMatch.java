package fr.tennismatch;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TennisMatch {

    private MatchType matchType;
    private Player player1;
    private Player player2;
    private Boolean tieBreakInLastSet;
    private List<TennisSet> tennisSetList;
    private int currentSetNumber;

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreakInLastSet) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.tennisSetList = new ArrayList<>();
        this.currentSetNumber = 1;
        tennisSetList.add(new TennisSet(currentSetNumber));
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
            tennisSetList.get(currentSetNumber - 1).setWinnerTennisJeu(player);
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
*/
    public int gamesInCurrentSetForPlayer(Player player) {
        ListIterator<TennisJeu> it = tennisSetList.get(currentSetNumber - 1).getTennisJeuList().listIterator();
        int count = 0;

        while(it.hasNext()) {
            if(it.next().getWinnerTennisJeu() == player) {
                count++;
            }
        }
        return count;
    }
/*
    public int gamesInSetForPlayer(int setNumber, Player player) {

    }

    public boolean isFinished() {

    }
    */

    public List<TennisSet> getTennisSetList() {
        return tennisSetList;
    }

    public int getCurrentSetNumber() {
        return currentSetNumber;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
