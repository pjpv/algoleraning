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

            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2d.addRenderingHints(hints);


            // 设置线条粗细
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            // 画边框
            AlgoVisHelper.strokeRoundRectangle(g2d, canvasWidth / 2, canvasHeight / 2, canvasWidth / 2 - 50);

            g2d.setFont(new Font("宋体",Font.BOLD,16));
            if (null != circles && 0 < circles.length) {
                Color c = Color.MAGENTA;
//                for (Circle circle : circles) {
//                    if (circle.color != c) {
//                        AlgoVisHelper.setColor(g2d, circle.color);
//                    }
//                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
////                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
//                }
                for (int i = 0; i < circles.length; i++) {

                    if (circles[i].color != c) {
                        AlgoVisHelper.setColor(g2d, circles[i].color);
                    }
                    AlgoVisHelper.fillCircle(g2d, circles[i].x, circles[i].y, circles[i].getR());
//                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());


                    AlgoVisHelper.setColor(g2d, Color.WHITE);
                    g2d.drawString(String.valueOf(i), circles[i].x, circles[i].y);
                    AlgoVisHelper.setColor(g2d, c);
                }
            }


        }

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}

