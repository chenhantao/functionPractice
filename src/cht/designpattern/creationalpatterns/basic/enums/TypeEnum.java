package cht.designpattern.creationalpatterns.basic.enums;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public enum TypeEnum {
    SHAPE("shape", ""),
    COLOR("color", ""),

    ;

    private String type;
    private String desc;

    TypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static TypeEnum getTypeByType(String type) {
        for (TypeEnum value : TypeEnum.values()) {
            if (value.type.equalsIgnoreCase(type)) {
                return value;
            }
        }
        return null;
    }

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
