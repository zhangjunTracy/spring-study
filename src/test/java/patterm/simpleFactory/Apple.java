package patterm.simpleFactory;

/**
 * 苹果
 * 
 * @author Mr.Zhang
 * @Date 2016年11月14日
 * @Email zhangjunTracy@qq.com
 */
public class Apple implements Fruit {

    @Override
    public String getName() {

        return "apple";
    }

    @Override
    public String getColor() {
        return "red";
    }

}
