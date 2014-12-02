public class Monster extends LivingBeing {
  private String name = "GenericTroll";
  public Monster(name, int h) {
    super(name, h);
  }
  public int attack() {
    System.out.println("GenericTroll is foaming at the mouth!");
    System.out.println("GenericTroll used FLAME CANNON");
    int i = (int)(Math.random() * 100);
    System.out.println("It mildly annoyed you!")
    return(i)
  }
}
