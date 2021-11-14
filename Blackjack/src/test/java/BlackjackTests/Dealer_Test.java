package BlackjackTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dealer_Test {
  
  @Test
  void testHasBlacjackV1(){
    Dealer dealerTest = new Dealer();
    boolean find = dealerTest.hasBlacjack();
    assertEquals(find, true);
  }
}