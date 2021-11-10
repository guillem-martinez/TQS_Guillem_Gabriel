package BlackjackTests;

import code.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Card_Test {

  Card card;

  @BeforeEach
  void SetUp(){
    card = new Card();
  }
}
