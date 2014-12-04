import JeXML.JeXMLNode;

//Done
abstract class Item
{
  protected int weight;
  protected String type; //?
  protected boolean hold;
  public static final String TypeName = "ITEM";
  public String name;
  
  protected Item()
  {
    hold = false;
    
  }
  
  protected Item(JeXMLNode node)
  {
   weight = Integer.parseInt(node.getChildNodeContentByName("iWeight"));
   type = node.getChildNodeContentByName("Type");
   hold = Boolean.parseBoolean(node.getChildNodeContentByName("bHold"));
  }
  
  public String getType()
  {
    return type;
  }
  
  public int getWeight()
  {
    return weight;
  }
  
  public void pickUp()
  {
    hold = true;
  }
  
  public void drop()
  {
    hold = false;
  }
  
  /*public Item random()
  {
    int x = (int)Math.random()*2+1;
    if(x==1)
      return Weapon();
    else
      return Potion();
  }*/
  
  public JeXMLNode getXML()
  {
   JeXMLNode base = new JeXMLNode("Item");
   base.addChildNode(new JeXMLNode("iWeight", ""+weight));
   base.addChildNode(new JeXMLNode("Type", type));
   base.addChildNode(new JeXMLNode("bHold", ""+hold));
   return base;
  }

  public String toString(){
  return name;
  }
}
