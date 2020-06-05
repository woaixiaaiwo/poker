package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 四带二
 */
public class FourTwoCard extends PlayCard {

    private Integer boonNum;

    private Integer singleNum;

    public FourTwoCard(Integer boonNum, Integer singleNum) {
        this.boonNum = boonNum;
        this.singleNum = singleNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        return null;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add(new Card(boonNum));
        }
        list.add(new Card(singleNum));
        list.add(new Card(singleNum));
        return list;
    }
}
