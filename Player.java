public class Player extends LivingBeing {
  Backpack bag = new Backpack();
  double xp;
  public Player(String n, int h) {
    super(n,h);
  }
  public void incrementHealth(int h) {
    super.changeHealth(h);
    if(health < 0) {
      System.out.println("Game Over.  " + name + " survived " + xp + " points' worth of internet rage");
      breakall();
    }
  }
  public void attack() {
    
  }
  public String toString() {
    return(name + " has " + health + " health remaining"); 
  }
  //public void drinkPotion(Potion a) {
  //  super.changeHealth(potion.getStrength());
  //}
}