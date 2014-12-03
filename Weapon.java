import JeXML.JeXMLNode;

//Done
public class Weapon extends Item
{
  protected int damage;
  protected int poison;//Why?
  protected String name;
  private String[] types = new String[5]; //What *is* this?
  public static final String TypeName = "WEAPON"; //For XML. Do not touch.
 
  public Weapon()
  {
    types[0] = "sword";
    types[1] = "spear";
    types[2] = "axe";
    types[3] = "stick";
    types[4] = "large rock"; //Can be in the declaration
    name = types[(int)Math.random()*5];
    damage = (int)Math.random()*15+1;
    poison = (int)Math.random()*5;
  }
  
  public Weapon(JeXMLNode node)
  {
	  super(node);
	  name = node.getChildNodeContentByName("Name");
	  damage = Integer.parseInt(node.getChildNodeContentByName("iDamage"));
	  poison = Integer.parseInt(node.getChildNodeContentByName("iPoison"));
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
  
  
  //XML. Do not touch!
  @Override
  public JeXMLNode getXML()
  {
	  JeXMLNode base = super.getXML();
	  base.addChildNode(new JeXMLNode("Name", name));
	  base.addChildNode(new JeXMLNode("Type", TypeName));
	  base.addChildNode(new JeXMLNode("iDamage", ""+damage));
	  base.addChildNode(new JeXMLNode("iPoison"));
	  //Not sure how to deal with 'types' since I have no idea what it means.
	  return base;
  }
}
  
