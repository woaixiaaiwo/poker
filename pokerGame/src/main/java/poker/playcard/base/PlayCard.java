package poker.playcard.base;

import poker.CardDisplayer;
import poker.sequence.base.Card;

import java.util.List;

public abstract class PlayCard {

    private CardDisplayer cardDisplayer = new CardDisplayer();

    /**
     * 用于比较牌的大小
     * a.compareTo(b)>0 => a>b
     * a.compareTo(b)<0 => a<b
     * @param o
     * @return
     */
    public abstract Boolean greaterThan(PlayCard o);

    /**
     * 获取card列表
     */
    public abstract List<Card>  getCardList();

    /**
     * 显示牌
     */
    public String disPlay(){
        return cardDisplayer.display(getCardList());
    }

}
