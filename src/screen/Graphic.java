package screen;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;

public class Graphic extends JPanel
{
    @Serial
    private static final long serialVersionUID = 6988939919844609021L;

    private short tic;

    public Graphic(int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
        GraphicUtil.updateSize(width, height);
        tic = 0;
    }

    @Override
    public void paint(Graphics gBase)
    {
        Graphics2D g = (Graphics2D) gBase;

        //reset screen every new frame
        g.setPaint(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        GraphicUtil.drawStars(g);
        GraphicUtil.drawPlanetAndCanon(g);
        GraphicUtil.drawBalls(g);
        GraphicUtil.drawPowerLabel(g);

        if(tic%100 == 0)
        {
            GraphicUtil.updateBallsPosition();
            GraphicUtil.updateBallsInertia();
        }

        GraphicUtil.cleanBalls();
        tic++;
        repaint();
    }
}
