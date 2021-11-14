package BlackjackTests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Card_Test {



  @Test
  public void cardConstructorTest() {

    Card cardTest = new Card(1, "S");

    assertEquals(1, cardTest.getNum());
    assertEquals("S", cardTest.getSuit());
    assertNotNull(cardTest.getNum());
    assertNotNull(cardTest.getSuit());
  }

  @Test
  public void validNumberTest() { //valors limit
    Card cardTest = new Card(15,"S");
    boolean find;
    List<Integer> listTest = cardTest.getValues();
    find = listTest.contains(cardTest.getNum());

    assertFalse(find == true);

  }

  @Test
  public void validSuitTest() { //valors limit
    Card cardTest = new Card(5,"G");
    boolean find;
    List<String> listTest = cardTest.getSuits();
    find = listTest.contains(cardTest.getSuits());

    assertFalse(find == true);


  }

  @Test
  public void getNumTest(){
    Card cardTest = new Card(1,"P");
    assertTrue(cardTest.getNum() == 1);
    cardTest.setNum(2);
    assertTrue(cardTest.getNum() == 2);
    cardTest.setNum(12);
    assertTrue(cardTest.getNum() ==12 );

  }

  @Test
  public void getSuitTest(){
    Card cardTest = new Card(1,"C");

    assertTrue(cardTest.getSuit() == "C");
    cardTest.setSuit("D");
    assertTrue(cardTest.getSuit() == "D");
    cardTest.setSuit("H");
    assertTrue(cardTest.getSuit() == "H");
    cardTest.setSuit("S");
    assertTrue(cardTest.getSuit() == "S");

  }





}
