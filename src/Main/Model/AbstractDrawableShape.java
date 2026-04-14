package Main.Model;

import Main.Model.options.CharacterBorderOption;
import Main.Model.options.SolidBackgroundOption;
import Main.Model.options.SolidFillOption;
import Main.UI.Canvas;
import Main.UI.DrawableShape;
import java.awt.*;

/**
 * Implements the DrawableShape interface.
 * Subclasses must implement the draw() method to specify how a
 * shape is rendered.
 */
public abstract class AbstractDrawableShape implements DrawableShape {
    protected final int top;
    protected final int left;
    protected final int width;
    protected final int height;
    protected BackgroundOption backgroundOption;
    protected BorderOption borderOption;
    protected FillOption fillOption;
    protected boolean isRedacted = false;

    public AbstractDrawableShape(int top, int left, int width, int height, BackgroundOption backgroundOption, BorderOption borderOption, FillOption fillOption) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.backgroundOption = backgroundOption;
        this.borderOption = borderOption;
        this.fillOption = fillOption;
    }

    public void setRedacted(boolean redacted) {
        if (redacted) {
            this.borderOption = new CharacterBorderOption('+');
            this.fillOption = new SolidFillOption('X');
            this.backgroundOption = (BackgroundOption) new SolidBackgroundOption(Color.LIGHT_GRAY);
        }
        this.isRedacted = redacted;
    }

    public abstract void draw(Canvas canvas);
}
