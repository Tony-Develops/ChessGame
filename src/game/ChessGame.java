package game;

import board.Board;
import exceptions.BoardException;
import exceptions.PlaceException;
import chessPieces.*;
import tools.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessGame {
	
	private Board board;
	private Scanner scanner = new Scanner(System.in);
	final int BOARD_SIZE_X = 6;
	final int BOARD_SIZE_Y = 4;
	
	public ChessGame()
	{
		try
		{
			board = new Board(BOARD_SIZE_X, BOARD_SIZE_Y);
			gameInit();
		} 
		catch (BoardException | PlaceException e) 
		{
			System.out.println(e.getMessage());
		}
		scanner.close();
		
	}
	
	public void PlayGame() throws Throwable
	{
		Boolean exit = false;
		Boolean player1 = false;
		Boolean player2 = false;
		int turns = 1;
		Position[] positions = new Position[2];
		while (exit == false) {
			board.displayBoard();
			System.out.println("Turn " + turns);
			player1 = true;
			System.out.println("Player 1 move");
			while (player1 == true) {
				try {
					positions = getInput();
					board.move(positions[0], positions[1], Type.White);
					player1 = false;
				}
				catch (Exception e)
				{
					player1 = true;
				}
			}
			board.displayBoard();
			player2 = true;
			System.out.println("Player 2 move");
			while (player2 == true) {
				try {
					positions = getInput();
					board.move(positions[0], positions[1], Type.Black);
					player2 = false;
				}
				catch (Exception e)
				{
					player2 = true;
				}
			}
			
			/*
			if (turns > turnLimit) {
				exit = true;
			} */
			
			turns++; 
		}
		System.out.println("Thank you for playing");
	}

	private Position[] getInput() throws InputMismatchException
	{
		Position[] positions = new Position[2];
		int x;
		int y;
		boolean pass = false;
		while (pass == false) {
			try {
				System.out.print("Enter x coordinate of chesspiece: ");
				x = scanner.nextInt();
				System.out.print("Enter y coordinate of chesspiece: ");
				y = scanner.nextInt();
				positions[0] = new Position(x,y);
				System.out.print("Enter x coordinate of destination: ");
				x = scanner.nextInt();
				System.out.print("Enter y coordinate of destination: ");
				y = scanner.nextInt();
				positions[1] = new Position(x,y);
				pass = true;
			}
			catch (InputMismatchException exception) 
			{
				pass = false;
				System.out.println("Integers only");
			}
		}
		return positions;
	}
	
	private void gameInit() throws PlaceException
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(1,0), Type.White));
		board.place(new Knight(new Position(2,0), Type.White));
		board.place(new Knight(new Position(3,0), Type.White));
		board.place(new Bishop(new Position(4,0), Type.White));
		board.place(new Rook(new Position(5,0), Type.White));
		
		board.place(new Rook(new Position(0,3), Type.Black));
		board.place(new Bishop(new Position(1,3), Type.Black));
		board.place(new Knight(new Position(2,3), Type.Black));
		board.place(new Knight(new Position(3,3), Type.Black));
		board.place(new Bishop(new Position(4,3), Type.Black));
		board.place(new Rook(new Position(5,3), Type.Black));
	}
}
