import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Form
 */
public class Form extends JFrame {
    // Auto generated serial
    private static final long serialVersionUID = 8557974571427438540L;
    private Canvas panel;

    Form() {
        // Panel
        panel = new Canvas();
        
        // Keylistener
        KeyListener myKeyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) { 
                if (e.getKeyCode() == 37) {
                    left();
                }

                if (e.getKeyCode() == 38) {
                    up();
                }

                if (e.getKeyCode() == 39) {
                    right();
                }

                if (e.getKeyCode() == 40) {
                    down();
                }
            }
        
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        };

        // Add keylistener
        panel.addKeyListener(myKeyListener);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        // Show
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        int resolutionX = 30+(9*50);
        int resolutionY = 20+resolutionX;
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }

    // TODO: Move this god class logic to the canvas... dont forget to place the movement in player and collision in canvas
    private void left() {
        int x = Canvas.player.x; 
        int y = Canvas.player.y-1;
        Entity collisioned = Canvas.getEntity(x, y);

        Canvas.player.currentShape = new ShapeTriangle();
        if (Canvas.player.y > 0&& !Canvas.isCollision(Canvas.player.x, Canvas.player.y-1)) {
            Canvas.player.rotation = 1;
            Canvas.player.y = Canvas.player.y - 1;
        } else if (Canvas.isDoor(x, y) && Canvas.player.unlock(collisioned)) {
            Canvas.remove(x, y);
        } else if (Canvas.isKey(x, y)) {
            Canvas.player.addKey();
            Canvas.remove(x, y);
        }
        refresh();
    }

    private void up() {
        int x = Canvas.player.x-1; 
        int y = Canvas.player.y;
        Entity collisioned = Canvas.getEntity(x, y);

        Canvas.player.currentShape = new ShapeTriangle();

        if(Canvas.player.x > 0 && !Canvas.isCollision(x, y)) {
            Canvas.player.rotation = 2;
            Canvas.player.x = x;
        } else if (Canvas.isDoor(x, y) && Canvas.player.unlock(collisioned)) {
            Canvas.remove(x, y);
        } else if (Canvas.isKey(x, y)) {
            Canvas.player.addKey();
            Canvas.remove(x, y);
        }
        refresh();
    }

    private void right() {
        int x = Canvas.player.x; 
        int y = Canvas.player.y+1;
        Entity collisioned = Canvas.getEntity(x, y);

        Canvas.player.currentShape = new ShapeTriangle();
        if (Canvas.player.y < 8 && !Canvas.isCollision(x, y)) {
            Canvas.player.rotation = 4;
            Canvas.player.y = y;
        } else if (Canvas.isDoor(x, y) && Canvas.player.unlock(collisioned)) {
            Canvas.remove(x, y);
        } else if (Canvas.isKey(x, y)) {
            Canvas.player.addKey();
            Canvas.remove(x, y);
        }
        refresh();
    }

    private void down() {
        Canvas.player.currentShape = new ShapeTriangle();

        int x = Canvas.player.x+1; 
        int y = Canvas.player.y;
        Entity collisioned = Canvas.getEntity(x, y);

        if (Canvas.player.x < 8 && !Canvas.isCollision(x, y)) {
            Canvas.player.rotation = 3;
            Canvas.player.x = x;
        } else if (Canvas.isDoor(x, y) && Canvas.player.unlock(collisioned)) {
            Canvas.remove(x, y);
        } else if (Canvas.isKey(x, y)) {
            Canvas.player.addKey();
            Canvas.remove(x, y);
        }
        
        refresh();
    }

    private void refresh() {
        panel.repaint();
    }
}