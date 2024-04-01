import java.awt.*;
import java.applet.*;

public class Slip1aa extends Applet implements Runnable {
    String a = "Tybca";
    int state;
    boolean flag;

    public void init() {
        setBackground(Color.pink);
        setBackground(Color.blue);
    }

    public void start() {
        Thread t = new Thread(this);
        flag = true;
        t.start();
    }

    public void run() {
        char ch;
        try {
            while (true) {
                repaint();
                Thread.sleep(150);
                ch = a.charAt(0);
                a = a.substring(1, a.length());
                a += ch;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void stop() {
        flag = false;
        Thread t = null;
    }

    public void paint(Graphics g) {
        Font font = new Font("Times New Roman", Font.BOLD, 60);
        g.setFont(font);
        g.drawString(a, 15, 70);
    }
}
