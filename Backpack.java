public class Backpack extends ItemList
{

  protected int maxHold;
  protected Item holding[] = new Item[50];
  
  public Backpack()
  {
    maxHold = 10;
    
  }
  
  public Backpack(int n)
  {
    maxHold = n;
    
  }
  
  public void addItem(Item i)
  {
    int c = 0;
    while(holding[c]!=null)
    {
      c++;
    }
    holding[c]= i;
    i.hold = true;
  }
  
  public Item removeItem(String s)        //trying to change holding to not holding and use the item
  {
    for(int c = 0; c<holding.length;c++)
    {
      if(holding[c].equals(s)
      {
        holding[c].drop;
        holding[c].use;
        return holding[c];
      }
    }
  }
  
  public void getItems()
  {
    for(int c = 0; c<holding.length; c++)
    {
      if(holding[c]!=null)
      System.out.println(holding[c]);
    }
  
    
  }
    
}
