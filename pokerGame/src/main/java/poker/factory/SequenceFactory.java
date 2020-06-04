package poker.factory;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.List;

public interface SequenceFactory {

    PokerSequence getPokerSequence(List<Card> cardList);

}
