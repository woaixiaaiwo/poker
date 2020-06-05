package poker.parser;

import poker.OutOfNumberException;
import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;

public abstract class SequenceParser {

    public abstract PlayCard getPokerSequence(CardSequence cardSequence);

    public static PlayCard parse(CardSequence cardSequence){
        Integer maxRepeatNum = cardSequence.getMaxRepeatNum();
        PlayCard playCard = null;
        switch (maxRepeatNum){
            case 1:
                playCard = SingleCardSequenceParser.parse(cardSequence);
                break;
            case 2:
                playCard = TwoCardSequenceParser.parse(cardSequence);
                break;
            case 3:
                playCard = ThirdCardSequenceParser.parse(cardSequence);
                break;
            case 4:
                playCard = FourCardSequenceParser.parse(cardSequence);
                break;
            default:
                throw new OutOfNumberException(cardSequence.getCardList());
        }
        return playCard;
    }

}
