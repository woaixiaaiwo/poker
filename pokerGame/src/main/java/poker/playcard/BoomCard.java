package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
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
        List<Card> list = new ArrayList<>();
        if(boomNum == CardEnum.Joker1.getCardNum()){
            list.add(new Card(boomNum));
            list.add(new Card(boomNum+1));
        }else{
            for(int i=0;i<4;i++){
                list.add(new Card(boomNum));
            }
        }
        return list;
    }
}
