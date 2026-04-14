package As4.UI;

/**
 * Defines a graphical shape interface.
 */
public interface DrawableShape {
    // This object will draw itself onto the canvas:
    void draw(Canvas canvas);

    void setRedacted(boolean redacted);
}