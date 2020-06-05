package poker;

import poker.sequence.base.Card;

import java.util.List;

public class OutOfNumberException extends RuntimeException{

    public OutOfNumberException(List<Card> list){
        super("序列："+list+"单张牌个数超出限制");
    }

}
