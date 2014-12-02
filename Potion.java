public class Potion extends Item
{
  private int strength;
  
  public Potion(int level)
  {
   type = "potion"; 
   strength = (int)Math.random()*10+1-(level/4);
  }
  
  public int getStrength()
  {
    return strength;
  }
}
    