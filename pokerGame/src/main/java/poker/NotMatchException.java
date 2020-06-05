package poker;

import poker.sequence.base.Card;

import java.util.List;

public class NotMatchException extends RuntimeException{

    public NotMatchException(List<Card> list){
        super("序列："+list+"不符合规则");
    }

}
