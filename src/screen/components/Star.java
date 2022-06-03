package screen.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serial;
import java.util.Random;

public class Star extends Component
{
    @Serial
    private static final long serialVersionUID = -2866742961653097566L;

    public Star()
    {
        super();
    }

    public Star(int x, int y)
    {
        super(x, y);
        generateStar();
    }

    private void generateStar()
    {
        Random random = new Random();
        int size = random.nextInt(5);
        setWidth(size);setHeight(size);
    }

    @Override
    public boolean equals(Object o)
    {
        if(o.getClass()==this.getClass())
        {
            return  ((Star)o).getX() == this.getX() && ((Star)o).getY() == this.getY();
        }
        return false;
    }

    @Override
    public void drawComponent(Graphics2D g)
    {
        g.setPaint(Color.WHITE);
        g.fillOval(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
    }
}
