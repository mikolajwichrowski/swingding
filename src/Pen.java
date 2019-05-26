import java.util.ArrayList;

/**
 * Pen
 */
public class Pen {
    public int x = 0, y = 0, rotation = 0;
    private ArrayList<ColorDrop> traces = new ArrayList<ColorDrop>();
    private int[] currentColor = new int[] { 255, 0, 0 };
    public Shape currentShape = new ShapeSquare();

    public void setTrace() {
        boolean removed = false;
        for (ColorDrop p : traces) {
            if(p.x == x && p.y == y) {
                if (p.rgb[0] == currentColor[0] && p.rgb[1] == currentColor[1] && p.rgb[2] == currentColor[2]) {
                    traces.remove(traces.indexOf(p));
                } else {
                    traces.remove(traces.indexOf(p));
                    traces.add(new ColorDrop(x, y, currentColor, currentShape, rotation));
                }
                removed = true;
            }
        }

        if(!removed) {
            traces.add(new ColorDrop(x, y, currentColor, currentShape, rotation));
        }
    }

    public void switchColor() {
        int[] red = new int[] { 255, 0, 0 };
        int[] green = new int[] { 0, 255, 0 };
        int[] blue = new int[] { 0, 0, 255 };

        if(currentColor[0] == 255) {
            currentColor = green;
        } else if(currentColor[1] == 255) {
            currentColor = blue;
        } else if(currentColor[2] == 255) {
            currentColor = red;
        }
    }

    public void switchShape() {
        if(currentShape.shapeIndex == 1) {
            currentShape = new ShapeTriangle();
        } else if(currentShape.shapeIndex == 2) {
            currentShape = new ShapeSquare();
        }
    }

    public ArrayList<ColorDrop> getTraces() {
        return traces;
    }

    public int[] getCurrentColor() {
        return currentColor;
    }
}