package fr.tennismatch;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TennisMatchTest {

    @Test
    public void scorePlayer() {
        Player player1 = new Player("Tristan");
        player1.setScore(4);
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, false);
        assertEquals(tennisMatch.pointsForPlayer(player1), "A");
    }

    @Test
    public void updateScorePlayer() {
        Player player1 = new Player("Tristan");
        player1.setScore(1);
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, false);
        tennisMatch.updateWithPointWonBy(player2);
        assertEquals(player2.getScore(), 1);
    }

    @Test
    public void jeuWinBy() {
        Player player1 = new Player("Tristan");
        player1.setScore(4);
        Player player2 = new Player("Jerome");
        player2.setScore(3);
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, false);
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals(tennisMatch.getTennisJeux().get(0).getWinner(), player1);
    }
}