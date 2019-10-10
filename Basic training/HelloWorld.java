import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;





public class HelloWorld {
	private int x;
	private int y;
	
	public static void main(String[] args) {
		new HelloWorld();
		System.out.println("dsf");
	}
	
	public HelloWorld() {
		x = y = 100;
		Frame  frame = new Frame("HelloWorld");
		DrawCanvas draw = new DrawCanvas();
		frame.add(draw);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		draw.requestFocus();
		draw.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				draw.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent event) {
						x = event.getX();
						y = event.getY();
						
						
						draw.repaint();
						
					}
				});
				
			}
			
		});
		
		
	}
	
	
	
	class DrawCanvas extends Canvas {
		public void  paint(Graphics g) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("楷体", Font.BOLD, 20));
			g.drawString("hello world", x, y);
		}
	}
	
}


