package screen.components;

import java.awt.Graphics2D;
import java.io.Serializable;

public interface IComponent extends Serializable
{
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void setX(int x);
    void setY(int y);
    void setWidth(int width);
    void setHeight(int height);
    int getCenterX();
    int getCenterY();

    void drawComponent(Graphics2D g);
}
