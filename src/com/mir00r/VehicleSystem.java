package com.mir00r;

import com.mir00r.enums.Factory;
import com.mir00r.enums.VehicleType;
import com.mir00r.factory.AbstractFactory;
import com.mir00r.factory.FactoryCreator;
import com.mir00r.vehicles.HeavyVehicle;
import com.mir00r.vehicles.SportsVehicle;
import com.mir00r.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mir00r on 12/5/20
 * @project IntelliJ IDEA
 */
public class VehicleSystem {
    private List<Vehicle> vehicleList = new ArrayList<>();
    private int index = 0;

    public void run() {
        while (true) {
            System.out.println("\n**** Vehicle Showroom SYSTEM MENU ****\n");
            System.out.println("Add vehicle:            1");
            System.out.println("Delete vehicle:         2");
            System.out.println("Display All Vehicles:   3");
            System.out.println("Exit Program:           4");
            System.out.println("Enter your choice:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    this.add(); //Method used to add either vehicle
                    break;
                case 2:
                    this.delete(); //Method used to delete vehicle
                    break;
                case 3:
                    this.getDetails();  //Method used to get the details of added vehicle
                    break;
                case 4:
                    input.close(); //Closing the scanner if 4 is selected by the user
                    return;
            }
        }
    }

    private void add() {
        Scanner input = new Scanner(System.in);
        String modelNumber, enginePower, tierSize, turbo = null;
        int visitor = 30;

        System.out.println("Enter the vehicle model number: ");
        modelNumber = input.nextLine();

        System.out.println("Enter the vehicle engine power: ");
        enginePower = input.nextLine();

        System.out.println("Enter the vehicle tier size: ");
        tierSize = input.nextLine();

        Long vehicleTypeId = Utility.getVehicleTypeInput(input);
        while (!Utility.validateVehicleInput(vehicleTypeId)) {
            vehicleTypeId = Utility.getVehicleTypeInput(input);
        }

        Long engineTypeId = Utility.getEngineTypeId(vehicleTypeId);
        if (engineTypeId == null) {
            engineTypeId = Utility.getEngineTypeInput(input);
            while (!Utility.validateEngineInput(engineTypeId)) {
                engineTypeId = Utility.getEngineTypeInput(input);
            }
        }

        double heavy = 0.0;
        if (vehicleTypeId.equals(VehicleType.SPORTS.getKey())) {
            Scanner turboScanner = new Scanner(System.in);
            System.out.println("Enter the turbo of sports vehicle: ");
            turbo = turboScanner.nextLine();
            this.setVisitor(visitor);
        } else if (vehicleTypeId.equals(VehicleType.HEAVY.getKey())) {
            Scanner weightScanner = new Scanner(System.in);
            System.out.println("Enter the weight of heavy vehicle: ");
            heavy = weightScanner.nextDouble();
        }

        this.insertToList(vehicleTypeId, modelNumber, engineTypeId, enginePower, tierSize, turbo, heavy, visitor);
        System.out.println();
    }

    public void insertToList(Long vehicleTypeId, String modelNumber, Long engineTypeId, String enginePower, String tierSize, String turbo, double heavy, int visitor) {
        AbstractFactory vehicleFactory = FactoryCreator.getFactory(Factory.VEHICLE.getValue());
        assert vehicleFactory != null;
        Vehicle vehicle = vehicleFactory.getVehicle(vehicleTypeId, modelNumber, engineTypeId, enginePower, tierSize, turbo, heavy, visitor);
        if (vehicle != null) {
            vehicleList.add(index, vehicle);
            System.out.println("------------- Vehicle Added Successfully -------------");
            System.out.println("Vehicle Id - " + index + " Model Number - " + vehicle.getModelNumber() + " Engine type - " + vehicle.getEngineType() + " Engine Power - " + vehicle.getEnginePower() + " Tier Size - " + vehicle.getTierSize());
            index++;
            this.run();
        }
    }

    public void getDetails() {
        if (vehicleList.size() == 0) {
            System.out.println("There are no vehicles to display, please enter some vehicles and try again");
        } else {
            for (Vehicle vehicle : vehicleList) {
                System.out.println("\n-----------------------------------------");

                System.out.println("Id - " + vehicle.getId());
                System.out.println("Model Number - " + vehicle.getModelNumber());
                System.out.println("Engine type - " + vehicle.getEngineType());
                System.out.println("Engine Power - " + vehicle.getEnginePower());
                System.out.println("Tier Size - " + vehicle.getTierSize());
                System.out.println("Visitor - " + vehicle.getVisitor());
                if (vehicle instanceof SportsVehicle)
                    System.out.println("Turbo - " + ((SportsVehicle) vehicle).getTurbo());
                if (vehicle instanceof HeavyVehicle)
                    System.out.println("Weight - " + ((HeavyVehicle) vehicle).getWeight());
            }
        }
    }

    private void delete() {
        Scanner input = new Scanner(System.in);
        if (vehicleList.size() == 0) {
            System.out.println("There are no vehicles to delete, please enter some vehicles and try again");
        } else {
            this.getDetails();
            System.out.println("Enter the vehicle id: ");
            int indexId = input.nextInt();
            while (vehicleList.size() - 1 < indexId) {
                System.out.println("Please enter valid vehicle id: ");
                indexId = input.nextInt();
            }
            vehicleList.remove(indexId);
            System.out.println("------ Vehicle remove successfully -----");
            index = 0;
            this.getDetails();
            this.run();
        }
    }

    private int setVisitor(int visitor) {
        if (visitor == 30)
            return visitor + 20;
        else return visitor - 20;
    }
}
