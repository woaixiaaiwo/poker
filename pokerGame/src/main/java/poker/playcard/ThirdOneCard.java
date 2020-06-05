package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

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
        return null;
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
}
