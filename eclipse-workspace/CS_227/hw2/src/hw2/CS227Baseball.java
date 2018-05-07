package hw2;

/**
 * Simplified model of American baseball.
 * 
 * THIS CODE WILL NOT COMPILE UNTIL YOU HAVE ADDED STUBS FOR 
 * ALL METHODS SPECIFIED IN THE JAVADOC
 * 
 * @author YOUR NAME HERE
 */
public class CS227Baseball
{
	//Current Inning
	private int inning;
	//Total number of outs in an inning
	private int inningOuts;
	//States if the inning is Top of Bottom
	private boolean topOrBottom;
	//Current number of outs in inning
	private int outs;
	//Current number of strikes for batter
	private int strikes;
	//Current number of balls for batter
	private int balls;
	//Away Teams Score
	private int score0;
	//Home teams score
	private int score1;
	//True if first is occupied
	private boolean first;
	//True if second is occupied
	private boolean second;
	//True if third is occupied
	private boolean third;
	//True if home is occupied
	private boolean home;
	//Total number of innings in game
	private int totalInnings;
  /**
   * Constant indicating that a pitch results in a ball.
   */
  public static final int BALL = 0;
  
  /**
   * Constant indicating that a pitch results in a strike.
   */
  public static final int STRIKE = 1;
  
