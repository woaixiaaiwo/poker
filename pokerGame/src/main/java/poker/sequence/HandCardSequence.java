package poker.sequence;

import poker.display.CardDisplayer;
import poker.display.DefaultCardDisplayer;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 手牌
 */
public class HandCardSequence extends CountableSequence{

    private CardDisplayer cardDisplayer;

    private Integer sortType = SORT_BY_NUM;

    public final static Integer SORT_BY_NUM = 1;

    public final static Integer SORT_BY_COUNT = 2;

    public HandCardSequence(){
        this(new ArrayList<Card>(),new DefaultCardDisplayer());
    }

    public HandCardSequence(List<Card> cardList){
        this(cardList,new DefaultCardDisplayer());
    }

    public HandCardSequence(List<Card> cardList,CardDisplayer cardDisplayer) {
        this.cardDisplayer = cardDisplayer;
        this.cardList = cardList;
    }

    public void dealCard(List<Card> dealCardList){
        for(Card card:dealCardList){
            cardList.remove(card);
        }
        sort();
    }

    public void playCard(List<Card> playList){
        for(Card card:playList){
            cardList.remove(card);
        }
        refreshInfo();
        cardDisplayer.display(cardList);
    }

    public void setCardDisplayer(CardDisplayer cardDisplayer) {
        this.cardDisplayer = cardDisplayer;
    }

    public void sort(Integer sortType){
        this.sortType = sortType;
        sort();
    }

    public void sort(){
        if(sortType == SORT_BY_NUM){
            Collections.sort(cardList, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o2.getCardNumber() - o1.getCardNumber();
                }
            });
        }
        if(sortType == SORT_BY_COUNT){
            refreshInfo();
            cardList.clear();
            for(Integer integer:cardNumList){
                List<Integer> cardNums = sequenceMap.get(integer);
                for(Integer cardNum:cardNums){
                    cardList.add(new Card(cardNum));
                }
            }
        }
        cardDisplayer.display(cardList);
    }

}
