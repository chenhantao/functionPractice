package cht.designpattern.creationalpatterns.basic.enums;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/21
 */
public enum ShapeTypeEnum {
    CIRCLE("Circle", "圆形"),
    SQUARE("Square", "正方形"),
    RECTANGLE("Rectangle", "长方形"),
    ;

    ShapeTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static ShapeTypeEnum getShapeByType(String shapeType) {
        for (ShapeTypeEnum value : ShapeTypeEnum.values()) {
            if (value.getType().equalsIgnoreCase(shapeType)) {
                return value;
            }
        }
        return null;
    }

    private String type;

    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
