package poker.cards;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

/**
 * 对子
 */
public class DoubleCard extends PokerSequence {

    public DoubleCard(List<Card> sequence) {
        super(sequence);
    }

    @Override
    public Boolean greaterThan(PokerSequence o) {
        return null;
    }
}
