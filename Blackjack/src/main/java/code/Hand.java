package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hand {
  private static final int NUM_MAX_CARDS = 11;
  private int numCards = 0;
  public List<Card> cards;

  public Hand(){
    cards = new ArrayList<Card>(NUM_MAX_CARDS);
  }

  public int calculateTotal(){return 0;}
  public boolean addCard(Card card){
    /* V1
    cards.add(card);
    numCards++;
    return true;
    */

    if (cards.contains(card)){
      return false;
    }
    else{
      cards.add(card);
      numCards++;
      return true;
    }

  }
  public void clearHand(){}
  public int getNumCards(){return this.numCards;}
}
