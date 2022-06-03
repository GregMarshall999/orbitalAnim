package screen.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serial;

public class Ball extends Component
{
    @Serial
    private static final long serialVersionUID = 3871373903509035858L;

    private double inertiaX, inertiaY;

    public Ball()
    {
        super();
    }

    public Ball(int x, int y)
    {
        super(x, y);
        int ballSize = 10;
        setWidth(ballSize);
        setHeight(ballSize);
    }

    public double getInertiaX() {
        return inertiaX;
    }

    public void setInertiaX(double inertiaX) {
        this.inertiaX = inertiaX;
    }

    public double getInertiaY() {
        return inertiaY;
    }

    public void setInertiaY(double inertiaY) {
        this.inertiaY = inertiaY;
    }

    @Override
    public void drawComponent(Graphics2D g)
    {
        g.setPaint(Color.RED);
        g.fillOval(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
    }
}
