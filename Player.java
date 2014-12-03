import JeXML.JeXMLNode;

public class Player extends LivingBeing {
  Backpack bag = new Backpack();
  double xp; //Making this a double seems unnessecary. Couldn't it be a long?
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
      System.out.println("Game Over.  " + name + " survived " + xp + " points' worth of internet rage");
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
    System.out.println(super.getHealth());
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
}
