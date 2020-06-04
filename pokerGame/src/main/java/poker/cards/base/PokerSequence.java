package poker.cards.base;

import java.util.List;

public abstract class PokerSequence {

    private List<Card> sequence;

    public PokerSequence(List<Card> sequence){
        this.sequence = sequence;
    }

    /**
     * 用于比较牌的大小
     * a.compareTo(b)>0 => a>b
     * a.compareTo(b)<0 => a<b
     * @param o
     * @return
     */
    public abstract Boolean greaterThan(PokerSequence o);

}
