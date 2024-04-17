import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame{

    int wigth = 2 * GameUtil.OFFSET + GameUtil.MAP_W * GameUtil.SQUARE_LENGTH;
    int height = 4 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH;

    Image offScreenImage = null;//创建画布避免闪屏

    MapBottom mapBottom = new MapBottom();
    MapTop mapTop = new MapTop();
    GameSelect gameSelect=new GameSelect();

    //是否开始
    boolean begin = false;

    void launch(){
        this.setVisible(true);//窗口是否可见
        if(GameUtil.state==3){
            this.setSize(500,500);
        }else{
            this.setSize(wigth, height);//设置窗口大小
        }
        this.setLocationRelativeTo(null);//设置窗口位置：居中显示
        this.setTitle("躲避左把杨");//设置窗口标题
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭窗口

        //鼠标事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击
                super.mouseClicked(e);
                switch (GameUtil.state) {
                    case 0:
                    if(e.getButton()==1){//左键
                        System.out.println(1);
                        GameUtil.MOUSE_X=e.getX();
                        GameUtil.MOUSE_Y=e.getY();
                        GameUtil.LEFT=true;
                    }
                    if(e.getButton()==3){//右键
                        System.out.println(3);
                        GameUtil.MOUSE_X=e.getX();
                        GameUtil.MOUSE_Y=e.getY();
                        GameUtil.RIGHT=true;
                    }
                    case 1:
                    case 2:
                        if(e.getButton()==1){
                            if(e.getX()>GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W)/2
                            &&e.getX()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W)/2 + GameUtil.SQUARE_LENGTH
                            &&e.getY()>GameUtil.OFFSET
                            &&e.getY()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH){
                                mapBottom.reGame();
                                mapTop.reGame();
                                GameUtil.FLAG_NUM=0;
                                GameUtil.state=0;
                            }
                        }
                        break;
                    case 3:
                        if(e.getButton()==1){//左键
                            System.out.println(1);
                            GameUtil.MOUSE_X=e.getX();
                            GameUtil.MOUSE_Y=e.getY();
                            begin = gameSelect.hard();
                        } 
                        break;
                    default:
                }
        }});

        while(true){
            repaint();
            begin();
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    void begin(){
        if(begin){
            begin = false;
            gameSelect.hard(GameUtil.level);
            GameWin gameWin = new GameWin();
            mapBottom.reGame();
            mapTop.reGame();
            gameWin.launch();
        }
    }

    @Override
    public void paint(Graphics g) {
        if(GameUtil.state==3){
            g.setColor(Color.white);
            g.fillRect(0,0,500,500);
            gameSelect.paintSelf(g);
        }else{
        offScreenImage = this.createImage(wigth,height);//初始化画布
        Graphics gImage = offScreenImage.getGraphics();//设置画笔
        //设置背景颜色
        gImage.setColor(Color.white);
        gImage.fillRect(0, 0, wigth, height);
        mapBottom.paintSelf(gImage);//调用画笔
        mapTop.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);//画布绘制到窗口中
    }}


    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
