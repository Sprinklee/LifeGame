package lifegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class finalpanel {
    gamepanel Gamepanel = new gamepanel();

    JButton start = new JButton("开始/继续游戏");
    JButton pause = new JButton("暂停");
    JButton restart = new JButton("重开");



    public finalpanel() {
        Gamepanel.setLayout(null);

        start.setBounds(300,700,150,40);
        pause.setBounds(500,700,70,40);
        restart.setBounds(600,700,70,40);
        Gamepanel.circulationnum.setBounds(20,700,200,40);
        Gamepanel.circulationnum.setEditable(false);
        Gamepanel.circulationnum.setFont(new Font("华文行楷",Font.BOLD,30));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamepanel.StartGame();
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamepanel.StopGame();
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamepanel.initgame();
                Gamepanel.StopGame();
            }
        });

        Gamepanel.add(start);
        Gamepanel.add(pause);
        Gamepanel.add(restart);
        Gamepanel.add(Gamepanel.circulationnum);

    }

}
