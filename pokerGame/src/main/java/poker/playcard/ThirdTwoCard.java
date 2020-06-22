package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 三带二
 */
public class ThirdTwoCard extends PlayCard {

    private Integer baseNum;

    private Integer doubleNum;

    public ThirdTwoCard(Integer baseNum,Integer doubleNum) {
        this.baseNum = baseNum;
        this.doubleNum = doubleNum;
    }

    @Override
    public Boolean greaterThan(PlayCard o) {
        if(o instanceof ThirdTwoCard){
            return this.baseNum > ((ThirdTwoCard) o).baseNum;
        }
        return false;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList, CardSequence cardSequence) {
        List<List<Card>> res = new ArrayList<>();
        List<Card> thirdTwoCard = new ArrayList<>();
        Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
        List<Integer> doubleCardNumList = sequenceMap.get(2);
        if(doubleCardNumList == null || doubleCardNumList.size() == 0)return res;
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
        if(cardList.size() < 4)return res;
        while(i < cardList.size()){
            Card card = cardList.get(i++);
            if(card.getCardNumber() > this.baseNum){
                if(thirdTwoCard.size() > 0){
                    if(thirdTwoCard.get(thirdTwoCard.size() - 1).equals(card.getCardNumber())){
                        thirdTwoCard.add(card);
                        if(thirdTwoCard.size() == 3){
                            thirdTwoCard.addAll(doubleCardList.get(0));
                            res.add(new ArrayList<>(thirdTwoCard));
                            thirdTwoCard.clear();
                        }
                    }else {
                        thirdTwoCard.clear();
                    }
                }else {
                    thirdTwoCard.add(card);
                }
            }
        }
        return res;
    }

    @Override
    public List<Card> getCardList() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(baseNum));
        cards.add(new Card(baseNum));
        cards.add(new Card(baseNum));
        cards.add(new Card(doubleNum));
        cards.add(new Card(doubleNum));
        return cards;
    }
}
