package history.view;

import history.controller.HistoryController; 
import javax.swing.JFrame;

public class HistoryFrame extends JFrame
{

	private HistoryController appController;
	private HistoryPanel appPanel;
	
	public HistoryFrame(HistoryController appController)
	{
		super();
		this.appController = appController;
		appPanel = new HistoryPanel(appController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setSize(500, 500);
		this.setTitle("HistoryLocator-csp");
		this.setContentPane(appPanel);
		this.setResizable(true);
		this.setVisible(true);
		
	}
}
