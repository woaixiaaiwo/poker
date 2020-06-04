package poker.cards.base;

import java.util.Objects;

public class Card implements Comparable<Card>{

    private String cardName;

    private Integer cardNumber;

    public Card(String cardName, Integer cardNumber) {
        this.cardName = cardName;
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

    public Boolean isNextCard(Card card){
        return cardNumber - card.cardNumber == 1;
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
