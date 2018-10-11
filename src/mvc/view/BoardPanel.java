package mvc.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel {
	private JPanel chessBoard;
	int boardLen = 6;
	private JButton[][] boardSize = new JButton[boardLen][boardLen];
	private static final String COLS = "ABCDEFGHIJKLMNOP";

	public BoardPanel() {

		chessBoard = new JPanel(new GridLayout(0, boardLen+1));
		for (int i = 0; i < boardSize.length; i++) {
			for (int j = 0; j < boardSize[i].length; j++) {
				JButton chessPiece = new JButton();
				chessPiece.setMargin(new Insets(10, 10, 10, 10));
				ImageIcon icon = new ImageIcon(new BufferedImage(50, 50, BufferedImage.BITMASK));
				chessPiece.setIcon(icon);
				chessPiece.setOpaque(true);
				
				if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
					chessPiece.setBackground(Color.WHITE);
				} else {
					chessPiece.setBackground(Color.BLACK);
				}

				boardSize[j][i] = chessPiece;
			}
		}

		chessBoard.add(new JLabel(""));

		for (int i = 0; i < boardLen; i++) {
			chessBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
		}
		for (int i = 0; i < boardLen; i++) {
			for (int j = 0; j < boardLen; j++) {
				switch (j) {
				case 0:
					chessBoard.add(new JLabel("" + ((boardLen+1)- (i + 1)), SwingConstants.CENTER));
				default:
					chessBoard.add(boardSize[j][i]);
				}
			}
		}
	}

	public final JComponent getBoard() {
		return chessBoard;
	}
}
