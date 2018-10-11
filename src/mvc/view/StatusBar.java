package mvc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatusBar extends JPanel
{
	
	private JLabel firstStatusLabel = new JLabel(" Game process: ", JLabel.LEFT);
	private JLabel secondStatusLabel = new JLabel(" Player info: ", JLabel.LEFT);

	public StatusBar()
	{
		setLayout(new GridLayout(1, 2));
		Border blackBorder = BorderFactory.createLineBorder(Color.GRAY);
		firstStatusLabel.setBorder(blackBorder);
		secondStatusLabel.setBorder(blackBorder);

		add(firstStatusLabel);
		add(secondStatusLabel);
		
		firstStatusLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		secondStatusLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
	}
	

	public void setMiddleLabel(String text) 
	{
		firstStatusLabel.setText(text);		
	}

	public void setRightLabel(String text) 
	{
		secondStatusLabel.setText(text);	
	}
}
