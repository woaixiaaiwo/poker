package poker.factory;

import poker.cards.BoomCard;
import poker.cards.DoubleCard;
import poker.cards.base.Card;
import poker.cards.base.PokerSequence;
import poker.cards.enums.CardEnum;

import java.util.*;

public class FourCardSequenceFactory implements SequenceFactory{

    @Override
    public PokerSequence getPokerSequence(List<Card> cardList) {
        if(cardList.size() == 4){
            Map<Card,Integer> tmp = new HashMap<>();
            for(Card card:cardList){
                Integer num = tmp.get(card);
                if(num == null){
                    tmp.put(card,1);
                }else {
                    tmp.put(card,num+1);
                }
            }
            Map<Integer,Card> map = new HashMap<>();
            for(Map.Entry<Card,Integer> entry:tmp.entrySet()){
                map.put(entry.getValue(),entry.getKey());
            }
            if(map.size() == 1){
                return new BoomCard(cardList);
            }

        }
        return null;
    }
}
