import JeXML.JeXMLNode;

public class Player extends LivingBeing {
  Backpack bag = new Backpack();
  double xp; //this is the money component, simply renamed.
  public static final String TypeName = "PLAYER";
  public Player(String n, int h) {
    super(n,h);
  }
  
  //XML. Do not touch.
  public Player(JeXMLNode node) 
  {
	super(node);
	xp = Double.parseDouble(node.getChildNodeContentByName("iXP"));
	bag = new Backpack();
	node = node.getChildNodeByName("Backpack");
	for (int i = 0; i < node.getNumChildren(); i++)
	{
		if (node.getChildNodeContentByName("Type") == Weapon.TypeName)
		{
			bag.add(new Weapon(node));
		}
		else if (node.getChildNodeContentByName("Type") == Potion.TypeName)
		{
			bag.add(new Potion(node));
		}
	}
	node = node.getParentNode();
  }
  public void incrementHealth(int h) {  
    super.changeHealth(h);
    if(health < 0) {
    	System.out.print("After enduring "+getXP()+" of internet vitriol, "+getName()+" lost all vestiges of sanity.");
    }
  }

	public double getXP()
	{
		return xp;
	}
	
	public void changeXP(int i)
	{
		xp += i;
	}
	  
	  public void addBag(Item i) {
	    bag.addItem(i);
	  }

  
  @Override
  public JeXMLNode getXML()
  {
	  JeXMLNode base = super.getXML();
	  base.addChildNode(new JeXMLNode("iXP", ""+xp));
	  JeXMLNode backpack = new JeXMLNode("Backpack");
	  for (int i = 0; i < bag.size(); i++)
	  {
		  backpack.addChildNode(bag.get(i).getXML()); //Will this call Item::getXML() or ?type?::getXML()?
		  //Will have to ask Batra
	  }
	  return base;
  }
  
  public String toString() {
    return(name + " has " + health + " health remaining"); 
  }

@Override
public void processChangeRoom() {
	// TODO Auto-generated method stub
	
}
}
