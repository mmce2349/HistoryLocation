package history.view;

import history.controller.HistoryController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;

public class HistoryPanel extends JPanel implements HyperlinkListener
{
	private HistoryController appController;
	private SpringLayout appLayout;
	
	private JButton viewLocalHistory;
	private JButton viewLocalSites;
	private JButton close;
	private JLabel titleLabel;
	private JLabel locationLabel;
	private JTextField inputField;
	private JTextArea descriptionArea;
	private JPanel History;
	private JButton backButton, forwardButton;
	private JTextField URLField;
	 private JEditorPane displayEditorPane;
	 private ArrayList pageList = new ArrayList();
	
	public HistoryPanel(HistoryController appController)
	{
		super("ProvideWebsite");
	    setSize(700, 500);
	    
		this.appController = appController; 
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		viewLocalHistory = new JButton("History");
		close = new JButton("Close App");
		viewLocalSites = new JButton("Sites");
		//descriptionArea = new JTextArea("This is an app which takes your location and shows you local history and sites");
		
		titleLabel = new JLabel("History locator");
		
		locationLabel = new JLabel("location");
		
		this.History = new JPanel();
		
		setupPanel();
		setupLayout();
		setupListeners();
		JMenuBar menu = new JMenuBar();
		 JMenu fileMenu = new JMenu("File");
		 fileMenu.setMnemonic(KeyEvent.VK_F);
		 JMenuItem fileExitMenuItem = new JMenuItem("Abort Program", KeyEvent.VK_X);
		 JPanel buttonPanel = new JPanel();
			backButton = new JButton( "<- Back");
			backButton.setEnabled(true);
			buttonPanel.add(backButton);
			forwardButton = new JButton(" Forward ->");
			forwardButton.setEnabled(true);
			buttonPanel.add(forwardButton);
			URLField = new JTextField(35);
			fileMenu.add(fileExitMenuItem);
			menu.add(fileMenu);
			setJMenuBar(menu);
			forwardButton.setEnabled(true);
			buttonPanel.add(forwardButton);
			URLField = new JTextField(35);
			buttonPanel.add(URLField);
			JButton returnButton = new JButton("Return");
			buttonPanel.add(returnButton);
			private void actionEscape()
			  {
			  System.exit(0);
			  }
			private void actionBack()
			  {
			  	URL currentUrl = displayEditorPane.getPage();
				int pageIndex = pageList.indexOf(currentUrl.toString());
				try
				{
					showPage(new URL((String) pageList.get(pageIndex -1)), false);
				}
				catch(Exception e)
				{
					
				}
			  }
			private void actionForward()
			  {
			  	URL currentUrl = displayEditorPane.getPage();
				int pageIndex = pageList.indexOf(currentUrl.toString());
				try
				{
					showPage(new URL((String) pageList.get(pageIndex +1)), false);
				}
				catch(Exception e)
				{
					
				}
			  }
			 private void actionGo()
			    {
			    	URL verifiedUrl = verifyUrl(URLField.getText());
				if(verifiedUrl != null)
				{
					showPage(verifiedUrl, true);
				}
				else
				{
					showError("Not a valid URL, Try Again!");
				}
			    }
			 private void showError(String errorMessage)
			   {
			   	JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
			   }
			 private URL verifyUrl(String url)
			 {
			 	if(!url.toLowerCase().startsWith("http://"))
			 	{
			 		return null;
			 	}
			 	URL verifiedUrl = null;
			 	try
			 	{
			 		verifiedUrl = new URL(url);
			 	}
			 	catch(Exception e)
			 	{
			 	return null;
			 	}
			 return verifiedUrl;
			 	
			 }
			 private void showPage(URL pageUrl, boolean addToList)
			 {
			 	setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			 		try
			 		{
			 			URL currentURL = displayEditorPane.getPage();
			 			displayEditorPane.setPage(pageUrl);
			 			URL newUrl = displayEditorPane.getPage();
			 			//abstraction
			 			if(addToList)
			 			{
			 				int listSize = pageList.size();
			 				if(listSize>0)
			 				{
			 					int pageIndex = pageList.indexOf(currentUrl.toString());
			 					if(pageIndex < listSize - 1)
			 					{
			 						for(int index = listSize -1; index > pageIndex; index --)
			 						{
			 						pageList.remove(index);
			 						}
			 					}
			 				}
			 				pageList.add(newUrl.toString());
			 			}
			 		}
			 			
			 			catch(Exception e)
			 			{
			 			showError("Unable to load da page");
			 			}
			 			finally
			 			{
			 			setCursor(Cursor.getDefaultCursor());
			 			}
			 		
			 		//endAbstraction
			 		URLField.setText(newUrl.toString());
			 		updatesButtons();
			 	
			 	
			 }
			 private void updateButtons()
			 {
			 	if(pageList.size() < 2)
				{
				backButton.setEnabled(true);
				forwardButton.setEnabled(true);
				}
				else
				{
				URL currentUrl = displayEditorPane.getPage();
				int pageIndex = pageList.indexOf(currentUrl.toString());
				backButton.setEnabled(pageIndex > 0);
				forwardButton.setEnabled(pageIndex < (pageList.size() -1));
				}
			 } 
	}
	public void hyperlinkUpdate(HyperlinkEvent event)
	{
	HyperlinkEvent.EventType eventType = event.getEventType();
	if (eventType == HyperlinkEvent.EventType.ACTIVATED)
	{
		if(event instanceof HTMLFrameHyperlinkEvent)
		{
			HTMLFrameHyperlinkEvent linkEvent = (HTMLFrameHyperlinkEvent) event;
			HTMLDocument document = (HTMLDocument) displayEditorPane.getDocument();
			document.processHTMLFrameHyperlinkEvent(linkEvent);
		}
		else
		{
			showPage(event.getURL(), true);
		}
	}
	
	private void setupPanel()
	{
		setLayout(appLayout);
		
		this.setBackground(Color.WHITE);
		this.add(descriptionArea);
		this.add(viewLocalHistory);
		this.add(viewLocalSites);
		this.add(titleLabel);
		this.add(locationLabel);
		this.add(descriptionArea);
		this.add(close);
		this.add(inputField);
		 
			displayEditorPane = new JEditorPane();
		     displayEditorPane.setContentType("text/html");
		     displayEditorPane.setEditable(false);
		     displayEditorPane.addHyperlinkListener(this);
		    
	}

	private void setupLayout()
	{
		 getContentPane().setLayout(new BorderLayout());
	     getContentPane().add(buttonPanel, BorderLayout.NORTH);
	     getContentPane().add(new JScrollPane(displayEditorPane), BorderLayout.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 9, SpringLayout.SOUTH, titleLabel);
		appLayout.putConstraint(SpringLayout.NORTH, titleLabel, 32, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, titleLabel, 172, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, descriptionArea, 6, SpringLayout.NORTH, viewLocalHistory);
		appLayout.putConstraint(SpringLayout.NORTH, locationLabel, 5, SpringLayout.NORTH, close);
		appLayout.putConstraint(SpringLayout.WEST, locationLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, close, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, viewLocalHistory, 0, SpringLayout.NORTH, viewLocalSites);
		appLayout.putConstraint(SpringLayout.WEST, viewLocalHistory, 78, SpringLayout.EAST, viewLocalSites);
		appLayout.putConstraint(SpringLayout.WEST, viewLocalSites, 92, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, viewLocalSites, -43, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 77, SpringLayout.SOUTH, titleLabel);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 66, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, close, 12, SpringLayout.SOUTH, viewLocalHistory);
	}
	
	private void setupListeners()
	{
		viewLocalHistory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String city = inputField.getText();
				
				//appController.ProvideWebsite(city);
			}
		});
		viewLocalSites.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String sites = inputField.getText();
				
			}
		});
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				System.exit(0);
			}
		});
		addWindowListener(new WindowAdapter()
		   {
		   	public void closeWindow(WindowEvent e)
			{
			actionEscape();
			}
		   
		   });
		fileExitMenuItem.addActionListener(new ActionListener()
		 {
			public void actionPerformed(ActionEvent e)
		 	{
			 actionEscape();
		 	}
		 });
		backButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				actionBack();
			}
		});
		{
			public void actionPerformed(ActionEvent event)
			{
				actionForward();
			}
			});
			URLField.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent event)
				{
					if(event.getKeyCode() == KeyEvent.VK_ENTER)
					{
						actionGo();
					}
				}
			});
			URLField.addKeyListener(new KeyAdapter() 
			{
				public void keyReleased(KeyEvent event)
				{
					if(event.getKeyCode() == KeyEvent.VK_ENTER)
					{
						actionGo();
					}
				}
			});
			returnButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
				actionGo();
				}
			});
	}
}
