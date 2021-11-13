package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  public List<Card> deck = new ArrayList<Card>();

  public Deck(){

    for (int i=1;i<=13;i++){
      deck.add(new Card(i,"C"));
      deck.add(new Card(i,"D"));
      deck.add(new Card(i,"H"));
      deck.add(new Card(i,"S"));
    }
  }

  public void swapCards(int pos1, int pos2){
    Collections.swap(deck, pos1, pos2);
    /*
    Card aux;
    Card aux2;
    aux = deck.get(pos1);
    aux2 = deck.get(pos2);
    deck.set(pos1, deck.get(pos2));
    deck.set(pos2, aux);
    */

  }

  public void shuffle(){

  }
  public Card getCard(int pos){return null;}
  public Card nextCard(){return null;}


}
