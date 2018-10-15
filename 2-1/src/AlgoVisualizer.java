import java.awt.*;

public class AlgoVisualizer {

    private Circle[] circles;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {

        circles = new Circle[N];
        int R = 20;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            vx = vx == 0 ? 1 : vx;
            vy = vy == 0 ? 1 : vy;
            circles[i] = new Circle(x, y, R, vx, vy, Color.BLACK);
        }

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {

                run();
            }).start();

        });

    }

    private void run() {

        while (true) {
            frame.render(circles);  // 重绘
            AlgoVisHelper.pause(20);    // 延时
            for (Circle circle : circles) {
                circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight(), 50);
                AlgoVisHelper.checkCircleCollision(circle, circles);
            }
        }

    }
}
