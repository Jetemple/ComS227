package ui;

/**
 * Represents a position and value on a grid that can be
 * animated from an old position to a new position.
 */
public class Tile
{
  // label
  private int currentValue;
  private int value;
  private int initialValue;
  
  // initial pixel location
  private int initialX;
  private int initialY;
  
  // final pixel location
  private int x;
  private int y;

  // is it moving
  private boolean movingX;
  private boolean movingY;
  
  // in case it is moving
  private double currentX;
  private double currentY;
   
  // how much to move each frame
  private double incrementX;
  private double incrementY;
  
  public Tile(int x, int y, int value)
  {
    movingX = false;
    movingY = false;
    this.x = x * GameMain.TILE_SIZE;
    this.y = y * GameMain.TILE_SIZE;
    this.value = value;
    
    // save the initial values incase of undo
    this.initialValue = this.value;
    this.initialX = this.x;
    this.initialY = this.y;
    
    
    // these values may differ if animating
    this.currentX = this.x;
    this.currentY = this.y;
    this.currentValue = value;
  }
  
  public void reverse(int frames)
  {
    value = initialValue;
    currentValue = initialValue;
    x = initialX;
    y = initialY;
    incrementX = (x - currentX) / frames;
    incrementY = (y - currentY) / frames;
    movingX = true;
    movingY = true;
  }
  
  public void setNew(int newX, int newY, int newValue, int frames)
  {
    // target values after animation
    x = newX * GameMain.TILE_SIZE;
    y = newY * GameMain.TILE_SIZE;
    value = newValue;
    
    incrementX = (x - currentX) / frames;
    incrementY = (y - currentY) / frames;
    movingX = true;
    movingY = true;
  }
  
  public int getCurrentX()
  {
    return (int) Math.round(currentX);
  }

  public int getCurrentY()
  {
    return (int) Math.round(currentY);
  }
  
  public void step()
  {
    if (movingX)
    {
      currentX = currentX + incrementX;
      if (Math.abs(currentX - x) < incrementX)
      {
        currentX = x;
        movingX = false;
      }
    }
    if (movingY)
    {
      currentY = currentY + incrementY;
      if (Math.abs(currentY - y) < incrementY)
      {
        currentY = y;
        movingY = false;
      }
    }
    
    if (!movingX && !movingY)
    {
      currentValue = value;
    }
  }
  
  // stop animation
  public void finish()
  {
    movingX = false;
    movingY = false;
    currentX = x;
    currentY = y;
    currentValue = value;
  }
  
  public boolean moving()
  {
    return movingX || movingY;
  }

  public int getCurrentValue()
  {
    return currentValue;
  }
}
