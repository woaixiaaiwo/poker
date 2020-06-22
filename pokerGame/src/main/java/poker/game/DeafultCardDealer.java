package poker.game;

import poker.player.Player;
import poker.sequence.HandCardSequence;
import poker.sequence.base.Card;

import java.util.ArrayList;
import java.util.List;

public class DeafultCardDealer implements CardDealer{

    @Override
    public void dealCard(List<Card> cardList, List<Player> users) {
        List<HandCardSequence> list = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            List<Card> cards = new ArrayList<>();
            for(int j=i;j<cardList.size();j=j+users.size()){
                cards.add(cardList.get(j));
            }
            users.get(i).dealCard(cards);
        }
    }
}
