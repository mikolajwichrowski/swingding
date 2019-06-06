package main.java.org.swingding;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * Program
 */
public class Program {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO: move this shit to appropiate locations
		JFrame loadingScreen = new JFrame();
		loadingScreen.setUndecorated(true);
		loadingScreen.setSize(new Dimension(500,500));
		loadingScreen.setLocationRelativeTo(null);
		try{
			class LoadingPanel extends JPanel {
				private static final long serialVersionUID = 1L;
				LoadingPanel() {
					setPreferredSize(new Dimension(500,500));
				}
		
				@Override
				public void paintComponent(Graphics g) {
					try {
						BufferedImage img = ImageIO.read(new File(Paths.get("").toAbsolutePath().toString() + "/images/loading.png"));
						g.drawImage(img, 0, 0, 500, 500, null);
					} catch (Exception e) {
					}
					
				}
			}
			LoadingPanel panel = new LoadingPanel();

			loadingScreen.add(panel);
			loadingScreen.setVisible(true);
			Thread.sleep(6000);
			loadingScreen.dispose();

			new Form();
		}
		catch(Exception ie)
		{
			System.out.println(ie.getMessage());
			loadingScreen.dispose();
		}
			
		// JOptionPane.showMessageDialog(null, "To draw press 'Space'\nTo change shape press 'S'\nTo rotate the shape press 'R'\n To change color press 'C'" );
	}
}
