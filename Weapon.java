//Ready for JeXML!
public class Weapon extends Item
{
  protected int damage;
  protected int poison;
  protected String name;
  private String[] types = new String[5];
 
  public Weapon()
  {
    types[0] = "sword";
    types[1] = "spear";
    types[2] = "axe";
    types[3] = "stick";
    types[4] = "large rock";
    name = types[(int)Math.random()*5];
    damage = (int)Math.random()*15+1;
    poison = (int)Math.random()*5;
  }
  
  
  public int getDamage()
  {
    return damage;
  }
  
  public int getPoisonStr()
  {
    return poison;
  }
  
  public String getName()
  {
    return name;
  }
    
    
  
  
  
  
  
  
}
  
