
package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
{
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }
  private int score = 0;
  private boolean gravity;
  private int magicCount = 0;
  @Override
  public List<Position> determinePositionsToCollapse()
  {
    if (gravity){
      //get array list for every empty cell
      List<Position> positions = new ArrayList<>();
      List<Position> emptyCells = new ArrayList<>();
      for (int i = 0; i < getHeight();i++)
      {
        for (int j =0; j < getWidth();j++)
        {
          if (getBlock(i,j)==null)
          {
            emptyCells.add(new Position(i,j));
          }
        }
      }
      for (int i = 0; i < emptyCells.size();i++)
      {
    	  	for (int j = 0; j >= 0; j--)
    	  	{
    	  		if (getBlock(j, emptyCells.get(i).col())!=null)
    	  		{
    	  			positions.add(emptyCells.get(i));
    	  			break;
    	  		}
    	  	}
      }
      gravity = false;
      return positions;



    }
    else{
      //Reuglar Sample game collapse
      //Gravity mode to true
      List<Position> positions = new ArrayList<>();
      boolean completeRow = true;

      for (int j = getHeight()-1;j>-1;j--)
      {
        for (int i = 0; i<getWidth();i++)
        {
          if (getBlock(j,i )==null)
          {
            completeRow=false;
          }
        }
        if (completeRow==true) {
          for (int i = 0; i < getWidth(); i++) {
            positions.add(new Position(j, i));
          }
        }
        completeRow = true;
      }
      for (int i = 0; i < positions.size(); i++)
      {
        if (getBlock(positions.get(i).row(),positions.get(i).col()).isMagic())
        {
          magicCount = magicCount + 1;
        }
      }
      if (positions.size()==getWidth())
      {
        score = score + (int)Math.pow(2.0, magicCount);
      }
      if (magicCount>=3)
      {
        gravity = true;
        magicCount = 0;
      }
      return positions;
    }



  }

  @Override
  public int determineScore()
  {
    return score;
  }

}
