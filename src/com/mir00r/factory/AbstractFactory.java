package com.mir00r.factory;

import com.mir00r.vehicles.Vehicle;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public abstract class AbstractFactory {
    public abstract Vehicle getVehicle(Long vehicleType, String modelNumber, Long engineTypeId, String enginePower, String tierSize, String turbo, double heavy, int visitor);
}
