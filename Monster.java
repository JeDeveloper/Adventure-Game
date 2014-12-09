import JeXML.JeXMLNode;

public class Monster extends LivingBeing {
  private String name;
  private int m_iKillXP;
  public static final String TypeName = "MONSTER";
  public Monster(String name, int h) 
  {
    super(name, h);
    weapon = new Weapon();
    m_iKillXP = (int) (Math.random() * h * 2);
  }
  
  //XML constructor. If you are not Josh Evans, ignore this
  public Monster(JeXMLNode node)
  {
	  super(node);
	  name = node.getChildNodeContentByName("Name");
  }

  public void changeHealth(int n) 
  {
    super.changeHealth(n);
  }
  
  public int getKillXP()
  {
	  return m_iKillXP;
  }
  
  @Override
  public JeXMLNode getXML()
  {
	  JeXMLNode base = super.getXML();
	  base.addChildNode(new JeXMLNode("Type", TypeName));
	  base.addChildNode(new JeXMLNode("Name", name));
	  return base;
  }

	@Override
	public void processChangeRoom() 
	{
		// TODO Auto-generated method stub
	}
}
