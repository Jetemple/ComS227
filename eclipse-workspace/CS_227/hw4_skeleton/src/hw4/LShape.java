package hw4;
import api.Block;
import api.Cell;
import api.Position;

import java.awt.*;


/**
 * Extends AbstractShape for implementations Shape interface for an LShape
 */
public class LShape extends AbstractShape{
	/*
	 * Constructs an LShape with the given position and magic state.
	 */
    public LShape(Position givenPosition, boolean magic){
        position = givenPosition;
        cells = new Cell[4];
        cells[0] = new Cell(new Block(Color.ORANGE, magic), givenPosition);

        Position position1 = new Position(givenPosition.row() + 1,givenPosition.col() - 2);
        Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() -1);
        Position position3 = new Position(givenPosition.row() + 1, givenPosition.col());
        
        cells[1] = new Cell(new Block(Color.ORANGE, false), position1);
        cells[2] = new Cell(new Block(Color.ORANGE, false),position2);
        cells[3] = new Cell(new Block(Color.ORANGE, false),position3);

    }

}
