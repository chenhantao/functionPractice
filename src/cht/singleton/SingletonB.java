package cht.singleton;

/**
 * 饿汉式（静态代码块）
 * <p>
 * 与A类似
 *
 * @author chenhantao
 * @since 2019/8/28
 */
public class SingletonB {
    private static SingletonB instance;

    static {
        instance = new SingletonB();
    }

    private SingletonB() {
    }

    public static SingletonB getInstance() {
        return instance;
    }

}
