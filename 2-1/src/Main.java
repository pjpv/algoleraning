import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;

        int N = 2;
        int R = 10;
        int bianju = 50;
        Circle[] circles = randomCricle(sceneWidth, sceneWidth, N, R);

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("test", sceneWidth, sceneHeight);

            new Thread(() -> {

                while (true) {
                    frame.render(circles);
                    AlgoVisHelper.pause(5);
                    for (Circle circle : circles)
                        circle.move(0, 0, sceneWidth, sceneHeight, bianju);
                }
            }).start();

            JButton jb = new JButton("触发事件");
            frame.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 进行逻辑处理即可

                    for (Circle circle : circles)
                        circle.vy -= 1;
                }
            });
            jb.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    // 进行逻辑处理即可
                    System.out.print("键盘" + KeyEvent.getKeyText(e.getKeyCode()) + e.getKeyCode() + "键向下\n");

                    for (Circle circle : circles) {
                        circle.vy += e.getKeyCode() == 37 ? -1 : e.getKeyCode() == 39 ? 1 : 0;
                        circle.vx -= e.getKeyCode() == 37 ? -1 : e.getKeyCode() == 39 ? 1 : 0;
                    }
                }
            });

        });
    }


    public static Circle[] randomCricle(int w, int h, int n, int r) {
        int sceneWidth = w;
        int sceneHeight = h;

        int N = n;
        Circle[] circles = new Circle[N];
        int R = r;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        return circles;
    }
}
