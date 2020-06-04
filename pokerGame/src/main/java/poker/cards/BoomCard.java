package poker.cards;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

/**
 * 炸弹
 */
public class BoomCard extends PokerSequence {

    public BoomCard(List<Card> sequence) {
        super(sequence);
    }

    @Override
    public Boolean greaterThan(PokerSequence o) {
        return null;
    }
}
