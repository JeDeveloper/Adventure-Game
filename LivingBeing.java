//Done
public abstract class LivingBeing {
  protected String name;
  protected int health;
  boolean RoamsOnOwn;
  float moveProb;
  protected int location;
  public Weapon weapon;
  
  
  
  public LivingBeing(String n, int h) {
    name = n;
    health = h;
    moveProb = Math.random();
  }
  
  public float checkprob() {
    moveProb = Math.random();
    if(moveProb > .5) {
      changeRoom();
    }
  }
  
  public void weapon(Weapon w)
  {
    weapon = w;
  }
  public Weapon getWeapon()
  {
    return weapon;
  }
  public void changeRoom() {
  //  
  }
  
  
  /*
  public int gHealth() {
    return health;
  }
  */

  public int getHealth()
  {
    return health;
  }
  public void changeHealth(int c) {
    health = health + c;
  }
}
//}
