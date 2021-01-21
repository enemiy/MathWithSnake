package fp.pbo.its;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
    final int x[] = new int[GamePanel.GameCell];
    final int y[] = new int[GamePanel.GameCell];
    private int bodyParts = 6;
    private int applesEaten;
    private char direction = 'R';
    private Color Bcolor;

    Snake(Color Bcolor) {
    	this.Bcolor=Bcolor;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - GamePanel.cell;
                break;
            case 'D':
                y[0] = y[0] + GamePanel.cell;
                break;
            case 'L':
                x[0] = x[0] - GamePanel.cell;
                break;
            case 'R':
                x[0] = x[0] + GamePanel.cell;
                break;
        }

    }

    public boolean checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                return false;
            }
        }
        if (x[0] < 0) {
            return false;
        }
        if (x[0] > GamePanel.width) {
            return false;
        }
        if (y[0] < 0) {
            return false;
        }
        if (y[0] > GamePanel.height) {
            return false;
        }
        if (bodyParts < 1) return false;
        return true;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    public int getApplesEaten() {
        return applesEaten;
    }

    public void setApplesEaten(int applesEaten) {
        this.applesEaten = applesEaten;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(this.Bcolor.darker());
                g.fillRect(x[i], y[i], GamePanel.cell, GamePanel.cell);
            } else {
                g.setColor( this.Bcolor.darker().darker());
                g.fillRect(x[i], y[i], GamePanel.cell, GamePanel.cell);
            }
        }
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }
}