import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {

        double xVelocity;
        double yVelocity;
        double x;
        double y;

        public Ball() {
            x = 450;
            y = 250;
            xVelocity = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
            yVelocity = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
        }

        public void draw(Graphics g) {

            g.setColor(Color.white);
            g.fillOval((int)x-10, (int)y-10, 20,20);

        }

        public void move() {
            x += xVelocity;
            y += yVelocity;

            if (y < 10) {

                y = 490;

                // yVelocity = -yVelocity;
            }
            if (y > 490) {

                y = 10;


            }

        }

        public int getX() {
            return (int)x;
        }

        public int getY() {
            return (int)y;
        }


        public void checkPaddleCollision(Paddle p1, Paddle p2) {

            if (x <= 50) {
                if (y >= p1.getY() && y <= p1.getY() + 80) {
                    xVelocity = -xVelocity + .2;
                }


            } else if (x >= 860){

                if (y >= p2.getY() && y <= p2.getY() + 80) {

                    xVelocity = -xVelocity - .2;




                }


            }


        }


}
