package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺子
 */
public class Flush  extends PlayCard {

    private Integer baseNum;

    private Integer cardNum;

    public Flush(Integer baseNum,Integer cardNum) {
        this.baseNum = baseNum;
        this.cardNum = cardNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        return null;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> list = new ArrayList<>();
        for(int i=baseNum;i<baseNum+cardNum;i++){
            list.add(new Card(i));
        }
        return list;
    }
}
