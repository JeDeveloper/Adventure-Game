public class Action 
{
	//Josh replaced fightsim in its enteirity because it's terrible.
	public static void doCombatRound(Player p, Monster m) //TODO: Enable multi-monster fights
	{
		p.attack(m);
		if (m.getHealth() > 0)
			m.attack(p);
		else
		{
			System.out.println(p.getName() + " has defeated a " + m.getName()+"!");
			p.changeXP(m.getKillXP());
			p.getCurrentRoom().removeLivingBeing(m);
			return;
		}
		if (p.getHealth() < 0)	
		{
			System.out.print("After enduring "+p.getXP()+" of internet vitriol, "+p.getName()+" lost all vestiges of sanity.");
		}
	}
	public static String drinkPotion(Player a, Potion b) 
	{
		a.incrementHealth(b.getStrength());
		return("After drinking a potion, " + a.toString());
  }
}
