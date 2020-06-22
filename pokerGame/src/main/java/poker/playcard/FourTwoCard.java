package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if(o instanceof FourTwoCard){
            return this.boonNum > ((FourTwoCard) o).boonNum;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        List<List<Card>> res = new ArrayList<>();
        List<List<Card>> lists = BoomCard.searchBoom(cardSequence);
        Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
        List<Integer> singleCardNumList = sequenceMap.get(1);
        if(singleCardNumList == null || singleCardNumList.size() < 2)return res;
        Card card1 = null,card2 = null;
        int i=0,j=0;
        while(j < cardList.size()){
            Card card = cardList.get(j++);
            if(card.getCardNumber().equals(singleCardNumList.get(i))){
                if(card1 == null){
                    card1 = card;
                    i++;
                }else {
                    card2 = card;
                    break;
                }
            }
        }
        List<Card> cards = new ArrayList<>();
        if(lists.size() > 0){
            for(i=0;i<lists.size();i++){
                cards = lists.get(i);
                if(cards.get(0).getCardNumber() > this.boonNum){
                    List<Card> list = new ArrayList<>();
                    list.addAll(cards);
                    list.add(card1);
                    list.add(card2);
                    res.add(list);
                }
            }
        }
        return res;
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
