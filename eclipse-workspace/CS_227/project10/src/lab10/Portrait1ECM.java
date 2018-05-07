package lab10;

import java.awt.Graphics;
import java.awt.Color;
public class Portrait1ECM extends Portrait{

    public Portrait1ECM() {
        super(.1, .1, .1, .4, .3, .7);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(0,0,250));
        int midX = getWidth() / 2;

        // Draw two blue eyes
        int eyeRadius = (int)(0.02 * SIZE);
        g.fillOval((int) (midX - 2.5*eyeRadius), (int) (headRadius - 3*eyeRadius), 2 * eyeRadius, 2 * eyeRadius);
        g.fillOval((int) (midX + 1.5*eyeRadius), (int) (headRadius - 3*eyeRadius), 2 * eyeRadius, 2 * eyeRadius);

        // Draw a black nose
        g.setColor(new Color(0,0,0));
        int rectangleWidth = (int) (0.02 * SIZE);
        int rectangleLength = (int) (0.03 * SIZE);
        g.fillRect((int) (midX-.5*rectangleWidth), (int) (headRadius+.5*rectangleLength), rectangleWidth, rectangleLength);

        //Draw a red smile
        g.setColor(new Color(100,0,10));
        int smileRadius = (int)(0.5 * headRadius);
        g.drawArc(midX - smileRadius, (int)(.8*headRadius), smileRadius * 2,
                smileRadius * 2, 0, -180);
    }

}