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
