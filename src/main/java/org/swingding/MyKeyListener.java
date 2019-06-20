package main.java.org.swingding;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

// This keeps my Form.java code clean ...
class MyKeyListener implements KeyListener {
    private Consumer<KeyEvent> eventConsumer;

    public MyKeyListener(Consumer<KeyEvent> eventConsumer){
        this.eventConsumer = eventConsumer;
    }

    public void keyPressed(KeyEvent e) {
        eventConsumer.accept(e);
    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
