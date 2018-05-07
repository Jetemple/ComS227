package examples;
import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
import api.Block;

/**
 * Partial implementation of the Shape interface for experimentation.
 */
public class SampleShape implements Shape
{
  private Position position;
  private Cell[] cells;
  
  public SampleShape(Position givenPosition, boolean magic)
  {
    position = givenPosition;
    cells = new Cell[3];
    cells[0] = new Cell(new Block(Color.RED, magic), givenPosition );
    
    // another cell just below the first one
    Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
    Position position2 = new Position(givenPosition.row() + 2, givenPosition.col());
    cells[1] = new Cell(new Block(Color.RED, false), position1);
    cells[2] = new Cell(new Block(Color.RED, false), position2);
  }
  
  @Override
  public Cell[] getCells()
  {
    Cell[] copy = new Cell[cells.length];
    for (int i = 0; i < cells.length; i++)
    {
      copy[i] = new Cell(cells[i]);
    }
    return copy;
  }

  @Override
  public void shiftDown()
  {
    position.setRow(position.row()+1);
    for (int i = 0; i < cells.length;i++)
    {
      cells[i].setRow(cells[i].getRow() + 1);
    }
  }

  @Override
  public void shiftLeft()
  {
    position.setCol(position.col() - 1);
    cells[0].setCol(cells[0].getCol() - 1);
    cells[1].setCol(cells[1].getCol() - 1);
    cells[2].setCol(cells[2].getCol() - 1);
  }

  @Override
  public void shiftRight()
  {
    position.setCol(position.col() + 1);
    cells[0].setCol(cells[0].getCol() + 1);
    cells[1].setCol(cells[1].getCol() + 1);
    cells[2].setCol(cells[2].getCol() + 1);
    
  }

  @Override
  public void transform()
  {
    for (int i = 1; i<cells.length; i++)
    {
      int tempCol = cells[i].getCol()-position.col();
      int tempRow = cells[i].getRow()-position.row();
      int row = (tempCol * -1);
      int col = tempRow;
      cells[i].setCol(col+position.col());
      cells[i].setRow(row+position.row());
    }

    
  }

  @Override
  public void cycle()
  {
    Cell [] oldCells = getCells();
    cells[0].setBlock(oldCells[cells.length-1].getBlock());
    for (int i = 1; i < oldCells.length; i++)
    {
      cells[i].setBlock(oldCells[i-1].getBlock());
    }
  }

  @Override
  public Shape clone()
  {
    try
    {
      // call the Object clone() method to create a shallow copy
      SampleShape s = (SampleShape) super.clone();

      // then make it into a deep copy
      s.position = new Position(position);
      s.cells = new Cell[3];
      s.cells[0] = new Cell(cells[0]);
      s.cells[1] = new Cell(cells[1]);
      s.cells[2] = new Cell(cells[2]);
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }    
  }
}
