package BlackjackTests;
import code.Card;
import code.Hand;
import org.mockito.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class Hand_Test {


  @Test
  public void handConstructorTest(){
    Hand handTest = new Hand();

    assertNotNull(handTest);
    assertNotNull(handTest.cards.size());
  }

  @Test
  public void calculateTotalTest(){
    Hand handTest = new Hand();
    int sumTest = 0;
    handTest.calculateTotal();

  }

  @Mock
  private Card cardMock = new Card(10,"S");

  @Test
  public void addCardTestV1(){
    Hand handTest = new Hand();
    int size = handTest.cards.size();

    handTest.addCard(cardMock);

    assertNotEquals(size,handTest.cards.size());



  }
  @Test
  public void addCardTestV2(){
    Hand handTest = new Hand();
    int size = handTest.cards.size();

    handTest.addCard(cardMock);
    assertEquals(false,handTest.addCard(cardMock));
    assertNotEquals(size,handTest.cards.size());
  }


}
