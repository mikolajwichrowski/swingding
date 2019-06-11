package main.java.org.swingding;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
    public Canvas panel;

    /**
     * 
     */
    public Form() {
        // Panel
        this.panel = new Canvas();

        // Buttons
        JButton saveButton = new JButton("SAVE");
        JButton restartButton = new JButton("RESTART");
        JButton replayButton = new JButton("REPLAY");
        JButton quitButton = new JButton("QUIT");
        
        // Key listener
        KeyListener myKeyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) { 
                if (e.getKeyCode() == 37) {
                    panel.player.left();
                    panel.repaint();
                }

                if (e.getKeyCode() == 38) {
                    panel.player.up();
                    panel.repaint();
                }

                if (e.getKeyCode() == 39) {
                    panel.player.right();
                    panel.repaint();
                }

                if (e.getKeyCode() == 40) {
                    panel.player.down();
                    panel.repaint();
                }
            }
        
            public void keyTyped(KeyEvent e) {
                return; // uninplemented
            }
            public void keyReleased(KeyEvent e) {
                return; // uninplemented
            }
        };

        // X and Y pointers for painting.
        int offsetX = 30;
        int offsetY = 30;
        int resolutionX = offsetX+((Canvas.WIDTH+1)*50)+(offsetX*2);
        int resolutionY = offsetY+(30+((Canvas.HEIGHT+1)*50))+(offsetY*3);
        int buttonWidth = (resolutionX/4) - offsetX; // relative width
        int buttonHeight = 30; // absolute height
        int paneWidth = (Canvas.WIDTH+1)*50+offsetX;
        int paneHeight = (Canvas.HEIGHT+1)*50+offsetY;
        int buttonX = 20; // Fix for the weird offset
        int buttonY = paneHeight+offsetY;

        //Manual Layout positioning of elements
        panel.setBounds(offsetX-8,offsetY-10, paneWidth,paneHeight);
        saveButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        restartButton.setBounds((buttonX*2)+buttonWidth, buttonY, buttonWidth, buttonHeight);
        replayButton.setBounds((buttonX*3)+(buttonWidth*2), buttonY, buttonWidth, buttonHeight);
        quitButton.setBounds((buttonX*4)+(buttonWidth*3), buttonY, buttonWidth, buttonHeight);

        // Add KeyListener for panel
        panel.addKeyListener(myKeyListener);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        // Add lambda expressions for buttons
        saveButton.addActionListener(e -> saveEvent());

        restartButton.addActionListener(e -> reloadEvent());

        replayButton.addActionListener(e -> replayEvent());

        quitButton.addActionListener(e -> dispose());

        // Show form with controls
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().add(panel);
        this.add(saveButton);
        this.add(restartButton);
        this.add(replayButton);
        this.add(quitButton);
        this.setSize(resolutionX-15, resolutionY-20); // Fix for weird size issue
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void reloadEvent()
    {
        panel.player.x = 0;
        panel.player.y = 0;
        panel.player.level = 1;
        panel.player.keys = new ArrayList<EntityKey>();

        panel.player.saveState();
        new Form();
        dispose();
    }

    public void replayEvent()
    {
        panel.player.x = 0;
        panel.player.y = 0;
        panel.player.keys = new ArrayList<EntityKey>();
        new Form();
        dispose();
    }

    public void saveEvent()
    {
        panel.player.saveState();
        panel.requestFocus();
    }
}