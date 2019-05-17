package cht.anything;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User("1",  "1");
        User user2 = user1;

        User user3 = new User();
        user3 = user1;

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
    }
}
