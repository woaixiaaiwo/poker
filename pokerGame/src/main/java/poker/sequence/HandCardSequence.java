package poker.sequence;

import poker.sequence.base.Card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 手牌
 */
public class HandCardSequence extends CountableSequence{

    private Integer sortType = SORT_BY_NUM;

    public final static Integer SORT_BY_NUM = 1;

    public final static Integer SORT_BY_COUNT = 2;


    public void playCard(List<Card> playList){

    }

    public void sort(Integer sortType){
        this.sortType = sortType;
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

        }
    }

}
