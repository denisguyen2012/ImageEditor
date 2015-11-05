import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class ImageEditorFrame extends JFrame{ 
	public ImageEditorFrame(){

panel = new ImageEditorPanel();
add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setSize(400, 300);
		setVisible(true);
		setTitle("BildEditor");
}

	private void createMenuBar(){
	
	
JMenuBar menuBar = new JMenuBar(); 
setJMenuBar(menuBar);
JMenu menuFile = new JMenu("File"); 
menuBar.add(menuFile);
JMenuItem menuItemOpen = new JMenuItem("Open"); 
menuFile.add(menuItemOpen); 
menuItemOpen.addActionListener(new ActionListener() {
public void ActionPerformed(ActionEvent e ){
onOpen();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
} 
}
); 
}
private void onOpen(){ JOptionPane.showMessageDialog(this, "Open Selected");
}
private void setDummyImage(){
 BufferedImage bufferedImage =
 new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
 Graphics g = bufferedImage.getGraphics();
 g.setColor(Color.YELLOW);
 g.fillOval(10, 10, 380, 280);
 panel.setImage(bufferedImage);
}
	public static void main (String [] args){
		new ImageEditorFrame();
	}
}