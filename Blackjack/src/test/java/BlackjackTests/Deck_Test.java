package BlackjackTests;
import code.Card;
import code.Deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;



public class Deck_Test {

  @Test
  public void deckConstructorTest() {

    Deck deckTest = new Deck();
    int capacity = deckTest.deck.size();

    assertEquals(52,capacity);

    boolean find;
    Card cardTest = new Card(10,"S");
    find = deckTest.deck.contains(cardTest);

    assertTrue(true == find);

    cardTest.setNum(15);
    find = deckTest.deck.contains(cardTest);

    assertTrue(find == false);

  }

  @Test
  public void swapCardsTestV1(){
    int pos1 = 40;
    int pos2 = 20;
    Deck deckTest = new Deck();

    assertTrue(pos1 <= 52);
    assertTrue(pos2 <= 52);

    Card aux = deckTest.deck.get(pos1); //2 picas

    deckTest.swapCards(pos1, pos2); // pos 1 tindra 4 cors i pos2 2 picas

    assertEquals(deckTest.deck.get(pos2).getNum(),aux.getNum());
    //assertEquals(deckTest.deck.get(pos1).getNum(),deckTest.deck.get(pos2).getNum());

    //assertEquals(deckTest.deck.get(pos2).getSuit(),deckTest.deck.get(pos1).getSuit());
    //assertEquals(deckTest.deck.get(pos1).getSuit(),deckTest.deck.get(pos2).getSuit());

  }
  @Test
  public void shuffleTest(){

    Deck deckTest = new Deck();

  }






}
