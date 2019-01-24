package fr.tennismatch;

import java.util.ArrayList;
import java.util.List;

public class TennisSet {

    private int setNumber;
    private Player winnerTennisSet;
    private List<BaseGame> baseGameList;

    public TennisSet(int numberOfSet) {
        this.setNumber = numberOfSet;
        this.winnerTennisSet = null;
        this.baseGameList = new ArrayList<>();
    }

    public void setWinnerTennisJeu(Player winnerTennisJeu) {
        baseGameList.add(new TennisGame(winnerTennisJeu));
    }

    public Player getWinnerTennisSet() {
        return winnerTennisSet;
    }

    public void setWinnerTennisSet(Player winnerTennisSet) {
        this.winnerTennisSet = winnerTennisSet;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public List<BaseGame> getBaseGameList() {
        return baseGameList;
    }
}