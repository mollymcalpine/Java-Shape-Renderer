package Main.Model.options;

import Main.Model.BorderOption;
import Main.UI.Canvas;

/**
 * Implementation of the BorderOption interface which
 * makes the border of a box be of a given character.
 */
public class CharacterBorderOption implements BorderOption {
    private final char borderCharacter;

    public CharacterBorderOption(char borderCharacter) {
        this.borderCharacter = borderCharacter;
    }

    @Override
    public void drawBorder(Canvas canvas, int top, int left, int width, int height) {
        for (int col = 0; col < width; col++) {
            canvas.setCellText(left + col, top, borderCharacter);
            canvas.setCellText(left + col, top + height - 1, borderCharacter);
        }

        for (int row = 0; row < height; row++) {
            canvas.setCellText(left, top + row, borderCharacter);
            canvas.setCellText(left + width - 1, top + row, borderCharacter);
        }
    }
}