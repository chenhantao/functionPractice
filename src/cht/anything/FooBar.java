package cht.anything;

/**
 * @author chenhantao
 * @since 2019/9/9
 */
class FooBar {

    private volatile boolean isFoo = true;


    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (isFoo) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    isFoo = false;
                    break;
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (!isFoo) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    isFoo = true;
                    break;
                }
            }
        }
    }
}