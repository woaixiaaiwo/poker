package poker.parser;

import poker.OutOfNumberException;
import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class SequenceParser {

    public abstract PlayCard getPokerSequence(CardSequence cardSequence);

    public static PlayCard parse(CardSequence cardSequence){
        Integer maxRepeatNum = cardSequence.getMaxRepeatNum();
        PlayCard playCard = null;
        switch (maxRepeatNum){
            case 1:
                playCard = new SingleCardSequenceParser().getPokerSequence(cardSequence);
                break;
            case 2:
                playCard = new TwoCardSequenceParser().getPokerSequence(cardSequence);
                break;
            case 3:
                playCard = new ThirdCardSequenceParser().getPokerSequence(cardSequence);
                break;
            case 4:
                playCard = new FourCardSequenceParser().getPokerSequence(cardSequence);
                break;
            default:
                throw new OutOfNumberException(cardSequence.getCardList());
        }
        return playCard;
    }


    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(0));
        cardList.add(new Card(0));
        cardList.add(new Card(0));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(2));
        cardList.add(new Card(2));
        cardList.add(new Card(2));
        cardList.add(new Card(9));
        cardList.add(new Card(9));
        cardList.add(new Card(9));
        CardSequence cardSequence = new CardSequence(cardList);
        PlayCard playCard = parse(cardSequence);
        System.out.println(playCard.disPlay());
    }

}
