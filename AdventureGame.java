import java.util.ArrayList;
import java.util.Scanner;

import JeXML.JeXMLInterface;

public class AdventureGame 
{
	private static AdventureGame G;
	public AdventureGame getGlobalContext(){return G;}
	private Room m_Current;
	
	public static void breakall() {
	System.out.println("GAME OVER");
	}

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Hello and welcome to INTERNET FIGHTER I");
	System.out.println("What is your name?");
	String name = in.nextLine();
	Player player = new Player(name, 100);
	
}
}
	}
	
	public AdventureGame()
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
	
	private void save()
	{
		//Will have to be written once data structures are established
	}
	
	private void load() throws InstantiationException, IllegalAccessException
	{
		JeXMLInterface intr = new JeXMLInterface();
		//Load basics
		World world = intr.loadInfos(new World()).get(0);
		ArrayList<Room> rooms = intr.loadInfos(new Room());
		ArrayList<Door> doors = intr.loadInfos(new Door());
		ArrayList<Usable> usables = intr.loadInfos(new Usable());
		ArrayList<Weapon> weapons = intr.loadInfos(new Weapon());
		ArrayList<Monster> monsters = intr.loadInfos(new Monster());
		Player player = intr.loadInfos(new Player()).get(0);
		//Load details
		intr.loadInfosDetails(new World[]{world}, new World());
		intr.loadInfosDetails(rooms, new Room());
		intr.loadInfosDetails(doors, new Door());
		intr.loadInfosDetails(usables, new Usable());
		intr.loadInfosDetails(weapons, new Weapon());
		intr.loadInfosDetails(monsters, new Monster());
		intr.loadInfosDetails(new Player[]{player}, new Player());
		
		//Transfer loaded data into data structures... could be difficult...
	}
}
