package fr.tennismatch;

public class BaseGame {

    private Player winnerBaseGame;

    public BaseGame(Player winnerBaseGame) {
        this.winnerBaseGame = winnerBaseGame;
    }

    public Player getWinnerBaseGame() {
        return winnerBaseGame;
    }
}
