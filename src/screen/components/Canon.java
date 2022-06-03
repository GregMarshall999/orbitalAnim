package screen.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serial;

public class Canon extends Component
{
    @Serial
    private static final long serialVersionUID = 8802076133426748696L;

    public Canon()
    {
        super();
    }

    public Canon(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    @Override
    public void drawComponent(Graphics2D g)
    {
        g.setPaint(Color.ORANGE);
        g.fillRect(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
        g.setPaint(Color.GRAY);
        g.fillOval(getX() - (int)(getWidth()/1.5f), getY(), (int)(getHeight()/1.2f), (int)(getHeight()/1.2f));
        g.fillOval(getX() - getHeight()/3, getY(), (int)(getHeight()/1.2f), (int)(getHeight()/1.2f));
    }
}