  /**
   * Constant indicating that a pitch results in an out from a fly ball.
   */
  public static final int POP_FLY = 2;
  
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 3;
  
  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 4;
  
  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;
  /**
   * Constructs a game that has the given number of innings and starts at the top of inning 1.
   * @param givenNumberInnings
   */
  public CS227Baseball(int givenNumberInnings)
  {
	  totalInnings=givenNumberInnings;
	  topOrBottom ^= true;
	  inning=1;
  }
  /**
   * Called upon to determine if the game is over or not
   * @return true if current inning exceeds totalInnings
   */
  public boolean isOver()
  {
	  if (inning>totalInnings)
	  {
		  return true;
	  }
	  else 
		  {
		  return false;
		  }
  }
  /**
   * Player occupied at first
   * @return true if first is occupied
   */
  public boolean playerOnFirst()
  {
	  return first!=false;
	 
  }
  /**
   * Second status
   * @return true if second is occupied
   */
  public boolean playerOnSecond()
  {
	  return second!=false;
  }
  /**
   * Third Status
   * @return true if third is occupied
   */
  public boolean playerOnThird()
  {
	  return third!=false;
  }
  /**
   * Returns the current inning
   * @return inning
   */
  public int getInning()
  {
	return inning;
  }
  /**
   * States if the inning is in the top or bottom
   * @return topOrBottom method
   */
  public boolean isTop()
  {
	  return topOrBottom;
  }
  /**
   * States number of outs in current inning
   * @return outs 
   */
  public int getOuts()
  {
	  return outs;
  }
  /**
   * Returns number of strikes for current batter
   * @return strikes
   */
  public int getStrikes()
  {
	  return strikes;
  }
  /**
   * Returns number of balls for current batter
   * @return balls
   */
  public int getBalls()
  {
	  return balls;
  }
  /**
   * Returns the score of the indicated team, where an argument of 
   * true indicates team 0 (batting in the top of the inning) and an 
   * argument of false indicates team 1 (batting in the bottom of the inning). 
   * If game is a CS227Baseball object, the call game.getScore(game.isTop()) 
   * always returns the score for the team that is currently at bat.
   * @param team0 - true to get team 0's score, false for team 1's score
   * @return score for the indicated team
   */
  public int getScore(boolean team0)
  {
	  if (team0==true)
	  {
		  return score0;
	  }
	  else
	  {
		  return score1;
	  }
  }
  /**
   * Pitch not resulting in a hit. The argument for outcome should be one of the 
   * three predefined constants BALL, STRIKE, or POP_FLY. A detailed description 
   * of these values is described in the section entitled "Balls, strikes, and outs" 
   * in the assignment pdf. This method may update the count of balls, strikes, and/or outs, 
   * and may cause existing players on base to advance in the case of a walk, and causes
   *  the teams to switch if the number of outs reaches MAX_OUTS. This method does nothing 
   *  if the game is over or if the argument is not one of the values BALL, STRIKE, or POP_FLY.
   * @param outcome - one of the three constants STRIKE, BALL, or POP_FLY
   */
  public void pitch(int outcome)
  {
	  if (isOver()==false)
	  {
		  if (outcome==BALL)
		  {
			  balls++;
		  }			  
		  if (outcome==STRIKE)
		  {
			  strikes++;
		  }
		  if (outcome==POP_FLY)
		  {
			  outs++;
			  inningOuts++;
			  strikes=0;
			  balls=0;
		  }
		  if (balls==MAX_BALLS)
		  {
			  advanceRunners(true);
			  strikes=0;
			  balls=0;
		  }
		  if (strikes>=MAX_STRIKES)
		  {
			  outs++;
			  inningOuts++;
			  strikes=0;
			  balls=0;
		  }
		  if (outs>=MAX_OUTS)
		  {
			  outs=0;
			  topOrBottom ^= true;
			  first=false;
			  second=false;
			  third=false;
		  }
		  else 
			  return;
		  if (inningOuts>=6)
		  {
			  inningOuts=0;
			  inning++;
		  }
	  }	 
  }
  /**
   * Pitch resulting in a hit where no player is out. The argument for 
   * numBases should be 1, 2, 3, or 4, indicating a single, double, triple, 
   * or home run. The batter and all players currently on base must advance 
   * the given number of bases (possibly resulting in one or more runs). 
   * This method does nothing if the game is over or if the argument is not 
   * one of the values 1, 2, 3, or 4.
   * @param numBases - number of bases that the batter and all players on base will advance
   */
  public void pitchWithHit(int numBases)
  {
	  if (isOver()==false)
	  {
		  if (numBases==1)
		  {
			  advanceRunners(true);
		  }
		  if (numBases==2)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
		  }
		  if (numBases==3)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
			  advanceRunners(false);
		  }
		  if (numBases==4)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
			  advanceRunners(false);
			  advanceRunners(false);
		  }
		  balls=0;
		  strikes=0;
	  }
	  else
		  return;
	  if (outs>=MAX_OUTS)
	  {
		  if (inningOuts>=6)
		  {
			  inningOuts=0;
			  inning++;
			  outs=0;
			  topOrBottom ^= true;
			  
		  }
		  outs=0;
		  first=false;
		  second=false;
		  third=false;
	  }
	
  }
  /**
   * Pitch resulting in a hit and a possible out. Advancement of runners is the same as pitchWithHit() 
   * except that it might cause a player to be out. The argument for whichBaseFielded indicates the 
   * base to which the ball is fielded (1, 2, 3, or 4). If the batter or one of the players on base 
   * arrives at the base whichBaseFielded after advancing exactly numBases, then that player is out. 
   * That is, we assume that the time it takes to field the ball to the indicated base is the same 
   * as the time it takes the runners to advance numBase bases. If a player is put out when advancing 
   * to home, that run is not counted. (Note that at most one out is possible, i.e. there are no double or
   * triple plays. Also, there are no special exceptions for counting runs when it's the third out.) 
   * This method does nothing if the game is over or if either argument is not one of the values 1, 2, 3, or 4.
   * @param numBases - number of bases that the batter and all players on base will advance
   * @param whichBaseFeilded - the base to which the defense fields the ball (1, 2, 3, or 4)
   */
  public void pitchWithHitAndOut(int numBases, int whichBaseFeilded)
  {
	  if (isOver()==false)
	  {
		  if (numBases==1)
		  {
			  advanceRunners(true);
			  if (third==true);
			  {
				  home=true;
			  }
		  }
		  if (numBases==2)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
			  if(second==true||third==true);
			  {
				  home=true;
			  }
		  }
		  if (numBases==3)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
			  advanceRunners(false);
			  if (first==true||second==true||third==true);
			  {
				  home=true;
			  }
		  }
		  if (numBases==4)
		  {
			  advanceRunners(true);
			  advanceRunners(false);
			  advanceRunners(false);
			  advanceRunners(false);
			  home=true;
		  }
		  if (whichBaseFeilded==1 && first==true)
		  {
			  first=false;
			  outs++;
			  inningOuts++;
		  }
		  if (whichBaseFeilded==2 && second==true)
		  {
			  second=false;
			  outs++;
			  inningOuts++;
		  }
		  if (whichBaseFeilded==3 && third==true)
		  {
			  third=false;
			  outs++;
			  inningOuts++;
		  }
		  if (whichBaseFeilded==4 && home==true)
		  {
			  outs++;
			  inningOuts++;
			  if(topOrBottom==true)
			  {
				  score0--;
			  }
			  if(topOrBottom==false)
			  {
				  score1--;
			  }
		  }
	  }
	  if (outs>=MAX_OUTS)
	  {
		  if (inningOuts>=6)
		  {
			  inningOuts=0;
			  inning++;
			  outs=0;
			  topOrBottom ^= true;
			  
		  }
		  outs=0;
		  first=false;
		  second=false;
		  third=false;
	  }
	  
	  if (isOver()==true)
	  {
		  return;
	  }
  }
  /**
   * Advances all players on base by one base, updating the 
   * score if there is currently a player on third.
   *  If the argument newPlayerOnFirst is true, 
   *  a player (i.e. the batter) is placed on first base.
   * @param newPlayerOnFirst - if true, there will be a runner on first after this method executes
   */
  public void advanceRunners(boolean newPlayerOnFirst)
  {
	  if (third==true)
	  {
		  if(topOrBottom==true)
		  {
			  score0++;
		  }
		  if(topOrBottom==false)
		  {
			  score1++;
		  }
		  third=false;
		  home=true;
	  }
	  if (second==true)
	  {
		  third=true;
		  second=false;
	  }
	  if (first==true)
	  {
		  second=true;
		  first=false;
	  }
	  if (newPlayerOnFirst==true)
	  {
		  first=true;
	  }
  } 
  
  /**
   * Returns a three-character string representing the players on base, 
   * in the order first, second, and third, where 'X' indicates a player 
   * is present and 'o' indicates no player.  For example, the string "XXo" 
   * means that there are players on first and second but not on third.
   * @return
   *   three-character string showing players on base
   */
  public String getBases()
  {
    return (playerOnFirst() ? "X" : "o") +
        (playerOnSecond() ? "X" : "o") +
        (playerOnThird() ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state.
   * The format is:
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * The first three characters represent the players on base as returned by 
   * the <code>getBases()</code> method. The 'T' after the inning number indicates 
   * it's the top of the inning, and a 'B' would indicate the bottom.
   * 
   * @return
   *   one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTop() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(), getStrikes(), getOuts());
  }

  /**
   * Returns a multi-line string representation of the current game state.
   * The format is:  
   * <pre>
   *     o - o    Inning:1 (T)
   *     |   |    Score:0-0
   *     o - H    Balls:0 Strikes:0 Outs:0
   * </pre>
   * The 'T' after the inning number indicates it's the top of the inning, 
   * and a 'B' would indicate the bottom.
   * @return
   *   multi-line string representation of current game state
   */
  public String toDisplayString()
  {
    String firstChar = (playerOnFirst() ? "X" : "o");
    String secondChar = (playerOnSecond() ? "X" : "o");
    String thirdChar = (playerOnThird() ? "X" : "o");
    String topOrBottom = (isTop() ? "T" : "B");
    String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(), topOrBottom);
    String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
    String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(), getOuts());
    return firstLine + secondLine + thirdLine;   
  }
  
}