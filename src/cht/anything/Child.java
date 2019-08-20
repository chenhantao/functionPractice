package cht.anything;

import java.io.Serializable;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/7/31
 */
public class Child extends User implements Serializable {

    private static final long serialVersionUID = 4025284668322642156L;


    public Child(String name) {
        System.out.println(name);
    }
}
