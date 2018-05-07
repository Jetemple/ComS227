package hw4;
import api.Block;
import api.Cell;
import api.Position;

import java.awt.*;

/**
 * Extends AbstractShape for implementations Shape interface for an JShape
 */
public class JShape extends AbstractShape{
	/*
	 * Constructs an JShape with the given position and magic state.
	 */
    public JShape(Position givenPosition, boolean magic){
        position = givenPosition;
        cells = new Cell[4];

        Position position0 = new Position(givenPosition.row(),givenPosition.col() - 1);
        Position position1 = new Position(givenPosition.row() + 1,givenPosition.col() - 1);
        Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
        Position position3 = new Position(givenPosition.row() + 1, givenPosition.col() + 1);
        cells[0] = new Cell(new Block(Color.BLUE, magic), position0);
        cells[1] = new Cell(new Block(Color.BLUE, false), position1);
        cells[2] = new Cell(new Block(Color.BLUE, false),position2);
        cells[3] = new Cell(new Block(Color.BLUE, false),position3);

    }

}
