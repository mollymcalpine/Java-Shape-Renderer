package Main.Model.options;

import Main.Model.FillOption;

/**
 * Implementation of the FillOption interface which
 * fills each cell inside a box (not including the border), with
 * the first character of a given String.
 */
public class SolidFillOption implements FillOption {
    private final char fillCharacter;

    public SolidFillOption(char fillCharacter) {
        this.fillCharacter = fillCharacter;
    }

    @Override
    public String getCharacterAt(int row, int col, int width, int height) {
        return String.valueOf(fillCharacter);
    }
}
