import java.util.ArrayList;

//Should this inherit from InfoBase?
public class ItemList extends ArrayList<Item> 
{
 
  
  
  
  
  public int getTotalWeight()
 {
  int iWeight = 0;
  for (int i = 0; i < size(); i++)
  {
   iWeight += get(i).getWeight();
  }
  return iWeight;
 }
}
