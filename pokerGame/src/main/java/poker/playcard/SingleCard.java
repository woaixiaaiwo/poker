package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 单牌
 */
public class SingleCard extends PlayCard {

    private Integer num;

    public SingleCard(Integer num) {
        this.num = num;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof SingleCard){
            return this.num > ((SingleCard) o).num;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        int i=0;
        List<List<Card>> res = new ArrayList<>();
        List<Card> singleCard = new ArrayList<>();
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.num){
                singleCard.add(card);
                res.add(new ArrayList<>(singleCard));
                singleCard.clear();
            }
        }
        return res;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(num));
        return cards;
    }
}
