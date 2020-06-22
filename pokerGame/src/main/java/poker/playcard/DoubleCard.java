package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对子
 */
public class DoubleCard extends PlayCard {

    private Integer baseNum;

    public DoubleCard(Integer baseNum) {
        this.baseNum = baseNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof DoubleCard){
            return this.baseNum > ((DoubleCard)o).baseNum;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList,CardSequence cardSequence) {
        int i=0;
        List<List<Card>> res = new ArrayList<>();
        List<Card> doubleCard = new ArrayList<>();
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.baseNum){
                if(doubleCard.size() > 0){
                    if(doubleCard.get(0).equals(card.getCardNumber())){
                        doubleCard.add(card);
                        res.add(new ArrayList<>(doubleCard));
                        doubleCard.clear();
                    }else {
                        doubleCard.clear();
                    }
                }else {
                    doubleCard.add(card);
                }
            }
        }
        return res;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> list = new ArrayList<>();
        for(int i=0;i<2;i++){
            list.add(new Card(baseNum));
        }
        return list;
    }
}
