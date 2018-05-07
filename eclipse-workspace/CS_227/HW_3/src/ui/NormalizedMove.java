package ui;

/**
 * A NormalizedMove is a description of a tile move in the game
 * described in terms of actual row and column positions.
 */
public class NormalizedMove
{
  Position oldPos;
  Position newPos;
  boolean merged;
  Position oldPos2; // null when 'merged' is false
  int value;
  int newValue;
  
  public NormalizedMove(Position oldPos, Position newPos, int value)
  {
    this.oldPos = oldPos;
    this.newPos = newPos;
    this.value = value;
    merged = false;
  }
  
  public NormalizedMove(Position oldPos, Position oldPos2, Position newPos, int value, int newValue)
  {
    this.oldPos = oldPos;
    this.newPos = newPos;
    this.oldPos2 = oldPos2;
    this.value = value;
    this.newValue = newValue;
    merged = true;
  }

  public Position getOldPosition()
  {
    return oldPos;
  }
  
  public Position getOldPosition2()
  {
    return oldPos2;
  }
  
  public Position getNewPosition()
  {
    return newPos;
  }
  
  public int getValue()
  {
    return value;
  }
  
  public int getNewValue()
  {
    return newValue;
  }
  
  public String toString()
  {
    if (merged)
    {
      return "---> Merging " + value + " in "+ oldPos +
          " with " + newPos + ", resulting new value " + newValue;
    }
    else
    {
      return "---> Moving " + value + " in "+ oldPos + " to " + newPos;
    }

  }
}