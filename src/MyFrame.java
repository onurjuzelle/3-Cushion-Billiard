package yeniJavaProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;


import javax.swing.JFrame;



public class MyFrame extends JFrame {
	public MyFrame(String s) 
	{
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150,150,900,900);
		setLayout(new FlowLayout());
		setBackground(Color.DARK_GRAY);
		addMouseListener(new MyMouseSensor());
		setVisible(true);
	
	}
	public void paint(Graphics g) {
		Dimension d =getSize();
		checkOffscreenImage();
		Graphics offG = ((variable.OSC).getGraphics());
        offG.setColor(Color.white);
        offG.fillRect(0, 0, d.width, d.height);
        paintOffscreen(variable.OSC.getGraphics());
        g.drawImage(variable.OSC, 0, 0, null);
		
	}
	private void checkOffscreenImage() 
	{
		Dimension d =getSize();
		if(variable.OSC == null ||variable.OSC.getWidth(null) !=d.width || variable.OSC.getHeight(null) != d.height) 
		{
			variable.OSC = createImage(d.width,d.height);
			
		}
	}
	
	public void paintOffscreen(Graphics g) 
	{
		g.clearRect(0, 0, 900, 900);
		Point first =new Point();
		Point last =variable.listOfDots.get(0);
		g.setColor(Color.BLACK);
		Graphics2D graphics2d=(Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i=1;i<variable.listOfDots.size();i++) 
		{
			first =variable.listOfDots.get(i);
			graphics2d.drawLine(first.x, first.y, last.x, last.y);
			last= new Point(first);
			
		}
		graphics2d.setColor(Color.red);
		for(int i=0;i<variable.foods.size();i++) 
		{
			graphics2d.fillOval(variable.foods.get(i).x,variable.foods.get(i).y, 10, 10);
			
		}
		
	}
}
