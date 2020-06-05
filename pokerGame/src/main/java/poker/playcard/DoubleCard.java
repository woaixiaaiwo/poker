package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
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
        List<Card> list = new ArrayList<>();
        for(int i=0;i<2;i++){
            list.add(new Card(baseNum));
        }
        return list;
    }
}
