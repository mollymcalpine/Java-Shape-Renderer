package Main;

import Main.UI.GUI;
import Main.Model.ShapeModelImplementation;

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