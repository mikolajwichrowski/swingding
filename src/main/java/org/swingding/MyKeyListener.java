package main.java.org.swingding;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// This keeps my Form.java code clean ...
abstract class MyKeyListener implements KeyListener {
    public void keyPressed(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
