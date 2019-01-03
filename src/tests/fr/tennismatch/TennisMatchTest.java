package fr.tennismatch;

import org.junit.Test;

import static org.junit.Assert.*;

public class TennisMatchTest {

    @Test
    public void scorePlayer() {
        Player player1 = new Player("Tristan");
        player1.setScore(4);
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        assertEquals(tennisMatch.pointsForPlayer(player1), "A");
    }

    @Test
    public void updateScorePlayer() {
        Player player1 = new Player("Tristan");
        player1.setScore(1);
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.updateWithPointWonBy(player2);
        assertEquals(player2.getScore(), 1);
    }

    @Test
    public void jeuWinBy() {
        Player player1 = new Player("Tristan");
        player1.setScore(4);
        Player player2 = new Player("Jerome");
        player2.setScore(3);
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals(tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).getTennisJeuList().get(0).getWinnerTennisJeu(), player1);
    }

    @Test
    public void gamesInCurrentSetForPlayer() {
        Player player1 = new Player("Tristan");
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        assertEquals(tennisMatch.gamesInCurrentSetForPlayer(player1) ,2);
    }

    @Test
    public void getCurrentSetNumber() {
        Player player1 = new Player("Tristan");
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        assertEquals(tennisMatch.currentSetNumber(), 3);
    }

    @Test
    public void getGamesInSetForPlayer(){
        Player player1 = new Player("Tristan");
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player2);
        assertEquals(tennisMatch.gamesInSetForPlayer(1, player2), 1);
    }

    @Test
    public void playerHasWonSet(){
        Player player1 = new Player("Tristan");
        Player player2 = new Player("Jerome");
        TennisMatch tennisMatch = new TennisMatch(MatchType.BEST_OF_FIVE, player1, player2, true);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player1);
        tennisMatch.getPlayer1().setScore(4);
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals(tennisMatch.currentSetNumber(), 2);
    }
}