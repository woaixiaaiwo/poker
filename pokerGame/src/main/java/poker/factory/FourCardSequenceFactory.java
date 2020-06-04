package poker.factory;

import poker.cards.BoomCard;
import poker.cards.DoubleCard;
import poker.cards.base.Card;
import poker.cards.base.PokerSequence;
import poker.cards.enums.CardEnum;

import java.util.*;

public class FourCardSequenceFactory extends SequenceFactory{

    @Override
    public PokerSequence getPokerSequence(List<Card> cardList) {
        if(cardList.size() == 8){
            List<Integer> sequenceNumList = new ArrayList<>();
            Map<Integer,List<Integer>> map = new HashMap<>();
            calculate(cardList,sequenceNumList,map);
            System.out.println(sequenceNumList);
            System.out.println(map);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Card> list = new ArrayList<>();
        list.add(new Card("3",3));
        list.add(new Card("3",3));
        list.add(new Card("3",3));
        list.add(new Card("4",4));
        list.add(new Card("4",4));
        list.add(new Card("4",4));
        list.add(new Card("5",5));
        list.add(new Card("5",5));
        new FourCardSequenceFactory().getPokerSequence(list);
    }
}
