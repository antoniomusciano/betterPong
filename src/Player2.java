import java.awt.*;

public class Player2 implements Paddle{

    /**
     * The player 2 paddle.
     */

    double y, yVelocity;
    boolean upAcceleration, downAcceleration;
    int player, x;
    final double FRICTION = 0.95;


    public Player2(int player) {

        /**
         * Sets the basis of the player 2 Paddle
         *
         * @param player    takes the player number
         */

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

        /**
         * Sets the up acceleration.
         *
         * @param input     takes the key  input
         */

        upAcceleration = input;

    }

    public void setDownAccel(boolean input) {

        /**
         * Sets the down acceleration.
         *
         * @param input     takes the key  input
         */

        downAcceleration = input;

    }
    public void draw(Graphics g) {

        /**
         * Draws the paddle.
         *
         * @param g     graphics
         */

        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);

    }

    @Override
    public void move() {

        /**
         * The paddle physics.
         */

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

        /**
         * Gets the Y value of the paddle as an int.
         */

        return (int)y;
    }
}
