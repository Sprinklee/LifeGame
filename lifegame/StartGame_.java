package lifegame;

import javax.swing.*;

public class StartGame_ {
    public static void main(String[] args) {
        finalpanel startgame = new finalpanel();
        JFrame jFrame = new JFrame();
        jFrame.add(startgame.Gamepanel);
        jFrame.setBounds(0,0,810,800);
        jFrame.setResizable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
