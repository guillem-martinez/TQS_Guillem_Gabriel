package BlackjackTests;

public class Player {

  private int chips;
  private String name;
  private int bet;
  public Hand hand;

  public Player(){
    chips = 100;
    hand = new Hand();
  }
  public void setChips(int num){chips = num;}
  public int getChips() {return chips;}
  public String getName(){return name;}
  public int getBet(){return bet;}

  public boolean setBet(int b){

    if ( b <= this.getChips() & b > 0){
      this.bet = b;
      return true;
    }
    else{
      this.bet = 1;
      return false;
    }
    /* V1
      this.bet = b;
     */
  }
  public int getTotal(){
    return hand.calculateTotal();
  }

  public void setName(String n){
    this.name = n;
  }


  public void bust(){
    chips = chips - bet;
    bet = 0;
  }
  public void win(){
    chips = chips + bet;
    bet = 0;
  }
  public void loss(){
    chips = chips - bet;
    bet = 0;
  }
  public void blackjack(){
    chips = (int) (chips + (bet * 1.5));
    bet = 0;
  }

  public void push(){
    bet = 0;
  }
  public void clearHand(){
    hand.clearHand();
  }
  public void addCard(Card card){
    hand.addCard(card);
  }
  public void removeFromGame(){chips = -1;}
  public void resetBank(){chips = 0;}


}
