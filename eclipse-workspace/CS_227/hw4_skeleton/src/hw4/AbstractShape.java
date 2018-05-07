
package hw4;

import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
{
  protected Position position;//position Instance variable
  protected Cell[] cells;//cells initialization


  /*
   * (non-Javadoc)
   * @see api.Shape#getCells()
   * Returns a new array of Cell objects representing the blocks in the 
   * shape along with their absolute positions.
   */
  public Cell[] getCells()
  {
    Cell[] copy = new Cell[cells.length];
    for (int i = 0; i < cells.length; i++)
      copy[i] = new Cell(cells[i]);
    return copy;
  }
  
  /*
   * (non-Javadoc)
   * @see api.Shape#shiftDown
   * Shifts the position of this shape down (increasing the column) by one.
   */
  public void shiftDown() {
    position.setRow(position.row()+1);
    for (int i = 0; i < cells.length;i++)
    {
      cells[i].setRow(cells[i].getRow() + 1);
    }
  }
  
  /*
   * (non-Javadoc)
   * @see api.Shape#shiftLeft()
   * Shifts the position of this shape left (decreasing the column) by one.
   */
  public void shiftLeft() {
    position.setCol(position.col() - 1);
    for (int i = 0; i < cells.length;i++)
    {
      cells[i].setCol(cells[i].getCol() - 1);
    }
  }
  
  /*
   * (non-Javadoc)
   * @see api.Shape#shiftRight()
   * Shifts the position of this shape right (increasing the column) by one.
   */
  public void shiftRight() {
    position.setCol(position.col() + 1);
    for (int i = 0; i < cells.length;i++)
    {
      cells[i].setCol(cells[i].getCol() + 1);
    }
  }
  
  /*
   * (non-Javadoc)
   * @see api.Shape#transform()
   * Transforms every shape but OShape and SZShape
   */
  public void transform()
  {
    for (int i = 0; i<cells.length; i++)
    {
      int tempCol = cells[i].getCol()-position.col();
      int tempRow = cells[i].getRow()-position.row();
      int row = (tempCol * -1);
      int col = tempRow;
      cells[i].setCol(col+position.col());
      cells[i].setRow(row+position.row());

    }
  }

  /*
   * (non-Javadoc)
   * @see api.Shape#cycle()
   * Cycles the blocks within the cells of this shape
   */
  public void cycle()
  {
    Cell [] oldCells = getCells();
    cells[0].setBlock(oldCells[cells.length-1].getBlock());
    for (int i = 1; i < oldCells.length; i++)
    {
      cells[i].setBlock(oldCells[i-1].getBlock());
    }
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#clone()
   * Returns a deep copy of this object having the correct runtime type.
   */
  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape) super.clone();

      s.position = new Position(position);
      s.cells = new Cell[cells.length];
      for (int i = 0; i < cells.length; i++)
      {
        s.cells[i] = new Cell(cells[i]);
      }

      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
