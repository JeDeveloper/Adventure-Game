//Done
public abstract class LivingBeing {
  protected String name;
  protected int hitpoints;
  boolean RoamsOnOwn;
  float moveProb;
  protected int location;
  
  public LivingBeing(String n, int h) {
    name = n;
    health = h;
    moveProb = Math.random();
  }
  
  
  
  public int health() {
  return health;
  }
  public void changeHealth(int c) {
    health = health + c;
  }
}
