package BlackjackTests;

public class Dealer {

  public Hand hand;
  public Vista vista = new Vista();

  public Dealer(){
    hand = new Hand();
  }

  public boolean hasBlacjack(){
    if (this.calculateTotal() == 21) {
      return true;
    }
    else{
      return false;
    }
  }
  public Hand getHand() {return hand;}
  public void dealerPlay(Deck d){
    while (hand.calculateTotal() <= 16){
      vista.dealerHits(hand.calculateTotal());
      hand.addCard(d.nextCard());
      vista.printHand("Dealer", this.hand);
    }
    if(hand.calculateTotal() > 21){
      vista.dealerBusts();
      vista.dealerStands();
    }
  }
  public void addCard(Card card){
    hand.addCard(card);
  }
  public int calculateTotal(){
    return hand.calculateTotal();
  }
  public void clearHand(){
    hand.clearHand();
  }

}
