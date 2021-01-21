package fp.pbo.its;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    static final int width = 640;
    static final int height = 400;
    static final int cell = 20;
    static final int GameCell = (width * height) / (cell * cell);
    private int delay;
    private Color Fcolor, Bcolor;
    private Apple apple;
    private JButton tryagain;
    boolean running = false;
    Timer timer;
    Random random;
    Snake snake;
    private String User;
    private int appleDelay;
    private int appleDelayCounter = 0;

    GamePanel(int delay, Color Bcolor, Color Fcolor, Color BGcolor, String User) {
        random = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(BGcolor);
        this.setFocusable(true);
        this.delay = delay;
        this.Fcolor = Fcolor;
        this.Bcolor = Bcolor;
        this.addKeyListener(new MyKeyAdapter());
        this.User = User;
        appleDelay = 6000/delay;
        startGame();
    }

    public void startGame() {
        snake = new Snake(this.Bcolor);
        newApple();
        running = true;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (running) {
                    snake.move();
                    checkApple();
                    running = snake.checkCollisions();
                }
                repaint();
                if (appleDelayCounter < appleDelay) appleDelayCounter++;
                else newApple();
            }
        });
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return this.delay;
    }
    
    public String getUser() {
        return this.User;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
            apple.draw(g);
            snake.draw(g);

            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString("Score: " + snake.getApplesEaten(), 5, 18);
            g.drawString("Length: " + snake.getBodyParts(), 5, 38);
        } else {
            gameOver(g);
            TryAgain();
        }

    }

    private void TryAgain() {
		tryagain = new JButton("2");
		tryagain.setBounds(300, 350, 50, 50);
		
	}

	public void newApple() {
        int appleX = random.nextInt((int) (width / cell)) * cell;
        int appleY = random.nextInt((int) (height / cell)) * cell;
        int changeLength = random.nextInt(3) + 1;
        String ops = "+-:*";
        String op = String.valueOf(ops.charAt(random.nextInt(4)));

        apple = new Apple(appleX, appleY, Fcolor, changeLength, op);
        appleDelayCounter = 0;
    }

    public void checkApple() {
        if ((snake.getX()[0] == apple.getX()) && (snake.getY()[0] == apple.getY())) {
            switch (apple.getOp()) {
                case "+":
                	snake.setApplesEaten(snake.getApplesEaten() + (snake.getBodyParts() + apple.getChangeLength()));
                    snake.setBodyParts(snake.getBodyParts() + apple.getChangeLength());
                    break;
                case "-":
                	snake.setApplesEaten(snake.getApplesEaten() + (snake.getBodyParts() - apple.getChangeLength()));
                    snake.setBodyParts(snake.getBodyParts() - apple.getChangeLength());
                    break;
                case ":":
                	snake.setApplesEaten(snake.getApplesEaten() + (snake.getBodyParts() / apple.getChangeLength()));
                    snake.setBodyParts(snake.getBodyParts() / apple.getChangeLength());
                    break;
                case "*":
                	snake.setApplesEaten(snake.getApplesEaten() + (snake.getBodyParts() * apple.getChangeLength()));
                    snake.setBodyParts(snake.getBodyParts() * apple.getChangeLength());
                    break;
                
                default:
                    break;
            }
            newApple();
        }
        
    }

    public void gameOver(Graphics g) {
    	g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
    	g.drawString("Username :  " +  getUser(), 
    			((width - metrics.stringWidth("Username: " + getUser())) / 2), (height/2)-45);
    	
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + snake.getApplesEaten(),
                (width - metrics1.stringWidth("Score: " + snake.getApplesEaten())) / 2, (height / 2) + 25);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", 
        		(width - metrics2.stringWidth("Game Over")) / 2, height / 2);
        
//    	g.setColor(Color.WHITE);
//        g.setFont(new Font("Ink Free", Font.BOLD, 20));
//        FontMetrics metrics3 = getFontMetrics(g.getFont());
//    	g.drawString("TRY AGAIN", 
//    			(width - metrics3.stringWidth("TRY AGAIN")) / 2, (height / 2)+60);
    	
       
        
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != 'R') {
                        snake.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT: 
                    if (snake.getDirection() != 'L') {
                        snake.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != 'D') {
                        snake.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != 'U') {
                        snake.setDirection('D');
                    }
                    break;
            }
        }
    }
}
