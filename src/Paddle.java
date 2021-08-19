import java.awt.*;

public interface Paddle {

    /**
     * The Paddle interface.
     */

    public void draw(Graphics g);
    public void move();
    public int getY();
}
