import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener {

    /**
     * The applet class. Where everything is brought together.
     */

    final int WIDTH = 900, HEIGHT = 500;
    private boolean running;
    Thread thread;
    Ball b1;
    Player1 p1;
    Player2 p2;


    public void init() {

        /**
         * Initalizing the applet and all of the classes.
         */

        if (!running) {
            running = true;
            this.resize(WIDTH, HEIGHT);
            b1 = new Ball();
            p1 = new Player1(1);
            p2 = new Player2(2);
            this.addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }



    }

    public void paint(Graphics g) {

        /**
         * Paints the screen with the graphics.
         */

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.drawLine(450,0,450, 500);
        if(b1.getX() < -10 || b1.getX() > 860) {
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.red);
            g.drawString("You Lost", 425, HEIGHT/2);

        } else {

            p1.draw(g);
            b1.draw(g);
            p2.draw(g);

        }



    }

    public void update(Graphics g) {

        /**
         * Updates the screen.
         */

        paint(g);

    }


    @Override
    public void run() {

        /**
         * The game loop.
         */
        while (running) {

            b1.move();
            p1.move();
            p2.move();

            b1.checkPaddleCollision(p1,p2);
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void stop() {

        if(running) {
            running = false;
            try {
                thread.join();
            } catch(Exception e) {
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        /**
         * Empty.
         */

    }

    @Override
    public void keyPressed(KeyEvent e) {

        /**
         * Player controls.
         *
         * @param e the key
         */
        if(e.getKeyCode() == KeyEvent.VK_UP) {

            p1.setUpAccel(true);


        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            p1.setDownAccel(true);



        } else if (e.getKeyCode() == KeyEvent.VK_Q) {

            p2.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {

            p2.setDownAccel(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        /**
         * Player controls.
         *
         * @param e the key
         */

        if(e.getKeyCode() == KeyEvent.VK_UP) {

            p1.setUpAccel(false);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            p1.setDownAccel(false);

        } else if (e.getKeyCode() == KeyEvent.VK_Q) {

            p2.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {

            p2.setDownAccel(false);
        }


    }
}
