import java.awt.*;

public class HumanPaddle implements Paddle{
    double y, yVelocity;
    boolean upAcceleration, downAcceleration;
    int player, x;
    final double FRICTION = 0.95;


    public HumanPaddle(int player) {

        upAcceleration = false;
        downAcceleration = false;
        y = 210;
        yVelocity = 0;
        if (player == 1) {
            x = 20;

        } else {

            x = 660;

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

        if (yVelocity >=9) {
            yVelocity = 9;
        } else if (yVelocity <= -9){

            yVelocity = -9;

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
