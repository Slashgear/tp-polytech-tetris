package Core.GridGame;

import java.util.Arrays;

/**
 * Abstract Shape of a Grid Game
 * @author Adrien
 * @version 1.0
 */
public abstract class Shape {
    /**
     * Array of Shapes
     */
    private int _shape[][];
    /**
     * Getter of an indexed value in the shape choosen
     * @param i Horizontal Position
     * @param j Vertical Position
     * @return 
     */
    public int getShape(int i,int j) {
        return _shape[i][j];
    }
    /**
     * Constructor of a Shape
     * @param shape 
     */
    public Shape(int[][] shape) {
        _shape = shape;
    }
    /**
     * toString function for a Shape
     * @return String to display the grid like a tab
     */
    @Override
    public String toString() {
        StringBuilder buf=new StringBuilder();
        for (int[] _shape1 : _shape) {
            buf.append(Arrays.toString(_shape1));
        }
        return buf.toString();
    }

}
