package Models;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public abstract class Services {
    String id;
    String nameService;
    float areaUsed;
    int rentalCost;
    int maxRenter;
    String typeOfRent;

    public Services() {
    }

    public Services(float areaUsed, int rentalCost, int maxRenter, String typeOfRent) {


        this.areaUsed = areaUsed;
        this.rentalCost = rentalCost;
        this.maxRenter = maxRenter;
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(float areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxRenter() {
        return maxRenter;
    }

    public void setMaxRenter(int maxRenter) {
        this.maxRenter = maxRenter;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public abstract void showInfo();
}
