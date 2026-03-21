Shape Rendering Engine

Overview:
A Java Swing application that renders configurable 2D shapes onto a grid-based canvas.
Shapes are defined via JSON, displayed in a GUI, and can be redacted or exported to a text file.
The project emphasizes clean object-oriented design through layered abstractions and the strategy pattern.

Architecture:
The project is split into three packages:
- Main: top-level entry point and the ShapeModel interface.
- Main.Model: Business logic (shape construction, JSON parsing, and rendering options).
- Main.UI: Swing-based GUI, canvas abstraction, and the DrawableShape interface.

This separation keeps the model completely decoupled from the UI.
The GUI only interacts with the model through the ShapeModel interface, and shapes are rendered through the DrawableShape interface.
Neither side knows about the other's concrete implementation.

Design Patterns and OOP Practices:
1. Strategy pattern is the core design principle:
Each shape has three independently swappable rendering strategies:
- BackgroundOption: controls per-cell color (solid, checkerboard, triangle).
- BorderOption: controls how the border is drawn (character, ASCII line art, numeric sequence).
- FillOption: controls interior fill (solid character, word-wrapped text).
New combinations can be added without touching existing classes, keeping the design open for extension and closed for modification.

2. Interface-Driven Design:
- ShapeModel, DrawableShape, BackgroundOption, BorderOption, and FillOption are all interfaces.
- Concrete implementations are hidden behind these contracts, making the system easy to extend.

3. Abstract Class with Template Structure:
- AbstractDrawableShape holds shared state (position, dimensions, options) and enforced the draw(Canvas) contract on subclasses.
- This avoid duplication and leaves rendering flexible.

4. Factory Methods:
- ShapeModelImplementation uses private factory methods to encapsulate object construction logic and keep JSON parsing clean.

Skills Demonstrated:
- Object-oriented design (encapsulation, abstraction, inheritance, and polymorphism).
- Interface segregation and dependency inversion.
- Strategy pattern applied across multiple independent axes of variation.
- Runtime object construction from external data (JSON).
