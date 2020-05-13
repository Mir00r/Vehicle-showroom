package com.mir00r.vehicles;

import com.mir00r.enums.EngineType;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class NormalVehicle extends Vehicle {
    private EngineType engineType;

    public NormalVehicle(String modelNumber, Long engineTypeId, String enginePower, String tierSize, int visitor) {
        super(modelNumber, EngineType.get(engineTypeId), enginePower, tierSize, visitor);
    }

    @Override
    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
