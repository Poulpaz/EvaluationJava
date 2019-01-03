package fr.tennismatch;

import java.util.ListIterator;

public class ManagerTennisMatch {
    private final TennisMatch tennisMatch;

    public ManagerTennisMatch(TennisMatch tennisMatch) {
        this.tennisMatch = tennisMatch;
    }

    public int getSetWonByPlayer(Player player) {
        ListIterator<TennisSet> it = tennisMatch.getTennisSetList().listIterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().getWinnerTennisSet() == player) {
                count++;
            }
        }
        return count;
    }

    public int getNumberTennisJeuWon(Player player, ListIterator<TennisJeu> it, int count) {
        while (it.hasNext()) {
            if (it.next().getWinnerTennisJeu() == player) {
                count++;
            }
        }
        return count;
    }

    public void checkScoreAndUpdateGame(Player player1, Player player2) {
        if (tennisMatch.pointsForPlayer(player2) == "A") {
            player2.setScore(player2.getScore() - 1);
        } else {
            player1.setScore(player1.getScore() + 1);
            if (player1.getScore() > 4) {
                tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
                tennisMatch.getPlayer1().setScore(0);
                tennisMatch.getPlayer2().setScore(0);
                actionForCurrentSet(player1, player2);
            } else {
                return;
            }
        }
    }

    public void actionForCurrentSet(Player player1, Player player2) {
        if ((tennisMatch.gamesInCurrentSetForPlayer(player1) == 6 && tennisMatch.gamesInCurrentSetForPlayer(player2) <= 4) || (tennisMatch.gamesInCurrentSetForPlayer(player1) == 7 && tennisMatch.gamesInCurrentSetForPlayer(player2) <= 5)) {
            tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisSet(player1);
            tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        } else if (tennisMatch.gamesInCurrentSetForPlayer(player1) == 6 && tennisMatch.gamesInCurrentSetForPlayer(player2) == 6 && tennisMatch.getTieBreakInLastSet()) {
            //Manage tieBreak
        } else if (tennisMatch.gamesInCurrentSetForPlayer(player1) == 6 && tennisMatch.gamesInCurrentSetForPlayer(player2) == 6 && !tennisMatch.getTieBreakInLastSet() && tennisMatch.getMatchType().numberOfSetsToWin() == tennisMatch.getTennisSetList().size()) {
            //Manage two games played by players to win
        } else {
            return;
        }
    }
}