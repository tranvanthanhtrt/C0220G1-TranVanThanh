package Models;

public class Room extends Services {
    private String freeServiceAttached;

    public Room() {
    }

    public Room(String id, String nameService, float areaUsed, int rentalCost, int maxRenter, String typeOfRent, String freeServiceAttached) {
        super(areaUsed, rentalCost, maxRenter, typeOfRent);
        this.id = id;
        this.nameService = nameService;
        this.freeServiceAttached = freeServiceAttached;
    }

    public String getFreeServiceAttached() {
        return freeServiceAttached;
    }

    public void setFreeServiceAttached(String freeServiceAttached) {
        this.freeServiceAttached = freeServiceAttached;
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
                + "Free service attached: " + this.freeServiceAttached
        );
    }
}
