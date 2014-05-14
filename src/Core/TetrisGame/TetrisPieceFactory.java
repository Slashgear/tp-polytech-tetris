package Core.TetrisGame;

import Core.GridGame.Piece;
import Core.GridGame.PieceFactory;
import Core.GridGame.Shape;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Antoine
 */
public class TetrisPieceFactory implements PieceFactory {

    public TetrisPieceFactory() {
    }

    /**
     * Create the Piece of a classic Tetris Game with all the rotion in
     * anti-hour sort.
     *
     * @return The list of each Tetris Piece with all the possible rotation
     */
    @Override
    public ArrayList<Piece> createAvailablePieces() {
        ArrayList<Piece> possible_pieces = new ArrayList<Piece>();

        System.out.println("Construction des Pieces Disponibles..");

        System.out.println("Ajout du Z");
        TetrisShape[] shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.red));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout du Carré");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.yellow));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout de la Ligne");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.cyan));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout du S");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.green));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout du T");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 1, 1, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.magenta));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout du J");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 0, 1, 1}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 1, 0, 0}, {0, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.blue));
        System.out.println(Arrays.toString(shapes));

        System.out.println("Ajout du L");
        shapes = new TetrisShape[Piece.NB_SHAPE];
        shapes[0] = new TetrisShape(new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}});
        shapes[1] = new TetrisShape(new int[][]{{0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        shapes[2] = new TetrisShape(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}});
        shapes[3] = new TetrisShape(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}});
        possible_pieces.add(new TetrisPiece(shapes,Color.orange));
        System.out.println(Arrays.toString(shapes));

        return possible_pieces;
    }

    @Override
    public ArrayList<Color> createAvailableColors() {
        ArrayList<Color> list_Colors = new ArrayList<Color>();
        list_Colors.add(Color.red);
        list_Colors.add(Color.blue);
        //rajouter en fonction des textures dispo
        return list_Colors;
    }

}
