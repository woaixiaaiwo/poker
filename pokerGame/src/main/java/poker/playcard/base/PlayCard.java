package poker.playcard.base;

import poker.display.CardDisplayer;
import poker.display.DefaultCardDisplayer;
import poker.playcard.BoomCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class PlayCard {

    private CardDisplayer cardDisplayer = new DefaultCardDisplayer();

    /**
     * 用于比较牌的大小
     * a.compareTo(b)>0 => a>b
     * a.compareTo(b)<0 => a<b
     * @param o
     * @return
     */
    public abstract Boolean greaterThan(PlayCard o);

    public List<List<Card>> searchSuggest(List<Card> cardList){
        List<Card> copyCardList = new ArrayList<>(cardList);
        Collections.sort(copyCardList);
        CardSequence cardSequence = new CardSequence(copyCardList);
        cardSequence.refreshInfo();
        List<List<Card>> res = doSearchSuggest(copyCardList,cardSequence);
        if(this.getClass() != BoomCard.class){
            res.addAll(BoomCard.searchBoom(cardSequence));
        }
        return res;
    }

    /**
     * 从指定牌组中搜索提示，即比指定参数大的牌组
     * @param cardList
     * @return
     */
    public abstract List<List<Card>> doSearchSuggest(List<Card> cardList,CardSequence cardSequence);

    /**
     * 获取card列表
     */
    public abstract List<Card>  getCardList();

    public abstract String  getName();

    public void setCardDisplayer(CardDisplayer cardDisplayer) {
        this.cardDisplayer = cardDisplayer;
    }

    /**
     * 显示牌
     */
    public String disPlay(){
        return getName()+"："+cardDisplayer.display(getCardList());
    }

}
