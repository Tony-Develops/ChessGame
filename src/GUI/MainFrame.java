package GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;



public class MainFrame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        JFrame frame = new JFrame("Play the colour chess");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Player");
        JMenuItem loginBtn = new JMenuItem("Login");
        JMenuItem quit = new JMenuItem("Quit");
        menu.add(loginBtn);
        menu.add(quit);
        menubar.add(menu);
        frame.setJMenuBar(menubar);

        
        frame.validate();
        frame.repaint();

	}

}
