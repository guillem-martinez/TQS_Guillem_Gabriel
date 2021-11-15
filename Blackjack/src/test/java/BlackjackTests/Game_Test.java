package BlackjackTests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Game_Test {
  @Mock
  private Game gameTest = new Game();
  @Mock
  private Game gameTest2 = new Game();
  @Mock
  private Game gameTest3 = new Game();
  @Mock
  private Game gameTest4 = new Game();
  @Mock
  private Game gameTest5 = new Game();
  @Mock
  private int userTest = 2;
  @Mock
  private List<Player> playersTest;
  @Mock
  private Dealer dealerTest = new Dealer();
  @Mock
  private Player plTest1 = new Player();
  @Mock
  private Player plTest2 = new Player();
  @Mock
  private Player plTest3 = new Player();
  @Mock
  private Player plTest4 = new Player();
  @Mock
  private Card cardTest1 = new Card(5, "C");
  @Mock
  private Card cardTest2 = new Card(7, "S");
  @Mock
  private Card cardTest3 = new Card(9, "H");
  @Mock
  private Card cardTest4 = new Card(10, "H");
  @Mock
  private Card cardTest5 = new Card(1, "H");


  @Test
  public void initializeGameTest() {
    gameTest.setUsers(userTest);
    plTest1.setName("Guillem");
    gameTest.getPlayers().add(plTest1);

    plTest2.setName("Biel");
    gameTest.getPlayers().add(plTest2);

    gameTest.initializeGame();

    gameTest.getPlayers().get(0).setName("Guillem");
    gameTest.getPlayers().get(1).setName("Biel");

    assertEquals(gameTest.getUsers(), 2);
    assertNotNull(gameTest.getDeck());
    assertTrue(gameTest.getUsers() > 0 & gameTest.getUsers() < 7);

    //assertEquals(userTest,playersTest.size());
    assertNotNull(gameTest.getPlayers().get(0).getName());
    assertEquals("Guillem", gameTest.getPlayers().get(0).getName());
    assertEquals("Biel", gameTest.getPlayers().get(1).getName());
  }

  @Test
  public void shuffleTestV1() {
    Game auxGame = new Game();

    gameTest.shuffle();

    assertNotEquals(auxGame.getDeck().getDeck().get(0), gameTest.getDeck().getDeck().get(0));
    assertNotEquals(auxGame.getDeck().getDeck().get(51), gameTest.getDeck().getDeck().get(51));

  }

  @Test
  public void shuffleTestV2() {
    Game auxGame = new Game();

    gameTest.shuffle();

    assertNotEquals(gameTest.getDeck().getDeck(), auxGame.getDeck().getDeck());

  }

  @Test
  public void dealCardsTest() {
    initializeGameTest();
    gameTest.dealCards();
    //gameTest.setDeck(deckTest);
    gameTest.getPlayers().add(plTest1);

    playersTest = gameTest.getPlayers();
    dealerTest = gameTest.getDealer();
    assertNotEquals(playersTest.get(0).getChips(), 0);
    assertNotNull(playersTest.get(0).hand.cards.get(0));
    assertNotNull(playersTest.get(0).hand.cards.get(1));
    assertNotNull(dealerTest.hand.cards.get(0));
    assertNotNull(dealerTest.hand.cards.get(1));
    assertEquals(2,dealerTest.hand.cards.size());
  }

  @Test
  public void dealerPlaysTest() {

    gameTest.setUsers(1);
    plTest1.setName("Guillem");

    gameTest.getPlayers().add(plTest1);
    gameTest.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest.getPlayers().get(0).hand.addCard(cardTest2);

    assertTrue(gameTest.getPlayers().get(0).getTotal() <= 21);

    if (gameTest.getPlayers().get(0).getTotal() <= 21) {

      int sizeTest = gameTest.getDealer().hand.cards.size();
      gameTest.dealerPlays();

      if (gameTest.getDealer().hand.calculateTotal() <= 16) {
        Assertions.assertNotEquals(sizeTest, dealerTest.hand.cards.size());
      } else {
        Assertions.assertEquals(sizeTest, dealerTest.hand.cards.size());
      }
    }
  }

  @Test
  public void getBetsTest() {

  }

  @Test
  public void checkBlackJackTest() {
    gameTest.setUsers(1);
    gameTest.getPlayers().add(plTest1);
    gameTest.getPlayers().get(0).clearHand();
    gameTest.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest.getPlayers().get(0).hand.addCard(cardTest2);
    gameTest.getPlayers().get(0).hand.addCard(cardTest3);
    gameTest.getPlayers().get(0).setBet(50);

    gameTest.getDealer().hand.clearHand();
    gameTest.getDealer().addCard(cardTest1);
    gameTest.getDealer().addCard(cardTest2);
    gameTest.getDealer().addCard(cardTest3);

    gameTest.checkBlackjack();

    assertEquals(0, gameTest.getPlayers().get(0).getBet());

    gameTest2.setUsers(1);
    gameTest2.getPlayers().add(plTest2);
    gameTest2.getPlayers().get(0).clearHand();
    gameTest2.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest2.getPlayers().get(0).hand.addCard(cardTest2);
    gameTest2.getPlayers().get(0).setBet(50);

    gameTest2.getDealer().hand.clearHand();
    gameTest2.getDealer().addCard(cardTest1);
    gameTest2.getDealer().addCard(cardTest2);
    gameTest2.getDealer().addCard(cardTest3);

    gameTest2.checkBlackjack();

    assertEquals(0, gameTest2.getPlayers().get(0).getBet());
    assertEquals(50, gameTest2.getPlayers().get(0).getChips());

    gameTest3.setUsers(1);
    gameTest3.getPlayers().add(plTest3);
    gameTest3.getPlayers().get(0).clearHand();
    gameTest3.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest3.getPlayers().get(0).hand.addCard(cardTest2);
    gameTest3.getPlayers().get(0).hand.addCard(cardTest3);
    gameTest3.getPlayers().get(0).setBet(50);
    gameTest3.getDealer().hand.clearHand();
    gameTest3.getDealer().addCard(cardTest1);
    gameTest3.getDealer().addCard(cardTest2);

    gameTest3.checkBlackjack();
    assertEquals(175, gameTest3.getPlayers().get(0).getChips());
    assertEquals(0, gameTest3.getPlayers().get(0).getBet());
  }

  @Test
  public void settleBetsTest() {
    gameTest.setUsers(1);
    gameTest.getPlayers().add(plTest1);
    gameTest.getPlayers().get(0).clearHand();
    gameTest.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest.getPlayers().get(0).hand.addCard(cardTest2);
    gameTest.getPlayers().get(0).hand.addCard(cardTest3);
    gameTest.getPlayers().get(0).hand.addCard(cardTest4);

    gameTest.getPlayers().get(0).setBet(49);

    gameTest.settleBets();
    assertEquals(51, gameTest.getPlayers().get(0).getChips());
    assertEquals(0, gameTest.getPlayers().get(0).getBet());

    gameTest2.setUsers(1);
    gameTest2.getPlayers().add(plTest1);
    gameTest2.getPlayers().get(0).clearHand();
    gameTest2.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest2.getPlayers().get(0).hand.addCard(cardTest2);

    gameTest2.getDealer().hand.clearHand();
    gameTest2.getDealer().addCard(cardTest1);
    gameTest2.getDealer().addCard(cardTest2);
    gameTest2.getPlayers().get(0).setBet(49);
    gameTest2.settleBets();

    assertEquals(0, gameTest2.getPlayers().get(0).getBet());

    gameTest3.setUsers(1);
    gameTest3.getPlayers().add(plTest2);
    gameTest3.getPlayers().get(0).clearHand();
    gameTest3.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest3.getPlayers().get(0).hand.addCard(cardTest2);

    gameTest3.getDealer().hand.clearHand();
    gameTest3.getDealer().addCard(cardTest1);
    gameTest3.getDealer().addCard(cardTest2);
    gameTest3.getDealer().addCard(cardTest5);
    gameTest3.getPlayers().get(0).setBet(49);
    gameTest3.settleBets();

    assertTrue(gameTest3.getPlayers().get(0).getTotal() < gameTest3.getDealer().calculateTotal());
    assertTrue(gameTest3.getDealer().calculateTotal() < 21);
    assertEquals(51, gameTest3.getPlayers().get(0).getChips());
    assertEquals(0, gameTest3.getPlayers().get(0).getBet());

    gameTest4.setUsers(1);
    gameTest4.getPlayers().add(plTest3);
    gameTest4.getPlayers().get(0).clearHand();
    gameTest4.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest4.getPlayers().get(0).hand.addCard(cardTest2);
    gameTest4.getPlayers().get(0).hand.addCard(cardTest3);
    gameTest4.getPlayers().get(0).setBet(50);
    gameTest4.settleBets();

    assertTrue(gameTest4.getPlayers().get(0).getTotal() == 21);
    assertEquals(175, gameTest4.getPlayers().get(0).getChips());
    assertEquals(0, gameTest4.getPlayers().get(0).getBet());


    gameTest5.setUsers(1);
    gameTest5.getPlayers().add(plTest4);

    gameTest5.getPlayers().get(0).clearHand();
    gameTest5.getPlayers().get(0).hand.addCard(cardTest1);
    gameTest5.getPlayers().get(0).hand.addCard(cardTest2);

    gameTest5.getDealer().hand.clearHand();
    gameTest5.getDealer().addCard(cardTest1);
    gameTest5.getDealer().addCard(cardTest2);
    gameTest5.getDealer().addCard(cardTest4);
    gameTest5.getPlayers().get(0).setBet(49);
    gameTest5.settleBets();

    assertTrue(gameTest5.getDealer().calculateTotal() > 21);
    assertEquals(149,gameTest5.getPlayers().get(0).getChips());
    assertEquals(0, gameTest5.getPlayers().get(0).getBet());

  }
  @Test
  public void clearHandsTest(){

    gameTest.setUsers(1);
    plTest1.setName("Guillem");
    gameTest.getPlayers().add(plTest1);

    gameTest.getDealer().addCard(cardTest1);
    gameTest.getPlayers().get(0).hand.addCard(cardTest2);

    assertTrue(gameTest.getPlayers().get(0).hand.cards.size() > 0);
    assertTrue(gameTest.getDealer().getHand().cards.size() > 0);

    gameTest.clearHands();


    assertTrue(gameTest.getPlayers().get(0).hand.cards.size() == 0);
    assertTrue(gameTest.getDealer().getHand().cards.size() == 0);

  }
  @Test
  public void forceEndTest(){
    gameTest.setUsers(1);
    plTest1.setName("Guillem");
    gameTest.getPlayers().add(plTest1);
    gameTest.getPlayers().get(0).setChips(-1);

    boolean find = gameTest.forceEnd();

    assertTrue(find);

    gameTest.getPlayers().get(0).setChips(60);
    boolean find2 = gameTest.forceEnd();

    assertFalse(find2);

    gameTest.getPlayers().get(0).setChips(1);
    boolean find3 = gameTest.forceEnd();

    assertFalse(find3);
  }

  @Test
  public void endGameTest(){
    gameTest.setUsers(1);
    plTest1.setName("Guillem");
    gameTest.getPlayers().add(plTest1);
    gameTest.getPlayers().get(0).setChips(-1);

    gameTest.endGame();
    assertTrue(gameTest.getPlayers().get(0).getChips() == 0);

  }

}



