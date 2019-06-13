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
    private static final long serialVersionUID = 8557974571427438540L; // Auto generated serial
    public Canvas panel;

    private JButton saveButton;
    private JButton restartButton;
    private JButton replayButton;
    private JButton quitButton;

    /**
     * 
     */
    public Form() {
        // Panel
        panel = new Canvas();

        // Buttons
        saveButton = new JButton("SAVE");
        restartButton = new JButton("RESTART");
        replayButton = new JButton("REPLAY");
        quitButton = new JButton("QUIT");
        
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().add(panel);
        add(saveButton);
        add(restartButton);
        add(replayButton);
        add(quitButton);
        setSize(resolutionX-15, resolutionY-20); // Fix for weird size issue
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void reloadEvent()
    {
        panel.player.x = 0;
        panel.player.y = 0;
        panel.player.level = 1;
        panel.player.keys = new ArrayList<EntityKey>();

        saveEvent();

        new Form();
        dispose();
    }

    public void replayEvent()
    {
        panel.player.x = 0;
        panel.player.y = 0;
        panel.player.keys = new ArrayList<EntityKey>();

        saveEvent();

        new Form();
        dispose();
    }

    public void saveEvent()
    {
        FileUtil.fileWriter("state.json", panel.player.toString());
        panel.requestFocus();
    }
}