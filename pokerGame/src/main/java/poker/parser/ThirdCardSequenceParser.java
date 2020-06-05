package poker.parser;

import poker.NotMatchException;
import poker.playcard.*;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.playcard.base.PlayCard;
import poker.sequence.enums.CardEnum;
import poker.utils.ListUtil;

import java.util.List;
import java.util.Map;

public class ThirdCardSequenceParser extends SequenceParser {

    @Override
    public PlayCard getPokerSequence(CardSequence cardSequence) {
        List<Card> cardList = cardSequence.getCardList();
        //单个三张
        if(cardList.size() == 3){
            return new ThirdCard(cardList.get(0).getCardNumber());
        }
        //三带一
        if(cardList.size() == 4){
            return new ThirdOneCard(cardList.get(0).getCardNumber());
        }
        List<Integer> sequenceNumList = cardSequence.getSequenceNumList();
        //三带二
        if(cardList.size() == 5){
            if(sequenceNumList.get(1) != 2){
                throw new NotMatchException(cardList);
            }
            return new ThirdTwoCard(cardList.get(0).getCardNumber());
        }
        //飞机
        if(cardList.size() >= 6){
            Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
            List<Integer> thirdList = sequenceMap.get(3);
            List<Integer> twoList = sequenceMap.get(2);
            List<Integer> oneList = sequenceMap.get(1);
            Integer firstNum = thirdList.get(0);
            Integer lastNum = thirdList.get(thirdList.size() - 1);
            boolean hasSingle = false;
            if(oneList.size() != 0){
                //把两张牌当做一张牌看，2张牌*2和1张牌的个数加起来不等于3张牌的个数，不符合规则
                if((oneList.size() + twoList.size()*2) != thirdList.size()){
                    throw new NotMatchException(cardList);
                }
                hasSingle = true;
            }else{
                if(twoList.size() != thirdList.size()){
                    throw new NotMatchException(cardList);
                }
            }
            if(firstNum >= CardEnum.Three.getCardNum() && lastNum <= CardEnum.Ace.getCardNum()){
                if(!ListUtil.isContinuityList(thirdList)){
                    throw new NotMatchException(cardList);
                }
                if(hasSingle){
                    return new Plain(firstNum,lastNum - firstNum + 1);
                }else {
                    return new Plain(firstNum,lastNum - firstNum + 1,false);
                }
            }
        }
        return null;
    }
}
