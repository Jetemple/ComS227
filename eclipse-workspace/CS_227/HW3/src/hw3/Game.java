//@author Jack Temple
package hw3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import api.Direction;
import api.Move;
import api.TilePosition;

import static api.Direction.*;

/**
 * The Game class contains the state and logic for an implementation of a
 * video game such as "Threes".  The basic underlying state is an n by n 
 * grid of tiles, represented by integer values.  A zero in a cell is considered 
 * to be * "empty".  To play the game, a client calls the method <code>shiftGrid()</code>, 
 * selecting one of the four directions (LEFT, RIGHT, UP, DOWN). Each row or 
 * column is then shifted according to the rules encapsulated in the
 * associated <code>GameUtil</code> object. The move is completed by
 * calling <code>newTile</code>, which makes a new tile appear in the grid
 * in preparation for the next move.
 * <p>
 * In between the call to <code>shiftGrid()</code> and the call to
 * <code>newTile</code>, the client may also call <code>undo()</code>, which
 * reverts the grid to its state before the shift.
 * <p>
 * The game uses an instance of java.util.Random to generate new tile values
 * and to select the location for a new tile to appear.  The new values
 * are generated by the associated <code>GameUtil</code>'s 
 * <code>generateRandomTileValue</code> method, and the new positions are
 * generated by the <code>GameUtil</code>'s
 * <code>generateRandomTilePosition</code> method. The values are always 
 * generated one move ahead and stored, in order to support the ability
 * for a UI to provide a preview of the next tile value.
 * <p>
 * The score is the sum over all cells of the individual scores returned by
 * the <code>GameUtil</code>'s <code>getScoreForValue()</code> method.
 */
public class Game
{
  int[][] GridUtil;



  /**
   * Constructs a game with a grid of the given size, using a default
   * random number generator. The initial grid is produced by the 
   * <code>initializeNewGrid</code> method of the given 
   * <code>GameUtil</code> object.  
   * @param givenSize
   *   size of the grid for this game
   * @param givenConfig
   *   given instance of GameUtil   
   */
  public Game(int givenSize, GameUtil givenConfig)
  {
    // just call the other constructor
    this(givenSize, givenConfig, new Random());
  }

  /**
   * Constructs a game with a grid of the given size, using the given
   * instance of <code>Random</code> for the random number generator.
   * The initial grid is produced by the <code>initializeNewGrid</code>
   * method of the given <code>GameUtil</code> object.  
   * @param givenSize
   *   size of the grid for this game
   * @param givenConfig
   *   given instance of GameUtil
   * @param givenRandom
   *   given instance of Random   
   */
  public Game(int givenSize, GameUtil givenConfig, Random givenRandom)
  {
    this.GridUtil = givenConfig.initializeNewGrid(givenSize,givenRandom);
  }


  //Instance Variables!!!!!
  private GameUtil util = new GameUtil();//Calls upon GameUtil to use throughout code
  private Random rand = new Random(2020);//Creates a random variable with the seed 2020
  private int nextTileValue;//Sets the next tile value
  private Direction lastMove = null;//initializes the Direction API for last direction moved
  private TilePosition tile = new TilePosition(0,0,0);//initializes tile for new tile
  private int score = 0;//initializes the score
  private int[][] lastGrid;//initializes the last grid



  /**
   * Returns the value in the cell at the given row and column.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   value in the cell at the given row and column
   */
  public int getCell(int row, int col)
  {
    return GridUtil[row][col];
  }
//
//  public int[][] copy(int[][] input) {
//    int[][] target = new int[input.length][];
//    for (int i=0; i <input.length; i++) {
//      target[i] = Arrays.copyOf(input[i], input[i].length);
//    }
//    return target;
//  }
  /**
   * Sets the value of the cell at the given row and column.
   * <em>NOTE: This method should not be used by clients outside
   * of a testing environment.</em>
   * @param row
   *   given row
   * @param col
   *   given col
   * @param value
   *   value to be set
   */
  public void setCell(int row, int col, int value)
  {
    GridUtil[row][col]=value;
  }

