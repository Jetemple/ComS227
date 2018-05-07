package hw3;

import api.Direction;
import ui.ConsoleUI;

import java.util.Arrays;
import java.util.Random;

public class GameUtilTest {
    public static void main(String args[]) {

        GameUtil util = new GameUtil();
        Random rand = new Random();
        // Merge Values and Shift Array
        int [] arr = {2,1,2,1};
        System.out.println(util.shiftArray(arr));
        util.initializeNewGrid(3, new Random(22));
        System.out.println(Arrays.toString(arr));
        //Get Score For Value
//        System.out.println(util.getScoreForValue(48));
//        System.out.println(util.getScoreForValue(1)); // expected 0
//        System.out.println(util.getScoreForValue(2)); // expected 0
//        System.out.println(util.getScoreForValue(3)); // expected 3 WORK ON THIS
//        System.out.println(util.getScoreForValue(6)); // expected 9
//        System.out.println(util.getScoreForValue(48));// expected 243
        //Initialize New Grid
        //Should work perfectly because it was implimented by teacher

        //Calculate Total Score
        //Should work fine because it was implimented by teacher

        //Copy Grid
        //Should work fine because it was implimented by teacher


        //Generate Random Tile Value
//        System.out.println(util.generateRandomTileValue(rand));
//        System.out.println(util.generateRandomTileValue(rand));
//        System.out.println(util.generateRandomTileValue(rand));

        //Generate Random Tile Position
//        System.out.println(util.generateRandomTilePosition(new int[4][4],rand ,Direction.LEFT ));
//        System.out.println(util.generateRandomTilePosition(new int[4][4],rand ,Direction.RIGHT ));
//        System.out.println(util.generateRandomTilePosition(new int[4][4],rand ,Direction.DOWN ));
//        System.out.println(util.generateRandomTilePosition(new int[4][4],rand ,Direction.UP));











//        int grid[][] = util.initializeNewGrid(2, new Random(2) );
//        Game game = new Game(4, new GameUtil(), new Random(26));
//        ConsoleUI.printGrid(game);
//        util.shiftArray(arr);
//        game.updateRowOrColumn(arr, 3, Direction.LEFT);
//        game.updateRowOrColumn(arr, 0, Direction.DOWN);
//        game.updateRowOrColumn(arr, 1, Direction.DOWN);
//        ConsoleUI.printGrid(game);
//        System.out.println(game.getScore());
//        arr=game.copyRowOrColumn(3, Direction.UP);
//        ConsoleUI.printGrid(game);
//        System.out.println(Arrays.toString(arr));



//        ConsoleUI.printGrid(game);
//        game.shiftGrid(Direction.UP);
//        ConsoleUI.printGrid(game);



    }
}