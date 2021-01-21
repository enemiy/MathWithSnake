package fp.pbo.its;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
    private int x;
    private int y;
    private Color Fcolor;
    private int changeLength;
    private String op;

    Apple(int x, int y, Color Fcolor, int changeLength, String op) {
        this.x = x;
        this.y = y;
        this.Fcolor = Fcolor;
        this.changeLength = changeLength;
        this.op = op;
    }

    public int getX() {
        return x;
    }

    public int getY() { 
        return y;
    }

    public int getChangeLength() {
        return changeLength;
    }

    public String getOp() {
        return op;
    }

    public void draw(Graphics g) {
        g.setColor(this.Fcolor);
        g.fillOval(x, y, GamePanel.cell, GamePanel.cell);

        g.setColor(Color.WHITE);
        g.drawString(op + changeLength, x + GamePanel.cell/3, y + 2*GamePanel.cell/3);
    }

}