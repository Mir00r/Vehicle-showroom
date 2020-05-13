package com.mir00r.vehicles;

import com.mir00r.enums.EngineType;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class SportsVehicle extends Vehicle {
    private String turbo;

    public SportsVehicle(String modelNumber, Long engineTypeId, String enginePower, String tierSize, String turbo, int visitor) {
        super(modelNumber, EngineType.get(engineTypeId), enginePower, tierSize, visitor);
        this.turbo = turbo;
    }


    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }
}
