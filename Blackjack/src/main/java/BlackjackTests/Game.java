package BlackjackTests;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;



public class Game {

  public Scanner scanner = new Scanner(System.in);
  private int users = 0;
  private List<Player> players = new ArrayList<Player>();
  private Deck deck = new Deck();
  private Dealer dealer = new Dealer();
  private Vista vista = new Vista();

  public Deck getDeck() { return deck; }

  public List<Player> getPlayers(){return players;}
  public Dealer getDealer(){return dealer;}
  public void setUsers(int num){ users = num;}
  public int getUsers(){return users;}
  public void setDeck(Deck d){deck = d;}

  public int readInt(){
    return scanner.nextInt();
  }

  public void initializeGame() {

    String name;
    vista.printRules();

    do{
      vista.askPlayers();
      if(users == 0 || users > 6) {
        users = readInt();
      }
    }while(users>6 || users<=0);


    //players.resize(users);
    deck = new Deck();

    for (int i=0; i<users; i++){
      vista.askNames(i);
      Player p = new Player();
      players.add(p);
      if(players.get(i).getName()==null){
        name = scanner.next();
        p.setName(name);
      }


    }
  }
  public void shuffle(){deck.shuffle();}
  public void dealCards(){
    for(int j=0; j<2; j++){
      for(int i=0; i<users;i++){
        if(players.get(i).getChips() > 0){
          players.get(i).addCard(deck.nextCard());
        }
      }
      dealer.addCard(deck.nextCard());
    }
  }
  public void getBets(){
    int betValue;

    for(int i=0; i<users; i++){
      if(players.get(i).getChips() > 0){
        do{
          vista.askBet(players.get(i).getName(), players.get(i).getChips());
          betValue = scanner.nextInt();
          players.get(i).setBet(betValue);
        }while(!(betValue>0 & betValue <= players.get(i).getChips()));
      }
    }
  }
  public void checkBlackjack() {

    if (dealer.hasBlacjack()) {

      vista.BlackJackAchieved();
      for (int i = 0; i < users; i++) {
        if (players.get(i).getTotal() == 21) {
          vista.printPush(players.get(i).getName());
          players.get(i).push();
        } else {
          vista.printLost(players.get(i).getName());
          players.get(i).bust();
        }
      }
    } else {
      for (int i = 0; i < users; i++) {
        if (players.get(i).getTotal() == 21) {
          //vista.BlackJackAchieved();
          players.get(i).blackjack();
        }


      }
    }
  }
  public void hitOrStand(){
    String option;
    char o;

    for (int i=0; i<users; i++){
      vista.printHand(players.get(i).getName(), players.get(i).hand);

      do{
        do{
          vista.printHitOrStand(players.get(i).getName());
          option = scanner.next();
          o = option.toUpperCase().charAt(0);
        }while(!(o == 'H' || o == 'S'));
        if( o == 'H'){
          players.get(i).addCard(deck.nextCard());
          vista.printHand(players.get(i).getName(), players.get(i).hand);
        }
      }while (o != 'S' & players.get(i).getTotal() <= 21);
    }
  }
  public void dealerPlays(){
    boolean playersStillInGame = false;
    for(int i=0; i<users & playersStillInGame == false; i++){
      if (players.get(i).getTotal() <= 21){
        playersStillInGame = true;
      }
    }
    if(playersStillInGame){
      dealer.dealerPlay(deck);
    }
  }
  public void settleBets(){
      for(int i=0; i<users; i++){
        if(players.get(i).getTotal() > 21){
          vista.busted(players.get(i).getName());
          players.get(i).bust();
        }
        else if(players.get(i).getTotal() == dealer.calculateTotal()){
          vista.push(players.get(i).getName());
          players.get(i).push();
        }
        else if(players.get(i).getTotal() < dealer.calculateTotal() & dealer.calculateTotal() <= 21){
          vista.loss(players.get(i).getName());
          players.get(i).loss();
      }
        else if(players.get(i).getTotal() == 21) {
          vista.blackjack(players.get(i).getName());
          players.get(i).blackjack();
        }
        else{
          vista.win(players.get(i).getName());
          players.get(i).win();
        }
    }
  }
  public void Status(){ vista.printStatus(users,players,dealer); }
  public void Chips(){vista.printChips(users,players);}
  public void clearHands(){
    for (int i=0; i<users; i++){
      players.get(i).clearHand();
    }
    dealer.clearHand();
  }
  public boolean playAgain(){
    String option;
    char o;
    boolean playState = true;
    if(forceEnd()){
      playState = false;
    }
    else{
      do{
        vista.askNewGame();
        option = scanner.next();
        o = option.toUpperCase().charAt(0);
      }while (!( o == 'Y' || o == 'N' ));
      if( o == 'N'){
        playState = false;
      }
    }
    return playState;
  }
  public boolean forceEnd(){
    boolean end = false;
    int finalCount = 0;

    for(int i=0; i<users; i++){
      if(players.get(i).getChips() == -1){
        finalCount++;
      }
    }
    if(finalCount == users){
      end = true;
    }
    if(end){
      vista.printEnd();
    }
    return end;
  }
  public void endGame(){
    int finalAmount;
    String endState = " no change.";

    for (int i=0; i<users; i++){
      if(players.get(i).getChips() == -1){
        players.get(i).resetBank();
      }
      finalAmount = players.get(i).getChips() - 100;
      if(finalAmount>0){
        endState = " gain of ";
      }
      else if(finalAmount<0){
        endState = " loss of ";
      }
      vista.printFinalStatePlayer(players.get(i).getName(), players.get(i).getChips());
      if(endState != " no change."){
        vista.printFinalAmount(endState, finalAmount);
      }
      else{
        vista.printNoChange();
      }
    }
    vista.printGreetings();
  }

}
