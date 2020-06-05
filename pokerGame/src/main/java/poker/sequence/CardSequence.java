package poker.sequence;

import poker.sequence.base.Card;
import poker.utils.ListUtil;

import java.util.*;

public class CardSequence extends CountableSequence{

    public CardSequence(List<Card> cardList){
        this.cardList = cardList;
    }

    /**
     * 获取牌最大出现次数
     */
    public Integer getMaxRepeatNum(){
        if(sequenceNumList == null || sequenceNumList.size() == 0){
            refreshInfo();
        }
        if(sequenceNumList.size() > 0){
            return sequenceNumList.get(0);
        }
        return 0;
    }

    public boolean isContinuitySequence(){
        return ListUtil.isContinuityList(cardNumList);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public List<Integer> getSequenceNumList() {
        return sequenceNumList;
    }

    public Map<Integer, List<Integer>> getSequenceMap() {
        return sequenceMap;
    }


}
