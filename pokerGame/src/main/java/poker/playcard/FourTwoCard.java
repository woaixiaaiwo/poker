package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 四带二
 */
public class FourTwoCard extends PlayCard {

    private Integer baseNum;

    public FourTwoCard(Integer baseNum) {
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
