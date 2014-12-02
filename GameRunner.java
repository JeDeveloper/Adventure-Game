// I am the topmost user-view class.
import java.util.Scanner;
public class GameRunner {
  public static void breakall() {
    System.out.println("GAME OVER");
    
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Hello and welcome to INTERNET FIGHTER I");
    System.out.println("What is your name?");
    String name = in.nextLine();
    Player player = new Player(name, 100);
  }
}