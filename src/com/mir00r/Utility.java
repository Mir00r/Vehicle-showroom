package com.mir00r;

import com.mir00r.enums.EngineType;
import com.mir00r.enums.VehicleType;

import java.util.Scanner;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class Utility {
    public static Long getEngineTypeId(Long vehicleType) {
        if (vehicleType.equals(VehicleType.SPORTS.getKey())) {
            return EngineType.OIL.getKey();
        } else if (vehicleType.equals(VehicleType.HEAVY.getKey())) {
            return EngineType.DIESEL.getKey();
        }
        return null;
    }

    public static long getEngineTypeInput(Scanner input) {
        System.out.println("Enter the vehicle engine type number: ");
        for (EngineType type : EngineType.values()) {
            System.out.println("Id -> " + type.getKey() + " Name ->" + type.getValue());
        }
        return input.nextLong();
    }

    public static boolean validateEngineInput(Long engineTypeId) {
        return EngineType.validate(engineTypeId);
    }

    public static long getVehicleTypeInput(Scanner input) {
        System.out.println("Enter the id of vehicle type: ");
        for (VehicleType type : VehicleType.values()) {
            System.out.println("Id -> " + type.getKey() + " Name -> " + type.getValue());
        }
        return input.nextLong();
    }

    public static boolean validateVehicleInput(Long vehicleTypeId) {
        return VehicleType.validate(vehicleTypeId);
    }
}
