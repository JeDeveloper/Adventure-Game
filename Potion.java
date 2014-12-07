import JeXML.JeXMLNode;

//Done
public class Potion extends Item
{
  private int strength;
  public static final String TypeName = "POTION"; //For XML. Do not touch
  
  public Potion()
  {
    type = "potion";
    strength = (int)Math.random()*10+1;
    name = "potion " + strength;
  }
  public Potion(int level)
  {
   type = "potion"; 
   strength = level;
   name = "potion " + strength;
  }
  
  public Potion(JeXMLNode node)
  {
   super(node);
   strength = Integer.parseInt("iStrength");
  }
  
  public int getStrength()
  {
    return strength;
  }
  
  @Override
  public JeXMLNode getXML()
  {
   JeXMLNode base = super.getXML();
   base.addChildNode(new JeXMLNode("Type", TypeName));
   base.addChildNode(new JeXMLNode("iStrength", ""+strength));
   return base;
  }
}
    
