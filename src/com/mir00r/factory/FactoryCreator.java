package com.mir00r.factory;

import com.mir00r.enums.Factory;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.contains(Factory.VEHICLE.getValue())) {
            return new VehicleFactory();
        }
        return null;
    }
}
