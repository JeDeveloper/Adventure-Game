import JeXML.InfoBase;
import JeXML.JeXMLBase;
import java.util.ArrayList;


public class World
{
	private static World Game;
	public static World getGame(){return Game;}
	
	private Room m_CurrentRoom;
	private ArrayList<Room> m_Rooms;
	private ArrayList<LivingBeing> m_Beings;
	private Player m_Player;
	
	public World()
	{
		
	}
	
	public Room getCurrentRoom()
	{
		return m_Current;
	}
	
	public void setCurrentRoom(Room newVal)
	{
		m_Current = newVal;
	}
	
	public int getNumRooms()
	{
		return m_Rooms.size();
	}
	
	public Room getRoom(int iIndex)
	{
		assert iIndex < getNumRooms() : "Index OOB";
		assert iIndex > -1 : "Index OOB";
		return m_Rooms.get(iIndex);
	}
	
	public Room getRoom(String tag)
	{
		for (int i = 0; i < getNumRooms(); i++)
		{
			if (getRoom(i).getTag().equals(tag))
			{
				return getRoom(i);
			}
		}
		assert false : "No room with tag " + tag;
		return null;
	}
	
	public int getNumLivingBeings()
	{
		return m_LivingBeings.size();
	}
	
	public LivingBeing getLivingBeing(int iIndex)
	{
		assert iIndex > -1 : "Index OOB";
		assert iIndex < getNumLivingBeings() : "Index OOB";
		return m_LivingBeings.get(iIndex);
	}
	
	public LivingBeing getLivingBeing(String tag)
	{
		for (int i = 0; i < getNumLivingBeings(); i++)
		{
			if (getLivingBeing(i).getTag().equals(tag))
			{
				return getLivingBeing(i);
			}
		}
		assert false : "No LivingBeing with tag "+tag;
		return null;
	}
	
	public Player getPlayer()
	{
		return m_Player;
	}
	
	private void save()
	{
		ArrayList<LivingBeing> beings = m_LivingBeings.clone();
		beings.remove(m_Player);
	}
	
	private void load() throws InstantiationException, IllegalAccessException
	{
		JeXMLInterface intr = new JeXMLInterface();
		//Load basics
		ArrayList<Room> m_Rooms = intr.loadInfos(new Room());
		ArrayList<Usable> usables = intr.loadInfos(new Usable());
		ArrayList<Weapon> weapons = intr.loadInfos(new Weapon());
		ArrayList<LivingBeing> m_LivingBeings = intr.loadInfos(new Monster());
		m_Player = intr.loadInfos(new Player()).get(0);
		//Load details
		intr.loadInfosDetails(m_Rooms, new Room());
		intr.loadInfosDetails(usables, new Usable());
		intr.loadInfosDetails(weapons, new Weapon());
		intr.loadInfosDetails(m_LivingBeings, new Monster());
		intr.loadInfosDetails(new Player[]{m_Player}, new Player());
		m_LivingBeings.add(m_Player);
		
		//Transfer loaded data into data structures... could be difficult...
	}
}
