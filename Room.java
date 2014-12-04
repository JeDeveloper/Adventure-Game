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
	private boolean m_bHasDetails;
	public static final int MAX_EXITS = 6;
	
	public Room()
	{
		m_Doors = new ArrayList<Door>();
		m_Beings = new ArrayList<LivingBeing>();
		m_bHasDetails = false;
	}
	
	public void makeDetails()
	{
		if (isHasDetails())
			return;
		int iNumExits = (int)(Math.random() * (MAX_EXITS)) + 1;
		Room newRoom;
		for (int i = 0; i < iNumExits; i++)
		{
			newRoom = World.getGame().newRoom();
			addRoomWithReturn(newRoom);
		}
		m_bHasDetails = true;
	}
	
	public Room addRoom(Room r)
	{
		addDoor(new Door(r));
		return r;
	}
	
	public Room addRoomWithReturn(Room r)
	{
		addDoor(new Door(r));
		r.addDoor(new Door(this));
		return r;
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
	
	public void addLivingBeing(LivingBeing being)
	{
		m_Beings.add(being);
	}
	
	public boolean isHasMonsters(boolean isPlayerInRoom)
	{
		if (isPlayerInRoom){return getNumLivingBeings()-1>0;}
		else {return getNumLivingBeings() > 0;}
	}

	public int getLevel()
	{
		return m_iLevel;
	}
	
	public boolean isHasDetails()
	{
		return m_bHasDetails;
	}
	
	@Override
	public void readDetails(JeXMLBase xml) 
	{
		m_szName = xml.getCurrentNode().getChildNodeContentByName("Name");
		xml.setCurrentNode(xml.getCurrentNode().getChildNodeByName("Doors"));
		for (int i = 0; i < xml.getCurrentNode().getNumChildren(); i++)
		{
			xml.setCurrentNode(xml.getCurrentNode().getChild(i));
			Door d = new Door(xml.getCurrentNode().getChildNodeContentByName("Direction"),
					World.getGame().getRoom(xml.getCurrentNode().getChildNodeContentByName("LeadsTo")));
			m_Doors.add(d);
			xml.setCurrToParent();
		}
		xml.setCurrToParent();
		xml.setCurrentNode(xml.getCurrentNode().getChildNodeByName("LivingBeings"));
		for (int i = 0; i < xml.getCurrentNode().getNumChildren(); i++)
		{
			if (xml.getCurrentNode().getChild(i).getChildNodeContentByName("TypeName").equals("PLAYER"))
				m_Beings.add(new Player(xml.getCurrentNode().getChild(i)));
			else
				m_Beings.add(new Monster(xml.getCurrentNode().getChild(i)));
		}
		xml.setCurrToParent();
		m_iLevel = Integer.parseInt(xml.getCurrentNode().getChildNodeContentByName("iLevel"));
		m_bHasDetails = Boolean.parseBoolean(xml.getCurrentNode().getChildNodeContentByName("bHasDetails"));
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
			xml.getCurrentNode().addChildNode(n);
			n = new JeXMLNode("LeadsTo");
			n.setContent(getDoor(i).getLeadsTo().getTag());
			xml.getCurrentNode().addChildNode(n);
			xml.setCurrentNode(doors.getParentNode());
		}
		xml.getCurrentNode().addChildNode(doors);
		JeXMLNode beings = new JeXMLNode("LivingBeings");
		for (int i = 0; i < getNumLivingBeings(); i++)
		{
			if (getLivingBeing(i).getClass().equals(Player.class))
				n = ((Player)getLivingBeing(i)).getXML();
			else
				n = ((Monster)getLivingBeing(i)).getXML();
			beings.addChildNode(n);
		}
		xml.getCurrentNode().addChildNode(beings);
		xml.getCurrentNode().addChildNode(new JeXMLNode("iLevel", ""+getLevel()));
		xml.getCurrentNode().addChildNode(new JeXMLNode("bHasDetails", isHasDetails()+""));
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
			szAugTag = szTag+i;
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
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass().equals(Room.class))
			return equals((Room)obj);
		return false;
	}
	
	public boolean equals(Room r)
	{
		if (isHasDetails() != r.isHasDetails())
			return false;
		if
	}
}
