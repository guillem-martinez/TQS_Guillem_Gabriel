package BlackjackTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  public List<Card> deck = new ArrayList<Card>();
  private int cardPointer;

  public Deck(){

    cardPointer = 0;

    for (int i=1;i<=13;i++){
      deck.add(new Card(i,"C"));
      deck.add(new Card(i,"D"));
      deck.add(new Card(i,"H"));
      deck.add(new Card(i,"S"));
    }
  }
  public List<Card> getDeck(){return deck;}
  public boolean swapCards(int pos1, int pos2){
    //
    if (((pos2 >= 0)&(pos2 <= 51))&((pos1 >= 0)&(pos1 <= 51))) {
      Collections.swap(deck, pos1, pos2);
      return true;
    }
    else{
      return false;
    }
    /*
    1a versio
    Card aux;
    Card aux2;
    aux = deck.get(pos1);
    aux2 = deck.get(pos2);
    deck.set(pos1, deck.get(pos2));
    deck.set(pos2, aux);

    2a versio
    Collections.swap(deck, pos1, pos2);
    */

  }

  public void shuffle(){
    /*1a versio
    Random rn = new Random();
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 52; j++) {
        swapCards(i, rn.nextInt(52));
      }
    }
    //2a versio*/
    Collections.shuffle(deck);
    cardPointer = 0;
  }
  public Card nextCard(){
    if ((cardPointer < 0) || (cardPointer > 51))
    {
      return null;
    }
    return deck.get(cardPointer++);
  }

  public int getCardPointer(){return cardPointer;}
  public void setCardPointer(int n){cardPointer=n;}


}
