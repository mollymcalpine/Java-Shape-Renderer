package Main.Model.options;

import Main.Model.BorderOption;
import Main.UI.Canvas;

/**
 * Implementation of the BorderOption interface which
 * makes the border of a box by linearly cycling through numbers 1 through 5.
 * Starts in the top left with a 1, & counts up to 5 in a clockwise direction.
 */
public class SequenceBorderOption implements BorderOption {
    @Override
    public void drawBorder(Canvas canvas, int top, int left, int width, int height) {
        int current = 1;

        if (height == 1) {
            for (int col = 0; col < width; col++) {
                canvas.setCellText(left + col, top, Character.forDigit(current, 10));
                current = (current % 5) + 1;
            }
            return;
        }

        for (int col = 0; col < width; col++) {
            canvas.setCellText(left + col, top, Character.forDigit(current, 10));
            current = (current % 5) + 1;
        }

        for (int row = 1; row < height; row++) {
            canvas.setCellText(left + width - 1, top + row, Character.forDigit(current, 10));
            current = (current % 5) + 1;
        }

        for (int col = width - 2; col >= 0; col--) {
            canvas.setCellText(left + col, top + height - 1, Character.forDigit(current, 10));
            current = (current % 5) + 1;
        }

        for (int row = height - 2; row > 0; row--) {
            canvas.setCellText(left, top + row, Character.forDigit(current, 10));
            current = (current % 5) + 1;
        }
    }
}
