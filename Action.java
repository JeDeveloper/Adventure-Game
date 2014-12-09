import java.util.Scanner;

public class Action 
{
	//Josh replaced fightsim in its enteirity because it's terrible.
	public static void doCombatRound(Player p, Monster m) //TODO: Enable multi-monster fights
	{
		int iPlayerAttackDmg, iMonsterAttackDmg = 0;
		iPlayerAttackDmg = p.attack(m);
		if (m.getHealth() > 0)
			iMonsterAttackDmg =  m.attack(p);
		else
		{
			System.out.println(p.getName() + " has defeated a " + m.getName()+"!");
			System.out.println(p.getName() + " has gained "+m.getKillXP()+" experience!");
			p.changeXP(m.getKillXP());
			System.out.println(m.getName()+" had a "+m.getWeapon()+"! Do use it instead of your "+p.getWeapon()+"? (y/n)");
			Scanner in = new Scanner(System.in);
			if (in.nextLine().equals("y"))
			{
				p.setWeapon(m.getWeapon());
			}
			p.getCurrentRoom().removeLivingBeing(m);
			return;
		}
		if (p.getHealth() < 0)	
		{
			System.out.print("After enduring "+p.getXP()+" of internet vitriol, "+p.getName()+" lost all vestiges of sanity.");
			return;
		}
		System.out.println("You did "+iPlayerAttackDmg+" points of damage to "+m.getName()+" , reducing it to "+m.getHealth()+".");
		System.out.println(m.getName()+" did "+iMonsterAttackDmg+" points of damage to you, reducing your to "+p.getHealth()+".");
	}
	
	public static String drinkPotion(Player a, Potion b) 
	{
		a.incrementHealth(b.getStrength());
		return("After drinking a potion, " + a.toString());
  }
}
