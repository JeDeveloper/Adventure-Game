import JeXML.InfoBase;
import JeXML.JeXMLBase;


public class Door extends InfoBase
{
	private Door m_Partner;
	
	//Blank constructor required by JeXML
	public Door()
	{
		
	}
	
	public Door(Door partner)
	{
		m_Partner = partner;
	}
	
	public Door getPartner()
	{
		return m_Partner;
	}
	
	public void setPartner(Door d)
	{
		m_Partner = d;
	}
	
	@Override
	public void readDetails(JeXMLBase xml) 
	{
		
	}

	@Override
	public void writeDetails(JeXMLBase xml) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String makeTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilePath() 
	{
		return "save/doors.xml";
	}

}
