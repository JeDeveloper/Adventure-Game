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
	  name = n.getChildNodeContentByName("Name");
	  health = Integer.parseInt(n.getChildNodeContentByName("iHealth"));
	  RoamsOnOwn = Boolean.parseBoolean(n.getChildNodeContentByName("bRoamsOnOwn"));
	  location = World.getGame().getRoomIndex(n.getChildNodeContentByName("Location"));
  }
  
  //I am rewriting this method because it doesn't compile and makes no sense.
  public boolean checkprob() 
  {
    return moveProb < Math.random();
  }
  
  public void weapon(Weapon w)
  {
    weapon = w;
  }
  public Weapon getWeapon()
  {
    return weapon;
  }
  
  public Room getCurrentRoom()
  {
	  return World.getGame().getRoom(location);
  }
  
  public void changeToRandomRoom()
  {
	  int iNumChoices = getCurrentRoom().getNumDoors();
	  int iDoor = (int) (Math.random() * iNumChoices);
	  changeRoom(getCurrentRoom().getDoor(iDoor).getLeadsTo());
  }
  
  public void changeRoom(Room newRoom)
  {
	  changeRoom(World.getGame().getRoomIndex(newRoom));
  }
  
  public void changeRoom(int iNewRoom) 
  {
	  location = iNewRoom;
	  processChangeRoom();
  }
  
  public abstract void processChangeRoom();
  
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
 		node = new JeXMLNode("iHealth");
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
