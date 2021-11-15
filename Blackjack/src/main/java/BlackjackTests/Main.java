package BlackjackTests;

public class Main {
  public static void main(String[] args ){
    Game myGame = new Game();

    myGame.initializeGame();
    do{
      myGame.shuffle();
      myGame.getBets();
      myGame.dealCards();
      myGame.Status();
      myGame.checkBlackjack();
      myGame.hitOrStand();
      myGame.dealerPlays();
      myGame.settleBets();
      myGame.Chips();
      myGame.clearHands();
    } while (myGame.playAgain());
    myGame.endGame();
  }
}
