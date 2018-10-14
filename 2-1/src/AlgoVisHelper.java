
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Shape.*;
import java.awt.geom.RoundRectangle2D;

public class AlgoVisHelper {

    // 不可实例
    private AlgoVisHelper() {
    }

    public static void setStrokeWidth(Graphics2D g2d, int width) {
        int strokeWidth = width;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    }

    public static void setColor(Graphics2D g2d, Color c) {
        g2d.setColor(c);

    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.fill(circle);
    }

    public static void strokeRoundRectangle(Graphics2D g2d, int x, int y, int r) {
        RoundRectangle2D circle = new RoundRectangle2D.Double(x - r, y - r, r * 2, r * 2, 0, 0);
        g2d.draw(circle);
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (Exception e) {
            System.out.print("Error");
        }

    }
}
