import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Form class die wordt aangeroepen in de Program Class.
 * Program(Start)
 * --Form(You are here)
 *
 * Op deze Class komt het Canvas en de Button interface te staan.
 */
public class Form extends JFrame {
    // Auto generated serial
    private static final long serialVersionUID = 8557974571427438540L;
    private Canvas panel;

    Form() {
        // Panel
        panel = new Canvas();
        JButton saveButton = new JButton("Save");
        JButton restartButton = new JButton("Restart");
        JButton optionsButton = new JButton("Options");
        JButton quitButton = new JButton("Quit");
        
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

        // X and Y pointers for painting.
        int offsetX = 30;
        int offsetY = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;
        int resolutionX = offsetX+((Canvas.WIDTH+1)*50)+(offsetX*2);
        int resolutionY = offsetY+(30+((Canvas.HEIGHT+1)*50))+(offsetY*3);
        int paneWidth = (Canvas.WIDTH+1)*50+offsetX;
        int paneHeight = (Canvas.HEIGHT+1)*50+offsetY;
        int buttonX = offsetX;
        int buttonY = paneHeight+offsetY;

        //Manual Layout positioning of elements
        panel.setBounds(offsetX-8,offsetY-10, paneWidth,paneHeight);
        saveButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        restartButton.setBounds((buttonX*2)+buttonWidth, buttonY, buttonWidth, buttonHeight);
        optionsButton.setBounds((buttonX*3)+(buttonWidth*2), buttonY, buttonWidth, buttonHeight);
        quitButton.setBounds((buttonX*4)+(buttonWidth*3), buttonY, buttonWidth, buttonHeight);

        // Add KeyListener for panel
        panel.addKeyListener(myKeyListener);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        // Add lambda expressions for buttons
        saveButton.addActionListener(e -> {/**TODO: Add logic for save.*/});
        restartButton.addActionListener(e -> {/**TODO: Add logic for restart.*/});
        optionsButton.addActionListener(e -> {/**TODO: Add logic for options window.*/});
        quitButton.addActionListener(e -> {/**TODO: Add logic for quitting to menu.*/});

        // Show
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().add(panel);
        this.add(saveButton);
        this.add(restartButton);
        this.add(optionsButton);
        this.add(quitButton);
        this.setSize(resolutionX, resolutionY);
        this.setVisible(true);
    }

    public void refresh() {
        panel.repaint();
    }
}