package mvc.view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mvc.controller.RegisterListener;
import mvc.model.game.GameMenu;
import mvc.controller.ExitListener;
import mvc.controller.LoginListener;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar
{
	private JMenu playersMenu;
	private JMenuItem register, exitApp, login;
	private ActionListener menuLogin, menuReg, menuExit;

	public MenuBar(GameMenu gameMenu, MainFrame frame)
	{
		playersMenu = new JMenu("Players");
		add(playersMenu);
		
		menuReg = new RegisterListener(gameMenu, frame);
		menuExit = new ExitListener(frame);
		menuLogin = new LoginListener(gameMenu, frame);
		
		login = new JMenuItem("Login");
		login.addActionListener(menuLogin);
		
		register = new JMenuItem("Register");
		register.addActionListener(menuReg);
		
		exitApp = new JMenuItem("Quit");
		exitApp.addActionListener(menuExit);
		
		playersMenu.add(login);
		playersMenu.add(register);
		playersMenu.add(exitApp);
	}
}
