package poker.playcard;

import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if(o instanceof BoomCard){
            return this.boomNum > ((BoomCard)o).boomNum;
        }
        return true;
    }

    public static List<List<Card>> searchBoom(CardSequence cardSequence){
        List<List<Card>> res = new ArrayList<>();
        Integer maxRepeatNum = cardSequence.getMaxRepeatNum();
        Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
        List<Card> cardList = cardSequence.getCardList();
        if(maxRepeatNum == 4){
            List<Integer> integers = sequenceMap.get(4);
            List<Card> boom = new ArrayList<>();
            int i=0,j=0;
            while(j < cardList.size()){
                Card card = cardList.get(j++);
                if(card.getCardNumber().equals(integers.get(i))){
                    boom.add(card);
                }else if(boom.size() == 4){
                    res.add(new ArrayList<>(boom));
                    boom.clear();
                    i++;
                }
            }
        }
        //查找是否有王炸
        if(cardList.get(cardList.size() - 2).getCardNumber().equals(CardEnum.Joker1.getCardNum())){
            List<Card> boom = new ArrayList<>();
            boom.add(cardList.get(cardList.size() - 2));
            boom.add(cardList.get(cardList.size() - 1));
            res.add(boom);
        }
        return res;
    }

    @Override
    public List<List<Card>> doSearchSuggest(List<Card> cardList,CardSequence cardSequence) {
        List<List<Card>> result = new ArrayList<>();
        List<List<Card>> lists = searchBoom(cardSequence);
        if(lists.size() > 0){
            for(int i=0;i<lists.size();i++){
                List<Card> cards = lists.get(i);
                if(cards.get(0).getCardNumber() > this.boomNum){
                    result.add(cards);
                }
            }
        }
        return result;
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

    @Override
    public String getName() {
        if(boomNum == CardEnum.Joker1.getCardNum()){
            return "王炸！！！";
        }
        return "炸弹！";
    }
}
