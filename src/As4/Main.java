package As4;

import As4.UI.GUI;
import As4.Model.ShapeModelImplementation;

/**
 * Displays a "picture" of the objects described to the As4.UI.
 */
public class Main {
    public static void main(String[] args) {
        ShapeModel model = new ShapeModelImplementation();
        GUI gui = new GUI(model);
        gui.start();
    }
}