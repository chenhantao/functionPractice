package cht.designpattern.creationalpatterns.basic.enums;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public enum ColorTypeEnum {
    BLUE("blue", "蓝色"),
    GREEN("green", "绿色"),
    RED("red", "红色");

    ColorTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static ColorTypeEnum getColorByType(String color) {
        for (ColorTypeEnum value : ColorTypeEnum.values()) {
            if (value.getType().equalsIgnoreCase(color)) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
