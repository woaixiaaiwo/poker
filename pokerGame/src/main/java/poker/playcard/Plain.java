package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 飞机
 */
public class Plain extends PlayCard {

    private Integer baseNum;

    private Integer plainNum;

    private List<Integer> otherNums;

    //带单牌飞机
    private Boolean isSingle;

    public Plain(Integer baseNum, Integer plainNum,List<Integer> otherNums) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
        this.otherNums = otherNums;
    }

    public Plain(Integer baseNum, Integer plainNum,List<Integer> otherNums,Boolean isSingle) {
        this.baseNum = baseNum;
        this.plainNum = plainNum;
        this.otherNums = otherNums;
        isSingle = true;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        return null;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> list = new ArrayList<>();
        for(int i=baseNum;i<baseNum+plainNum;i++){
            for(int j=0;j<3;j++){
                list.add(new Card(i));
            }
        }
        for(int i=0;i<otherNums.size();i++){
            list.add(new Card(otherNums.get(i)));
        }
        return list;
    }

}
