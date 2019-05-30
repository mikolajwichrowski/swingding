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
                    panel.player.left();
                    refresh();
                }

                if (e.getKeyCode() == 38) {
                    panel.player.up();
                    refresh();
                }

                if (e.getKeyCode() == 39) {
                    panel.player.right();
                    refresh();
                }

                if (e.getKeyCode() == 40) {
                    panel.player.down();
                    refresh();
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
        int resolutionX = 30+((Canvas.WIDTH+1)*50);
        int resolutionY = 20+(30+((Canvas.HEIGHT+1)*50));
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }

    public void refresh() {
        panel.repaint();
    }
}