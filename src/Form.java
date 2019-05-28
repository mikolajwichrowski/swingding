import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Form
 */
public class Form extends JFrame {
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
        };

        // Add keylistener
        panel.addKeyListener(myKeyListener);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        // Show
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        int resolutionX = 30 + (9 * 50);
        int resolutionY = 20 + resolutionX;
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }

    private void left() {
        if (Canvas.pen.y > 0) {
            Canvas.pen.y = Canvas.pen.y - 1;
        }
        refresh();
    }

    private void up() {
        if (Canvas.pen.x > 0) {
            Canvas.pen.x = Canvas.pen.x - 1;
        }
        refresh();
    }

    private void right() {
        if (Canvas.pen.y < 8) {
            Canvas.pen.y = Canvas.pen.y + 1;
        }
        refresh();
    }

    private void down() {
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
        refresh();
    }

    private void refresh() {
        panel.repaint();
    }
}