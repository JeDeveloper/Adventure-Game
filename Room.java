import java.util.ArrayList;

import JeXML.InfoBase;
import JeXML.JeXMLBase;
import JeXML.JeXMLNode;

public class Room extends InfoBase
{
	private ArrayList<Door> m_Doors;
	private ArrayList<LivingBeing> m_Beings;
	private String m_szName;
	private int m_iLevel;
	
	public Room()
	{
		m_Doors = new ArrayList<Door>();
		m_Beings = new ArrayList<LivingBeing>();
	}
	
	public Room addRoom(Room r)
	{
		m_Doors.add(new Door(r));
	}
	public String getName()
	{
		return m_szName;
	}
	
	public int getNumDoors()
	{
		return m_Doors.size();
	}
	
	public Door getDoor(int iIndex)
	{
		assert iIndex < getNumDoors() : "Index out of bounds.";
		assert iIndex > -1 : "Index out of bounds.";
		return m_Doors.get(iIndex);
	}
	
	public void addDoor(Door d)
	{
		m_Doors.add(d);
	}
	
	public int getNumLivingBeings()
	{
		return m_Beings.size();
	}
	
	public LivingBeing getLivingBeing(int iIndex)
	{
		assert iIndex < getNumLivingBeings() : "Index out of bounds.";
		assert iIndex > -1 : "Index out of bounds.";
		return m_Beings.get(iIndex);
	}

	public int getLevel()
	{
		return m_iLevel;
	}
	
	@Override
	public void readDetails(JeXMLBase xml) 
	{
		m_szName = xml.getCurrentNode().getChildNodeContentByName("Name");
		xml.setCurrentNode(xml.getCurrentNode().getChildNodeByName("Doors"));
		for (int i = 0; i < xml.getCurrentNode().getNumChildren(); i++)
		{
			//Add to m_Doors the door with the tag contained within
		}
		xml.setCurrToParent();
		xml.setCurrentNode(xml.getCurrentNode().getChildNodeByName("LivingBeings"));
		for (int i = 0; i < xml.getCurrentNode().getNumChildren(); i++)
		{
			//Add to m_LivingBeings the LivingBeing with the tag contained within.
			//Bear in mind that all LivingBeings are Player or Monsters! 
		}
		xml.setCurrToParent();
	}

	@Override
	public void writeDetails(JeXMLBase xml) 
	{
		JeXMLNode n;
		n = new JeXMLNode("Name");
		n.setContent(getName());
		xml.getCurrentNode().addChildNode(n);
		JeXMLNode doors = new JeXMLNode("Doors");
		for (int i = 0; i < getNumDoors(); i++)
		{
			n = new JeXMLNode("Door");
			xml.setCurrentNode(n);
			n = new JeXMLNode("Name");
			n.setContent(getDoor(i).getName());
			xml.getCurrentNode().addNode(n);
			n = new JeXMLNode("LeadsTo");
			n.setContent(getDoor(i).getLeadsTo().getTag());
			xml.getCurrentNode().addNode(n);
			xml.setCurrentNode(doors.getParentNode());
		}
		xml.getCurrentNode().addChildNode(doors);
		JeXMLNode beings = new JeXMLNode("LivingBeings");
		for (int i = 0; i < getNumLivingBeings(); i++)
		{
			n = new JeXMLNode("LivingBeing");
			n.setContent(getLivingBeing(i).getTag());
			beings.addChildNode(n);
		}
		xml.getCurrentNode().addChildNode(beings);
	}

	@Override
	protected String makeTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
