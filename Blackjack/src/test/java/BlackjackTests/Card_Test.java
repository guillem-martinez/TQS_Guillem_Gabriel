package BlackjackTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Card_Test {

  @Mock
  private Card cardTest;

  @Test
  public void cardConstructorTest() {

    cardTest = new Card(1, "S");

    assertEquals(1, cardTest.getNum());
    assertEquals("S", cardTest.getSuit());
    assertNotNull(cardTest.getNum());
    assertNotNull(cardTest.getSuit());
  }

  @Test
  public void validNumberTest() { //valors limit
    cardTest = new Card(14,"S");
    boolean find;
    List<Integer> listTest = cardTest.getValues();
    find = listTest.contains(cardTest.getNum());

    assertFalse(find == true);

  }

  @Test
  public void validSuitTest() { //partició equivalent
    cardTest = new Card(5,"G");
    boolean find;
    List<String> listTest = cardTest.getSuits();
    find = listTest.contains(cardTest.getSuits());
    assertFalse(find == true);
    cardTest = new Card(5,"Hearts");
    boolean find2;
    List<String> listTest2 = cardTest.getSuits();
    find2 = listTest.contains(cardTest.getSuits());
    assertFalse(find2 == true);

  }

  @Test
  public void getNumTest(){
    cardTest = new Card(1,"P");
    assertTrue(cardTest.getNum() == 1);
    cardTest.setNum(2);
    assertTrue(cardTest.getNum() == 2);
    cardTest.setNum(12);
    assertTrue(cardTest.getNum() ==12 );

  }

  @Test
  public void getSuitTest(){
    cardTest = new Card(1,"C");

    assertTrue(cardTest.getSuit() == "C");
    cardTest.setSuit("D");
    assertTrue(cardTest.getSuit() == "D");
    cardTest.setSuit("H");
    assertTrue(cardTest.getSuit() == "H");
    cardTest.setSuit("S");
    assertTrue(cardTest.getSuit() == "S");

  }
  @Test
  public void setSuitTest(){
    cardTest = new Card(1,"C");
    cardTest.setSuit("D");
    assertEquals("D",cardTest.getSuit());
  }

  @Test
  public void setNumTest(){
    cardTest = new Card(1,"C");
    cardTest.setNum(2);
    assertEquals(2,cardTest.getNum());

  }




}
