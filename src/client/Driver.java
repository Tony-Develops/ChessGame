package client;

import game.ChessGame;
import game.GameMenu;
import mvc.view.MainFrame;

public class Driver {

	
	public static void main(String[] args) throws Throwable
	{       
        Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame();

			}
        };
        
		r.run();
   
		GameMenu login = new GameMenu();
		login.menuSystem();
		
		ChessGame chessGame = new ChessGame();
		chessGame.PlayGame();
		
	}

}
