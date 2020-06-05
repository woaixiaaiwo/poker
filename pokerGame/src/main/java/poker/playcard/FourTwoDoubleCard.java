package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 四带两对
 */
public class FourTwoDoubleCard extends PlayCard {

    private Integer boonNum;

    private List<Integer> doubleNum;

    public FourTwoDoubleCard(Integer boonNum, List<Integer> doubleNum) {
        this.boonNum = boonNum;
        this.doubleNum = doubleNum;
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
        for(int i=0;i<doubleNum.size();i++){
            list.add(new Card(i));
            list.add(new Card(i));
        }

        return list;
    }
}
