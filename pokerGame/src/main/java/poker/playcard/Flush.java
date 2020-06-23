package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺子
 */
public class Flush  extends PlayCard {

    private Integer baseNum;

    private Integer cardNum;

    public Flush(Integer baseNum,Integer cardNum) {
        this.baseNum = baseNum;
        this.cardNum = cardNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof Flush){
            Flush flush = (Flush)o;
            return (this.cardNum == flush.cardNum) && (this.baseNum > flush.baseNum);
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        int i=0,nextBegin=0;
        List<List<Card>> res = new ArrayList<>();
        List<Card> flushCard = new ArrayList<>();
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.baseNum){
                if(flushCard.size() > 0){
                    if((card.getCardNumber() - flushCard.get(flushCard.size() - 1).getCardNumber() == 1) &&
                        card.getCardNumber() >= CardEnum.Three.getCardNum() && card.getCardNumber() <= CardEnum.Ace.getCardNum()){
                        flushCard.add(card);
                        if(flushCard.size() == this.cardNum){
                            res.add(new ArrayList<Card>(flushCard));
                            flushCard.clear();
                            i = nextBegin;
                        }
                    }
                }else {
                    flushCard.add(card);
                    nextBegin = i;
                    while(nextBegin < cardList.size() && cardList.get(nextBegin).getCardNumber().equals(card.getCardNumber())){
                        nextBegin++;
                    }
                }
                if(i == cardList.size()-1 && nextBegin != 0){
                    i = nextBegin;
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
        }
        return list;
    }

    @Override
    public String getName() {
        return "顺子~";
    }
}
