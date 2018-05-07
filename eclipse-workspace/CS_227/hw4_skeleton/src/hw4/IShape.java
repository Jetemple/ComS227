package hw4;

import api.Block;
import api.Cell;
import api.Position;

import java.awt.*;

/**
 * Extends AbstractShape for implementations Shape interface for an IShape
 */
public class IShape extends AbstractShape{
	/*
	 * Constructs an IShape with the given position and magic state.
	 */
    public IShape(Position givenPosition, boolean magic) {
        position = givenPosition;
        cells = new Cell[3];

        cells[0] = new Cell(new Block(Color.CYAN, magic), givenPosition);

        Position position1 = new Position(givenPosition.row()+1,givenPosition.col());
        Position position2 = new Position(givenPosition.row()+2, givenPosition.col());

        cells[1] = new Cell(new Block(Color.CYAN, false),position1);
        cells[2] = new Cell(new Block(Color.CYAN, false),position2);

    }


}
