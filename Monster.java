import JeXML.JeXMLNode;

public class Monster extends LivingBeing {
  private String name = "GenericTroll";
  public static final String TypeName = "MONSTER";
  public Monster(String name, int h) {
    super(name, h);
  }
  
  //XML constructor. If you are not Josh Evans, ignore this
  public Monster(JeXMLNode node)
  {
	  super(node);
	  name = node.getChildNodeContentByName("Name");
  }
  public Monster() 
  {
	// TODO Auto-generated constructor stub
  }

public int attack() {
    System.out.println("GenericTroll is foaming at the mouth!");
    System.out.println("GenericTroll used FLAME CANNON");
    int i = (int)(Math.random() * 100);
    System.out.println("It mildly annoyed you!");
    return i;
  }
  public void changeHealth(int n) {
    super.changeHealth(n);
  }
  
  @Override
  public JeXMLNode getXML()
  {
	  JeXMLNode base = super.getXML();
	  base.addChildNode(new JeXMLNode("Type", TypeName));
	  base.addChildNode(new JeXMLNode("Name", name));
	  return base;
  }
}
