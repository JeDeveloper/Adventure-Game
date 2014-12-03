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
  
  public int attack(Weapon delta) {
    System.out.println(name + " attacked GenericTroll with a " + delta.getName());
    int damage = delta.getPoisonStr() + delta.getDamage();
    System.out.println("GenericTroll lost " + damage + " health!");
    return(damage);
  }
  public void addBag(Item i) {
    bag.addItem(i);
  }
  public void drinkPotion(Potion beta) {
    super.changeHealth(beta.getStrength());
    System.out.println(super.getHealth)
  }
  
  public String toString() {
    return(name + " has " + health + " health remaining"); 
  }
}
