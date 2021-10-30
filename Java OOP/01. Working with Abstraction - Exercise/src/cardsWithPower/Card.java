package cardsWithPower;

public class Card {
    private final Suits cardSuit;
    private final Rank cardRank;
    private int power;

    public Card(Rank rank, Suits suit){
        this.cardSuit = suit;
        this.cardRank = rank;
        setPower();
    }

    private void setPower() {
        this.power = this.cardSuit.getValue() + this.cardRank.getValue();
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString(){
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank.name(), this.cardSuit.name(), this.getPower());
    }
}
