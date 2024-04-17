//工具类
//存放静态参数和静态方法

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameUtil {
    static int RAY_MAX=100;//地雷个数
    static int MAP_W = 36;
    //地图的高
    static int MAP_H = 17;
    //雷区偏移量
    static int OFFSET = 45;
    //格子边长
    static int SQUARE_LENGTH = 50;

    //插旗数量
    static int FLAG_NUM=0;

    //鼠标相关
    //鼠标坐标
    static int MOUSE_X;
    static int MOUSE_Y;
    //状态
    static boolean LEFT=false;
    static boolean RIGHT=false;

    //游戏状态 0游戏中 1 胜利 2 失败 3 难度选择
    static int state=3;
    //游戏难度
    static int level;

 
    //底层元素  -1 雷 0 空 1-8 表示对应数字
    static int[][] DATA_BOTTOM = new int[MAP_W+2][MAP_H+2];

    //顶层元素  -1 无覆盖 0 覆盖 1表示插旗 2表示插错旗
    static int[][] DATA_TOP = new int[MAP_W+2][MAP_H+2];

    //载入图片

    static Image lei = Toolkit.getDefaultToolkit().getImage("imgs/lei.png");//雷
    static Image top = Toolkit.getDefaultToolkit().getImage("imgs/gezi.gif");//格子
    static Image flag = Toolkit.getDefaultToolkit().getImage("imgs/qizi.gif");//旗子
    static Image noflag = Toolkit.getDefaultToolkit().getImage("imgs/chacuoqi.png");//插错旗
    static Image face = Toolkit.getDefaultToolkit().getImage("imgs/youxizhong.png");//游戏中
    static Image over = Toolkit.getDefaultToolkit().getImage("imgs/shibai.png");//失败
    static Image win = Toolkit.getDefaultToolkit().getImage("imgs/shengli.png");//胜利

    static Image[] images = new Image[9];//添加数字数组
    static{
        for(int i=1;i<=8;i++){//循环数组载入图片
            images[i] = Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }
    public static void drawWord(Graphics g, String string, int i, int j, int k, Color black) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawWord'");
    }

}




