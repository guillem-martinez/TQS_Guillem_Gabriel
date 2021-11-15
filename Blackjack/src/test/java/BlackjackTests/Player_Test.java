package BlackjackTests;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class Player_Test {

  @Mock
  Player playerTest = new Player();

  @Test
  public void getChipsTest(){
    assertEquals(100,playerTest.getChips());
  }

  @Test
  public void getNameTest(){
    playerTest.setName("Pere");
    assertEquals("Pere", playerTest.getName());
    playerTest.setName("Biel");
    assertEquals("Biel", playerTest.getName());
  }

  @Test
  public void getBetTestV1(){
    playerTest.setBet(12);
    assertEquals(12, playerTest.getBet());
  }

  @Test
  public void getBetTestV2(){
    playerTest.setBet(playerTest.getChips()+1);
    assertEquals(1, playerTest.getBet());
    playerTest.setBet(0);
    assertEquals(1, playerTest.getBet());
  }


  @Mock
  int bet = 50;
  @Mock
  int chipsTest;

  @Test
  public void bustTest(){
    chipsTest = playerTest.getChips();
    playerTest.setBet(bet);
    playerTest.bust();
    assertNotEquals(chipsTest, playerTest.getChips());
    assertEquals(chipsTest-bet, playerTest.getChips());
    assertEquals(0, playerTest.getBet());
  }

  @Test
  public void lossTest(){
    chipsTest = playerTest.getChips();
    playerTest.setBet(bet);
    playerTest.loss();
    assertNotEquals(chipsTest, playerTest.getChips());
    assertEquals(chipsTest-bet, playerTest.getChips());
    assertEquals(0, playerTest.getBet());
  }

  @Test
  public void winTest(){
    chipsTest = playerTest.getChips();
    playerTest.setBet(bet);
    playerTest.win();
    assertNotEquals(chipsTest, playerTest.getChips());
    assertEquals(chipsTest+bet, playerTest.getChips());
    assertEquals(0, playerTest.getBet());
  }

  @Test
  public void blackjackTest(){
    chipsTest = playerTest.getChips();
    playerTest.setBet(bet);
    playerTest.blackjack();
    assertNotEquals(chipsTest, playerTest.getChips());
    assertEquals(chipsTest+(bet*1.5), playerTest.getChips());
    assertEquals(0, playerTest.getBet());
  }

  @Test
  public void pushTest(){
    playerTest.setBet(bet);
    assertNotEquals(0,playerTest.getBet());
    playerTest.push();
    assertEquals(0, playerTest.getBet());
  }

  @Test
  public void setBetTestV1(){
    playerTest.setBet(bet);
    assertEquals(bet,playerTest.getBet());
  }

  @Test
  public void setBetTestV2(){
    playerTest.setBet(bet);
    assertEquals(bet,playerTest.getBet());
    assertFalse(playerTest.setBet(101));//valor frontera
    assertFalse(playerTest.setBet(0));//valor frontera
    assertTrue(playerTest.setBet(bet));
  }



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

  @Test
  public void clearHandTest() {
    playerTest.clearHand();
    assertTrue(playerTest.hand.cards.isEmpty());

    playerTest.addCard(cardMock1);
    playerTest.addCard(cardMock2);
    playerTest.addCard(cardMock3);
    playerTest.addCard(cardMock4);
    playerTest.addCard(cardMock5);

    playerTest.clearHand();
    assertTrue(playerTest.hand.cards.isEmpty());
  }

  @Test
  public void addCardTest(){
    int sizeTest = playerTest.hand.cards.size();
    assertEquals(0, sizeTest);

    playerTest.addCard(cardMock1);

    assertEquals(sizeTest+1, playerTest.hand.cards.size());
    assertEquals(playerTest.hand.cards.get(0), cardMock1);
  }

  @Test
  public void getTotalTest(){

    int totalTest = playerTest.getTotal();
    assertEquals(0, totalTest);
    playerTest.addCard(cardMock1);
    playerTest.addCard(cardMock5);
    totalTest = playerTest.getTotal();
    assertEquals(6, totalTest);


  }

  @Test
  public void removeFromGameTest(){
    playerTest.removeFromGame();
    assertEquals(-1,playerTest.getChips());
  }

  @Test
  public void resetBankTest(){
    playerTest.resetBank();
    assertEquals(0,playerTest.getChips());
  }



}
