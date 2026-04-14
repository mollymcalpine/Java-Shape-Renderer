package As4.Model;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import As4.Model.options.*;
import As4.ShapeModel;
import As4.UI.DrawableShape;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Provides a concrete implementation of the As4.ShapeModel interface.
 * Along with the required methods, it also provides methods for
 * converting color names (as Strings) into Color objects, and for
 * creating the background/border/fill options.
 */
public class ShapeModelImplementation implements ShapeModel {
    private List<DrawableShape> shapes = new ArrayList<>();

    @Override
    public void populateFromJSON(File jsonFile) {
        try (FileReader reader = new FileReader(jsonFile)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray shapesArray = root.getAsJsonArray("shapes");
            shapes.clear();

            for (JsonElement element : shapesArray) {
                JsonObject shapeObject = element.getAsJsonObject();
                shapes.add(createShape(shapeObject));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file: " + e.getMessage(), e);
        }
    }

    @Override
    public void redact() {
        for (DrawableShape shape : shapes) {
            shape.setRedacted(true);
        }
    }

    @Override
    public Iterator<? extends DrawableShape> iterator() {
        return shapes.iterator();
    }

    private DrawableShape createShape(JsonObject shapeObject) {
        int top = shapeObject.get("top").getAsInt();
        int left = shapeObject.get("left").getAsInt();
        int width = shapeObject.get("width").getAsInt();
        int height = shapeObject.get("height").getAsInt();
        String background = shapeObject.get("background").getAsString();
        String backgroundColor = shapeObject.get("backgroundColor").getAsString();
        String line = shapeObject.get("line").getAsString();
        String fill = shapeObject.get("fill").getAsString();
        String fillText = shapeObject.get("fillText").getAsString();
        String lineChar = line.equals("char") ? shapeObject.get("lineChar").getAsString() : null;

        BackgroundOption backgroundOption = createBackgroundOption(background, backgroundColor);
        BorderOption borderOption = createBorderOption(line, lineChar);
        FillOption fillOption = createFillOption(fill, fillText, width - 2, height - 2);

        return new DrawableShapeImplementation(
                top,
                left,
                width,
                height,
                backgroundOption,
                borderOption,
                fillOption
        );
    }

    private Color stringToColor(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "white" -> Color.WHITE;
            case "light gray" -> Color.LIGHT_GRAY;
            case "gray" -> Color.GRAY;
            case "dark gray" -> Color.DARK_GRAY;
            case "black" -> Color.BLACK;
            case "red" -> Color.RED;
            case "pink" -> Color.PINK;
            case "orange" -> Color.ORANGE;
            case "yellow" -> Color.YELLOW;
            case "green" -> Color.GREEN;
            case "magenta" -> Color.MAGENTA;
            case "cyan" -> Color.CYAN;
            case "blue" -> Color.BLUE;
            default -> throw new IllegalArgumentException("Unknown colour: " + colorName);
        };
    }

    private BackgroundOption createBackgroundOption(String type, String color) {
        Color backgroundColor = stringToColor(color);
        return switch (type) {
            case "solid" -> new SolidBackgroundOption(backgroundColor);
            case "checker" -> new CheckerBackgroundOption(backgroundColor);
            case "triangle" -> new TriangleBackgroundOption(backgroundColor);
            default -> throw new IllegalArgumentException("Unknown background type: " + type);
        };
    }

    private BorderOption createBorderOption(String type, String lineChar) {
        return switch (type) {
            case "char" -> new CharacterBorderOption(lineChar.charAt(0));
            case "ascii line" -> new AsciiLineBorderOption();
            case "sequence" -> new SequenceBorderOption();
            default -> throw new IllegalArgumentException("Unknown border type: " + type);
        };
    }

    private FillOption createFillOption(String type, String fillText, int width, int height) {
        return switch (type) {
            case "solid" -> new SolidFillOption(fillText.charAt(0));
            case "wrapper" -> new WrapperFillOption(fillText, width, height);
            default -> throw new IllegalArgumentException("Unknown fill type: " + type);
        };
    }
}
