/**
 * 底层数字类
 */
public class BottomNumber {
    void newNum(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.DATA_BOTTOM[i][j]==-1){
                    //判断雷周围八格
                    for (int k = i-1; k <=i+1 ; k++) {
                        for (int l = j-1; l <=j+1 ; l++) {
                            if(GameUtil.DATA_BOTTOM[k][l]>=0){//如果区域不是雷
                                GameUtil.DATA_BOTTOM[k][l]++;
                            }
                        }

                    }
                }

            }

        }
    }
}