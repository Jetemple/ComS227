package hw3;
import java.util.ArrayList;
import java.util.Random;
import api.Direction;
import api.Move;
import ui.ConsoleUI;
import java.util.Arrays;

import static api.Direction.LEFT;

public class GameTest {

    public static void main(String args[])
        {
            Random rand = new Random();

            Game g = new Game(4, new GameUtil(), new Random(42));
            int[][] test =
                    {
                            {0, 2, 3, 1},
                            {0, 1, 3, 2},
                            {0, 2, 3, 0},
                            {0, 1, 2, 0}
                    };
            for (int row = 0; row < test.length; row += 1)
            {
                for (int col = 0; col < test[0].length; col += 1)
                {
                    g.setCell(row, col, test[row][col]);
                }
            }
            ArrayList<Move> moves = g.shiftGrid(Direction.RIGHT);
            System.out.println(moves);

//            Move m = new Move(0,0,0);
//            m.setDirection(1,LEFT );
//            moves.add(m.getDirection());
//            moves.add(m.getRowOrColumn());
//            System.out.println(moves);

            //Get Cell
//            System.out.println(g.getCell(0, 0));

            //Set Cell
//            g.setCell(0, 0, 2);
//            System.out.println(g.getCell(0, 0));
//            ConsoleUI.printGrid(g);//Initial Grid

            //Get Size
//            System.out.println(g.getSize());

            //Get Score
//            g.setCell(1,1 ,48 );
//            ConsoleUI.printGrid(g);
//            System.out.println(g.getScore()); //Should return 243

            //Copy Row or Column
//            g.setCell(0, 0,0 );
//            g.setCell(0, 1,1 );
//            g.setCell(0, 2,2 );
//            g.setCell(0, 3,3 );
//
//            g.setCell(1, 0,1 );
//            g.setCell(2, 0,2 );
//            g.setCell(3, 0,3 );
//
//            ConsoleUI.printGrid(g);//Print Initial Grid
            //Copy Left
//            int arr[]=g.copyRowOrColumn(0, Direction.LEFT);
//            System.out.println(Arrays.toString(arr));
            //Copy Right
//            arr=g.copyRowOrColumn(0, Direction.RIGHT);
//            System.out.println(Arrays.toString(arr));
            //Copy Up
//            arr=g.copyRowOrColumn(0, Direction.UP);
//            System.out.println(Arrays.toString(arr));
            //Copy Down
//            arr=g.copyRowOrColumn(0, Direction.DOWN);
//            System.out.println(Arrays.toString(arr));

            //Update Row/Column
//            int arr[] = {1,2,3,4};
//            g.updateRowOrColumn(arr,0 ,Direction.LEFT );
//            g.updateRowOrColumn(arr,1 ,Direction.RIGHT );
//            ConsoleUI.printGrid(g);
//
//            g.updateRowOrColumn(arr,0 ,Direction.UP );
//            g.updateRowOrColumn(arr,1 ,Direction.DOWN);
//            ConsoleUI.printGrid(g);

            //Shift Grid
//            System.out.println(g.shiftGrid(Direction.LEFT));//Works
//            g.shiftGrid(Direction.RIGHT);//Works
//            g.newTile();
//            g.shiftGrid(Direction.DOWN);//DOESN'T WORK
//            g.shiftGrid(Direction.UP);//DOESN'T WORK
//            g.newTile();
//            ConsoleUI.printGrid(g);





//        util.shiftArray(arr);
//        game.updateRowOrColumn(arr, 3, Direction.LEFT);
//        game.updateRowOrColumn(arr, 0, Direction.DOWN);
//        game.updateRowOrColumn(arr, 1, Direction.DOWN);
//        ConsoleUI.printGrid(game);
//        System.out.println(game.getScore());
//        arr=game.copyRowOrColumn(3, Direction.UP);
//        ConsoleUI.printGrid(game);
//        System.out.println(Arrays.toString(arr));
        }
    }