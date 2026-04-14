package Main;

import Main.UI.DrawableShape;
import java.io.File;
import java.util.Iterator;

/**
 * An interface required by the As4.UI to support the program's operations.
 */
public interface ShapeModel {
    // Populate the model with the shapes described in
    // the jsonFile (replacing any current shapes):
    void populateFromJSON(File jsonFile);

    // Redact the display by changing all current objects to be
    // redacted (grey with X's):
    void redact();

    // Get iterator to shapes:
    Iterator<? extends DrawableShape> iterator();
}
