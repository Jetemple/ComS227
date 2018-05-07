package hw4;

import api.Generator;
import api.Position;
import api.Shape;


import java.util.Random;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 */
public class BasicGenerator implements Generator
{
	/*
	 * (non-Javadoc)
	 * @see api.Generator#getNext(int)
	 * Returns a new Shape instance according to this generator's strategy.
	 * @Param width
	 * @return Shape
	 */
  @Override
  public Shape getNext(int width)
  {
      Random rand = new Random();//Initialize Random variable

      boolean magic = false; //Initialize's magic block as false
      int shape = rand.nextInt(6);//Initialize's random shape number
      int magicNum = rand.nextInt(5);//Initialize's random magic number
      int mid = width/2;//Finds the middle of the board by dividing width of board by 2.
      
      if (magicNum==0)
      {
          magic=true;
      }
      if (shape == 0)
      {
          return new LShape(new Position(-1,mid+1),magic);

      }
      else if (shape == 1)
      {
          return new JShape(new Position(-1, mid),magic);

      }
      else if (shape == 2)
      {
          return new IShape(new Position(-2, mid), magic);

      }
      else if (shape == 3)
      {
          return new OShape(new Position(-1, mid), magic);

      }
      else if (shape == 4)
      {
          return new TShape(new Position(0, mid),magic);

      }
      else
      {
          return new SZShape(new Position(-1, mid),magic);
      }


  }
}

