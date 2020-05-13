package com.mir00r.vehicles;

import com.mir00r.enums.EngineType;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class HeavyVehicle extends Vehicle {
    private double weight;

    public HeavyVehicle(String modelNumber, Long engineTypeId, String enginePower, String tierSize, double weight, int visitor) {
        super(modelNumber, EngineType.get(engineTypeId), enginePower, tierSize, visitor);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
