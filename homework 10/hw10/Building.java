/**
 * The class that is a building and implements the interface
 * 
 * @author Danya Nasr
 * Assignment: 10 (Gathered from 9)
 */
package hw10;

public class Building implements CarbonFootprint{
    private int noOfOccupants;
    private double electricBill;
    private double gasBill;
    private double oilBill;
    
    /**
     * @param noOfOccupants
     * @param electricBill
     * @param gasBill
     * @param oilBill 
     */
    public Building(int noOfOccupants, double electricBill, double gasBill, double oilBill) {
        this.noOfOccupants = noOfOccupants;
        this.electricBill = electricBill;
        this.gasBill = gasBill;
        this.oilBill = oilBill;
    }
    
    //added new constructor just for the GUI
    public Building(double electricBill, double gasBill, double oilBill) {
        this.electricBill = electricBill;
        this.gasBill = gasBill;
        this.oilBill = oilBill;
    }
     
    public int getNoOfOccupants() {
        return noOfOccupants;
    }

    public void setNoOfOccupants(int noOfOccupants) {
        this.noOfOccupants = noOfOccupants;
    }
    

    public double getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(double electricBill) {
        this.electricBill = electricBill;
    }

    public double getGasBill() {
        return gasBill;
    }

    public void setGasBill(double gasBill) {
        this.gasBill = gasBill;
    }

    public double getOilBill() {
        return oilBill;
    }

    public void setOilBill(double oilBill) {
        this.oilBill = oilBill;
    }
    
    //method to calculate and return the carbon foot print
    public double getCarbonFootprint() {
        double electricEmission = electricBill * 105;
        double gasEmission = gasBill * 105;
        double oilEmission = oilBill * 113;
        
        return electricEmission * gasEmission * oilEmission;
    }

    @Override
    public String toString() {
        return "Building with " + "noOfOccupants = "  + noOfOccupants + "\nand, electricBill = " + electricBill + 
                ", gasBill = " + gasBill + ", oilBill = " + oilBill;
    }

   
    
}
