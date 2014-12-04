public class Backpack extends ItemList
{

  protected int maxHold;
 // protected Item holding[] = new Item[50];
  
  public Backpack()
  {
    maxHold = 10;
    
  }
  
  public Backpack(int n)
  {
    maxHold = n;
    
  }
  
  public boolean addItem(Item i)
  {
    if(size() < maxHold){
      add(i);
      return true;
    }
    
    return false;
    
   /* int c = 0;
    while(holding[c]!=null)
    {
      c++;
    }
    holding[c]= i;
    i.hold = true;*/
  }
  
  public Item removeItem(int s)        //trying to change holding to not holding and use the item
  {
    
   
        return get(s);
    
    
      /*int x = 0;
    for(int c = 0; c<holding.length;c++)
    {
      if(holding[c].equals(s))
      {
        return getStrength(); //No method Backpack::getStrength()
      }
    }*/
  }
  
  public void getItems()
  {
    for(int c = 0; c<size()-1; c++)
    {
      System.out.println(get(c).toString());
    }
  
    
  }
    
}
