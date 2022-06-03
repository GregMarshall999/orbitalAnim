package screen.components;

import java.io.Serial;

public abstract class Component implements IComponent
{
    @Serial
    private static final long serialVersionUID = 3923621213103995018L;

    private int x, y, width, height;

    public Component()
    {

    }

    public Component(int x, int y)
    {
        this.x = x;
        this.y = y;

        this.width = 1;
        this.height = 1;
    }

    public Component(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getCenterX()
    {
        return getX() - getWidth()/2;
    }

    @Override
    public int getCenterY()
    {
        return getY() - getHeight()/2;
    }
}
