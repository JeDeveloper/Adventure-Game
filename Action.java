public class Action 
{
 public static boolean fightsim(Player i, Monster j) {
    Scanner in = new Scanner(System.in);
  
    {
    int pdam = i.attack();
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
  public static String drinkPotion(Player a, Potion b) {
    a.incrementHealth(b.getStrength());
    return("After drinking a potion, " + a.toString());
  }
}
