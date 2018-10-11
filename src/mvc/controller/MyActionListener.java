package mvc.controller;

import java.awt.event.ActionListener;

import mvc.view.MainFrame;
import mvc.view.StatusBar;

//an abstract class inherited by listeners that contain statusbar, gameengine, mainframe object.
public abstract class MyActionListener implements ActionListener
{
	protected StatusBar statusBar;
	protected MainFrame mainFrame;
	
	public MyActionListener(MainFrame mainFrame) 
	{
		this.statusBar = mainFrame.getStatusBar();
		this.mainFrame = mainFrame;
	}
}