  /**
   * Returns the size of this game's grid.
   * @return
   *   size of the grid
   */
  public int getSize()
  {
    return GridUtil.length;
  }

  /**
   * Returns the current score.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    score = util.calculateTotalScore(GridUtil);
    return score;
  }

  /**
   * Copy a row or column from the grid into a new one-dimensional array.
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from left to right
   *   <li>RIGHT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from right to left)
   *   <li>UP - the column indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from top to bottom
   *   <li>DOWN - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from bottom to top)
   * </ul>
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   * @return
   *   array containing the row or column
   */
  public int[] copyRowOrColumn(int rowOrColumn, Direction dir)
  {
    int[] arr;
    arr = new int[GridUtil.length];
    if (dir == DOWN)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        arr[GridUtil.length-i-1]=GridUtil[i][rowOrColumn];
      }
    }
    else if (dir == UP)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        arr[i]=GridUtil[i][rowOrColumn];
      }
    }
    else if (dir == LEFT)
    {

      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        arr[i]=GridUtil[rowOrColumn][i];
      }
    }
    else if (dir == RIGHT)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        arr[GridUtil.length-i-1]=GridUtil[rowOrColumn][i];
      }
    }
    return arr;
  }

  /**
   * Updates the grid by copying the given one-dimensional array into
   * a row or column of the grid.
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the given array is copied into the the row indicated by the
   *   index <code>rowOrColumn</code> from left to right
   *   <li>RIGHT - the given array is copied into the the row indicated by the
   *   index <code>rowOrColumn</code> in reverse (from right to left)
   *   <li>UP - the given array is copied into the column indicated by the
   *   index <code>rowOrColumn</code> from top to bottom
   *   <li>DOWN - the given array is copied into the column indicated by the
   *   index <code>rowOrColumn</code> in reverse (from bottom to top)
   * </ul>
   * @param arr
   *   the array from which to copy
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   */
  public void updateRowOrColumn(int[] arr, int rowOrColumn, Direction dir)
  {
    if (dir == DOWN)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        GridUtil[i][rowOrColumn]=arr[GridUtil.length-i-1];
      }
    }
    else if (dir == UP)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        GridUtil[i][rowOrColumn]=arr[i];
      }
    }
    else if (dir == LEFT)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        GridUtil[rowOrColumn][i]=arr[i];
      }
    }
    else if (dir == RIGHT)
    {
      for (  int i = 0; i < GridUtil.length; i+=1)
      {
        GridUtil[rowOrColumn][i]=arr[GridUtil.length-i-1];
      }
    }
  }

  /**
   * Plays one step of the game by shifting the grid in the given direction.
   * Returns a list of Move objects describing all moves performed.  All Move
   * objects must include a valid value for <code>getRowOrColumn()</code> and
   * <code>getDirection()</code>.  If no cells are moved, the method returns
   * an empty list.
   * <p>
   * The shift of an individual row or column is performed by the
   * method <code>shiftArray</code> of <code>GameUtil</code>.
   * <p>
   * The score is not updated.
   *
   * @param dir
   *   direction in which to shift the grid
   * @return
   *   list of moved or merged tiles
   */
  public ArrayList<Move> shiftGrid(Direction dir) {
    nextTileValue = util.generateRandomTileValue(rand);
    int len = GridUtil.length;
    lastGrid = util.copyGrid(GridUtil);
    ArrayList<Move> moves = new ArrayList<>();
    int dummyArr[] = new int[len];
    int shiftArr[] = new int[len];

    if (dir == (LEFT)) {
      for (int i = 0; i < GridUtil.length; i++) {
        dummyArr = copyRowOrColumn(i, dir);
        shiftArr = dummyArr;

        ArrayList<Move> move = util.shiftArray(shiftArr);
        for (int j = 0; j < move.size(); j++) {
          move.get(j).setDirection(i, dir);
        }
        moves.addAll(move);
        updateRowOrColumn(shiftArr, i, dir);
      }
      lastMove = LEFT;
    }

    else if (dir == RIGHT) {
      for (int i = 0; i < GridUtil.length; i++) {
        dummyArr = copyRowOrColumn(i, dir);
        shiftArr = dummyArr;

        ArrayList<Move> currentMoves = util.shiftArray(shiftArr);
        for (int j = 0; j < currentMoves.size(); j++) {
          currentMoves.get(j).setDirection(i, dir);
        }
        moves.addAll(currentMoves);
        updateRowOrColumn(shiftArr, i, dir);
      }
      lastMove = RIGHT;
    }

    else if (dir == DOWN) {
      for (int i = 0; i < GridUtil.length; i++) {
        dummyArr = copyRowOrColumn(i, dir);
        shiftArr = dummyArr;

        ArrayList<Move> currentMoves = util.shiftArray(shiftArr);
        for (int j = 0; j < currentMoves.size(); j++) {
          currentMoves.get(j).setDirection(i, dir);
        }
        moves.addAll(currentMoves);
        updateRowOrColumn(shiftArr, i, dir);
      }
      lastMove = DOWN;
    }

    else if (dir == UP) {

      for (int i = 0; i < GridUtil.length; i++) {
        dummyArr = copyRowOrColumn(i, dir);
        shiftArr = dummyArr;

        ArrayList<Move> currentMoves = util.shiftArray(shiftArr);
        for (int j = 0; j < currentMoves.size(); j++) {
          currentMoves.get(j).setDirection(i, dir);
        }
        moves.addAll(currentMoves);
        updateRowOrColumn(shiftArr, i, dir);
      }
    }
    return moves;
  }

  /**
   * Reverts the shift performed in a previous call to <code>shiftGrid()</code>,
   * provided that neither <code>newTile()</code> nor <code>undo()</code>
   * has been called. If there was no previous call to <code>shiftGrid()</code>
   * without a <code>newTile()</code> or <code>undo()</code>,
   * this method does nothing and returns false; otherwise returns true.
   * @return
   *   true if the previous shift was undone, false otherwise
   */
  public boolean undo()
  {
    GridUtil=util.copyGrid(lastGrid);
    return true;
  }

  /**
   * Generates a new tile and places its value in the grid, provided that
   * there was a previous call to  <code>shiftGrid</code> without a
   * corresponding call to <code>undo</code> or <code>newTile</code>.
   * The tile's position is determined according
   * to the <code>generateRandomTilePosition</code> of this game's
   * associated <code>GameUtil</code> object.  If there was no previous call to
   * <code>shiftGrid</code> without an <code>undo</code> or <code>newTile</code>,
   * this method does nothing and returns null; otherwise returns a
   * <code>TilePosition</code> object with the new tiles's position and value.
   * Note that the returned tile's value should match the <em>current</em>
   * value returned by <code>getNextTileValue</code>, and if this method returns
   * a non-null value the upcoming tile value should be updated according
   * to <code>generateRandomTileValue()</code>.  This method should
   * update the total score and the score should include the newly generated tile.
   * @return
   *   TilePosition containing the new tile's position and value, or null
   *   if no new tile is created
   */
  public TilePosition newTile()
  {
    if (!Arrays.deepEquals(lastGrid,GridUtil ))
    {
      score = util.calculateTotalScore(GridUtil);
      tile = util.generateRandomTilePosition(GridUtil,rand , lastMove);
      setCell(tile.getRow(),tile.getCol() ,tile.getValue() );
      lastGrid =util.copyGrid(GridUtil);
      score=util.calculateTotalScore(GridUtil);
      return tile;
    }
    else
    {
      return null;
    }

  }

  /**
   * Returns the value that will appear on the next tile generated in a call to
   * <code>newTile</code>.  This is an accessor method that does not modify
   * the game state.
   * @return
   *   value to appear on the next generated tile
   */
  public int getNextTileValue()
  {
    return nextTileValue;
  }

}
  









