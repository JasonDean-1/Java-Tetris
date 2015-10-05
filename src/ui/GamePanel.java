package ui;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

import javax.swing.JPanel;

import object.Piece;
import object.PieceCreator;
import object.Square;
import object.impl.PieceCreatorImpl;
import util.ImageUtil;

public class GamePanel extends JPanel
{

	MainFrame mainFrame;

	private Image background = ImageUtil.getImage("images/background.jpg");

	public GamePanel(MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		// this.setPreferredSize(new Dimension())
	}

	public void paint(Graphics g)
	{
		g.drawImage(this.background, 0, 0, this.getWidth(), this.getHeight(), null);
		Piece currentPiece = this.mainFrame.getCurrentPiece();
		ImageUtil.paintPiece(g, currentPiece);
		Square[][] squares = this.mainFrame.getSquares();
		if (squares == null)
			return;
		for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares[i].length; j++)
			{
				Square s = squares[i][j];
				if (s != null)
				{
					g.drawImage(s.getImage(), s.getBeginX(), s.getBeginY(), this);
				}
			}
		}
	}

}
