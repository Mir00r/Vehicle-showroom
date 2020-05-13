package com.mir00r.enums;

/**
 * @author mir00r on 11/5/20
 * @project IntelliJ IDEA
 */
public enum EngineType {

    OIL(1L, "Oil"), GAS(2L, "gas"), DIESEL(3L, "Diesel");

    private final Long key;
    private final String value;

    EngineType(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public static EngineType get(Long id) {
        for (EngineType type : EngineType.values()) {
            if (type.key.equals(id)) return type;
        }
        return null;
    }

    public static EngineType get(String name) {
        for (EngineType type : EngineType.values()) {
            if (type.name().contains(name) || type.getValue().contains(name)) return type;
        }
        return null;
    }

    public static boolean validate(Long id) {
        for (EngineType type : EngineType.values()) {
            if (type.key.equals(id)) return true;
        }
        return false;
    }

    public static boolean validate(String name) {
        for (EngineType type : EngineType.values()) {
            if (type.name().equals(name) || type.getValue().contains(name)) return true;
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
