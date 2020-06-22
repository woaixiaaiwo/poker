package poker.game;

import poker.playcard.base.PlayCard;
import poker.player.Player;

public class MatchInfo {

    private PlayCard currentSequence;

    private Player currentPlayer;

    public PlayCard getCurrentSequence() {
        return currentSequence;
    }

    public void setCurrentSequence(PlayCard currentSequence) {
        this.currentSequence = currentSequence;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
