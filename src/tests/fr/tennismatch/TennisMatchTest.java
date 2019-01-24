package fr.tennismatch;

import org.junit.Test;

import static org.junit.Assert.*;

public class TennisMatchTest {

    public TennisMatch startTennisMatch(String namePlayer1, String namePlayer2, MatchType matchType, Boolean tieBreak) {
        Player player1 = new Player(namePlayer1);
        Player player2 = new Player(namePlayer2);
        return new TennisMatch(matchType, player1, player2, tieBreak);
    }

    public void setWinnerTennisJeu(TennisMatch tennisMatch, Player player, int nbJeu) {
        for (int i = 0 ; i < nbJeu ; i ++) {
            tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisJeu(player);
        }
    }

    @Test
    public void scorePlayer() {
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        tennisMatch.getPlayer1().setScore(4);
        assertEquals(tennisMatch.pointsForPlayer(tennisMatch.getPlayer1()), "A");
    }

    @Test
    public void updateScorePlayer() {
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        tennisMatch.getPlayer1().setScore(1);
        tennisMatch.updateWithPointWonBy(tennisMatch.getPlayer2());
        assertEquals(tennisMatch.getPlayer2().getScore(), 1);
    }

    @Test
    public void jeuWinBy() {
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        tennisMatch.getPlayer1().setScore(4);
        tennisMatch.getPlayer2().setScore(3);
        tennisMatch.updateWithPointWonBy(tennisMatch.getPlayer1());
        assertEquals(tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).getBaseGameList().get(0).getWinnerBaseGame(), tennisMatch.getPlayer1());
    }

    @Test
    public void gamesInCurrentSetForPlayer() {
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer1(), 2);
        assertEquals(tennisMatch.gamesInCurrentSetForPlayer(tennisMatch.getPlayer1()) ,2);
    }

    @Test
    public void getCurrentSetNumber() {
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        assertEquals(tennisMatch.currentSetNumber(), 3);
    }

    @Test
    public void getGamesInSetForPlayer(){
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer1(), 2);
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer2(), 1);
        assertEquals(tennisMatch.gamesInSetForPlayer(1, tennisMatch.getPlayer2()), 1);
    }

    @Test
    public void playerHasWonSet(){
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer1(), 5);
        tennisMatch.getPlayer1().setScore(4);
        tennisMatch.updateWithPointWonBy(tennisMatch.getPlayer1());
        assertEquals(tennisMatch.currentSetNumber(), 2);
    }

    @Test
    public void isFinishedWithBestOfThree(){
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_THREE, true);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisSet(tennisMatch.getPlayer1());
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer1(), 5);
        tennisMatch.getPlayer1().setScore(4);
        tennisMatch.updateWithPointWonBy(tennisMatch.getPlayer1());
        assertEquals(tennisMatch.isFinished(), true);
    }

    @Test
    public void isFinishedWithBestOfFive(){
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_FIVE, true);
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisSet(tennisMatch.getPlayer1());
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        tennisMatch.getTennisSetList().get(tennisMatch.getTennisSetList().size() - 1).setWinnerTennisSet(tennisMatch.getPlayer1());
        tennisMatch.getTennisSetList().add(new TennisSet(tennisMatch.getTennisSetList().size() + 1));
        setWinnerTennisJeu(tennisMatch, tennisMatch.getPlayer1(), 5);
        tennisMatch.getPlayer1().setScore(4);
        tennisMatch.updateWithPointWonBy(tennisMatch.getPlayer1());
        assertEquals(tennisMatch.isFinished(), true);
    }

    @Test
    public void simulateTennisMatchFromStartToEnd(){
        TennisMatch tennisMatch = startTennisMatch("Tristan", "Jerome", MatchType.BEST_OF_THREE, true);
    }
}