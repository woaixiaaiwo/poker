package poker.factory;

import poker.cards.BoomCard;
import poker.cards.DoubleCard;
import poker.cards.base.Card;
import poker.cards.base.PokerSequence;
import poker.cards.enums.CardEnum;

import java.util.List;

public class TwoCardSequenceFactory extends SequenceFactory{

    @Override
    public PokerSequence getPokerSequence(List<Card> cardList) {
        if(cardList.size() == 2){
            if(cardList.get(0).equals(cardList.get(1))){
                return new DoubleCard(cardList);
            }
            if(cardList.get(0).getCardNumber().equals(CardEnum.Joker1.getCardNum()) || cardList.get(1).getCardNumber().equals(CardEnum.Joker2.getCardNum())){
                return new BoomCard(cardList);
            }
        }
        return null;
    }
}
