package BlackjackTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Dealer_Test {

  @Mock
  private Dealer dealerTest = new Dealer();

  @Mock
  private Card cardMock1 = new Card(1,"S");
  @Mock
  private Card cardMock2 = new Card(2,"S");
  @Mock
  private Card cardMock3 = new Card(3,"S");
  @Mock
  private Card cardMock4 = new Card(4,"S");
  @Mock
  private Card cardMock5 = new Card(5,"S");
  @Mock
  private Card cardMock10 = new Card(10,"S");
  @Mock
  private Card cardMock11 = new Card(11,"S");
  @Mock
  private Deck deckMock = new Deck();
  @Mock
  private Vista vistaMock = new Vista();

  @Test
  public void clearHandTest() {
    dealerTest.clearHand();
    assertTrue(dealerTest.hand.cards.isEmpty());

    dealerTest.addCard(cardMock1);
    dealerTest.addCard(cardMock2);
    dealerTest.addCard(cardMock3);
    dealerTest.addCard(cardMock4);
    dealerTest.addCard(cardMock5);

    dealerTest.clearHand();
    assertTrue(dealerTest.hand.cards.isEmpty());
  }

  @Test
  public void addCardTest(){
    int sizeTest = dealerTest.hand.cards.size();
    assertEquals(0, sizeTest);

    dealerTest.addCard(cardMock1);

    assertEquals(sizeTest+1, dealerTest.hand.cards.size());
    assertEquals(dealerTest.hand.cards.get(0), cardMock1);
  }

  @Test
  public void calculateTotalTest(){

    assertNotNull(dealerTest.calculateTotal());

    dealerTest.addCard(cardMock1);
    dealerTest.addCard(cardMock2);
    dealerTest.addCard(cardMock3);

    assertEquals(6, dealerTest.calculateTotal());

  }

  @Test
  public void hasBlackjackTest(){

    dealerTest.addCard(cardMock10);
    dealerTest.addCard(cardMock11);

    assertTrue(dealerTest.hasBlacjack());

  }

  @Test
  public void hasBlackjackTestFalse(){
    dealerTest.addCard(cardMock2);
    assertFalse(dealerTest.hasBlacjack());
  }

  @Test
  public void dealerPlayCanPlayTest(){
    dealerTest.hand.addCard(cardMock10);
    dealerTest.hand.addCard(cardMock5);
    dealerTest.hand.addCard(cardMock1);
    int sizeTest = dealerTest.hand.cards.size();
    dealerTest.dealerPlay(deckMock);

    assertNotEquals(sizeTest,dealerTest.hand.cards.size());

  }

  @Test
  public void dealerPlayCannotPlayTest(){
    dealerTest.hand.addCard(cardMock10);
    dealerTest.hand.addCard(cardMock5);
    dealerTest.hand.addCard(cardMock2);
    int sizeTest = dealerTest.hand.cards.size();
    dealerTest.dealerPlay(deckMock);

    assertEquals(sizeTest,dealerTest.hand.cards.size());
  }

  @Test
  public void dealerPlayBustAndStandsTest(){
    dealerTest.hand.addCard(cardMock10);
    dealerTest.hand.addCard(cardMock1);
    dealerTest.hand.addCard(cardMock11);
    int sizeTest = dealerTest.hand.cards.size();
    dealerTest.dealerPlay(deckMock);

    assertEquals(sizeTest,dealerTest.hand.cards.size());
  }
}