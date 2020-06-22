package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 飞机
 */
public class Plain extends PlayCard {

    private Integer baseNum;

    private Integer plainNum;

    private List<Integer> otherNums;

    //带单牌飞机
    private Boolean isSingle;

    public Plain(Integer baseNum, Integer plainNum,List<Integer> otherNums) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
        this.otherNums = otherNums;
    }

    public Plain(Integer baseNum, Integer plainNum,List<Integer> otherNums,Boolean isSingle) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
        this.otherNums = otherNums;
        isSingle = true;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof Plain){
            Plain plain = (Plain)o;
            return (this.plainNum == plain.plainNum) && (this.baseNum > plain.baseNum);
        }
        return false;
    }

    @Override
    //todo:后续可以优化
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
                        if(size % 3 == 0){
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
                        if(flushDoubleList.size() == this.plainNum){
                            res.add(new ArrayList<>(flushDoubleList));
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
        for(int i=baseNum;i<baseNum+plainNum;i++){
            for(int j=0;j<3;j++){
                list.add(new Card(i));
            }
        }
        for(int i=0;i<otherNums.size();i++){
            list.add(new Card(otherNums.get(i)));
        }
        return list;
    }

}
