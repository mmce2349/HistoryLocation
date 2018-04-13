package history.controller;


import history.view.HistoryFrame;
import history.view.ProvideWebsite;


public class HistoryController 
{
	//private data members
	
	
	private HistoryFrame appFrame;
	private ProvideWebsite Website;
	
	
	
	public HistoryController()
	{
		
		this.appFrame = new HistoryFrame(this);
		Website = new ProvideWebsite();
		
	}
	
	//methods
	public void start()
	{
	//polishing stuff.
		
	}
	
}
