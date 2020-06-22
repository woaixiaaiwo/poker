package poker.game;

import poker.player.Player;
import poker.sequence.base.Card;

import java.util.List;

/**
 * 发牌器
 */
public interface CardDealer {


    void dealCard(List<Card> cardList, List<Player> users);


}
