package BlackjackTests;

public class Dealer {

  public Hand hand;

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
