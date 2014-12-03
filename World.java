import JeXML.InfoBase;
import JeXML.JeXMLBase;
import JeXML.JeXMLInterface;

import java.util.ArrayList;


public class World
{
	private static World Game;
	public static World getGame(){return Game;}
	
	private int m_iCurrentRoom;
	private ArrayList<Room> m_Rooms;
	private Player m_Player;
	
	public World()
	{
		
	}
	
	public int getCurrentRoom()
	{
		return m_iCurrentRoom;
	}
	
	public void setCurrentRoom(int iNewVal)
	{
		m_iCurrentRoom = iNewVal;
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
	
	//Uses default constructor
	public Room newRoom()
	{
		Room r = new Room();
		m_Rooms.add(r);
		return r;
	}
	
	public Player getPlayer()
	{
		return m_Player;
	}
	
	private void save() throws InstantiationException, IllegalAccessException
	{
		JeXMLInterface intr = new JeXMLInterface();
		intr.saveInfos(m_Rooms.toArray(new Room[0]), new Room());
	}
	
	private void load() throws InstantiationException, IllegalAccessException
	{
		JeXMLInterface intr = new JeXMLInterface();
		//Load basics
		ArrayList<Room> m_Rooms = intr.loadInfos(new Room());
		//Load details
		intr.loadInfosDetails(m_Rooms, new Room());
		
		//Find the player
		for (int i = 0; i < getNumRooms(); i++)
		{
			for (int j = 0; j < getRoom(i).getNumLivingBeings(); j++)
			{
				if (getRoom(i).getLivingBeing(j).getClass().equals(Player.class))
				{
					m_Player = (Player) getRoom(i).getLivingBeing(j);
					m_iCurrentRoom = i;
				}
			}
		}
	}
}
