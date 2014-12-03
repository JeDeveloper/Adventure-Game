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
	
	public Door(Room leadsTo)
	{
		m_LeadsTo = leadsTo;
	}
	
	public Room getLeadsTo()
	{
		return m_LeadsTo;
	}
	
	public String getDescription()
	{
		return m_szDirection;
	}
}
