package mvc.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import login.GameMenu;
import mvc.view.MenuBar;
import mvc.view.StatusBar;



public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusBar statusbar;
	private static MenuBar menuBar;
	private static GameMenu gameMenu;
	
	public MainFrame() {
		menuBar = new MenuBar(gameMenu, this);
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        setJMenuBar(menuBar);

        
        validate();
        repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void closeApp() {
		System.exit(0);
	}
	
	public void displayMessage(String text) {
		JOptionPane.showMessageDialog(this, text);
	}

	public StatusBar getStatusBar() {
		return statusbar;
	}
}
