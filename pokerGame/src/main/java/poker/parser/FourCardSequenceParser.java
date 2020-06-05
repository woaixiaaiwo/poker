package poker.parser;

import poker.NotMatchException;
import poker.playcard.BoomCard;
import poker.playcard.FourTwoCard;
import poker.playcard.FourTwoDoubleCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.playcard.base.PlayCard;

import java.util.*;

public class FourCardSequenceParser extends SequenceParser {

    @Override
    public PlayCard getPokerSequence(CardSequence cardSequence) {
        List<Card> cardList = cardSequence.getCardList();
        if(cardList.size() == 4){
            return new BoomCard(cardList.get(0).getCardNumber());
        }
        List<Integer> sequenceNumList = cardSequence.getSequenceNumList();
        //4带2
        if(cardList.size() == 6){
            if(sequenceNumList.get(1) != 2){
                throw new NotMatchException(cardList);
            }
            return new FourTwoCard(cardList.get(0).getCardNumber());
        }
        //4带2对
        if(cardList.size() == 8){
            Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
            List<Integer> doubleCardList = sequenceMap.get(2);
            if(doubleCardList == null || doubleCardList.size() != 2){
                throw new NotMatchException(cardList);
            }
            return new FourTwoDoubleCard(cardList.get(0).getCardNumber());
        }
        throw new NotMatchException(cardList);
    }
}
