package com.mir00r.vehicles;

import com.mir00r.enums.EngineType;

/**
 * @author mir00r on 11/5/20
 * @project IntelliJ IDEA
 */
public abstract class Vehicle {
    private int id;
    private String modelNumber;
    private EngineType engineType;
    private String enginePower;
    private String tierSize;
    private int visitor;

    public Vehicle(String modelNumber, EngineType engineType, String enginePower, String tierSize, int visitor) {
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tierSize = tierSize;
        this.visitor = visitor;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getTierSize() {
        return tierSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVisitor() {
        return visitor;
    }
}
