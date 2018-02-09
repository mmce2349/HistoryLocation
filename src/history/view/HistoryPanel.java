package history.view;

import history.controller.HistoryController;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryPanel 
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
		
		titleLabel = new JLabel("History locator");
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
		this.add(appLayout);
		this.add()
		
		
		
	}
	
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		
		
	}
}
