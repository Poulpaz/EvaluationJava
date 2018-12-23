package fr.tennismatch;

public class TennisJeu {

    private Player winner;

    public TennisJeu(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
