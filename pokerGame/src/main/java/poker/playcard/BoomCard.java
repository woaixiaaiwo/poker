package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 炸弹
 */
public class BoomCard extends PlayCard {

    private Integer boomNum;

    public BoomCard(Integer boomNum) {
        this.boomNum = boomNum;
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
