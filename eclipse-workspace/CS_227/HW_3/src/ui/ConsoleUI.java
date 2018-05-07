package ui;
import java.util.Scanner;

import api.Direction;
import hw3.Game;
import hw3.GameUtil;

/**
 * Ultra-simple UI for the 2048 game.
 * This version does not use the Result object returned
 * from the collapse method.
 */
public class ConsoleUI
{
  public static void main(String[] args)
  {
    runWithUndo();
  }
  
  
  
  public static void run()
  {
    Scanner in = new Scanner(System.in);
    Game g = new Game(4, new GameUtil());
    printGrid(g);
    
    while (true)
    {
      System.out.println("Enter a, d, w, or s: ");
      String s = in.nextLine();
      if (s.startsWith("a"))
      {
        g.shiftGrid(Direction.LEFT);
        g.newTile();
      }
      else if (s.startsWith("d"))
      {
        g.shiftGrid(Direction.RIGHT);
        g.newTile();
      }
      else if (s.startsWith("w"))
      {
        g.shiftGrid(Direction.UP);
        g.newTile();
      }
      else if (s.startsWith("s"))
      {
        g.shiftGrid(Direction.DOWN);
        g.newTile();
      }
      
      printGrid(g);
    }

  }

  public static void runWithUndo()
  {
    Scanner in = new Scanner(System.in);
    Game g = new Game(4, new GameUtil());
    printGrid(g);
    printNext(g);

    while (true)
    {
      System.out.println("Enter a, d, w, or s: ");
      String s = in.nextLine();
      if (s.startsWith("a"))
      {
        g.shiftGrid(Direction.LEFT);
      }
      else if (s.startsWith("d"))
      {
        g.shiftGrid(Direction.RIGHT);
      }
      else if (s.startsWith("w"))
      {
        g.shiftGrid(Direction.UP);
      }
      else if (s.startsWith("s"))
      {
        g.shiftGrid(Direction.DOWN);
      }     
      
      printGrid(g);
      printNext(g);
      
      System.out.println("ENTER again to confirm or 'x' to undo: ");
      s = in.nextLine();
      if (s.trim().length() == 0)
      {
        g.newTile();
      }
      else
      {
        g.undo();
      }
      printGrid(g);
      printNext(g);
    }
  }

  
  public static void printGrid(Game game)
  {
    System.out.println("---------------");
    for (int row = 0; row < game.getSize(); row += 1)
    {
      for (int col = 0; col < game.getSize(); col += 1)
      {
        System.out.printf("%4d", game.getCell(row, col));
      }
      System.out.println();
    }
    System.out.println("---------------");
  }
  
  private static void printNext(Game g)
  {
    int value = g.getNextTileValue();
    String next = "unknown";
    if (value == 1)
    {
      next = "blue";
    }
    else if (value == 2)
    {
      next = "red";
    }
    else if (value > 2)
    {
      next = "white";
    }
    System.out.println("Next: " + next);
  }

}
