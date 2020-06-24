package poker.parser;

import poker.NotMatchException;
import poker.playcard.DoubleCard;
import poker.playcard.Flush;
import poker.playcard.FlushDouble;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;
import poker.playcard.base.PlayCard;
import poker.sequence.enums.CardEnum;

import java.util.List;
import java.util.Scanner;

public class TwoCardSequenceParser extends SequenceParser {

    @Override
    public PlayCard getPokerSequence(CardSequence cardSequence) {
        List<Card> cardList = cardSequence.getCardList();
        //对子
        if(cardList.size() == 2){
            if(cardList.get(0).equals(cardList.get(1))){
                return new DoubleCard(cardList.get(0).getCardNumber());
            }
        }
        //连对
        if(cardList.size() >= 6){
            List<Integer> sequenceNumList = cardSequence.getSequenceNumList();
            //判断是否都是2
            for(Integer s:sequenceNumList){
                if(s != 2){
                    throw new NotMatchException(cardList);
                }
            }
            Card firstCard = cardList.get(0);
            Card lastCard = cardList.get(cardList.size() - 1);
            if(firstCard.getCardNumber() >= CardEnum.Three.getCardNum() && lastCard.getCardNumber() <= CardEnum.Ace.getCardNum()){
                if(cardSequence.isContinuitySequence()){
                    return new FlushDouble(firstCard.getCardNumber(),lastCard.getCardNumber() - firstCard.getCardNumber() + 1);
                }
            }
        }
        throw new NotMatchException(cardList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String str1 = scanner.next();
            System.out.println("Input:" + str1);
        }
        scanner.close();
    }
}
