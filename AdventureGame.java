import java.util.Scanner;

//import JeXML.JeXMLInterface;

public class AdventureGame 
{
	public static final String[] commands = new String[]{
		"info", //Prints info about room and status
		"attack", //Takes a variable afterwords
		"help", //prints a list of commands
		"move",// enter a door
		"load",//loads the game
		"save"//saves the game
		};
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(System.in);
	    System.out.println("Hello and welcome to INTERNET FIGHTER I");
	    System.out.println("What is your name?");
	    String name = in.nextLine();
	    Player player = new Player(name, 100);
	    new World(player);
	    while (true)
	    {
	    	processInput(in.nextLine());
	    }
	}
	
	public static void processInput(String input)
	{
		switch (getCommand(input))
		{
		case -1:
			System.out.println("Invalid command '"+input+"'. Press 'help' to view commands");
			return;
		case 0:
			Player p = World.getGame().getPlayer();
			System.out.println("Name: "+p.getName());
			System.out.println("Health: "+p.getHealth());
			System.out.println("XP: "+p.getXP());
			int iNumMonsters = p.getCurrentRoom().getNumLivingBeings()-1;
			System.out.println("Number of monsters in current website: "+iNumMonsters+".");
			if (iNumMonsters > 0)
				System.out.println("Monsters:");
			for (int i = 0; i < iNumMonsters; i++)
			{
				System.out.println("\t"+p.getCurrentRoom().getLivingBeing(i).getName());
			}
			int iNumDoors = p.getCurrentRoom().getNumDoors();
			System.out.println("Number of hyperlinks leading out of this website:" + iNumDoors);
			System.out.println("Hyperlinks:");
			for (int i = 0; i < iNumDoors; i++)
			{
				System.out.println("\tLeads To:"+p.getCurrentRoom().getDoor(i).getLeadsTo().getName());
			}
			return;
		case 1:
			p = World.getGame().getPlayer();
			String monstername = "";
			try{
			monstername = input.split(" ",2)[1];
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("No target for attack.");
				return;
			}
			Monster target = (Monster) p.getCurrentRoom().getMonster(monstername);
			if (target == null)
			{
				System.out.println("No monster in current room with name "+monstername+".");
				return;
			}
			Action.doCombatRound(p, target);
			return;
		case 2:
			System.out.println(commands[0]+" : display info about your surroundings.");
			System.out.println(commands[1]+" [the name of a monster] : attack a monster");
			System.out.println(commands[2]+" : the command you just used to print this list");
			System.out.println(commands[3]+" [the name of a destination] : go through a door");
			System.out.println(commands[4]+" : loads the previous game.");
			System.out.println(commands[5]+" : saves the game.");
		case 3:
			p = World.getGame().getPlayer();
			String roomname = "";
			try{
				roomname = input.split(" ",2)[1];
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("No destination specified.");
				return;
			}
			int iRoom = -1;
			for (int i = 0; i < p.getCurrentRoom().getNumDoors(); i++)
			{
				if (roomname.equals(p.getCurrentRoom().getDoor(i).getLeadsTo().getName()))
				{
					iRoom = i;
					break;
				}
			}
			if (iRoom < 0)
			{
				System.out.println("No website with name "+roomname+"linked from this site.");
				return;
			}
			p.changeRoom(p.getCurrentRoom().getDoor(iRoom).getLeadsTo());
			return;
		case 4:
			try {
				World.getGame().load();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case 5:
			try {
				World.getGame().save();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}
	
	public static int getCommand(String input)
	{
		for (int i = 0; i < commands.length; i++)
		{
			if (input.startsWith(commands[i]))
				return i;
		}
		return -1;
	}
}
