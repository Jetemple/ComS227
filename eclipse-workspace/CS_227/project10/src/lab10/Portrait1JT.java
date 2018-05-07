package lab10;
import java.awt.Graphics;

/**
 * Cyclops look a lot like you and me, but they only have one eye.
 */
public class Portrait1JT extends Portrait
{

    public Portrait1JT()
    {
        super(0.2);

        setBodyHeight(.45);
        setArmSpan(0.9);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int midX = getWidth() / 2;

        // Draw's 2 Eyes looking right
        int eyeRadius = (int)(0.04 * SIZE);
        g.fillOval(midX-2*eyeRadius, headRadius - eyeRadius * 2, 2 * eyeRadius,
                2 * eyeRadius);
        g.fillOval(midX+eyeRadius, headRadius - eyeRadius * 2, 2 * eyeRadius,
                2 * eyeRadius);

        //Draws mouth
        int smileRadius = (int)(0.5 * headRadius);
        g.drawOval(midX-2,headRadius+smileRadius ,smileRadius,5);
    }
}
