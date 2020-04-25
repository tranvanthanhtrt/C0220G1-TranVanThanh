package Controllers;

import Models.House;
import Models.Room;
import Models.Villa;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class ServicesManage {
    public static Villa newVilla() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.print("Input Id (Ex:SVVL-1234,..):");
            id = scanner.nextLine();
            if (!validateVillaId(id)) {
                System.out.println("Format mismatch! Try again!");
            }
            if(isExistedVillaID(id)){
                System.out.println("ID already exists, try another !");
                id="";
            }
        }
        while (!validateVillaId(id));
        String nameService;
        do {
            System.out.print("Input name service (viết hoa chữ cái đầu tiên) :");
            nameService = scanner.nextLine();
            if (!validateNameService(nameService)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateNameService(nameService));
        float areaUsed = 0;
        do {
            System.out.print("Input area used (>30):");
            try {
                areaUsed = scanner.nextFloat();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateArea(areaUsed)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateArea(areaUsed));

        int rentalCost = 0;
        do {
            System.out.print("Input rental Cost(>0) :");
            try {
                rentalCost = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateRentalCost(rentalCost)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateRentalCost(rentalCost));
        int maxRenter = 0;
        do {
            System.out.print("Input max Renter (0<maxRenter<20):");
            try {
                maxRenter = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateMaxRenter(maxRenter)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateMaxRenter(maxRenter));
        scanner.nextLine();

        String typeOfRent;
        do {
            System.out.print("Input type Of Rent(Year|Month|Day|Hour) :");
            typeOfRent = scanner.nextLine();
            if (!validateTypeOfRent(typeOfRent)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateTypeOfRent(typeOfRent));
        String standarOfRoom;
        do {
            System.out.print("Input standar Of Room (viết hoa chữ cái đầu):");
            standarOfRoom = scanner.nextLine();
            if (!validateStandarOfRoom(standarOfRoom)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateStandarOfRoom(standarOfRoom));

        System.out.print("Input describeOtherConvenient :");
        String describeOtherConvenient = scanner.nextLine();

        float areaOfPool = 0;
        do {
            System.out.print("Input area Of Pool(>30) :");
            try {
                areaOfPool = scanner.nextFloat();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateArea(areaOfPool)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateArea(areaOfPool));
        int level = 0;
        do {
            System.out.print("Input level(>0) :");
            try {
                level = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateLevel(level)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateLevel(level));

        return new Villa(id, nameService, areaUsed, rentalCost, maxRenter, typeOfRent, standarOfRoom, describeOtherConvenient, areaOfPool, level);
    }

    public static House newHouse() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.print("Input Id (Ex:SVHO-1234,..):");
            id = scanner.nextLine();
            if (!validateHouseId(id)) {
                System.out.println("Format mismatch! Try again!");
            }
            if(isExistedHouseID(id)){
                System.out.println("ID already exists, try another !");
                id="";
            }
        }
        while (!validateHouseId(id));
        String nameService;
        do {
            System.out.print("Input name service (viết hoa chữ cái đầu tiên) :");
            nameService = scanner.nextLine();
            if (!validateNameService(nameService)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateNameService(nameService));
        float areaUsed = 0;
        do {
            System.out.print("Input area used (>30):");
            try {
                areaUsed = scanner.nextFloat();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateArea(areaUsed)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateArea(areaUsed));

        int rentalCost = 0;
        do {
            System.out.print("Input rental Cost(>0) :");
            try {
                rentalCost = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateRentalCost(rentalCost)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateRentalCost(rentalCost));
        int maxRenter = 0;
        do {
            System.out.print("Input max Renter (0<maxRenter<20):");
            try {
                maxRenter = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateMaxRenter(maxRenter)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateMaxRenter(maxRenter));
        scanner.nextLine();

        String typeOfRent;
        do {
            System.out.print("Input type Of Rent(Year|Month|Day|Hour) :");
            typeOfRent = scanner.nextLine();
            if (!validateTypeOfRent(typeOfRent)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateTypeOfRent(typeOfRent));
        String standarOfRoom;
        do {
            System.out.print("Input standar Of Room (viết hoa chữ cái đầu):");
            standarOfRoom = scanner.nextLine();
            if (!validateStandarOfRoom(standarOfRoom)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateStandarOfRoom(standarOfRoom));

        System.out.print("Input describeOtherConvenient :");
        String describeOtherConvenient = scanner.nextLine();
        int level = 0;
        do {
            System.out.print("Input level(>0) :");
            try {
                level = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateLevel(level)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateLevel(level));

        return new House(id, nameService, areaUsed, rentalCost, maxRenter, typeOfRent, standarOfRoom, describeOtherConvenient, level);
    }

    public static Room newRoom() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.print("Input Id (Ex:SVRO-1234,..):");
            id = scanner.nextLine();
            if (!validateRoomId(id)) {
                System.out.println("Format mismatch! Try again!");
            }
            if(isExistedRoomID(id)){
                System.out.println("ID already exists, try another !");
                id="";
            }
        }
        while (!validateRoomId(id));
        String nameService;
        do {
            System.out.print("Input name service (viết hoa chữ cái đầu tiên) :");
            nameService = scanner.nextLine();
            if (!validateNameService(nameService)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateNameService(nameService));
        float areaUsed = 0;
        do {
            System.out.print("Input area used (>30):");
            try {
                areaUsed = scanner.nextFloat();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateArea(areaUsed)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateArea(areaUsed));

        int rentalCost = 0;
        do {
            System.out.print("Input rental Cost(>0) :");
            try {
                rentalCost = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (!validateRentalCost(rentalCost)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        } while (!validateRentalCost(rentalCost));
        int maxRenter = 0;
        do {
            System.out.print("Input max Renter (0<maxRenter<20):");
            try {
                maxRenter = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
                if (!validateMaxRenter(maxRenter)) {
                    System.out.println("Format mismatch! Try again!");
                } ;
        } while (!validateMaxRenter(maxRenter));
        scanner.nextLine();

        String typeOfRent;
        do {
            System.out.print("Input type Of Rent(Year|Month|Day|Hour) :");
            typeOfRent = scanner.nextLine();
            if (!validateTypeOfRent(typeOfRent)) {
                System.out.println("Format mismatch! Try again!");
            }
            ;
        }
        while (!validateTypeOfRent(typeOfRent));
        System.out.print("Input free Service Attached:");
        String freeServiceAttached = scanner.nextLine();

        return new Room(id, nameService, areaUsed, rentalCost, maxRenter, typeOfRent, freeServiceAttached);
    }

    public static boolean isExistedVillaID(String id) throws FileNotFoundException {
        ReadWriteFile.loadVilla();
        for (Villa villa : ReadWriteFile.villas) {
            if (villa.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExistedHouseID(String id) throws FileNotFoundException {
        ReadWriteFile.loadHouse();
        for (House house : ReadWriteFile.houses) {
            if (house.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExistedRoomID(String id) throws FileNotFoundException {
        ReadWriteFile.loadRoom();
        for (Room room : ReadWriteFile.rooms) {
            if (room.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateVillaId(String id) {
        String ID_PATTERN = "^SVVL-\\d{4}$";
        return Pattern.matches(ID_PATTERN, id);
    }

    public static boolean validateHouseId(String id) {
        String ID_PATTERN = "^SVHO-\\d{4}$";
        return Pattern.matches(ID_PATTERN, id);
    }

    public static boolean validateRoomId(String id) {
        String ID_PATTERN = "^SVRO-\\d{4}$";
        return Pattern.matches(ID_PATTERN, id);
    }

    public static boolean validateNameService(String service) {
        String PATTERN = "^[A-Z][0-9 a-z]+";
        return Pattern.matches(PATTERN, service);
    }

    public static boolean validateArea(float area) {
        return (area > 30.0);
    }

    public static boolean validateRentalCost(int value) {
        return (value > 0);
    }

    public static boolean validateMaxRenter(int value) {
        return (value > 0) & (value < 20);
    }

    public static boolean validateAccompaniedService(String service) {
        String PATTERN = "^massage|karaoke|food|drink|car";
        return Pattern.matches(PATTERN, service);
    }

    public static boolean validateLevel(int value) {
        return (value > 0);
    }

    public static boolean validateTypeOfRent(String value) {
        String PATTERN = "^Year|Month|Day|Hour";
        return Pattern.matches(PATTERN, value);
    }

    public static boolean validateStandarOfRoom(String value) {
        String PATTERN = "^[A-Z][0-9 a-z]+";
        return Pattern.matches(PATTERN, value);
    }


}
