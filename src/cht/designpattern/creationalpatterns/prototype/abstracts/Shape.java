package cht.designpattern.creationalpatterns.prototype.abstracts;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public abstract class Shape implements Cloneable {

    private Integer id;
    protected String type;

    public abstract void draw();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
