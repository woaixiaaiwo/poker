package poker.cards;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

/**
 * 三带一
 */
public class ThirdOneCard extends PokerSequence {

    public ThirdOneCard(List<Card> sequence) {
        super(sequence);
    }

    @Override
    public Boolean greaterThan(PokerSequence o) {
        return null;
    }
}
