package Module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Node class representing an element in the scene graph
class SceneNode {
    String name;
    int x, y; // Position in the grid
    char symbol; // Symbol used in the ASCII grid
    int layer; // Layer depth of the object
    List<SceneNode> children = new ArrayList<>(); // Child nodes

    public SceneNode(String name, int x, int y, char symbol, int layer) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.layer = layer;
    }

    // Method to render the node on the canvas (does not recursively render
    // children)
    public void render(char[][] layerCanvas) {
        if (x >= 0 && x < layerCanvas.length && y >= 0 && y < layerCanvas[0].length) {
            layerCanvas[x][y] = symbol; // Place the symbol on the canvas
        }
    }
}

public class SceneGraph {
    public static void main(String[] args) {
        // Define canvas size and initialize layers
        int canvasSize = 10;
        List<char[][]> layers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char[][] layer = new char[canvasSize][canvasSize];
            for (char[] row : layer)
                Arrays.fill(row, ' ');
            layers.add(layer);
        }

        // Create the scene graph nodes adjusted for a 10x10 canvas
        SceneNode ground = new SceneNode("Ground", 7, 5, 'G', 0);
        SceneNode lake = new SceneNode("Lake", 8, 3, 'L', 0);
        SceneNode path = new SceneNode("Path", 6, 7, 'P', 0);
        SceneNode hole = new SceneNode("Hole", 0, 1, 'E', 0);

        SceneNode house = new SceneNode("House", 4, 6, 'H', 1);
        SceneNode tree = new SceneNode("Tree", 2, 3, 'T', 1);
        SceneNode car = new SceneNode("Car", 9, 5, 'C', 1);
        SceneNode cover = new SceneNode("Cover", 0, 1, 'c', 1);

        SceneNode sun = new SceneNode("Sun", 1, 8, 'S', 2);
        SceneNode cloud = new SceneNode("Cloud", 0, 5, 'O', 2);
        SceneNode bird = new SceneNode("Bird", 3, 1, 'B', 2);

        // Render each node on its corresponding layer without recursive child rendering
        renderNodeToLayer(ground, layers); // Layer 0
        renderNodeToLayer(lake, layers); // Layer 0
        renderNodeToLayer(path, layers); // Layer 0
        renderNodeToLayer(hole, layers);

        renderNodeToLayer(house, layers); // Layer 1
        renderNodeToLayer(tree, layers); // Layer 1
        renderNodeToLayer(car, layers); // Layer 1
        renderNodeToLayer(cover, layers);

        renderNodeToLayer(sun, layers); // Layer 2
        renderNodeToLayer(cloud, layers); // Layer 2
        renderNodeToLayer(bird, layers); // Layer 2

        // Print each layer separately to verify placement
        System.out.println("Layer 0 (Base Elements):");
        printCanvas(layers.get(0));
        System.out.println("\nLayer 1 (Mid-Level Elements):");
        printCanvas(layers.get(1));
        System.out.println("\nLayer 2 (Top-Level Elements):");
        printCanvas(layers.get(2));

        // Composite the layers into a final view
        char[][] composite = compositeLayers(layers, canvasSize);
        System.out.println("\nComposite View:");
        printCanvas(composite);
    }

    // Method to render a node to the specified layer without recursively rendering
    // children
    private static void renderNodeToLayer(SceneNode node, List<char[][]> layers) {
        node.render(layers.get(node.layer)); // Render only the node itself on its layer
    }

    // Method to print the ASCII canvas with custom formatting and colors
    public static void printCanvas(char[][] canvas) {
        for (char[] row : canvas) {
            for (char cell : row) {
                // Print the cell with colors based on the symbol
                switch (cell) {
                    case 'G': // Ground
                        System.out.print("\u001B[32m[G]\u001B[0m"); // Green
                        break;
                    case 'L': // Lake
                        System.out.print("\u001B[34m[L]\u001B[0m"); // Blue
                        break;
                    case 'P': // Path
                        System.out.print("\u001B[37m[P]\u001B[0m"); // White
                        break;
                    case 'H': // House
                        System.out.print("\u001B[31m[H]\u001B[0m"); // Red
                        break;
                    case 'T': // Tree
                        System.out.print("\u001B[32m[T]\u001B[0m"); // Green
                        break;
                    case 'C': // Car
                        System.out.print("\u001B[35m[C]\u001B[0m"); // Magenta
                        break;
                    case 'S': // Sun
                        System.out.print("\u001B[33m[S]\u001B[0m"); // Yellow
                        break;
                    case 'O': // Cloud
                        System.out.print("\u001B[37m[O]\u001B[0m"); // White
                        break;
                    case 'B': // Bird
                        System.out.print("\u001B[36m[B]\u001B[0m"); // Cyan
                        break;
                    case 'E':
                        System.out.print("\u001B[31m[E]\u001B[0m"); // Red
                        break;
                    case 'c':
                        System.out.print("\u001B[31m[c]\u001B[0m"); // Red
                        break;

                    default: // Empty space
                        System.out.print("[ ]");
                        break;
                }
            }
            System.out.println();
        }
    }

    // Method to composite multiple layers into one final canvas
    public static char[][] compositeLayers(List<char[][]> layers, int size) {
        char[][] composite = new char[size][size];
        for (char[] row : composite)
            Arrays.fill(row, ' ');

        // Combine each layer onto the composite canvas
        for (char[][] layer : layers) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (layer[i][j] != ' ') {
                        composite[i][j] = layer[i][j];
                    }
                }
            }
        }
        return composite;
    }
}