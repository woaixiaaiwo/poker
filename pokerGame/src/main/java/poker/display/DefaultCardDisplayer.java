package poker.display;

import poker.sequence.base.Card;

import java.util.List;

public class DefaultCardDisplayer implements CardDisplayer{

    @Override
    public String display(List<Card> cardList) {
        StringBuilder sb = new StringBuilder();
        for(Card card:cardList){
            sb.append(card.getCardName());
        }
        return sb.toString();
    }
}
