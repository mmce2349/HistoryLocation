package history.controller;


import history.view.HistoryFrame;
import history.view.ProvideWebsite;
import history.model.ProvideLocation;

public class HistoryController 
{
	//private data members
	
	private ProvideLocation location;
	private HistoryFrame appFrame;
	private ProvideWebsite Website;
	
	
	
	public HistoryController()
	{
		location = new ProvideLocation();
		this.appFrame = new HistoryFrame(this);
		Website = new ProvideWebsite();
		
	}
	
	//methods
	public void start()
	{
		
		
	}
	
}
