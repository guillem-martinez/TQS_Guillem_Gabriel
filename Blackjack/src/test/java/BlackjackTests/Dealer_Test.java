package BlackjackTests;

import code.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dealer_Test {

  Dealer dealer;

  @BeforeEach
  void setUp(){
    dealer = new Dealer();
  }
}