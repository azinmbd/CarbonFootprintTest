/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Azinm
 */
import java.util.ArrayList;

interface CarbonFootprint {
    double getCarbonFootprint();
}

class Building implements CarbonFootprint {
    private final double squareFeet;
    private final boolean isGreenBuilding;
    
    public Building(double squareFeet, boolean isGreenBuilding) {
        this.squareFeet = squareFeet;
        this.isGreenBuilding = isGreenBuilding;
    }
    
    @Override
    public double getCarbonFootprint() {
        double footprint = 50; // default value for non-green buildings
        
        if (isGreenBuilding) {
            footprint = 10;
        }
        
        return footprint * squareFeet;
    }
    
    @Override
    public String toString() {
        return "Building with " + squareFeet + " square feet";
    }
}

class Car implements CarbonFootprint {
    private final String make;
    private final String model;
    private final int year;
    private final double milesPerGallon;
    private final double milesDriven;
    
    public Car(String make, String model, int year, double milesPerGallon, double milesDriven) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.milesPerGallon = milesPerGallon;
        this.milesDriven = milesDriven;
    }
    
    @Override
    public double getCarbonFootprint() {
        return (milesDriven / milesPerGallon) * 19.64; // 19.64 pounds of CO2 per gallon of gasoline
    }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

class Bicycle implements CarbonFootprint {
    private final String brand;
    
    public Bicycle(String brand, int weight) {
        this.brand = brand;
    }
    
    @Override
    public double getCarbonFootprint() {
        // Assuming the bicycle is used for transportation instead of driving a car
        return 0;
    }
    
    @Override
    public String toString() {
        return "Bicycle made by " + brand;
    }
}

public class CarbonFootprintTest {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> objects = new ArrayList<>();
        
        objects.add(new Building(5000, true));
        objects.add(new Car("Toyota", "Prius", 2020, 50, 10000));
        objects.add(new Bicycle("Trek", 20));
        
        for (CarbonFootprint object : objects) {
            System.out.println(object.toString());
            System.out.println("Carbon footprint: " + object.getCarbonFootprint() + " pounds of CO2 per year\n");
        }
    }
}