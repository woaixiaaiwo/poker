package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 三带二
 */
public class ThirdTwoCard extends PlayCard {

    private Integer baseNum;

    private Integer doubleNum;

    public ThirdTwoCard(Integer baseNum,Integer doubleNum) {
        this.baseNum = baseNum;
        this.doubleNum = doubleNum;
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
