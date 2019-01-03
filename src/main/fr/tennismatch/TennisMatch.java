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

    public TennisMatch(MatchType matchType, Player player1, Player player2, Boolean tieBreakInLastSet) {
        this.matchType = matchType;
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.tennisSetList = new ArrayList<>();
        tennisSetList.add(new TennisSet(1));
    }

    public void updateWithPointWonBy(Player player) {
        if(player == player1) {
            checkScoreAndUpdateGame(player, player2);
        } else {
            checkScoreAndUpdateGame(player, player1);
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
        return getNumberTennisJeuWon(player, it, count);
    }

    public int gamesInSetForPlayer(int setNumber, Player player) {
        int count = 0;
        try {
            ListIterator<TennisJeu> it = tennisSetList.get(setNumber - 1).getTennisJeuList().listIterator();
            return getNumberTennisJeuWon(player, it, count);
        } catch(Exception e) {
            e.printStackTrace();
            return count;
        }
    }
    /*
    public boolean isFinished() {

    }
    */
    public int getNumberTennisJeuWon(Player player, ListIterator<TennisJeu> it, int count) {
        while (it.hasNext()) {
            if (it.next().getWinnerTennisJeu() == player) {
                count++;
            }
        }
        return count;
    }

    public void checkScoreAndUpdateGame(Player player1, Player player2) {
        if(pointsForPlayer(player2) == "A") {
            player2.setScore(player2.getScore() - 1);
        } else {
            player1.setScore(player1.getScore() + 1);
            if(player1.getScore() > 4) {
                tennisSetList.get(getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
                this.player1.setScore(0);
                player2.setScore(0);
                if(gamesInCurrentSetForPlayer(player1) == 6) {
                    tennisSetList.get(tennisSetList.size() - 1).setWinnerTennisSet(player1);
                    tennisSetList.add(new TennisSet(tennisSetList.size() + 1));
                } else { return; }
            } else { return; }
        }
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
}
