package Models;

import java.io.Serializable;

public class House extends Services {
    private String standarOfRoom;
    private String describeOtherConvenient;
    private int level;

    public House() {
    }

    public House(String id, String nameService, float areaUsed, int rentalCost, int maxRenter, String typeOfRent, String standarOfRoom, String describeOtherConvenient, int level) {
        super(areaUsed, rentalCost, maxRenter, typeOfRent);
        this.id = id;
        this.nameService = nameService;
        this.standarOfRoom = standarOfRoom;
        this.describeOtherConvenient = describeOtherConvenient;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "House[id=";
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
                + "Level: " + this.level
        );
    }
}
