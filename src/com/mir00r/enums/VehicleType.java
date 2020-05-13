package com.mir00r.enums;

/**
 * @author mir00r on 11/5/20
 * @project IntelliJ IDEA
 */
public enum VehicleType {
    NORMAL(1L, "Normal"), SPORTS(2L, "Sports"), HEAVY(3L, "Heavy");

    private final Long key;
    private final String value;

    VehicleType(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public static VehicleType get(Long id) {
        for (VehicleType type : VehicleType.values()) {
            if (type.key.equals(id)) return type;
        }
        return null;
    }

    public static VehicleType get(String name) {
        for (VehicleType type : VehicleType.values()) {
            if (type.name().contains(name)) return type;
        }
        return null;
    }

    public static boolean validate(Long id) {
        for (VehicleType type : VehicleType.values()) {
            if (type.key.equals(id)) return true;
        }
        return false;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
