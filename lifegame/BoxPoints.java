package lifegame;

import java.awt.*;

public class BoxPoints {
    points[][] points;
////  调试是否成功
//    public static void main(String[] args) {
//        lifegame.points[][] points1 = new points[3][4];
//        lifegame.points[][] points2 = new points[3][4];
//        for (int i = 0; i < points1.length; i++) {
//            for (int j = 0; j < points1[i].length; j++) {
//                points1[i][j] = new points();
//                points2[i][j] = new points();
//            }
//        }
//        BoxPoints boxPoints = new BoxPoints(points1);
//        for (int i = 0; i < points1.length; i++) {
//            for (int j = 0; j < points1[i].length; j++) {
//                points1[i][j].setIsalive(false);
//            }
//        }
//        points1[1][1].setIsalive(true);
//        points1[2][1].setIsalive(true);
//        points1[1][2].setIsalive(true);
//
//        points2 = boxPoints.getnextpoints(points1);
//        System.out.println(points2[1][1].isIsalive());
//
//    }

    public BoxPoints(lifegame.points[][] points) {
        this.points = points;
    }

    public points[][] getnextpoints(points[][] points){
        points[][] p =copypoints(points);

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                int count = getslivenum(i,j,p);//周围的活者数量
                if (count==3){
                    points[i][j].setIsalive(true);
                }else if (count==2){
                    points[i][j].setIsalive(points[i][j].isIsalive());
                }else points[i][j].setIsalive(false);

            }

        }
        return points;
    }
    public int getslivenum(int y,int x,points[][] points){
        int count = 0;
        if (x>0){ if (points[y][x-1].isIsalive()) {count++;}}
        if (y>0){ if (points[y-1][x].isIsalive()) {count++;}}
        if (x<points[0].length-1){ if (points[y][x+1].isIsalive()) {count++;}}
        if (y<points.length-1){ if (points[y+1][x].isIsalive()) {count++;}}

        if (y>0&&x<points[0].length-1){ if (points[y-1][x+1].isIsalive()) {count++;}}
        if (y>0&&x>0){ if (points[y-1][x-1].isIsalive()) {count++;}}
        if (y<points.length-1&&x<points[0].length-1){ if (points[y+1][x+1].isIsalive()) {count++;}}
        if (y<points.length-1&&x>0){ if (points[y+1][x-1].isIsalive()) {count++;}}
        return count;

    }

    public points[][] copypoints(points[][] points){
        lifegame.points[][] points1 = new points[points.length][points[0].length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points1[i][j] = new points();
                points1[i][j].setIsalive(points[i][j].isIsalive());
            }
        }
        return points1;
    }
}
