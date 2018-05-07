package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Panel for displaying the score in a simple video game.
 */
public class PreviewPanel extends JPanel
{  
  /**
   * Background color.
   */
  private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
  
  /**
   * Value of next tile
   */
  private int nextValue;

  /**
   * Sets the score to be displayed in this panel.
   * @param newScore
   *   score to be displayed
   */
  public void updateValue(int newValue)
  {
    this.nextValue = newValue;
    repaint();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    Dimension d = getPreferredSize();
    ((Graphics2D) g).setBackground(BACKGROUND_COLOR);
    g.clearRect(0, 0, d.width, d.height);
    int size = GameMain.PREVIEW_SIZE;
    int x = d.width / 2 - size;
    int y = d.height / 2 - size;
    int count = 0;
    if (nextValue == 1)
    {
      count = 0;
    }
    else if (nextValue == 2)
    {
      count = 1;
    }
    else
    {
      count = 2;  // 3 or higher
    }
    Color c = GameMain.colors[count];
    
    g.setColor(c);
    g.fillRoundRect(x, y, size * 2, size * 2, 5, 5);

  }
}
