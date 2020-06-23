package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 三带一
 */
public class ThirdOneCard extends PlayCard {

    private Integer baseNum;

    private Integer singleNum;

    public ThirdOneCard(Integer baseNum,Integer singleNum) {
        this.baseNum = baseNum;
        this.singleNum = singleNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof ThirdOneCard){
            return this.baseNum > ((ThirdOneCard) o).baseNum;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        int i=0;
        List<List<Card>> res = new ArrayList<>();
        List<Card> thirdCard = new ArrayList<>();
        if(cardList.size() < 4)return res;
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.baseNum){
                if(thirdCard.size() > 0){
                    if(thirdCard.get(thirdCard.size() - 1).equals(card.getCardNumber())){
                        thirdCard.add(card);
                        if(thirdCard.size() == 3){
                            if(cardList.get(0) != thirdCard.get(0)){
                                thirdCard.add(cardList.get(0));
                            }else{
                                thirdCard.add(cardList.get(3));
                            }
                            res.add(new ArrayList<>(thirdCard));
                            thirdCard.clear();
                        }
                    }else {
                        thirdCard.clear();
                    }
                }else {
                    thirdCard.add(card);
                }
            }
        }
        return res;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(baseNum));
        cards.add(new Card(baseNum));
        cards.add(new Card(baseNum));
        cards.add(new Card(singleNum));
        return cards;
    }

    @Override
    public String getName() {
        return "三带一";
    }
}
