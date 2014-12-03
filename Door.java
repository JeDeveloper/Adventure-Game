import JeXML.InfoBase;
import JeXML.JeXMLBase;


public class Door
{
	private Room m_LeadsTo;
	private String m_szDirection;
	
	//Blank constructor required by JeXML
	public Door()
	{
		
	}
	
	public Door(String direction, Room leadsTo)
	{
		m_LeadsTo = leadsTo;
		m_szDirection = direction;
	}
	
	public Door(Room leadsTo)
	{
		m_LeadsTo = leadsTo;
	}
	
	public Room getLeadsTo()
	{
		return m_LeadsTo;
	}
	
	public String getDirection()
	{
		return m_szDirection;
	}
}
