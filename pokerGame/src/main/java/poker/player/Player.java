package poker.player;

import poker.game.MatchInfo;
import poker.parser.SequenceParser;
import poker.playcard.base.PlayCard;
import poker.sequence.CardSequence;
import poker.sequence.HandCardSequence;
import poker.sequence.base.Card;

import java.util.List;

public class Player {

    private String name;

    private HandCardSequence handCardSequence;

    public Player(String name, HandCardSequence handCardSequence) {
        this.name = name;
        this.handCardSequence = handCardSequence;
    }

    public Player(String name) {
       this(name,new HandCardSequence());
    }

    public void dealCard(List<Card> dealCardList){
        handCardSequence.dealCard(dealCardList);
    }

    public String displayCard(){
        return handCardSequence.displayCard();
    }

    public String palyCard(String playstr, MatchInfo matchInfo){
        List<Card> playCardList = null;
        PlayCard playCard = null;
        try{
            playCardList = handCardSequence.parsePlayList(playstr);
        }catch (Exception e){
            System.out.println("输入的序列在手牌中不存在");
            return "";
        }
        try {
            CardSequence cardSequence = new CardSequence(playCardList);
            playCard = SequenceParser.parse(cardSequence);
        }catch (Exception e){
            System.out.println("你出的牌不符合规则");
            return "";
        }
        if(matchInfo.getCurrentSequence() != null && !playCard.greaterThan(matchInfo.getCurrentSequence())){
            System.out.println("你出的牌不大于上家");
            return "";
        }
        matchInfo.setCurrentPlayer(this);
        matchInfo.setCurrentSequence(playCard);
        return handCardSequence.playCard(playCardList);
    }

    public String palyCard(List<Card> playCardList, MatchInfo matchInfo){
        CardSequence cardSequence = new CardSequence(playCardList);
        PlayCard playCard = null;
        try {
            playCard = SequenceParser.parse(cardSequence);
        }catch (Exception e){
            System.out.println("你出的牌不符合规则");
            return "";
        }
        PlayCard currentSequence = matchInfo.getCurrentSequence();
        if(matchInfo.getCurrentSequence() != null && !playCard.greaterThan(currentSequence)){
            System.out.println("你出的牌不大于上家");
            return "";
        }
        matchInfo.setCurrentPlayer(this);
        matchInfo.setCurrentSequence(playCard);
        return handCardSequence.playCard(playCardList);
    }

    public boolean isFinish(){
        return handCardSequence.getCardNum() == 0;
    }

    public String sort(Integer sortType){
        handCardSequence.sort(sortType);
        return displayCard();
    }

    public void searchSyggest(PlayCard currentCard){

    }

    public String getName() {
        return name;
    }
}
