import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Form
 */
public class Form extends JFrame {
<<<<<<< HEAD
    // Auto generated serial
=======
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
    private static final long serialVersionUID = 8557974571427438540L;
    private Canvas panel;

    Form() {
        // Panel
        panel = new Canvas();
<<<<<<< HEAD
        
        // Keylistener
        KeyListener myKeyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) { 
=======

        // Keylistener
        KeyListener myKeyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
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
<<<<<<< HEAD
            }
        
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
=======

                if (Character.isSpaceChar(e.getKeyChar())) {
                    space();
                }

                if (e.getKeyChar() == 'c') {
                    color();
                }

                if (e.getKeyChar() == 's') {
                    shape();
                }

                if (e.getKeyChar() == 'r') {
                    rotate();
                }

                if (e.getKeyChar() == 'q') {
                    rotate();
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        };

        // Add keylistener
        panel.addKeyListener(myKeyListener);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        // Show
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
<<<<<<< HEAD
        int resolutionX = 30+(9*50);
        int resolutionY = 20+resolutionX;
=======
        int resolutionX = 30 + (9 * 50);
        int resolutionY = 20 + resolutionX;
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }

<<<<<<< HEAD
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
=======
    private void left() {
        if (Canvas.pen.y > 0) {
            Canvas.pen.y = Canvas.pen.y - 1;
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        }
        refresh();
    }

    private void up() {
<<<<<<< HEAD
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
=======
        if (Canvas.pen.x > 0) {
            Canvas.pen.x = Canvas.pen.x - 1;
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        }
        refresh();
    }

    private void right() {
<<<<<<< HEAD
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
=======
        if (Canvas.pen.y < 8) {
            Canvas.pen.y = Canvas.pen.y + 1;
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        }
        refresh();
    }

    private void down() {
<<<<<<< HEAD
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
        
=======
        if (Canvas.pen.x < 8) {
            Canvas.pen.x = Canvas.pen.x + 1;
        }
        refresh();
    }

    private void space() {
        Canvas.pen.setTrace();
        refresh();
    }

    private void color() {
        Canvas.pen.switchColor();
        refresh();
    }

    private void shape() {
        Canvas.pen.switchShape();
        refresh();
    }

    private void rotate() {
        Canvas.pen.rotation = Canvas.pen.rotation + 1;
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        refresh();
    }

    private void refresh() {
        panel.repaint();
    }
}