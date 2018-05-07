package hw4;
import api.Block;
import api.Cell;
import api.Position;

import java.awt.*;

/**
 * Extends AbstractShape for implementations Shape interface for an TShape
 */
public class TShape extends AbstractShape {
	/*
	 * Constructs an TShape with the given position and magic state.
	 */
    public TShape(Position givenPosition, boolean magic) {
        position = givenPosition;
        cells = new Cell[4];

        

        Position position0 = new Position(givenPosition.row() - 1, givenPosition.col());
        Position position1 = new Position(givenPosition.row() ,givenPosition.col() - 1);
        Position position3 = new Position(givenPosition.row(), givenPosition.col() + 1);

        cells[0] = new Cell(new Block(Color.MAGENTA, magic),position0);
        cells[1] = new Cell(new Block(Color.MAGENTA, false),position1);
        cells[2] = new Cell(new Block(Color.MAGENTA, false), givenPosition);
        cells[3] = new Cell(new Block(Color.MAGENTA, false),position3);
    }

}
