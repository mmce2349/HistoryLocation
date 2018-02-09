package history.view;

import history.controller.HistoryController;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryPanel extends JPanel
{
	private HistoryController appController;
	private SpringLayout appLayout;
	
	private JButton viewLocalHistory;
	private JButton viewLocalSites;
	
	private JLabel titleLabel;
	private JLabel locationLabel;
	
	private JTextArea descriptionArea;
	private JPanel History;
	
	public HistoryPanel(HistoryController appController)
	{
		super();
		this.appController = appController; 
		
		appLayout = new SpringLayout();
		
		viewLocalHistory = new JButton("History");
		appLayout.putConstraint(SpringLayout.EAST, viewLocalHistory, -111, SpringLayout.EAST, this);
		viewLocalSites = new JButton("Sites");
		appLayout.putConstraint(SpringLayout.NORTH, viewLocalSites, 0, SpringLayout.NORTH, viewLocalHistory);
		appLayout.putConstraint(SpringLayout.EAST, viewLocalSites, -67, SpringLayout.WEST, viewLocalHistory);
		//descriptionArea = new JTextArea("This is an app which takes your location and shows you local history and sites");
		appLayout.putConstraint(SpringLayout.SOUTH, descriptionArea, 6, SpringLayout.NORTH, viewLocalHistory);
		titleLabel = new JLabel("History locator");
		appLayout.putConstraint(SpringLayout.NORTH, viewLocalHistory, 6, SpringLayout.SOUTH, titleLabel);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 9, SpringLayout.SOUTH, titleLabel);
		appLayout.putConstraint(SpringLayout.NORTH, titleLabel, 32, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, titleLabel, 172, SpringLayout.WEST, this);
		locationLabel = new JLabel("location");
		appLayout.putConstraint(SpringLayout.NORTH, locationLabel, -26, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, locationLabel, 190, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, locationLabel, -10, SpringLayout.SOUTH, this);
		
		this.History = new JPanel();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		setLayout(appLayout);
		
		this.setBackground(Color.BLUE);
		this.add(descriptionArea);
		this.add(viewLocalHistory);
		this.add(viewLocalSites);
		this.add(titleLabel);
		this.add(locationLabel);
		this.add(descriptionArea);
		
		
		
		
		
	}
	
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		
		
	}
}
