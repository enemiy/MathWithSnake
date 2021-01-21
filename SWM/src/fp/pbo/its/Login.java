package fp.pbo.its;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField NameUser;
    private JButton Main, batal;
	private String UserT;
    
    public Login(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        userInterface();
    }
    
    private void userInterface(){
        JPanel p_nama = new JPanel();
       p_nama.setLayout(new FlowLayout(FlowLayout.CENTER,0, 40));
        p_nama.setBackground(new Color(33, 41, 48));
        getContentPane().add(p_nama,"North");
        
        ImageIcon Image = new ImageIcon("icons72x72.png");
        
        JLabel user = new JLabel(Image);
        user.setPreferredSize(new Dimension(190,150));
        p_nama.add(user);
            
        NameUser = new JTextField();
        NameUser.setPreferredSize(new Dimension(180, 30));
        
       // p_nama.add(NameUser);
        
        JPanel textbox = new JPanel();
        textbox.setLayout(new FlowLayout(FlowLayout.CENTER,0, 0));
        textbox.setBackground(new Color(33, 41, 48));
        textbox.add(NameUser);
        getContentPane().add(textbox,"Center");
        
        JPanel pButton = new JPanel();
        pButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pButton.setBackground(new Color(33, 41, 48));
       
        Main = new JButton("Login");
        Main.addActionListener(this);
        pButton.add(Main);
        
        batal = new JButton("Exit");
        batal.addActionListener(this);
        pButton.add(batal);
    
        getContentPane().add(pButton, "South");
    }
    
    public void setUserT (String UserT) {
    	this.UserT = UserT;
    }
    
    public String getUserT() {
    	return this.UserT;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Main){
        	setUserT(NameUser.getText());
            new Draw(getUserT());
            setVisible(false);
        } 
        if(e.getSource()==batal){
            System.exit(0);
        }
    }
  
}

    
    
