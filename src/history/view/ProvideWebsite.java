package history.view;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;

public class ProvideWebsite extends JFrame implements HyperlinkListener 
	  {
		    
    private JButton backButton, forwardButton;
//	    private JButton backButton, forwardButton;
     
   private JTextField URLField;
//	    private JTextField locationTextField;
     
   private JEditorPane displayEditorPane;
//	    private JEditorPane displayEditorPane;
     
   private ArrayList pageList = new ArrayList();
//	    private ArrayList pageList = new ArrayList();
     
   
//	    public ProvideWebsite() 
//	    {
public ProvideWebsite()
{


        super("ProvideWebsite");
//	        super("ProvideWebsite");
         
        setSize(700, 500);
//	        setSize(640, 480);
         
   addWindowListener(new WindowAdapter()
   {
   	public void closeWindow(WindowEvent e)
	{
	actionEscape();
	}
   
   });
//	        addWindowListener(new WindowAdapter() 
//	        {
//	            public void windowClosing(WindowEvent e) 
//	            {
//	                actionEscape();
//	            }
//	        });

         
 JMenuBar menu = new JMenuBar();
 JMenu fileMenu = new JMenu("File");
 fileMenu.setMnemonic(KeyEvent.VK_F);
 JMenuItem fileExitMenuItem = new JMenuItem("Abort Program", KeyEvent.VK_X);
 fileExitMenuItem.addActionListener(new ActionListener()
 {
 public void actionPerformed(ActionEvent e)
 {
 actionEscape();
 }
 });
//	        JMenuBar menuBar = new JMenuBar();
//	        JMenu fileMenu = new JMenu("File");
//	        fileMenu.setMnemonic(KeyEvent.VK_F);
//	        JMenuItem fileExitMenuItem = new JMenuItem("Exit",
//	                KeyEvent.VK_X);
//	        fileExitMenuItem.addActionListener(new ActionListener() 
//	        {
//	            public void actionPerformed(ActionEvent e) 
//	            {
//	                actionEscape();
//	            }
//	        });

	fileMenu.add(fileExitMenuItem);
	menu.add(fileMenu);
	setJMenuBar(menu);
//	        fileMenu.add(fileExitMenuItem);
//	        menuBar.add(fileMenu);
//	        setJMenuBar(menuBar);
         
//	        //cool
	JPanel buttonPanel = new JPanel();
	backButton = new JButton( "<- Back");
	backButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			actionBack();
		}
	});
//	        JPanel buttonPanel = new JPanel();
//	        backButton = new JButton("< Back");
//	        backButton.addActionListener(new ActionListener() 
//	        {
//	            public void actionPerformed(ActionEvent e) 
//	            {
//	                actionBack();
//	            }
//	        });

backButton.setEnabled(true);
buttonPanel.add(backButton);
forwardButton = new JButton(" Forward ->");
forwardButton.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent event)
{
	actionForward();
}
});
//	        backButton.setEnabled(true);
//	        buttonPanel.add(backButton);
//	        forwardButton = new JButton("Forward >");
//	        forwardButton.addActionListener(new ActionListener() 
//	        {
//	            public void actionPerformed(ActionEvent e) 
//	            {
//	                actionForward();
//	            }
//	        });
forwardButton.setEnabled(true);
buttonPanel.add(forwardButton);
URLField = new JTextField(35);
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
	forwardButton.setEnabled(true);
	buttonPanel.add(forwardButton);
	URLField = new JTextField(35);
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
//	        forwardButton.setEnabled(true);
//	        buttonPanel.add(forwardButton);
//	        locationTextField = new JTextField(35);
//	        locationTextField.addKeyListener(new KeyAdapter() 
//	        {
//	            public void keyReleased(KeyEvent e) 
//	            {
//	                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
//	                {
//	                    actionGo();
//	                }
//	            }
//	        });
	buttonPanel.add(URLField);
	JButton returnButton = new JButton("Return");
	returnButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
		actionGo();
		}
	});
	buttonPanel.add(returnButton);
//	        buttonPanel.add(locationTextField);
//	        JButton goButton = new JButton("GO");
//	        goButton.addActionListener(new ActionListener() 
//	        {
//	            public void actionPerformed(ActionEvent e) 
//	            {
//	                actionGo();
//	            }
//	        });
//	        buttonPanel.add(goButton);
         
     displayEditorPane = new JEditorPane();
     displayEditorPane.setContentType("text/html");
     displayEditorPane.setEditable(false);
     displayEditorPane.addHyperlinkListener(this);
     getContentPane().setLayout(new BorderLayout());
     getContentPane().add(buttonPanel, BorderLayout.NORTH);
     getContentPane().add(new JScrollPane(displayEditorPane), BorderLayout.CENTER);
     }
//	        displayEditorPane = new JEditorPane();
//	        displayEditorPane.setContentType("text/html");
//	        displayEditorPane.setEditable(false);
//	        displayEditorPane.addHyperlinkListener(this);
         
