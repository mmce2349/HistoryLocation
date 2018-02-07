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
		
		setupFrame();
	}
	private void setupFrame()
	{
		this.setSize(500, 500);
		this.setTitle("Chatbot 2017");
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
	}
}
