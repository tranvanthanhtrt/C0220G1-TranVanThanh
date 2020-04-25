package Models;

import com.opencsv.bean.CsvBindByPosition;

public class Villa extends Services {

    private String standarOfRoom;

    private String describeOtherConvenient;

    private float areaOfPool;

    private int level;

    public Villa() {
        super();
    }

    public Villa(String id, String nameService, float areaUsed, int rentalCost, int maxRenter, String typeOfRent, String standarOfRoom, String describeOtherConvenient, float areaOfPool, int level) {
        super(areaUsed, rentalCost, maxRenter, typeOfRent);
        this.id = id;
        this.nameService = nameService;
        this.standarOfRoom = standarOfRoom;
        this.describeOtherConvenient = describeOtherConvenient;
        this.areaOfPool = areaOfPool;
        this.level = level;
    }


    public String getStandarOfRoom() {
        return standarOfRoom;
    }

    public void setStandarOfRoom(String standarOfRoom) {
        this.standarOfRoom = standarOfRoom;
    }

    public String getDescribeOtherConvenient() {
        return describeOtherConvenient;
    }

    public void setDescribeOtherConvenient(String describeOtherConvenient) {
        this.describeOtherConvenient = describeOtherConvenient;
    }

    public float getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(float areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public void showInfo() {
        System.out.println("Service infomation:" + "\n"
                + "Id: " + this.id + "\n"
                + "Name Service: " + this.nameService + "\n"
                + "Area Used: " + this.areaUsed + "\n"
                + "Rental Cost: " + this.rentalCost + "\n"
                + "Max Renter: " + this.maxRenter + "\n"
                + "Type Of Rent: " + this.typeOfRent + "\n"
                + "Standar Of Room: " + this.standarOfRoom + "\n"
                + "Other Convenient: " + this.describeOtherConvenient + "\n"
                + "Area of Pool: " + this.areaOfPool + "\n"
                + "Level: " + this.level
        );

    }
}
