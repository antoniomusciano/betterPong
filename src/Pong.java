import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener {

    final int WIDTH = 900, HEIGHT = 500;
    Thread thread;
    Ball b1;
    HumanPaddle p1;
    UltimatoPaddle p2;


    public void init() {

        this.resize(WIDTH, HEIGHT);
        b1 = new Ball();
        p1 = new HumanPaddle(1);
        p2 = new UltimatoPaddle(2, b1);
        this.addKeyListener(this);
        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if(b1.getX() < -10 || b1.getX() > 710) {
            g.setColor(Color.red);
            g.drawString("You Lost", WIDTH/2, HEIGHT/2);
        } else {

            p1.draw(g);
            b1.draw(g);
            p2.draw(g);

        }



    }

    public void update(Graphics g) {

        paint(g);


    }


    @Override
    public void run() {
        while (true) {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {

            p1.setUpAccel(true);


        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            p1.setDownAccel(true);



        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP) {

            p1.setUpAccel(false);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            p1.setDownAccel(false);

        }

    }
}
