package BlackjackTests;
import code.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Hand_Test {

  Hand hand;

  @BeforeEach
  void SetUp(){
    hand = new Hand();
  }

}
