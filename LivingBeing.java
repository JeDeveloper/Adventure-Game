import JeXML.JeXMLNode;

//Done
public abstract class LivingBeing {
  protected String name;
  protected int health;
  boolean RoamsOnOwn;
  float moveProb;
  protected int location;
  public Weapon weapon;
  public static final String TypeName = "LIVING_BEING"; //Inherit this in classes that extend LivingBeing
  
  
  public LivingBeing(String n, int h) 
  {
    name = n;
    health = h;
    moveProb = (float) Math.random();
  }
  
  public LivingBeing()
  {
	  
  }
  
  //XML constructor. If you are not Josh Evans, ignore
  public LivingBeing(JeXMLNode n)
  {
	  
  }
  
  public float checkprob() {
    moveProb = (float) Math.random();
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
  
  public String getName()
  {
	  return name;
  }
  
  public void setName(String szNewName)
  {
	  name = szNewName;
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

 	public JeXMLNode getXML() 
  	{
 		JeXMLNode base = new JeXMLNode("LivingBeing");
 		JeXMLNode node = new JeXMLNode("Name");
 		node.setContent(getName());
 		base.addChildNode(node);
 		node = new JeXMLNode("Health");
 		node.setContent(""+getHealth());
 		base.addChildNode(node);
 		node = new JeXMLNode("bRoamsOnOwn");
 		node.setContent(RoamsOnOwn+"");
 		base.addChildNode(node);
 		node = new JeXMLNode("Location");
 		node.setContent(World.getGame().getRoom(location).getTag());
 		base.addChildNode(node);
 		base.addChildNode(weapon.getXML());
 		return base;
	}
}
//}
