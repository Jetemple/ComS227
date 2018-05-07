package hw4;
import api.Block;
import api.Cell;
import api.Position;

import java.awt.*;

/**
 * Extends AbstractShape for implementations Shape interface for an SZShape
 */
public class SZShape extends AbstractShape {
	/*
	 * Constructs an SZShape with the given position and magic state.
	 */
    public SZShape(Position givenPosition, boolean magic) {
        position = givenPosition;
        cells = new Cell[4];
        cells[0] = new Cell(new Block(Color.GREEN, magic), givenPosition);

        Position position1 = new Position(givenPosition.row() + 1,givenPosition.col());
        Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() +1);
        Position position3 = new Position(givenPosition.row() + 2, givenPosition.col()+1);
        cells[1] = new Cell(new Block(Color.GREEN, false),position1);
        cells[2] = new Cell(new Block(Color.GREEN, false),position2);
        cells[3] = new Cell(new Block(Color.GREEN, false),position3);
    }
    
    /*
     * (non-Javadoc)
     * @see hw4.AbstractShape#transform()
     * Overrides AbstractShape and uses its own transform method for this specific shape.
     */
    @Override
    public void transform()
    {
        if (cells[0].getCol()>cells[3].getCol())
        {

            cells[0].setCol(cells[0].getCol()-1);
            cells[1].setCol(cells[1].getCol()-1);
            cells[2].setCol(cells[2].getCol()+1);
            cells[3].setCol(cells[3].getCol()+1);
            for (int i = 0; i < cells.length; i++)
            {
                Block green = new Block(Color.GREEN,cells[i].getBlock().isMagic());
                cells[i].setBlock(green);
            }
        }
        else if (cells[0].getCol()<cells[3].getCol())
        {
            cells[0].setCol(cells[0].getCol()+1);
            cells[1].setCol(cells[1].getCol()+1);
            cells[2].setCol(cells[2].getCol()-1);
            cells[3].setCol(cells[3].getCol()-1);
            for (int i = 0; i < cells.length; i++)
            {
                Block red = new Block(Color.RED,cells[i].getBlock().isMagic());
                cells[i].setBlock(red);
            }
        }
        
    }

}
