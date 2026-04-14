package As4.Model.options;

import As4.Model.FillOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FillOption interface which
 * fills a box (not including the border) with a given String,
 * starting in the top left corner.
 * Each line of text is centered within the box, and only enough
 * text that can fit inside the rectangle will be displayed.
 */
public class WrapperFillOption implements FillOption {
    private final List<String> lines;
    private final int width;
    private final int height;

    public WrapperFillOption(String fillText, int width, int height) {
        this.width = width;
        this.height = height;
        this.lines = wrapText(fillText.trim(), this.width, this.height);
    }

    @Override
    public String getCharacterAt(int row, int col, int width, int height) {
        if (row < 0 || row >= this.height || col < 0 || col >= this.width || row >= lines.size()) {
            return " ";
        }

        String line = lines.get(row);
        return col < line.length() ? String.valueOf(line.charAt(col)) : " ";
    }

    private List<String> wrapText(String text, int width, int height) {
        List<String> wrappedLines = new ArrayList<>();
        if (text.isEmpty() || width <= 0 || height <= 0) {
            return wrappedLines;
        }

        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            while (word.length() > width) {
                if (wrappedLines.size() >= height) break;
                String partOfWord = word.substring(0, width);
                wrappedLines.add(centerText(partOfWord, width));
                word = word.substring(width);
            }

            if (wrappedLines.size() >= height) {
                break;
            }

            if (currentLine.length() + (!currentLine.isEmpty() ? 1 : 0) + word.length() <= width) {
                if (!currentLine.isEmpty()) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                if (!currentLine.isEmpty()) {
                    wrappedLines.add(centerText(currentLine.toString(), width));
                    if (wrappedLines.size() >= height) {
                        break;
                    }
                    currentLine = new StringBuilder(word);
                } else {
                    wrappedLines.add(centerText(word, width));
                    if (wrappedLines.size() >= height) {
                        break;
                    }
                    currentLine = new StringBuilder();
                }
            }
        }

        if (!currentLine.isEmpty() && wrappedLines.size() < height) {
            wrappedLines.add(centerText(currentLine.toString(), width));
        }

        return wrappedLines;
    }

    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }

        int totalSpaces = width - text.length();
        int leftPadding = (totalSpaces + 1) / 2;
        return " ".repeat(leftPadding) + text + " ".repeat(totalSpaces - leftPadding);
    }
}
