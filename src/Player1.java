import java.awt.*;

public class Player1 implements Paddle{
    double y, yVelocity;
    boolean upAcceleration, downAcceleration;
    int player, x;
    final double FRICTION = 0.95;


    public Player1(int player) {

        upAcceleration = false;
        downAcceleration = false;
        y = 210;
        yVelocity = 0;
        if (player == 1) {
            x = 20;

        } else {

            x = 860;

        }


    }
    public void setUpAccel(boolean input) {

        upAcceleration = input;

    }

    public void setDownAccel(boolean input) {

        downAcceleration = input;

    }
    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);

    }

    @Override
    public void move() {

        if (upAcceleration) {

            yVelocity -= 2;

        } else if (downAcceleration) {

            yVelocity += 2;


        } else if (!upAcceleration && !downAcceleration) {

            yVelocity *= FRICTION;


        }

        if (yVelocity >=5) {
            yVelocity = 5;
        } else if (yVelocity <= -5){

            yVelocity = -5;

        }


        y += yVelocity;

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
