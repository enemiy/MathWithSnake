package fp.pbo.its;

import java.awt.Color;

//import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	GameFrame(int delay,Color Bcolor, Color Fcolor,Color BGcolor, String User){
		this.add(new GamePanel(delay,Bcolor,Fcolor,BGcolor, User));
		this.setTitle("Math With Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
        this.setLocationRelativeTo(null);
	}
	
}