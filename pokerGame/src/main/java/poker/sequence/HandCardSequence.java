package poker.sequence;

import poker.display.CardDisplayer;
import poker.display.DefaultCardDisplayer;
import poker.sequence.base.Card;

import java.util.*;

/**
 * 手牌
 */
public class HandCardSequence extends CountableSequence{

    private CardDisplayer cardDisplayer;

    private Integer sortType = SORT_BY_NUM;

    public final static Integer SORT_BY_NUM = 1;

    public final static Integer SORT_BY_COUNT = 2;

    public HandCardSequence(){
        this(new ArrayList<Card>(),new DefaultCardDisplayer());
    }

    public HandCardSequence(List<Card> cardList){
        this(cardList,new DefaultCardDisplayer());
    }

    public HandCardSequence(List<Card> cardList,CardDisplayer cardDisplayer) {
        this.cardDisplayer = cardDisplayer;
        this.cardList = cardList;
    }

    /**
     * 发牌
     * @param dealCardList
     */
    public void dealCard(List<Card> dealCardList){
        for(Card card:dealCardList){
            cardList.add(card);
        }
        sort();
    }

    public String displayCard(){
        return cardDisplayer.display(cardList);
    }

    public Integer getCardNum(){
        return cardList.size();
    }

    /**
     * 解析牌
     * @param str
     */
    public List<Card> parsePlayList(String str){
        List<Card> res = new ArrayList<>();
        String[] strs = str.split(" ");
        List<Card> cards = new ArrayList<>(cardList);
        for(int i=0;i<strs.length;i++){
            Iterator<Card> iterator = cards.iterator();
            while (iterator.hasNext()){
                Card card = iterator.next();
                if(card.getCardName().equalsIgnoreCase(strs[i])){
                    res.add(card);
                    if(res.size() == strs.length){
                        return res;
                    }
                    iterator.remove();
                    break;
                }
            }
        }
        throw new RuntimeException("输入的序列在手牌中不存在");
    }

    /**
     * 出牌
     * @param playList
     */
    public String playCard(List<Card> playList){
        for(Card card:playList){
            cardList.remove(card);
        }
        refreshInfo();
        return cardDisplayer.display(cardList);
    }

    public void setCardDisplayer(CardDisplayer cardDisplayer) {
        this.cardDisplayer = cardDisplayer;
    }

    public void sort(Integer sortType){
        this.sortType = sortType;
        sort();
    }

    public void sort(){
        if(sortType == SORT_BY_NUM){
            Collections.sort(cardList, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.getCardNumber() - o2.getCardNumber();
                }
            });
        }
        if(sortType == SORT_BY_COUNT){
            refreshInfo();
            cardList.clear();
            for(Integer integer:sequenceNumList){
                List<Integer> cardNums = sequenceMap.get(integer);
                if(cardNums != null){
                    for(Integer cardNum:cardNums){
                        for(int i=0;i<integer;i++){
                            cardList.add(new Card(cardNum));
                        }
                    }
                }
            }
        }
    }

}
