package history.view;

import history.controller.HistoryController;
import java.awt.Color;

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
		 fileMenu.add(fileExitMenuItem);
			menu.add(fileMenu);
			setJMenuBar(menu);
			forwardButton.setEnabled(true);
			buttonPanel.add(forwardButton);
			URLField = new JTextField(35);
			buttonPanel.add(URLField);
			JButton returnButton = new JButton("Return");
	}

	private void setupLayout()
	{
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
	//*Abstraction
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
	}
}
