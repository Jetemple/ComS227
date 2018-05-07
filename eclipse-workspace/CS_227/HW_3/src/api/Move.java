package api;


/**
 * A Move object describes the motion of one tile (or two tiles in the case
 * of a merge move) in the Threes game.  A move is represented
 * by the old and new indices of the tile or tiles within a one-dimensional array.
 * In addition, it is possible to also specify a Direction and a row or column
 * index, so that the move could be interpreted as taking place in a two-dimensional
 * grid.  For example, given a Move with startIndex 0, newIndex 1,
 * rowOrColumn 2 and direction UP, in a 5 x 5 grid it would
 * correspond to a move from (4, 2) to (3, 2).
 */
public class Move
{
  /**
   * Starting index of the tile being moved, or, in the case of a merge, 
   * starting index of the right tile of the pair being merged.
   */  
  private final int startIndex;
  
  /**
   * In case of a merge, represents the starting index of the left
   * tile of the pair being merged.
   */  
  private final int startIndex2;
  
  /**
   * Ending index of the tile or tiles.
   */
  private final int endIndex;
  
  /**
   * Indicates whether this is a merge move or not.
   */
  private final boolean merged;
  
  /**
   * Current value in the tile to be moved, or, in the case of a merge, 
   * current value of the right tile of the pair being merged.
   */
  private final int value;
  
  /**
   * In case of a merge, represents the current value of the left
   * tile of the pair being merged.
   */ 
  private final int value2;
  
  /**
   * Value on the tile after the move.
   */
  private final int newValue;
  
  /**
   * Row or column in the grid (represents a row if direction
   * is LEFT or RIGHT, represents a column if direction is UP or DOWN).
   */
  private int rowOrColumn;
  
  /**
   * Direction of the move in the grid.
   */
  private Direction dir;

  /**
   * Constructs a single-tile move from oldPos to newPos.  Caller should
   * ensure that newPos is strictly less than oldPos. 
   * @param oldIndex
   *   old index of the tile within an array
   * @param newIndex
   *   new index of the tile within an array
   * @param value
   *   current value of the tile
   */
  public Move(int oldIndex, int newIndex, int value)
  {
    this.startIndex = oldIndex;
    this.startIndex2 = -1;  // ignored
    this.endIndex = newIndex;
    this.newValue = value;
    this.value = value;
    this.value2 = -1; // ignored
    merged = false;
    dir = null;
    rowOrColumn = -1;
  }
  
  /**
   * Constructs a merge move from startIndex to endIndex, assuming
   * that the left tile of the pair being merged is at startIndex - 1.
   * @param startIndex
   *   old index of the right tile of the pair being merged
   * @param endIndex
   *   new index of the right tile of the pair being merged
   * @param currentValue
   *   current value of the right tile of the pair
   * @param currentValue2
   *   current value of the left tile
   * @param newValue
   *   new value on the tile after merging
   */
  public Move(int startIndex, int endIndex, int currentValue, int currentValue2, int newValue)
  {
    this.startIndex = startIndex;
    this.startIndex2 = startIndex - 1;
    this.endIndex = endIndex;
    this.value = currentValue;
    this.value2 = currentValue2;
    this.newValue = newValue;
    merged = true;
    dir = null;
    rowOrColumn = -1;
  }

  /**
   * Constructs a merge move from tiles at startIndex and startIndex2 to 
   * endIndex, where the left tile of the pair being merged is at startIndex2.
   * @param startIndex
   *   old index of the right tile of the pair being merged
   * @param startIndex2
   *   old index of the left tile of the pair being merged
   * @param endIndex
   *   new index of the right tile of the pair being merged
   * @param currentValue
   *   current value of the right tile of the pair
   * @param currentValue2
   *   current value of the left tile
   * @param newValue
   *   new value on the tile after merging
   */
  public Move(int startIndex, int startIndex2, int endIndex, int currentValue, int currentValue2, int newValue)
  {
    this.startIndex = startIndex;
    this.startIndex2 = startIndex2;
    this.endIndex = endIndex;
    this.value = currentValue;
    this.value2 = currentValue2;
    this.newValue = newValue;
    merged = true;
    dir = null;
    rowOrColumn = -1;
  }
  /**
   * Sets a direction and row/column index for interpreting this move within a grid.
   * @param givenRowOrColumn
   *   row or column index
   * @param givenDirection
   *   direction to set
   */
  public void setDirection(int givenRowOrColumn, Direction givenDirection)
  {
    dir = givenDirection;
    rowOrColumn = givenRowOrColumn;
  }

  /**
   * Returns the old index of the first (or only) tile represented by this move.
   * @return
   *   index of first tile
   */
  public int getOldIndex()
  {
    return startIndex;
  }

  /**
   * Returns the new index of the tile or tiles represented by this move.
   * @return
   *   new index for move
   */
  public int getNewIndex()
  {
    return endIndex;
  }

  /**
   * Determines whether this is a merge move or a single tile move.
   * @return
   *   true if this is a merge move, false otherwise
   */
  public boolean isMerged()
  {
    return merged;
  }

  /**
   * Returns a direction for interpreting this move in a 2D grid.
   * @return
   *   direction for this move, or null if none has been set
   */
  public Direction getDirection()
  {
    return dir;
  }

  /**
   * Returns a row or column index for interpreting this move in a 2D grid.
   * @return
   *   row or column index, or -1 if none has been set
   */
  public int getRowOrColumn()
  {
    return rowOrColumn;
  }

  /**
   * Returns the current (old) value of the tile or tiles represented by this move.
   * @return
   *   value of tiles in this move
   */
  public int getValue()
  {
    return value;
  }

  public int getNewValue()
  {
    return newValue;
  }
  
  /**
   * Determines whether this Move object is equal to the given object.
   * @return
   *   true if the given object is a Move and all attributes are the same as those
   *   in this Move
   */
  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Move))
    {
      return false;
    }
    Move other = (Move) obj;

    return (startIndex == other.startIndex &&
        endIndex == other.endIndex &&
        value == other.value &&
        rowOrColumn == other.rowOrColumn &&
        dir == other.dir &&
        merged == other.merged);      
  }
  
  /**
   * Returns a string description of this move.
   * @return
   *   a string description of this move
   */
  public String toString()
  {
    String rowAndDirection = "";
    if (rowOrColumn >= 0 && dir != null)
    {
      if (dir == Direction.UP || dir == Direction.DOWN)
      {
        rowAndDirection = " (column " + rowOrColumn + " " + dir + ")";
      }
      else if (dir == Direction.LEFT || dir == Direction.RIGHT)
      {
        rowAndDirection = " (row " + rowOrColumn + " " + dir + ")";
      }

    }
    
    if (merged)
    {
      return "Merge " + startIndex + " to " + endIndex + rowAndDirection;
    }
    else
    {
      return "Move " + startIndex + " to " + endIndex  + rowAndDirection;
    }
  }
}