package examples;
import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * Brain-dead subclass of AbstractGame for experimentation...
 */
public class SampleGame extends AbstractGame
{
  public SampleGame()
  {
    super(6, 8, new SampleGenerator());
  }
  private int score = 0;

  @Override
  protected List<Position> determinePositionsToCollapse()
  {
    // empty list
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
   if (positions.size()==getWidth())
   {
     score += 1;
   }
    getScore();
    return positions;


  }

  @Override
  protected int determineScore()
  {
    return score;
  }
}
