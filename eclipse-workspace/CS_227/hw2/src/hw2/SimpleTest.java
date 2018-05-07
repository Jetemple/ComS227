package hw2;
import static hw2.CS227Baseball.*;

public class SimpleTest
{
	public static void main(String[] args)
	{
		CS227Baseball game = new CS227Baseball(2);
		
		game.pitchWithHit(3);
		game.pitch(POP_FLY);
		game.pitch(POP_FLY);
		game.pitch(POP_FLY);
		game.pitchWithHit(4);
		game.pitchWithHit(1);
		game.pitchWithHit(2);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitchWithHitAndOut(2, 1);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitchWithHitAndOut(2, 2);
		game.pitchWithHit(3);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(STRIKE);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitchWithHitAndOut(3, 3);
		game.pitchWithHit(4);
		System.out.println("Test");
		//1-6 BSO=000 INNING T2
		game.pitch(STRIKE);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(STRIKE);
		game.pitchWithHit(1);
		game.pitchWithHit(1);
		game.pitch(POP_FLY);
		game.pitchWithHitAndOut(4, 4);
		game.pitch(STRIKE);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitch(POP_FLY);
		System.out.println(game.toDisplayString());
		game.pitchWithHit(2);
		game.pitchWithHitAndOut(2, 1);
		game.pitch(STRIKE);
		game.pitch(STRIKE);
		game.pitch(BALL);
		game.pitch(BALL);
		game.pitch(STRIKE);
		game.pitchWithHitAndOut(2,2);
		

		System.out.println(game.toDisplayString());
		
		
		
		
		
		
		
		
		
	}
}