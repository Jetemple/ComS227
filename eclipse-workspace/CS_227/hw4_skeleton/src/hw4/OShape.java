package hw4;

import api.Block;
import api.Cell;
import api.Position;


import java.awt.*;

/*
 * Constructs an OShape with the given position and magic state.
 */
public class OShape extends AbstractShape {

    public OShape(Position givenPosition, boolean magic) {
        position = givenPosition;
        cells = new Cell[4];
        cells[0] = new Cell(new Block(Color.YELLOW, magic), givenPosition);

        // another cell just below the first one
        Position position1 = new Position(givenPosition.row(),givenPosition.col() + 1);
        Position position2 = new Position(givenPosition.row()+1,givenPosition.col());
        Position position3 = new Position(givenPosition.row()+1,givenPosition.col()+1);
        cells[1] = new Cell(new Block(Color.YELLOW, false), position1);
        cells[2] = new Cell(new Block(Color.YELLOW, false),position2);
        cells[3] = new Cell(new Block(Color.YELLOW, false),position3);

    }

    @Override
    public void transform() {
        //Does Nothing since shape is square.
    }


}
