package poker.game;

import poker.player.Player;
import poker.sequence.base.Card;
import poker.sequence.enums.CardEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameContext {

     private MatchInfo matchInfo;

     private List<Player> users;

     private List<Card> cardSequence;

     private CardDealer cardDealer;


    public GameContext(List<Player> user){
        this(user,new DeafultCardDealer());
    }

    public GameContext(List<Player> users,CardDealer cardDealer){
        this.users = users;
        this.matchInfo = new MatchInfo();
        this.cardSequence = new ArrayList<>();
        this.cardDealer = cardDealer;
    }


    private void initCard(){
         cardSequence.clear();
         CardEnum[] values = CardEnum.values();
         for(CardEnum value:values){
             int cardNums = 4;
             if(value == CardEnum.Joker1 || value == CardEnum.Joker2){
                 cardNums = 1;
             }
             for(int i=0;i<cardNums;i++){
                 cardSequence.add(new Card(value.getCardName(),value.getCardNum()));
             }
         }
         Collections.shuffle(cardSequence);
     }

     public void beginContext(){
         //洗牌
         initCard();
         //发牌
         cardDealer.dealCard(cardSequence,users);
         for(Player user:users){
             System.out.println("玩家："+user.getName()+"手牌为：");
             System.out.println(user.displayCard());
             System.out.println("-----------------------------------");
         }
         boolean isFinish = false;
         while(!isFinish){
             for(Player user:users){
                 System.out.println("玩家："+user.getName()+"请出牌");
                 System.out.println("手牌："+user.getHandCard());
                 Scanner scanner = new Scanner(System.in);
                 String commond = scanner.nextLine();
                 String playCard = "";
                 while(true){
                     commond = scanner.nextLine();
                     if(commond.contains("s")){
                         if("s1".equals(commond)){
                             playCard = user.sort(1);
                         }else{
                             playCard = user.sort(2);
                         }
                         System.out.println("玩家："+user.getName()+"：");
                         System.out.println("手牌："+playCard);
                     }else if("no".equals(commond)){
                         //todo:添加要不起逻辑
                         //todo:如果当前玩家是出牌玩家，清空场上的出牌记录
                     }else {
                         playCard = user.palyCard(commond, matchInfo);
                         if(playCard != null && !"".equals(playCard)){
                             break;
                         }
                     }
                 }
                 System.out.println("玩家："+user.getName()+"：");
                 System.out.println("出牌："+matchInfo.getCurrentSequence().disPlay());
                 System.out.println("手牌："+playCard);
                 System.out.println("-----------------------------------");
                 if(user.isFinish()){
                     isFinish = true;
                 }
             }
         }
         System.out.println("玩家："+matchInfo.getCurrentPlayer()+"胜出！");
     }

    public static void main(String[] args) {
        List<Player> user = new ArrayList<>();
        user.add(new Player("小王"));
        user.add(new Player("小明"));
        GameContext gameContext = new GameContext(user);
        gameContext.beginContext();
    }

}
