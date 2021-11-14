package BlackjackTests;

import java.util.Arrays;
import java.util.List;

public class Card {
  private final List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
  private int num;
  private final List<String> suits = Arrays.asList("C", "D", "H", "S");
  private String suit;
  public Card(int n, String s){
    num = n;
    suit = s;
  }

  public String getSuit(){return suit;}
  public int getNum(){return num;}
  public List<Integer> getValues() {return values;}
  public List<String> getSuits() {return suits;}
  public void setSuit(String suit){this.suit = suit;}
  public void setNum(int num){this.num = num;}

}
