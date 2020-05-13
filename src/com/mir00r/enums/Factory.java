package com.mir00r.enums;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public enum Factory {
    VEHICLE(1L, "Vehicle");

    private final Long key;
    private final String value;

    Factory(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public Factory get(Long id) {
        for (Factory type : Factory.values()) {
            if (type.key.equals(id)) return type;
        }
        return null;
    }

    public Factory get(String name) {
        for (Factory type : Factory.values()) {
            if (type.name().contains(name)) return type;
        }
        return null;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
