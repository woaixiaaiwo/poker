package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 连对
 */
public class FlushDouble extends PlayCard {

    private Integer baseNum;

    private Integer cardNum;

    public FlushDouble(Integer baseNum,Integer cardNum) {
        this.baseNum = baseNum;
        this.cardNum = cardNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof FlushDouble){
            FlushDouble flushDouble = (FlushDouble)o;
            return (this.cardNum == flushDouble.cardNum) && (this.baseNum > flushDouble.baseNum);
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        List<Card> flushDoubleList = new ArrayList<>();
        List<List<Card>> res = new ArrayList<>();
        int j=0,nextBegin=0;
        while(j < cardList.size()){
            Card card = cardList.get(j++);
            if(card.getCardNumber() > this.baseNum){
                if(flushDoubleList.size() > 0){
                    if(card.getCardNumber() >= CardEnum.Three.getCardNum() && card.getCardNumber() <= CardEnum.Ace.getCardNum()){
                        int size = flushDoubleList.size();
                        if(size % 2 == 0){
                            if(card.getCardNumber() - flushDoubleList.get(flushDoubleList.size() - 1).getCardNumber() == 1){
                                flushDoubleList.add(card);
                            }
                        }else{
                            if(card.getCardNumber() .equals(flushDoubleList.get(flushDoubleList.size() - 1).getCardNumber())){
                                flushDoubleList.add(card);
                            }else{
                                flushDoubleList.clear();
                                j = nextBegin;
                                continue;
                            }
                        }
                        if(flushDoubleList.size() == this.cardNum){
                            res.add(new ArrayList<Card>(flushDoubleList));
                            flushDoubleList.clear();
                            j = nextBegin;
                        }
                    }
                }else {
                    nextBegin = j;
                    while(nextBegin < cardList.size() && cardList.get(nextBegin).getCardNumber().equals(card.getCardNumber())){
                        nextBegin++;
                    }
                }
                if(j == cardList.size() - 1 && nextBegin != 0){
                    j = nextBegin;
                }
            }
        }
        return res;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> list = new ArrayList<>();
        for(int i=baseNum;i<baseNum+cardNum;i++){
            list.add(new Card(i));
            list.add(new Card(i));
        }
        return list;
    }

    @Override
    public String getName() {
        return "连对~~";
    }
}
