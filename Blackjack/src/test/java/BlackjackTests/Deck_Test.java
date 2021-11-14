package BlackjackTests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;


public class Deck_Test {

  @Test
  public void deckConstructorTest() {

    Deck deckTest = new Deck();
    int capacity = deckTest.deck.size();

    assertEquals(52,capacity);
    /*
    boolean find;
    Card cardTest = Card(10,"S");
    find = deckTest.deck.contains(cardTest);

    //assertTrue(find);

    cardTest.setNum(15);
    find = deckTest.deck.contains(cardTest);

    assertTrue(find == false);
    */
  }

  @Test
  public void swapCardsTestV1(){
    int pos1 = 40; //partició equivalent
    int pos2 = 20; //partició equivalent
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
  public void swapCardsTestV2(){
    int pos1 = 0; //valor frontera
    int pos2 = 51; //valor frontera
    Deck deckTest = new Deck();

    assertTrue(pos1 <= 51);
    assertTrue(pos2 <= 51);
    assertTrue(pos1 >= 0);
    assertTrue( pos2 >= 0);

    Card aux = deckTest.deck.get(pos1);

    deckTest.swapCards(pos1, pos2);

    assertEquals(deckTest.deck.get(pos2).getNum(),aux.getNum());
    assertEquals(deckTest.deck.get(pos2).getSuit(),aux.getSuit());
    assertEquals(false, deckTest.swapCards(-1,52));
    assertEquals(false, deckTest.swapCards(52,-1));


  }
  //V1
  @Test
  public void shuffleTestV1(){
    Deck deckTest = new Deck();
    Deck auxDeck = new Deck();

    deckTest.shuffle();

    assertNotEquals(auxDeck.deck.get(0),deckTest.deck.get(0));
    assertNotEquals(auxDeck.deck.get(51),deckTest.deck.get(51));
  }
  //V2
  @Test
  public void shuffleTest(){
    Deck deckTest = new Deck();
    Deck auxDeck = new Deck();

    deckTest.shuffle();

    assertNotEquals(auxDeck.deck,deckTest.deck);
  }

  @Test
  public void nextCardTest(){
    Deck deckTest = new Deck();
    assertNotNull(deckTest.nextCard());

  }
}
