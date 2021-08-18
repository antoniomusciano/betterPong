import java.awt.*;

public class UltimatoPaddle implements Paddle{
    double y, yVelocity;
    boolean upAcceleration, downAcceleration;
    int player, x;
    final double FRICTION = 0.95;

    Ball b1;


    public UltimatoPaddle(int player, Ball b) {

        b1 = b;
        y = 210;
        yVelocity = 0;
        if (player == 1) {
            x = 20;

        } else {

            x = 660;

        }

    }

    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);

    }

    @Override
    public void move() {

        y = b1.getY();


        if (y < 0) {
            y = 0;

        } else if (y > 420) {
            y = 420;
        }

    }

    @Override
    public int getY() {


        return (int)y;
    }
}
