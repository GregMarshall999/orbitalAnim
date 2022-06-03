package screen;

import screen.components.Ball;
import screen.components.Canon;
import screen.components.Planet;
import screen.components.Star;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphicUtil
{
    protected final static int planetDiam = 100;
    protected final static int starsMin = 100;
    protected final static int starsMax = 150;
    protected final static List<Star> stars = new ArrayList<>();
    protected final static List<Ball> balls = new ArrayList<>();

    protected static Planet planet = new Planet(planetDiam);
    protected static Canon canon = new Canon();
    protected static int gWidth, gHeight;
    protected static String power = "Canon Power: 10";

    private static final double force = 30;

    private static double updateInertia(double inertia, int distance)
    {
        return inertia - force/distance;
    }

    protected static void cleanBalls()
    {
        for (Ball ball : balls)
        {
            if(ball.getX() < 0 || ball.getX() > gWidth ||
                    ball.getY() < 0 || ball.getY() > gHeight)
            {
                balls.remove(ball);
                cleanBalls();
                break;
            }
        }
    }

    protected static void drawBalls(Graphics2D g)
    {
        for(Ball ball: balls)
        {
            ball.drawComponent(g);
        }
    }

    protected static void drawPlanetAndCanon(Graphics2D g)
    {
        planet.setX(gWidth/2);
        planet.setY(gHeight/2);
        planet.drawComponent(g);
        canon.setX(gWidth/2);
        canon.setY(gHeight/2 - planetDiam/2 - planetDiam/15);
        canon.setWidth(planetDiam/3);
        canon.setHeight(planetDiam/6);
        canon.drawComponent(g);
    }

    protected static void drawPowerLabel(Graphics2D g)
    {
        g.setColor(Color.RED);
        g.drawString(power, gWidth/2, gHeight/2 - planetDiam);
    }

    protected static void drawStars(Graphics2D g)
    {
        for (Star star : stars)
        {
            star.drawComponent(g);
        }
    }

    protected static void updateBallsInertia()
    {
        for (Ball ball : balls)
        {
            ball.setInertiaX(updateInertia(ball.getInertiaX(), ball.getCenterX() - planet.getCenterX()));
            //ball.setInertiaY(updateInertia(ball.getInertiaY(), ball.getCenterY() - planet.getCenterY()));
        }
    }

    protected static void updateBallsPosition()
    {
        for(Ball ball : balls)
        {
            System.out.println(ball.getInertiaX());
            System.out.println(ball.getCenterX());
            ball.setX(ball.getX()+(int)ball.getInertiaX());
            ball.setY(ball.getY()+(int)ball.getInertiaY());
        }
    }

    /**
     * required because new Dimension does not update size before pain is called
     */
    protected static void updateSize(int width, int height)
    {
        gWidth = width;
        gHeight = height;
    }

    public static void addBall(int ballPower)
    {
        Ball ball = new Ball(canon.getX() + canon.getWidth()/2, canon.getY());
        ball.setInertiaX(ballPower);
        balls.add(ball);
    }

    public static void generateStars()
    {
        Random random = new Random();
        Star currentStar;
        int amount = random.nextInt(starsMax-starsMin)+starsMin;

        for(int i = 0; i < amount; i++)
        {
            currentStar = new Star(random.nextInt(gWidth), random.nextInt(gHeight));
            while(stars.contains(currentStar))
            {
                currentStar.setX(random.nextInt(gWidth));
                currentStar.setY(random.nextInt(gHeight));
            }
            stars.add(currentStar);
        }
    }

    public static void updatePower(int newPower)
    {
        power = "Canon Power :"+newPower;
    }
}
