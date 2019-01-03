package fr.tennismatch;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TennisMatch {

    private final ManagerTennisMatch managerTennisMatch = new ManagerTennisMatch(this);
    private MatchType matchType;
    private Player player1;
    private Player player2;
    private Boolean tieBreakInLastSet;
    private List<TennisSet> tennisSetList;

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreakInLastSet) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.tennisSetList = new ArrayList<>();
        tennisSetList.add(new TennisSet(1));
    }

    /* -- Main methods for TennisMatch --*/
    // Start Region

    public void updateWithPointWonBy(Player player) {
        if(player == player1) {
            managerTennisMatch.checkScoreAndUpdateGame(player, player2);
        } else {
            managerTennisMatch.checkScoreAndUpdateGame(player, player1);
        }
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

    public int currentSetNumber() {
        return tennisSetList.get(getTennisSetList().size() - 1).getSetNumber();
    }

    public int gamesInCurrentSetForPlayer(Player player) {
        ListIterator<TennisJeu> it = tennisSetList.get(getTennisSetList().size() - 1).getTennisJeuList().listIterator();
        int count = 0;
        return managerTennisMatch.getNumberTennisJeuWon(player, it, count);
    }

    public int gamesInSetForPlayer(int setNumber, Player player) {
        int count = 0;
        try {
            ListIterator<TennisJeu> it = tennisSetList.get(setNumber - 1).getTennisJeuList().listIterator();
            return managerTennisMatch.getNumberTennisJeuWon(player, it, count);
        } catch(Exception e) {
            e.printStackTrace();
            return count;
        }
    }

    public boolean isFinished() {
        if(matchType == MatchType.BEST_OF_THREE && managerTennisMatch.getSetWonByPlayer(player1) == MatchType.BEST_OF_THREE.numberOfSetsToWin() || managerTennisMatch.getSetWonByPlayer(player2) == MatchType.BEST_OF_THREE.numberOfSetsToWin()) {
            return true;
        } else if(matchType == MatchType.BEST_OF_FIVE && managerTennisMatch.getSetWonByPlayer(player1) == MatchType.BEST_OF_FIVE.numberOfSetsToWin() || managerTennisMatch.getSetWonByPlayer(player2) == MatchType.BEST_OF_FIVE.numberOfSetsToWin()) {
            return true;
        } else { return false; }
    }

    public List<TennisSet> getTennisSetList() {
        return tennisSetList;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public Boolean getTieBreakInLastSet() {
        return tieBreakInLastSet;
    }

    //End Region

    /* -- Manager's methods for TennisMatch --*/
    // Start Region

    public int getSetWonByPlayer(Player player) {
        return managerTennisMatch.getSetWonByPlayer(player);
    }

    public int getNumberTennisJeuWon(Player player, ListIterator<TennisJeu> it, int count) {
        return managerTennisMatch.getNumberTennisJeuWon(player, it, count);
    }


    public void checkScoreAndUpdateGame(Player player1, Player player2) {
        managerTennisMatch.checkScoreAndUpdateGame(player1, player2);
    }

    public void actionForCurrentSet(Player player1, Player player2) {
        managerTennisMatch.actionForCurrentSet(player1, player2);
    }

    //End Region
}