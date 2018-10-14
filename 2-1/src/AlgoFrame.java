import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();

        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        pack();


        setSize(canvasWidth, canvasHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public AlgoFrame(String title) {
        this(title, 500, 500);
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        this.repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // 启用双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);


//            Integer jg = 3;
//            Integer sl = 100;
//            for (int i = 0; i < sl; i++) {
//                g.drawOval(50 + i * jg, 50 + i * jg, 30, 30);
//            }
//            for (int i = sl; i > 0; i--) {
//                g.drawOval((50 + i * jg) * 2, 50 + i * jg, 30, 30);
//            }
            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2d.addRenderingHints(hints);
            // 设置线条粗细
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.strokeRoundRectangle(g2d, canvasWidth / 2, canvasHeight / 2, canvasWidth/2-50);
            if (null != circles && 0 < circles.length)
                for (Circle circle : circles)
//                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());

//            int strokeWidth = 10;
//            g2d.setStroke(new BasicStroke(strokeWidth));
//            // 设置线条粗细
//            AlgoVisHelper.setStrokeWidth(g2d, 10);
//            // 设置颜色
//            AlgoVisHelper.setColor(g2d, Color.BLACK);
//            g2d.setColor(Color.blue);
            // 画圆圈
//            AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 50);
//            AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 100);
//            AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 150);
//            for (int i = 0; i < 8; i++) {
//                AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 10 + i * 30);
//            }
//            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
//            g2d.draw(circle);

//            AlgoVisHelper.setColor(g2d, Color.RED);
//            // 画实心圆
//            AlgoVisHelper.fillCircle(g2d, canvasWidth / 2, canvasHeight / 2, 20);
//            Ellipse2D circle2 = new Ellipse2D.Double(60, 60, 280, 280);
//            g2d.setColor(Color.green);
//            g2d.fill(circle2);
//
//            Rectangle2D circle3 = new Rectangle2D.Double(100, 100, 280, 280);
//
//            g2d.setColor(Color.RED);
//            g2d.draw(circle3);
            // 圆角方形
//            RoundRectangle2D circle4 = new RoundRectangle2D.Double(100, 100, 280, 280, 50, 50);
//            g2d.setColor(Color.RED); // 设置颜色
//            g2d.draw(circle4);      // 话边框


        }

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}

