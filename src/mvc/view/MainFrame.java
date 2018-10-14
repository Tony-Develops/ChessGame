package mvc.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.model.game.GameMenu;



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
        BoardPanel board = new BoardPanel();

//        setLocationRelativeTo(null);

        setJMenuBar(menuBar);     
        add(board.getBoard());
 
        
        validate();
        repaint();
        pack();
        setMinimumSize(this.getSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
