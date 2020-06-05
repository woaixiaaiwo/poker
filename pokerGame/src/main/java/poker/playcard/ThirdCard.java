package poker.playcard;

import poker.playcard.base.PlayCard;
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
        return null;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(num));
        cards.add(new Card(num));
        cards.add(new Card(num));
        return cards;
    }
}
