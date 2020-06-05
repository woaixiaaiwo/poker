package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 连对
 */
public class FlushDouble extends PlayCard {

    private Integer baseNum;

    private Integer cardNum;

    public FlushDouble(Integer baseNum,Integer cardNum) {
        this.baseNum = baseNum;
        this.cardNum = cardNum;
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
