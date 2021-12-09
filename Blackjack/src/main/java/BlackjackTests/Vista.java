package BlackjackTests;

import java.util.List;

public class Vista {

  public void printRules(){
    System.out.println("WELCOME TO TQS BLACKJACK");
    System.out.println("RULES:\n");
    System.out.println("	-Each player is dealt 2 cards. The dealer is dealt 2 cards ");
    System.out.println("	-The players cards are added up for their total.");
    System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
    System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
    System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
    System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends.");
    System.out.println("	-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.\n");
    System.out.println(" ");
  }

  public void askPlayers() {
    System.out.println("How many people are playing 1-6:");
  }

  public void askNames(int i) {
    System.out.println("Insert player "+(i+1)+"'s name:");
  }

  public void askBet(String n, int c){
    System.out.println("How much do you want to bet " + n + " 1-"+ c + "?");

  }

  public void BlackJackAchieved(){
    System.out.println("Dealer has BlackJack!!!!");
  }

  public void printPush(String s){
    System.out.println(s + " pushes");

  }
  public void printLost(String s){
    System.out.println(s + " loses");

  }

  public void printHand(String n, Hand h){
    System.out.println(n + " has this cards:" );
    printCards(h);

  }

  public void printCards(Hand h) {
    int cards = h.getNumCards();
    for (int i = 0; i < cards; i++) {
      System.out.println(h.cards.get(i).getNum()+h.cards.get(i).getSuit()+" ");
    }
  }

  public void printHitOrStand(String s) {
    System.out.println(s+ " (H)it or (S)tand)");
  }

  public void busted(String s) {
    System.out.println(s + " has busted");
  }
  public void printStatus(int users, List<Player> players, Dealer dealer){
    for (int i = 0; i < users; i++) {
      if(players.get(i).getChips() > 0)
      {
        printHand(players.get(i).getName(),players.get(i).hand);
      }
    }
    printHand("Dealer",dealer.hand);
  }

  public void push(String s) {
    System.out.println(s+" has pushed");
  }

  public void loss(String s) {
    System.out.println(s+ " has lost");
  }

  public void blackjack(String s) {
    System.out.println(s+ " has won with blackjack!");
  }

  public void win(String s) {
    System.out.println(s+ " has won");
  }

  public void askNewGame() {
    System.out.println("Do you want tot play again (Y)es or (N)o ?");
  }

  public void printChips(int users, List<Player> players) {
    for (int i = 0; i < users; i++) {
      if(players.get(i).getChips() > 0)
      {
        System.out.println(players.get(i).getName() + " has " + players.get(i).getChips());
      }
      if(players.get(i).getChips() == 0)
      {
        System.out.println(players.get(i).getName() + " has " + players.get(i).getChips() + " and is out of the game.");
        players.get(i).removeFromGame();
      }
    }

  }

  public void printEnd() {
    System.out.println("All players have lost and the game ends.");
  }

  public void printFinalStatePlayer(String s, int c) {
    System.out.println(s + " has ended the game with " + c + " chips");
  }

  public void printFinalAmount(String n, int f) {
    System.out.println("A" + n + Math.abs(f));
  }

  public void printNoChange() {
    System.out.println(("No change from their starting value"));
  }
  public void printGreetings(){
    System.out.println("");
    System.out.println("");
    System.out.println("Thank you for playing!");
  }

  public void dealerHits(int c) {
    System.out.println("Dealer has " + c + " and hits");
  }

  public void dealerBusts() {
    System.out.println("Dealer busts");
  }

  public void dealerStands(){
    System.out.println("Dealer stands");
  }
}
