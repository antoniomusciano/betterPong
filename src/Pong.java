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


    public void init() {

        this.resize(WIDTH, HEIGHT);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        this.addKeyListener(this);
        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        p1.draw(g);
        b1.draw(g);


    }

    public void update(Graphics g) {

        paint(g);


    }


    @Override
    public void run() {
        while (true) {

            p1.move();
            b1.move();
            repaint();
            try {
                Thread.sleep(10);
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
