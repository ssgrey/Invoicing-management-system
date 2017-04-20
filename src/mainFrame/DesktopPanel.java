package mainFrame;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

public class DesktopPanel extends JDesktopPane {
	
	private final Image img ;
	public DesktopPanel(){
		super();
		URL url = this.getClass().getResource("/res/back.jpg");
		img = new ImageIcon(url).getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
