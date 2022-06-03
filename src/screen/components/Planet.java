package screen.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serial;

public class Planet extends Component
{
    @Serial
    private static final long serialVersionUID = 9176690053223684080L;

    public Planet()
    {
        super();
    }

    public Planet(int size)
    {
        super();
        setWidth(size);
        setHeight(size);
    }

    @Override
    public void drawComponent(Graphics2D g)
    {
        g.setColor(Color.GREEN);
        g.fillOval(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
    }
}
