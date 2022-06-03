import screen.Graphic;

import javax.swing.JFrame;
import java.io.Serial;

public class App extends JFrame
{
    @Serial
    private static final long serialVersionUID = 949744218770101004L;

    public static void main(String[] args)
    {
        new App();
    }

    public App()
    {
        super();

        Graphic graphic = new Graphic(800, 600);
        AppController appController = new AppController();

        add(graphic);
        addKeyListener(appController);

        setTitle("Orbital Animation");
        pack();
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
