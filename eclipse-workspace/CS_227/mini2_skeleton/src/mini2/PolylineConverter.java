package mini2;

import java.awt.Point;
import java.util.Scanner;

import api.Converter;
import plotter.Polyline;

/**
 * Converts a string into a <code>Polyline</code> object.  The given 
 * string must conform to the format specified for one valid line of the file 
 * as described in Lab 8, checkpoint 2.  See
 * <pre>
 * http://web.cs.iastate.edu/~cs227/labs/lab8/page12.html
 * </pre>
 */
public class PolylineConverter implements Converter<Polyline>
{
	
    @Override
    public Polyline convert(String s) {
    	Polyline poly;
    	Scanner scan = new Scanner(s);
    	if (scan.hasNextInt())

    	{

    	  int width = scan.nextInt();

    	  String color = scan.next();

    	  poly = new Polyline(color, width);

    	}

    	else

    	{

    	  String color = scan.next();

    	  poly = new Polyline(color);

    	}

    	// then loop through the rest of the values, making a Point from each pair

    	while(scan.hasNextInt())

    	{

    	  int x = scan.nextInt();

    	  int y = scan.nextInt();

    	  Point p = new Point(x, y);

    	  poly.addPoint(p);

    	}
    	return poly;
    }
    // TODO
}
