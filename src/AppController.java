import screen.GraphicUtil;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppController implements KeyListener
{
    private int power;

    public AppController()
    {
        power = 10;
        GraphicUtil.updatePower(power);
        GraphicUtil.generateStars();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                GraphicUtil.updatePower(++power);
                break;
            case KeyEvent.VK_DOWN:
                if(power > 1) {
                    GraphicUtil.updatePower(--power);
                }
                break;
            case KeyEvent.VK_SPACE:
                GraphicUtil.addBall(power);
                break;
            default:
                break;
        }
    }
}
