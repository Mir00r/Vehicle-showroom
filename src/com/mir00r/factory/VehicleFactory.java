package com.mir00r.factory;

import com.mir00r.enums.VehicleType;
import com.mir00r.vehicles.HeavyVehicle;
import com.mir00r.vehicles.NormalVehicle;
import com.mir00r.vehicles.SportsVehicle;
import com.mir00r.vehicles.Vehicle;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class VehicleFactory extends AbstractFactory {
    @Override
    public Vehicle getVehicle(Long vehicleType, String modelNumber, Long engineTypeId, String enginePower, String tierSize, String turbo, double weight, int visitor) {
        if (vehicleType.equals(VehicleType.NORMAL.getKey())) {
            return new NormalVehicle(modelNumber, engineTypeId, enginePower, tierSize, visitor);
        } else if (vehicleType.equals(VehicleType.SPORTS.getKey())) {
            return new SportsVehicle(modelNumber, engineTypeId, enginePower, tierSize, turbo, visitor);
        } else if (vehicleType.equals(VehicleType.HEAVY.getKey())) {
            return new HeavyVehicle(modelNumber, engineTypeId, enginePower, tierSize, weight, visitor);
        }
        return null;
    }
}
