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
	
	public int getLevel()
	{
		return m_iLevel;
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
			xml.setCurrentNode(xml.getCurrentNode().getChildNode(i));
			Door d = new Door(getCurrentNode().getChildNodeContentByName("Direction"),
					World.getGame().getRoom(getCurrentNode().getChildNodeContentByName("LeadsTo")));
			m_Doors.add(d);
			xml.setCurrToParent();
		}
		xml.setCurrToParent();
		xml.setCurrentNode(xml.getCurrentNode().getChildNodeByName("LivingBeings"));
		for (int i = 0; i < xml.getCurrentNode().getNumChildren(); i++)
		{
			m_LivingBeings.add(new LivingBeing(xml.getCurrentNode().getChildNode(i)));
		}
		xml.setCurrToParent();
		m_iLevel = Integer.parseInt(xml.getChildNodeContentByName("iLevel"));
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
			n = new JeXMLNode("Direction");
			n.setContent(getDoor(i).getDirection());
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
			n = getLivingBeing(i).getXML();
			beings.addChildNode(n);
		}
		xml.getCurrentNode().addChildNode(beings);
		n = new JeXMLNode("iLevel");
		n.setContent(getLevel());
		xml.getCurrentNode().addNode(n);
	}

	@Override
	protected String makeTag() 
	{
		String szTag = "ROOM_"+getName().toUpperCase();
		if (World.getGame().getRoom(szTag) == null || World.getGame().getRoom(szTag).equals(this))
			return szTag;
		String szAugTag;
		int i = 1;
		while (true)
		{
			szAugmentedTag = szTag+i;
			if (World.getGame().getRoom(szAugTag) == null || World.getGame().getRoom(szAugTag).equals(this))
				return szAugTag;
			i++;
		}
	}

	@Override
	public String getFilePath() 
	{
		return "save/rooms.xml";
	}
}
