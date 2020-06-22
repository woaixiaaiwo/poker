package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if(o instanceof FourTwoDoubleCard){
            return this.boonNum > ((FourTwoDoubleCard) o).boonNum;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        List<List<Card>> res = new ArrayList<>();
        List<List<Card>> lists = BoomCard.searchBoom(cardSequence);
        Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
        List<Integer> doubleCardNumList = sequenceMap.get(2);
        if(doubleCardNumList == null || doubleCardNumList.size() < 2)return res;
        List<List<Card>> doubleCardList = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        int i=0,j=0;
        while(j < cardList.size()){
            Card card = cardList.get(j++);
            if(card.getCardNumber().equals(doubleCardNumList.get(i))){
                cards.add(card);
            }else if(cards.size() == 2){
                doubleCardList.add(new ArrayList<>(cards));
                cards.clear();
                i++;
            }
        }
        if(lists.size() > 0){
            for(i=0;i<lists.size();i++){
                cards = lists.get(i);
                if(cards.get(0).getCardNumber() > this.boonNum){
                    List<Card> list = new ArrayList<>();
                    list.addAll(cards);
                    list.addAll(doubleCardList.get(0));
                    list.addAll(doubleCardList.get(1));
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
        for(int i=0;i<doubleNum.size();i++){
            list.add(new Card(i));
            list.add(new Card(i));
        }

        return list;
    }
}
