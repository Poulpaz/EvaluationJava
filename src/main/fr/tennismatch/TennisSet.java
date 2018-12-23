package fr.tennismatch;

import java.util.ArrayList;
import java.util.List;

public class TennisSet {

    private int numberOfSet;
    private Player winnerTennisSet;
    private List<TennisJeu> tennisJeuList;

    public TennisSet(int numberOfSet) {
        this.numberOfSet = numberOfSet;
        this.winnerTennisSet = null;
        this.tennisJeuList = new ArrayList<>();
    }

    public void setWinnerTennisJeu(Player winnerTennisJeu) {
        tennisJeuList.add(new TennisJeu(winnerTennisJeu));
    }

    public Player getWinnerTennisSet() {
        return winnerTennisSet;
    }

    public void setWinnerTennisSet(Player winnerTennisSet) {
        this.winnerTennisSet = winnerTennisSet;
    }

    public int getNumberOfSet() {
        return numberOfSet;
    }

    public List<TennisJeu> getTennisJeuList() {
        return tennisJeuList;
    }
}
