package BlackjackTests;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private static final int NUM_MAX_CARDS = 11;
  private int numCards = 0;
  public List<Card> cards;

  public Hand(){
    cards = new ArrayList<Card>(NUM_MAX_CARDS);
  }

  public int calculateTotal(){
    int sum = 0;
    if(!cards.isEmpty())
    {
      for(int i=cards.size()-1;i>=0;i--){
        sum = sum + cards.get(i).getNum();
      }
    }

    return sum;
  }
  public boolean addCard(Card card){
    /* V1
    cards.add(card);
    numCards++;
    return true;
    */
    if (cards.size()>=NUM_MAX_CARDS){
      return false;
    }

    if (cards.contains(card)){
      return false;
    }
    else{
      cards.add(card);
      numCards++;
      return true;
    }

  }
  public void clearHand(){

    if(!cards.isEmpty()){
      cards.clear();
    }

    numCards = 0;

    /* V1
    if(!cards.isEmpty()) {
      for (int i = cards.size()-1; i >= 0; i--) {
        cards.remove(i);
      }
    }
    */


  }
  public int getNumCards(){return this.numCards;}
}
