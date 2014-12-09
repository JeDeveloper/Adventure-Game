import JeXML.JeXMLNode;

//Done
public class Weapon extends Item
{
  protected int m_iMinDamage;
  protected int m_iMaxDamage;
  
  private static final String[] types = new String[]{"sword", "spear", "axe", "stick", "large rock"};
  public static final String TypeName = "WEAPON"; //For XML. Do not touch.
 
  public Weapon()
  {
    name = types[(int)Math.random()*5];
    m_iMinDamage = (int)Math.random()*15+1;
    m_iMaxDamage = (int)(Math.random() * 10 ) + getMinDamage();
  }
  
  public Weapon(JeXMLNode node)
  {
   super(node);
   name = node.getChildNodeContentByName("Name");
   m_iMinDamage = Integer.parseInt(node.getChildNodeContentByName("iMinDamage"));
   m_iMaxDamage = Integer.parseInt(node.getChildNodeContentByName("iMaxDamage"));
  }
  
  public int getMinDamage()
  {
	  return m_iMinDamage;
  }
  
  public int getMaxDamage()
  {
	  return m_iMaxDamage;
  }
  
  public int getDamage()
  {
	return getMinDamage() + (int)(Math.random() * (getMaxDamage()-getMinDamage()));
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
   base.addChildNode(new JeXMLNode("iMinDamage", ""+getMinDamage()));
   base.addChildNode(new JeXMLNode("iMaxDamage", ""+getMaxDamage()));
   //Not sure how to deal with 'types' since I have no idea what it means.
   return base;
  }
  
  public String toString()
  {
	  return getName()+"_"+getMinDamage()+"-"+getMaxDamage();
  }
}
  
