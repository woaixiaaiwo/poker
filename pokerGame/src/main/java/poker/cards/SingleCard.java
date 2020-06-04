package poker.cards;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

/**
 * 单牌
 */
public class SingleCard extends PokerSequence {

    public SingleCard(List<Card> sequence) {
        super(sequence);
    }

    @Override
    public Boolean greaterThan(PokerSequence o) {
        return null;
    }
}
