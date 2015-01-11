package galaxyoyo.unknown.editor;

import galaxyoyo.unknown.api.editor.sprites.Sprite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SpriteComp extends JComponent
{
	private static final long serialVersionUID = -6512257366877053285L;
	
	private final Sprite sprite;
	private final int couche;
	private boolean selected;
	
	public SpriteComp(Sprite sprite, int couche)
	{
		super ();
		this.sprite = sprite;
		this.couche = couche;
		this.setMinimumSize(new Dimension(32, 32));
		this.setMaximumSize(new Dimension(32, 32));
		this.setPreferredSize(new Dimension(32, 32));
		this.setSize(new Dimension(32, 32));
		
		repaint();
	}

	public Sprite getSprite()
	{
		return sprite;
	}
	
	public int getCouche()
	{
		return couche;
	}
	
	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(sprite.getImage(), 0, 0, 32, 32, Color.white, null);
		
		if (isSelected())
		{
			g.setColor(Color.black);
			g.drawLine(0, 0, getWidth() - 1, 0);
			g.drawLine(0, 0, 0, getHeight() - 1);
			g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
			g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
		}
	}
}