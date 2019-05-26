import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Canvas
 */
public class Canvas extends JPanel {
    private static final long serialVersionUID = 8999265021216122578L;
    public static Pen pen = new Pen();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new java.awt.Color(255, 255, 255));
        
        drawPoints(g, pen.getTraces());
    }

    private void drawPen(Graphics g, Pen p) { 
        int calculatedX = 15+(50*p.y);
        int calculatedY = 15+(50*p.x);

        Graphics2D body = (Graphics2D)g;
        body.setColor(new Color(p.getCurrentColor()[0], p.getCurrentColor()[1], p.getCurrentColor()[2]));
        body.fill(pen.currentShape.getPath(calculatedX, calculatedY, p.rotation));
        body.setColor(new Color(0, 0, 0));
        body.drawRect(calculatedX, calculatedY, 50, 50);
    }

    private void drawPoints(Graphics g, ArrayList<ColorDrop> ColorDropList) { 
        for (ColorDrop e : ColorDropList) {
            int calculatedX = 15+(50*e.y);
            int calculatedY = 15+(50*e.x);

            Graphics2D body = (Graphics2D)g;
            body.setColor(new Color(e.rgb[0], e.rgb[1], e.rgb[2]));
            body.fill(e.shape.getPath(calculatedX, calculatedY, e.rotation));
        }

        drawPen(g, pen);
    }
}
  