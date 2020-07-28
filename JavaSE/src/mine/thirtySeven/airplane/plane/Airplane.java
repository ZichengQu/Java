package mine.thirtySeven.airplane.plane;

import java.util.Random;

/**
 * 敌飞机: 是飞行物，也是敌人
 */
public class Airplane extends FlyingObject implements Enemy {
    private int speed = 3;  //移动步骤

    /** 初始化数据 */
    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;          
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
    }

    /** 获取分数 */
    
    public int getScore() {  
        return 5;
    }

    /** //越界处理 */
    
    public  boolean outOfBounds() {   
        return y>ShootGame.HEIGHT;
    }

    /** 移动 */
    
    public void step() {   
        y += speed;
    }

}

