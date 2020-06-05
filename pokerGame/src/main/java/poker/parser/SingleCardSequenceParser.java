package poker.parser;

import poker.NotMatchException;
import poker.playcard.BoomCard;
import poker.playcard.Flush;
import poker.playcard.SingleCard;
import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.List;

public class SingleCardSequenceParser extends SequenceParser{

    @Override
    public PlayCard getPokerSequence(CardSequence cardSequence) {
        List<Card> cardList = cardSequence.getCardList();
        //判断是否为单牌
        if(cardList.size() == 1){
            return new SingleCard(cardList.get(0).getCardNumber());
        }
        //判断是否为王炸
        if(cardList.size() == 2){
            if(cardList.get(0).getCardNumber().equals(CardEnum.Joker1.getCardNum())
            && cardList.get(1).getCardNumber().equals(CardEnum.Joker2.getCardNum())){
                return new BoomCard(CardEnum.Joker1.getCardNum());
            }
        }
        //判断是否为顺子
        if(cardList.size() >= 5){
            Card firstCard = cardList.get(0);
            Card lastCard = cardList.get(cardList.size() - 1);
            if(firstCard.getCardNumber() >= CardEnum.Three.getCardNum() && lastCard.getCardNumber() <= CardEnum.Ace.getCardNum()){
                if(cardSequence.isContinuitySequence()){
                    return new Flush(firstCard.getCardNumber(),lastCard.getCardNumber() - firstCard.getCardNumber() + 1);
                }
            }
        }
        throw new NotMatchException(cardList);
    }
}
