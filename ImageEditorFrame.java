import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ImageEditorFrame extends JFrame{ 
	public JPanel panel;

	public ImageEditorFrame(){
		panel = new ImageEditorPanel();
		add(panel);
		
		//creating new Menubar
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
		JMenu menuFile = new JMenu("File"); 
		menuBar.add(menuFile);
		JMenuItem menuItemOpen = new JMenuItem("Open"); 
		menuFile.add(menuItemOpen); 
		JMenuItem dummy = new JMenuItem("Dummy"); 
		menuFile.add(dummy); 
		menuItemOpen.addActionListener(e ->onOpen());
		dummy.addActionListener(e ->setDummyImage());

		setTitle("BildEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(400, 300);
		setVisible(true);

}	
	private void setDummyImage(){
		BufferedImage bufferedImage = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 380, 280);
		((ImageEditorPanel) panel).setImage(bufferedImage);
	}
		
		private void onOpen(){
			   try{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(this);
			File file = fileChooser.getSelectedFile(); 
			BufferedImage image = ImageIO.read(file); 
			((ImageEditorPanel) panel).setImage(image);
			   }
			   catch(IOException e){
			JOptionPane.showMessageDialog(this,
			"Die Datei konnte nicht geöffnet werden");
			   }
	}

	public static void main (String [] args){
		new ImageEditorFrame();
	}
}