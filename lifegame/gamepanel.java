package lifegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gamepanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    int panelwidth = 800;
    int panelheight = 720;
    int blockwidth = 20;
    int blockheight = 20;
    int edgedistance = 20;
    int boxwidth = (panelwidth-edgedistance-edgedistance)/blockwidth;
    int boxheight = (panelheight-edgedistance-edgedistance)/blockheight;

    points[][] p = new points[boxheight][boxwidth];
    BoxPoints boxPoints = new BoxPoints(p);
    boolean isstartgame = false;
    Timer timer = new Timer(1000,this);
    JTextField circulationnum = new JTextField();

    int circulation = 0;
    public void initgame(){
        SetLocation(p);
        isstartgame = false;
        circulation = 0;
        circulationnum.setText("循环数    "+circulation);
        repaint();
    }
    public gamepanel(){
        setSize(panelwidth,panelheight);
        initgame();
        this.setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void StartGame(){
        timer.start();
        isstartgame = true;
    }
    public void StopGame(){
        timer.stop();
        isstartgame = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(new Color(100,100,100));
        g.fill3DRect(20,20,760,680,false);
        g.setColor(Color.gray);
        for (int i = 0; i < ((panelwidth-edgedistance)/blockwidth); i++) {
            g.drawLine(edgedistance+(blockwidth*i),edgedistance,edgedistance+(blockwidth*i),panelheight-edgedistance);

        }for (int i = 0; i < (panelheight-edgedistance)/blockheight; i++) {
            g.drawLine(edgedistance,edgedistance+(blockheight*i),panelwidth-edgedistance,edgedistance+(blockheight*i));
        }
//        g.drawLine(800,20,800,700);
        g.setColor(Color.green);
//        g.setFont(new Font("Arial",Font.BOLD,10));
        for (int i = 0; i <p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                if (p[i][j].isIsalive()){
                    g.fill3DRect(p[i][j].getX()+2,p[i][j].getY()+2,blockwidth-3,boxheight/2,false);
                }

            }

        }




    }
    public points[][] SetLocation(points[][] p){
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                p[i][j] = new points();
                p[i][j].setIsalive(false);
                p[i][j].setX(edgedistance+(blockwidth*j));
                p[i][j].setY(edgedistance+(blockheight*i));
            }

        }
        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p = boxPoints.getnextpoints(p);
        circulation++;
        repaint();
        circulationnum.setText("循环数    "+circulation);




    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!isstartgame&&circulation==0) {

            if (e.getClickCount()==1) {
                for (int i = 0; i < p.length; i++) {
                    for (int j = 0; j < p[0].length; j++) {
                        Rectangle rectangle = new Rectangle(p[i][j].getX()+2,p[i][j].getY()+2,blockwidth-3,boxheight/2);
                        if (rectangle.contains(e.getX(),e.getY()))
                            p[i][j].setIsalive(true);
                        repaint();
                    }

                }
            }if (e.getClickCount()==2) {
                for (int i = 0; i < p.length; i++) {
                    for (int j = 0; j < p[0].length; j++) {
                        Rectangle rectangle = new Rectangle(p[i][j].getX()+2,p[i][j].getY()+2,blockwidth-3,boxheight/2);
                        if (rectangle.contains(e.getX(),e.getY()))
                            p[i][j].setIsalive(false);
                        repaint();
                    }

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isstartgame&&circulation==0) {
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[0].length; j++) {
                    Rectangle rectangle = new Rectangle(p[i][j].getX()+2,p[i][j].getY()+2,blockwidth-3,boxheight/2);
                    if (rectangle.contains(e.getX(),e.getY()))
                        p[i][j].setIsalive(true);
                    repaint();
                }

            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
