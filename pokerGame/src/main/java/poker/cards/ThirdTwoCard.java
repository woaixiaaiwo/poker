package poker.cards;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

/**
 * 三带二
 */
public class ThirdTwoCard extends PokerSequence {

    public ThirdTwoCard(List<Card> sequence) {
        super(sequence);
    }

    @Override
    public Boolean greaterThan(PokerSequence o) {
        return null;
    }
}
