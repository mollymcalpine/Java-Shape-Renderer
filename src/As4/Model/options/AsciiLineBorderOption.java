package As4.Model.options;

import As4.Model.BorderOption;
import As4.UI.Canvas;

/**
 * Implementation of the BorderOption interface which
 * makes the border of a box using ║, ═, ╚, ╝, ╔, and ╗
 * (or ■ for any box with width or height 1).
 * The box will look like it has a double-lined border.
 */
public class AsciiLineBorderOption implements BorderOption {
    private static final char VERTICAL = '║';
    private static final char HORIZONTAL = '═';
    private static final char TOP_LEFT = '╔';
    private static final char TOP_RIGHT = '╗';
    private static final char BOTTOM_LEFT = '╚';
    private static final char BOTTOM_RIGHT = '╝';
    private static final char SINGLE_ROW_OR_COLUMN = '■';

    @Override
    public void drawBorder(Canvas canvas, int top, int left, int width, int height) {
        if (width == 1 || height == 1) {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    canvas.setCellText(left + col, top + row, SINGLE_ROW_OR_COLUMN);
                }
            }
            return;
        }

        canvas.setCellText(left, top, TOP_LEFT);
        canvas.setCellText(left + width - 1, top, TOP_RIGHT);
        canvas.setCellText(left, top + height - 1, BOTTOM_LEFT);
        canvas.setCellText(left + width - 1, top + height - 1, BOTTOM_RIGHT);

        for (int col = 1; col < width - 1; col++) {
            canvas.setCellText(left + col, top, HORIZONTAL);
            canvas.setCellText(left + col, top + height - 1, HORIZONTAL);
        }

        for (int row = 1; row < height - 1; row++) {
            canvas.setCellText(left, top + row, VERTICAL);
            canvas.setCellText(left + width - 1, top + row, VERTICAL);
        }
    }
}