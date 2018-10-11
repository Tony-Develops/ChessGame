package mvc.controller;

import java.awt.event.ActionEvent;

import mvc.controller.FrameListener;
import mvc.view.MainFrame;

//added to menu item to close the application.

public class ExitListener extends FrameListener
{
	public ExitListener(MainFrame frame) 
	{
		super(frame);
	}

	public void actionPerformed(ActionEvent event) 
	{
		mainFrame.closeApp();
	}

}
