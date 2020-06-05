package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Card> getCardList() {
        return null;
    }
}
