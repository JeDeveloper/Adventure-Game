//Done
public abstract class LivingBeing {
  protected String name;
  protected int health;
  public LivingBeing(String n, int h) {
    name = n;
    health = h;
  }
  public void health(int h) {
    health = h;
  }
  public void changeHealth(int c) {
    health = health + c;
  }
}
