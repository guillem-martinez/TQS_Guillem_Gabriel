package BlackjackTests;
import org.mockito.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Hand_Test {

  @Mock
  private Card cardMock1 = new Card(1,"S");
  private Card cardMock2 = new Card(2,"S");
  private Card cardMock3 = new Card(3,"S");
  private Card cardMock4 = new Card(4,"S");
  private Card cardMock5 = new Card(5,"S");
  private Card cardMock6 = new Card(6,"S");
  private Card cardMock7 = new Card(7,"S");
  private Card cardMock8 = new Card(8,"S");
  private Card cardMock9 = new Card(9,"S");
  private Card cardMock10 = new Card(10,"S");
  private Card cardMock11 = new Card(11,"S");
  private Card cardMock12 = new Card(12,"S");




  @Test
  public void handConstructorTest(){
    Hand handTest = new Hand();

    assertNotNull(handTest);
    assertNotNull(handTest.cards.size());
  }

  @Test
  public void getNumCardsTest(){
    Hand handTest = new Hand();
    assertTrue(handTest.getNumCards() == 0);

    handTest.addCard(cardMock3);
    assertTrue(handTest.getNumCards() == 1);
  }

  @Test
  public void addCardTestV1(){
    Hand handTest = new Hand();
    int size = handTest.cards.size();

    handTest.addCard(cardMock1);

    assertNotEquals(size,handTest.cards.size());
  }

  @Test
  public void addCardTestV2(){
    Hand handTest = new Hand();
    int size = handTest.cards.size();

    handTest.addCard(cardMock1);

    assertEquals(false,handTest.addCard(cardMock1));
    assertNotEquals(size,handTest.cards.size());
  }

  @Test
  public void addCardTestV3(){
    Hand handTest = new Hand();
    int size = handTest.cards.size();

    assertTrue(handTest.addCard(cardMock1));
    assertTrue(handTest.addCard(cardMock2));
    assertTrue(handTest.addCard(cardMock3));
    assertTrue(handTest.addCard(cardMock4));
    assertTrue(handTest.addCard(cardMock5));
    assertTrue(handTest.addCard(cardMock6));
    assertTrue(handTest.addCard(cardMock7));
    assertTrue(handTest.addCard(cardMock8));
    assertTrue(handTest.addCard(cardMock9));
    assertTrue(handTest.addCard(cardMock10));
    assertTrue(handTest.addCard(cardMock11));

    assertFalse(handTest.addCard(cardMock1));
    assertFalse(handTest.addCard(cardMock12));
    assertNotEquals(size,handTest.cards.size());
    assertEquals(handTest.cards.size(),handTest.getNumCards());
  }

  @Test
  public void clearHandTestV1(){
    Hand handTest = new Hand();
    handTest.clearHand();
    assertEquals(0,handTest.cards.size());

  }
  @Test
  public void clearHandTestV2(){
    Hand handTest = new Hand();

    handTest.addCard(cardMock3);
    handTest.addCard(cardMock2);
    handTest.addCard(cardMock1);
    handTest.addCard(cardMock5);
    handTest.addCard(cardMock6);
    assertNotEquals(0,handTest.getNumCards());
    handTest.clearHand();
    assertEquals(0,handTest.cards.size());
    assertEquals(0,handTest.getNumCards());


  }

  @Test
  public void calculateTotalTest(){
    Hand handTest = new Hand();
    int sumTest = 0;
    handTest.addCard(cardMock3);
    handTest.addCard(cardMock2);
    handTest.addCard(cardMock1);
    handTest.addCard(cardMock5);
    handTest.addCard(cardMock6);

    sumTest = handTest.calculateTotal();

    assertEquals(17,sumTest);

  }

}
