package As4.Model;

import As4.UI.Canvas;
import java.awt.*;

/**
 * Provides a concrete implementation of the AbstractDrawableShape abstract class.
 * It defines the logic for rendering a drawable shape onto a Canvas by using
 * the given background, fill, and border options.
 * It draws the background option, then the fill option, then the border option.
 */
public class DrawableShapeImplementation extends AbstractDrawableShape {
    public DrawableShapeImplementation(int top, int left, int width, int height, BackgroundOption backgroundOption, BorderOption borderOption, FillOption fillOption) {
        super(top, left, width, height, backgroundOption, borderOption, fillOption);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int row = top; row < top + height; row++) {
            for (int col = left; col < left + width; col++) {
                Color backgroundColor = backgroundOption.getColorAt(row - top, col - left, width, height);
                canvas.setCellColor(col, row, backgroundColor);
            }
        }

        if (width > 2 && height > 2) {
            for (int row = top; row < top + height; row++) {
                for (int col = left; col < left + width; col++) {
                    String fillChar = fillOption.getCharacterAt(row - top - 1, col - left - 1, width - 1, height - 1);
                    canvas.setCellText(col, row, fillChar.charAt(0));
                }
            }
        }

        borderOption.drawBorder(canvas, top, left, width, height);
    }
}
