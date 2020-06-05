package poker.sequence.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card>{

    private String cardName;

    private Integer cardNumber;

    private final static Map<Integer,String> MAPPING = new HashMap(){{
        put(0,"3");
        put(1,"4");
        put(2,"5");
        put(3,"6");
        put(4,"7");
        put(5,"8");
        put(6,"9");
        put(7,"10");
        put(8,"J");
        put(9,"Q");
        put(10,"K");
        put(11,"A");
        put(12,"2");
        put(13,"J1");
        put(14,"J2");
    }};

    public Card(String cardName, Integer cardNumber) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
    }

    public Card(Integer cardNumber){
        this.cardName = MAPPING.get(cardNumber);
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public int compareTo(Card o) {
        return cardNumber - o.cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}
