import java.util.ArrayList;
import java.util.Scanner;

//import JeXML.JeXMLInterface;

public class AdventureGame 
{
  private static AdventureGame G;
  public AdventureGame getGlobalContext(){return G;}
  private Room m_Current;
  
  public static boolean fightsim(Player i, Monster j) {
    Scanner in = new Scanner(System.in);
  
    {
    int pdam = i.attack(); //Player::attack() requires an Weapon arguement
    int mdam = j.attack();
    j.changeHealth(pdam);
    i.incrementHealth(mdam);
    if(i.getHealth() <= 0) {
      
      return(false);
    }
    else if(j.getHealth() <= 0) {
      return(true);
    }
  }
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Hello and welcome to INTERNET FIGHTER I");
    System.out.println("What is your name?");
    String name = in.nextLine();
    Player player = new Player(name, 100);
    
  }
  
}
