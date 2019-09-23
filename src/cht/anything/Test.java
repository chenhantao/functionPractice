package cht.anything;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("asd", "as");
        Test.change(user);
        System.out.println(user.toString());


    }

    public static void change(User user) {
        user = new User();
        user.setName("hahah");
    }
}
