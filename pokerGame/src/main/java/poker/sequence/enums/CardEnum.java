package poker.sequence.enums;

public enum CardEnum {

    Three("3",0),
    Four("4",1),
    Five("5",2),
    Six("6",3),
    Seven("7",4),
    Eight("8",5),
    Nine("9",6),
    Ten("10",7),
    Jack("J",8),
    Queen("Q",9),
    King("K",10),
    Ace("A",11),
    Two("2",12),
    Joker1("J1",13),
    Joker2("J2",14);

    private String cardName;

    private Integer cardNum;

    CardEnum(String cardName, Integer cardNum) {
        this.cardName = cardName;
        this.cardNum = cardNum;
    }

    public String getCardName() {
        return cardName;
    }

    public Integer getCardNum() {
        return cardNum;
    }
}
