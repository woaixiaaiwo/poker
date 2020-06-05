package poker.parser;

import poker.NotMatchException;
import poker.playcard.*;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.playcard.base.PlayCard;
import poker.sequence.enums.CardEnum;
import poker.utils.ListUtil;

import java.util.ArrayList;
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
        Map<Integer, List<Integer>> sequenceMap = cardSequence.getSequenceMap();
        List<Integer> thirdList = sequenceMap.get(3);
        //三带一
        if(cardList.size() == 4){
            Integer singleNum = sequenceMap.get(1).get(0);
            return new ThirdOneCard(thirdList.get(0),singleNum);
        }
        //三带二
        if(cardList.size() == 5){
            if(sequenceMap.get(2) == null){
                throw new NotMatchException(cardList);
            }
            Integer doubleNum = sequenceMap.get(2).get(0);
            return new ThirdTwoCard(thirdList.get(0),doubleNum);
        }
        //飞机
        //todo:333444555999这种算不算？
        if(cardList.size() >= 6){
            List<Integer> twoList = sequenceMap.get(2);
            List<Integer> oneList = sequenceMap.get(1);
            Integer firstNum = thirdList.get(0);
            Integer lastNum = thirdList.get(thirdList.size() - 1);
            boolean hasSingle = false;
            Integer otherNumTotal = 0;
            if(oneList != null && twoList != null){
                //把两张牌当做一张牌看，2张牌*2和1张牌的个数加起来不等于3张牌的个数，不符合规则
                otherNumTotal = oneList.size() + twoList.size()*2;
                hasSingle = true;
            }else if(oneList != null){
                otherNumTotal = oneList.size();
            }else if(twoList != null){
                otherNumTotal = twoList.size();
            }
            if(otherNumTotal != 0 && otherNumTotal != thirdList.size()){
                throw new NotMatchException(cardList);
            }
            if(firstNum >= CardEnum.Three.getCardNum() && lastNum <= CardEnum.Ace.getCardNum()){
                if(!ListUtil.isContinuityList(thirdList)){
                    throw new NotMatchException(cardList);
                }
                List<Integer> otherNum = new ArrayList<>();
                if(twoList != null){
                    otherNum.addAll(twoList);
                    otherNum.addAll(twoList);
                }
                if(oneList != null){
                    otherNum.addAll(oneList);
                }
                if(hasSingle){
                    return new Plain(firstNum,lastNum - firstNum + 1,otherNum);
                }else {
                    return new Plain(firstNum,lastNum - firstNum + 1,otherNum,false);
                }
            }
        }
        throw new NotMatchException(cardList);
    }
}
