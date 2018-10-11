package mvc.controller;

import java.awt.event.ActionListener;

import mvc.view.MainFrame;

// Abstract class inherited by action listeners classes that are only inheriting MainFrameGUI frame 
// i.e. MenuExitListener.

public abstract class FrameListener implements ActionListener
{
	protected MainFrame mainFrame;
	
	public FrameListener(MainFrame mainFrame) 
	{
		this.mainFrame = mainFrame;
	}
}
