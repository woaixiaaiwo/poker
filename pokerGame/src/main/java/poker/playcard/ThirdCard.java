package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 三张
 */
public class ThirdCard extends PlayCard {

    private Integer num;

    public ThirdCard(Integer num) {
        this.num = num;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof ThirdCard){
            return this.num > ((ThirdCard) o).num;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        int i=0;
        List<List<Card>> res = new ArrayList<>();
        List<Card> thirdCard = new ArrayList<>();
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.num){
                if(thirdCard.size() > 0){
                    if(thirdCard.get(thirdCard.size() - 1).equals(card.getCardNumber())){
                        thirdCard.add(card);
                        if(thirdCard.size() == 3){
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
        cards.add(new Card(num));
        cards.add(new Card(num));
        cards.add(new Card(num));
        return cards;
    }

    @Override
    public String getName() {
        return "三个"+Card.getChineseName(num);
    }
}
