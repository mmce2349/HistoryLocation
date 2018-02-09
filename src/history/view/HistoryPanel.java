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
		viewLocalSites = new JButton("Sites");
		appLayout.putConstraint(SpringLayout.NORTH, viewLocalHistory, 0, SpringLayout.NORTH, viewLocalSites);
		appLayout.putConstraint(SpringLayout.WEST, viewLocalHistory, 40, SpringLayout.EAST, viewLocalSites);
		appLayout.putConstraint(SpringLayout.WEST, viewLocalSites, 115, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, viewLocalSites, -92, SpringLayout.SOUTH, this);
		descriptionArea = new JTextArea("This is an app which takes your location and shows you local history and sites");
		titleLabel = new JLabel("History locator");
		appLayout.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, titleLabel, 174, SpringLayout.WEST, this);
		locationLabel = new JLabel();
		
		this.History = new JPanel();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		setLayout(appLayout);
		
		this.setBackground(Color.BLACK);
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
