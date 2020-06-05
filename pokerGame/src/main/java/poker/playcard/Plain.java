package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 飞机
 */
public class Plain extends PlayCard {

    private Integer baseNum;

    private Integer plainNum;

    //带单牌飞机
    private Boolean isSingle;

    public Plain(Integer baseNum, Integer plainNum) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
    }

    public Plain(Integer baseNum, Integer plainNum,Boolean isSingle) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
        isSingle = true;
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