//	        getContentPane().setLayout(new BorderLayout());
//	        getContentPane().add(buttonPanel, BorderLayout.NORTH);
//	        getContentPane().add(new JScrollPane(displayEditorPane),
//	                BorderLayout.CENTER);
//	    }
     
  private void actionEscape()
  {
  System.exit(0);
  }
//	    private void actionExit() 
//	    {
//	        System.exit(0);
//	    }
     
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
//	    private void actionBack() 
//	    {
//	        URL currentUrl = displayEditorPane.getPage();
 
//	        int pageIndex = pageList.indexOf(currentUrl.toString());
//	        try 
//	        {
//	            showPage(new URL((String) pageList.get(pageIndex - 1)), false);
//	        } 
//	        catch (Exception e) 
//	        {
        	
//	        }
//	    }
     
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
//	    private void actionForward() 
//	    {
//	        URL currentUrl = displayEditorPane.getPage();
//	        int pageIndex = pageList.indexOf(currentUrl.toString());
//	        try 
//	        {
//	            showPage( new URL((String) pageList.get(pageIndex + 1)), false);
//	        } 
//	        catch (Exception e) 
//	        {
        	
//	        }
//	    }
     
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
//	    private void actionGo() 
//	    {
//	        URL verifiedUrl = verifyUrl(locationTextField.getText());
//	        if (verifiedUrl != null)
//	        {
//	            showPage(verifiedUrl, true);
//	        } 
//	        else 
//	        {
//	            showError("Invalid URL");
//	        }
//	    }
     
   private void showError(String errorMessage)
   {
   	JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
   }
//	    private void showError(String errorMessage) 
//	    {
//	        JOptionPane.showMessageDialog(this, errorMessage,"Error", JOptionPane.ERROR_MESSAGE);
//	    }
     
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

//	    private URL verifyUrl(String url) 
//	    {
       
//	        if (!url.toLowerCase().startsWith("http://"))
//	            return null;
         
       
//	        URL verifiedUrl = null;
//	        try 
//	        {
//	            verifiedUrl = new URL(url);
//	        } 
//	        catch (Exception e) 
//	        {
//	            return null;
//	        }
         
//	        return verifiedUrl;
//	    }
     
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
	  
//	    private void showPage(URL pageUrl, boolean addToList) 
//	    {
     
//	        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
         
//	        try 
//	        {
//	            URL currentUrl = displayEditorPane.getPage();
//	            displayEditorPane.setPage(pageUrl);
//	            URL newUrl = displayEditorPane.getPage();
             
//	         //startAbstraction
//	            if (addToList) 
//	            {
//	                int listSize = pageList.size();
//	                if (listSize > 0) 
//	                {
//	                    int pageIndex =
//	                            pageList.indexOf(currentUrl.toString());
//	                    if (pageIndex < listSize - 1) 
//	                    {
//	                        for (int i = listSize - 1; i > pageIndex; i--) 
//	                        {
//	                            pageList.remove(i);
//	                        }
//	                    }
//	                }
//	                pageList.add(newUrl.toString());
//	            }
//	            //endAbstraction
             
          
//	            locationTextField.setText(newUrl.toString());
             
           
//	            updateButtons();
//	        } 
//	        catch (Exception e) 
//	        {
       
//	            showError("Unable to load page");
//	        } 
//	        finally 
//	        {
          
//	            setCursor(Cursor.getDefaultCursor());
//	        }
//	    }
     
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
//	    private void updateButtons() 
//	    {
//	        if (pageList.size() < 2) 
//	        {
//	            backButton.setEnabled(true);
//	            forwardButton.setEnabled(true);
//	        } 
//	        else 
//	        {
//	            URL currentUrl = displayEditorPane.getPage();
//	            int pageIndex = pageList.indexOf(currentUrl.toString());
//	            backButton.setEnabled(pageIndex > 0);
//	            forwardButton.setEnabled(
//	                    pageIndex < (pageList.size() - 1));
//	        }
//	    }
     
//	//startComplexity
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
//	    public void hyperlinkUpdate(HyperlinkEvent event)
//	    {
//	        HyperlinkEvent.EventType eventType = event.getEventType();
//	        if (eventType == HyperlinkEvent.EventType.ACTIVATED) 
//	        {
//	            if (event instanceof HTMLFrameHyperlinkEvent) 
//	            {
//	                HTMLFrameHyperlinkEvent linkEvent =
//	                        (HTMLFrameHyperlinkEvent) event;
//	                HTMLDocument document =
//	                        (HTMLDocument) displayEditorPane.getDocument();
//	                document.processHTMLFrameHyperlinkEvent(linkEvent);
//	            } 
//	            else 
//	            {
//	                showPage(event.getURL(), true);
//	            }
//	        }
//	    }
     
//	   //endComplexity
//	    public static void main(String[] args) 
//	    {
//	        ProvideWebsite browser = new ProvideWebsite();
//	        browser.show();
	    }
}
