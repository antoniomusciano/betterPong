import java.awt.*;

public class Ball {

        double xVelocity;
        double yVelocity;
        double x;
        double y;

        public Ball() {
            x = 350;
            y = 250;
            xVelocity = -.1;
            yVelocity = 2;
        }

        public void draw(Graphics g) {

            g.setColor(Color.orange);
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



}
