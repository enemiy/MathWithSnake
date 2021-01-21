package fp.pbo.its;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Draw extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton Main,L1,L2,L3,L4,L5;
	private JButton B1,B2,B3,F1,F2,F3,BG1,BG2,BG3;
	private int delay;
	private Color Fcolor,Bcolor,BGcolor;
	private String User;

    public Draw(String User){
        this.setSize(640, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        userInterface();
        this.setVisible(true);
        this.setLayout(null);
        this.setUser(User);
    }
    
    private void userInterface() {
    	
        JPanel p_nama = new JPanel();
        p_nama.setBounds(0, 0, 640, 120);
        p_nama.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));
        p_nama.setBackground(new Color(33, 41, 48));
        
        JLabel user = new JLabel("Level :");
        user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        user.setForeground(new Color(10,255,4));
        
        p_nama.add(user);
       
        L1 = new JButton("1");
        L1.addActionListener(this);
        L1.setBackground(Color.WHITE);
        L1.setForeground(new Color(10, 255,4));
       
        
        L2 = new JButton("2");
        L2.setBackground(Color.WHITE);
        L2.setForeground(new Color(10,255,4));
        L2.addActionListener(this);
        
        L3 = new JButton("3");
        L3.setBackground(Color.WHITE);
        L3.setForeground(new Color(10,255,4));
        L3.addActionListener(this);
        
        L4 = new JButton("4");
        L4.setBackground(Color.WHITE);
        L4.setForeground(new Color(10,255,4));
        L4.addActionListener(this);   
        
        L5 = new JButton("5");
        L5.setBackground(Color.WHITE);
        L5.setForeground(new Color(10,255,4));
        L5.addActionListener(this);
        
        p_nama.add(L1);
        p_nama.add(L2);
        p_nama.add(L3);
        p_nama.add(L4);
        p_nama.add(L5);
        
        JPanel p_color = new JPanel();
        p_color.setBackground(new Color(33, 41, 48));
        p_color.setLayout(null);
        
        JLabel color = new JLabel("Color :");
        color.setFont(new Font("Times New Roman", Font.BOLD, 20));
        color.setBounds(135, 130, 100,50);
        color.setForeground(new Color(10,255,4));
 
        p_color.add(color);
        
        JLabel body = new JLabel("Snake");
        body.setFont(new Font("Times New Roman", Font.BOLD, 20));
        body.setBounds(170, 168, 100,50);
    
        body.setForeground(new Color(10,255,4))	;
        p_color.add(body);
        
        B1 = new JButton();
        B1.setBackground( new Color(195, 200, 205));
        B1.setBounds(330, 180, 20,20);
        B1.addActionListener(this);
        
        B2 = new JButton();
        B2.setBackground(new Color(189, 208, 156));
        B2.setBounds(370, 180, 20,20);
        B2.addActionListener(this);
        
        B3 = new JButton();
        B3.setBackground(new Color(170, 206, 226));
        B3.setBounds(410, 180, 20,20);
        B3.addActionListener(this);
        
        p_color.add(B1);
        p_color.add(B2);
        p_color.add(B3);
        
        JLabel food = new JLabel("Food");
        food.setFont(new Font("Times New Roman", Font.BOLD, 20));
        food.setForeground(new Color(10,255,4))	;
        food.setBounds(170, 202, 100,50);
        p_color.add(food);
        
        F1 = new JButton();
        F1.setBackground(new Color(239, 62, 91));
        F1.setBounds(330, 215, 20,20);
        F1.addActionListener(this);
        
        F2 = new JButton();
        F2.setBackground(new Color(0, 197, 144));
        F2.setBounds(370, 215, 20,20);
        F2.addActionListener(this);
        
        F3 = new JButton();
        F3.setBackground(new Color(95, 216, 250));
        F3.setBounds(410, 215, 20,20);
        F3.addActionListener(this);
        
        p_color.add(F1);
        p_color.add(F2);
        p_color.add(F3);
        
        
        JLabel bg = new JLabel("Background");
        bg.setFont(new Font("Times New Roman", Font.BOLD, 20));
        bg.setForeground(new Color(10,255,4))	;
        bg.setBounds(170, 237, 150,50);
        p_color.add(bg);
        
        BG1 = new JButton();
        BG1.setBackground(new  Color (33, 41, 48));
        BG1.setBounds(330, 250, 20,20);
        BG1.addActionListener(this);
        
        BG2 = new JButton();
        BG2.setBackground(new Color (50,53,49));
        BG2.setBounds(370, 250, 20,20);
        BG2.addActionListener(this);
        
        BG3 = new JButton();
        BG3.setBackground(new Color (0,65,89));
        BG3.setBounds(410, 250, 20,20);
        BG3.addActionListener(this);
        
        p_color.add(BG1);
        p_color.add(BG2);
        p_color.add(BG3);
        
        Main = new JButton("MAIN");
        Main.setFont(new Font("ARIAL", Font.BOLD, 11));
        Main.addActionListener(this);
        Main.setBounds(280, 310, 90,30);
        p_color.add(Main);
        getContentPane().add(p_nama);
        getContentPane().add(p_color);
    }
    
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==L1) this.delay=130; 
        if(e.getSource()==L2) this.delay=105;
        if(e.getSource()==L3) this.delay=85; 
        if(e.getSource()==L4) this.delay=65; 
        if(e.getSource()==L5) this.delay=45;
        if(e.getSource()==B1) this.Bcolor= new Color(195, 200, 205);
        if(e.getSource()==B2) this.Bcolor = new Color(189, 208, 156);
        if(e.getSource()==B3) this.Bcolor= new Color(170, 206, 226);
        if(e.getSource()==F1) this.Fcolor= new Color(239, 62, 91); 
        if(e.getSource()==F2) this.Fcolor= new Color(0, 197, 144); 
        if(e.getSource()==F3) this.Fcolor= new Color(95, 216, 250); 
        if(e.getSource()==BG1) this.BGcolor = new  Color (33, 41, 48); 
        if(e.getSource()==BG2) this.BGcolor= new Color (50,53,49); 
        if(e.getSource()==BG3) this.BGcolor= new Color (0,65,89); 
        if(e.getSource()==Main) {
            new GameFrame(getDelay(),getBcolor(),getFcolor(),getBGcolor(), getUser());
            setVisible(false);
        }
    }
    
    public int getDelay() {
    	return this.delay;
    }
    public Color getBGcolor() {
    	return this.BGcolor;
    }
    public Color getFcolor() {
    	return this.Fcolor;
    }
    public Color getBcolor() {
    	return this.Bcolor;
    }
    
    public  String getUser() {
        return this.User;
    }
 
    public void setUser(String user) {
        this.User = user;
    }
}

    
    