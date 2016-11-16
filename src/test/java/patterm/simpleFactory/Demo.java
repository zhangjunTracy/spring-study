package patterm.simpleFactory;

import org.junit.Test;

/**
 * 简单工厂模式 包含三个角色:1抽象产品2具体产品3工厂类 对于简单工厂模式而言,我们将对象的创建过程全部抽取到一个方法中.只需要维护这一个方法就行.
 * 创建对象的方法不一定非要用static关键字修饰,用static修饰的方法不用用创建对象就可以使用,但是需要清楚静态方法是不能被继承的。
 * 静态工厂模式将所有的对象生成逻辑集中在一个方法中，这是它的优点也是缺点，当我们的具体产品较少，层次比较扁平的时候， 借助于抽象工厂，可以让代码更加简洁，
 * 但是如果我们具有相当数量的具体产品，产品结构还分层次，那么静态工厂将所有对象创建逻辑集中在一个方法中势必 会让这个方法变得相当复杂、难以管理和扩展。
 * 
 * @author Mr.Zhang
 * @Date 2016年11月16日
 * @Email zhangjunTracy@qq.com
 */
public class Demo {

    @Test
    public void demo() {
        SimpleFactory simpleFactory = new SimpleFactory();

        Fruit fruit = simpleFactory.getFruit(1);

        System.out.println(fruit.getColor());

    }

}
