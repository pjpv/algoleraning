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

        int N = 20;


        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);


//            JButton jb = new JButton("触发事件");
//            frame.add(jb);
//            jb.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // 进行逻辑处理即可
//
//                    for (Circle circle : circles)
//                        circle.vy -= 10;
//                }
//            });
//            jb.addKeyListener(new KeyAdapter() {
//                @Override
//                public void keyPressed(KeyEvent e) {
//                    // 进行逻辑处理即可
//                    System.out.print("键盘" + KeyEvent.getKeyText(e.getKeyCode()) + e.getKeyCode() + "键向下\n");
//
//                    for (Circle circle : circles) {
//                        circle.vy += e.getKeyCode() == 37 ? -1 : e.getKeyCode() == 39 ? 1 : 0;
//                        circle.vx -= e.getKeyCode() == 37 ? -1 : e.getKeyCode() == 39 ? 1 : 0;
//                    }
//                }
//            });

    }


}
