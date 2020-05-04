package Controllers;

import Models.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class MainController {
    public static void displayMainMenu() throws IOException {
        System.out.print("Select from Menu:\n" +
                "1.\tAdd New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tBooking Movie Ticket 4D\n" +
                "8.\tFind Employee\n" +
                "9.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int chooseMainMenu = 0;
        try {
            chooseMainMenu = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Vui lòng chọn đúng menu");
        }

        performMainMenu(chooseMainMenu);

    }

    public static void performMainMenu(int choose) throws IOException {
        switch (choose) {
            case 1: {
                addNewServicesMenu();
                break;
            }
            case 2: {
                showServiceMenu();
                break;
            }
            case 3: {
                addNewCustomer();
                break;
            }
            case 4: {
                showInformationCustomer();
                break;
            }
            case 5: {
                addNewBooking();
                break;
            }
            case 6: {
                showInformationEmployee();
                break;
            }
            case 7: {
                bookingMovieTicket4D();
                break;
            }
            case 8: {
                findEmployee();
                break;
            }
            case 9: {
                System.out.println("Thoát chương trình");
                break;
            }
            case 0: {
                displayMainMenu();
                break;
            }
            default: {
                System.out.println("Vui lòng chọn đúng menu");
                displayMainMenu();
                break;
            }
        }
    }

    public static void addNewServicesMenu() throws IOException {
        System.out.print("Select from Menu:\n" +
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int chooseAddNewServicesMenu = 0;
        try {
            chooseAddNewServicesMenu = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Vui lòng chọn đúng menu");
        }
        performAddNewServicesMenu(chooseAddNewServicesMenu);
    }

    public static void performAddNewServicesMenu(int choose) throws IOException {
        switch (choose) {
            case 1: {
                ReadWriteFile.writeVilla(ServicesManage.newVilla());
                displayMainMenu();
                break;
            }
            case 2: {
                ReadWriteFile.writeHouse(ServicesManage.newHouse());
                displayMainMenu();
                break;
            }
            case 3: {
                ReadWriteFile.writeRoom(ServicesManage.newRoom());
                displayMainMenu();
                break;
            }
            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.out.println("Thoát khỏi chương trình");
                break;
            }
            case 0: {
                addNewServicesMenu();
                break;
            }
            default: {
                System.out.println("Vui lòng chọn đúng menu");
                addNewServicesMenu();
                break;
            }
        }
    }

    public static void showServiceMenu() throws IOException {
        System.out.print("Select from Menu:\n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int chooseShowServicesMenu = 0;
        try {
            chooseShowServicesMenu = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Vui lòng chọn đúng menu");
        }
        performShowServicesMenu(chooseShowServicesMenu);
    }

    public static void performShowServicesMenu(int choose) throws IOException {
        switch (choose) {
            case 1: {
                showAllVilla();
                break;
            }
            case 2: {
                showAllHouse();
                break;
            }
            case 3: {
                showAllRoom();
                break;
            }
            case 4: {
                showAllVillaNotDuplicate();
                displayMainMenu();
                break;
            }
            case 5: {
                showAllHouseNotDuplicate();
                displayMainMenu();
                break;
            }
            case 6: {
                showAllRoomNotDuplicate();
                displayMainMenu();
                break;
            }
            case 7: {
                displayMainMenu();
                break;
            }
            case 8: {
                System.out.println("Thoát chương trình");
                break;
            }
            case 0: {
                showServiceMenu();
                break;
            }
            default: {
                System.out.println("Vui lòng chọn đúng menu");
                showServiceMenu();
                break;
            }
        }
    }

    public static void showAllVilla() throws IOException {
        ReadWriteFile.loadVilla();
        if (ReadWriteFile.villas.size() == 0) {
            System.out.println("No data for display");
            showServiceMenu();
        } else
            for (Villa villa : ReadWriteFile.villas) {
                villa.showInfo();
                System.out.println("----------------------------");
            }
        showServiceMenu();
    }

    public static void showAllHouse() throws IOException {
        ReadWriteFile.loadHouse();
        if (ReadWriteFile.houses.size() == 0) {
            System.out.println("No data for display");
            showServiceMenu();
        } else
            for (House house : ReadWriteFile.houses) {
                house.showInfo();
                System.out.println("----------------------------");
            }
        showServiceMenu();
    }

    public static void showAllRoom() throws IOException {
        ReadWriteFile.loadRoom();
        if (ReadWriteFile.rooms.size() == 0) {
            System.out.println("No data for display");
            showServiceMenu();
        } else
            for (Room room : ReadWriteFile.rooms) {
                room.showInfo();
                System.out.println("----------------------------");
            }
        showServiceMenu();
    }

    public static void showAllVillaNotDuplicate() throws FileNotFoundException {
        ReadWriteFile.loadVilla();
        if (ReadWriteFile.villas.size() == 0) {
            System.out.println("No data for display!");
            return;
        }
        TreeSet<String> villaNotDuplicate = new TreeSet<>();
        for (Villa villa : ReadWriteFile.villas) {
            villaNotDuplicate.add(villa.getNameService());
        }
        System.out.println("All Name Villa Not duplicate:");
        int index = 1;
        for (String s : villaNotDuplicate) {
            System.out.println(index + ". " + s);
            index++;
        }
        System.out.println("---------------------------------");

    }


    public static void showAllHouseNotDuplicate() throws FileNotFoundException {
        ReadWriteFile.loadHouse();
        if (ReadWriteFile.houses.size() == 0) {
            System.out.println("No data for display!");
            return;
        }
        TreeSet<String> houseNotDuplicate = new TreeSet<>();
        for (House house : ReadWriteFile.houses) {
            houseNotDuplicate.add(house.getNameService());
        }
        System.out.println("All Name House Not duplicate:");
        int index = 1;
        for (String s : houseNotDuplicate) {
            System.out.println(index + ". " + s);
            index++;
        }
        System.out.println("---------------------------------");

    }

    public static void showAllRoomNotDuplicate() throws FileNotFoundException {
        ReadWriteFile.loadRoom();
        if (ReadWriteFile.rooms.size() == 0) {
            System.out.println("No data for display!");
            return;
        }
        TreeSet<String> roomNotDuplicate = new TreeSet<>();
        for (Room room : ReadWriteFile.rooms) {
            roomNotDuplicate.add(room.getNameService());
        }
        System.out.println("All Name Room Not duplicate:");
        int index = 1;
        for (String s : roomNotDuplicate) {
            System.out.println(index + ". " + s);
            index++;
        }
        System.out.println("---------------------------------");

    }

    public static void addNewCustomer() throws IOException {
        ReadWriteFile.writeCustomer(CustomerManage.addNewCustomer());
        displayMainMenu();
    }


    public static void showInformationCustomer() throws IOException {
        ReadWriteFile.loadCustomer();
        if (ReadWriteFile.customers.size() == 0) {
            System.out.println("No data for display");
            showServiceMenu();
        } else
            ReadWriteFile.customers.sort(Comparator.comparing(o -> ((Customer) o).getName()).thenComparing(o -> ((Customer) o).getBirthday().substring(6)));

        for (Customer customer : ReadWriteFile.customers) {
            customer.showInfo();
            System.out.println("----------------------------");
        }
        displayMainMenu();
    }

    public static void addNewBooking() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int chooseCustomerBooking = 0;

        do {
            displayCustomerNameList();
            System.out.print("Chọn khách hàng để booking:");
            try {
                chooseCustomerBooking = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if ((chooseCustomerBooking < 1) | (chooseCustomerBooking > ReadWriteFile.customers.size())) {
                System.out.println("Vui lòng chọn khách hàng có trong danh sách!");
            }
        }
        while ((chooseCustomerBooking < 1) | (chooseCustomerBooking > ReadWriteFile.customers.size()));

        int chooseTypeServiceBooking = 0;
        do {
            displayServiceForBookingMenu();
            System.out.print("Select service for booking:");
            try {
                chooseTypeServiceBooking = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if ((chooseTypeServiceBooking < 1) | (chooseTypeServiceBooking > 3)) {
                System.out.println("Vui lòng chọn service trong danh sách!");
            }
        } while ((chooseTypeServiceBooking < 1) | (chooseTypeServiceBooking > 3));
        Services chooseServiceBooking = confirmServiceBooking(chooseTypeServiceBooking);
        ReadWriteFile.writeBooking(ReadWriteFile.customers.get(chooseCustomerBooking - 1), chooseServiceBooking);
        System.out.println("Booking fof Customer successfully!");
        displayMainMenu();


    }

    public static void displayCustomerNameList() throws IOException {
        ReadWriteFile.loadCustomer();
        if (ReadWriteFile.customers.size() == 0) {
            System.out.println("No Customer for booking! please add new Customer!");
            showServiceMenu();
        } else
            ReadWriteFile.customers.sort(Comparator.comparing(o -> ((Customer) o).getName()).thenComparing(o -> ((Customer) o).getBirthday().substring(6)));
        int index = 1;
        System.out.println("Danh sách khách hàng hiện có:");
        for (Customer customer : ReadWriteFile.customers) {
            System.out.printf(index + ". %-15s - ID: " + customer.getId(), customer.getName());
            System.out.println();
            index++;
        }
        System.out.println("----------------------------");

    }

    public static void displayServiceForBookingMenu() {
        System.out.print("Service booking Menu:\n" +
                "1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");

    }

    public static Services confirmServiceBooking(int typeofService) throws IOException {
        int chooose = 0;
        switch (typeofService) {
            case 1: {
                do {
                    displayVillaNameList();
                    System.out.printf("Chọn Villa có trong danh sách để Booking:");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        chooose = scanner.nextInt();
                    } catch (Exception e) {
                        scanner.nextLine();
                    }
                } while (chooose < 1 | chooose > ReadWriteFile.villas.size());
                return ReadWriteFile.villas.get(chooose - 1);
            }
            case 2: {
                do {
                    displayHouseNameList();
                    System.out.printf("Chọn House có trong danh sách để Booking:");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        chooose = scanner.nextInt();
                    } catch (Exception e) {
                        scanner.nextLine();
                    }
                } while (chooose < 1 | chooose > ReadWriteFile.houses.size());
                return ReadWriteFile.houses.get(chooose - 1);

            }
            default: {
                do {
                    displayRoomNameList();
                    System.out.printf("Chọn Room có trong danh sách để Booking:");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        chooose = scanner.nextInt();
                    } catch (Exception e) {
                        scanner.nextLine();
                    }
                } while (chooose < 1 | chooose > ReadWriteFile.rooms.size());
                return ReadWriteFile.rooms.get(chooose - 1);
            }
        }

    }

    public static void displayVillaNameList() throws IOException {
        ReadWriteFile.loadVilla();
        if (ReadWriteFile.villas.size() == 0) {
            System.out.println("No Villa for booking! please add new Villa!");
            showServiceMenu();
        } else
            ReadWriteFile.villas.sort(Comparator.comparing(o -> ((Villa) o).getId()).thenComparing(o -> ((Villa) o).getNameService()));
        int index = 1;
        System.out.println("Danh sách Villa hiện có:");
        for (Villa villa : ReadWriteFile.villas) {
            System.out.printf(index + ". %-10s - Name: " + villa.getNameService(), villa.getId());
            System.out.println();
            index++;
        }
        System.out.println("----------------------------");

    }

    public static void displayHouseNameList() throws IOException {
        ReadWriteFile.loadHouse();
        if (ReadWriteFile.houses.size() == 0) {
            System.out.println("No House for booking! please add new House!");
            showServiceMenu();
        } else
            ReadWriteFile.houses.sort(Comparator.comparing(o -> ((House) o).getId()).thenComparing(o -> ((House) o).getNameService()));
        int index = 1;
        System.out.println("Danh sách House hiện có:");
        for (House house : ReadWriteFile.houses) {
            System.out.printf(index + ". %-10s - Name: " + house.getNameService(), house.getId());
            System.out.println();
            index++;
        }
        System.out.println("----------------------------");

    }

    public static void displayRoomNameList() throws IOException {
        ReadWriteFile.loadRoom();
        if (ReadWriteFile.rooms.size() == 0) {
            System.out.println("No Room for booking! please add new Room!");
            showServiceMenu();
        } else
            ReadWriteFile.rooms.sort(Comparator.comparing(o -> ((Room) o).getId()).thenComparing(o -> ((Room) o).getNameService()));
        int index = 1;
        System.out.println("Danh sách Room hiện có:");
        for (Room room : ReadWriteFile.rooms) {
            System.out.printf(index + ". %-10s - Name: " + room.getNameService(), room.getId());
            System.out.println();
            index++;
        }
        System.out.println("----------------------------");

    }

    public static void showInformationEmployee() throws IOException {
        ReadWriteFile.loadEmployee();
        EmployeeManage.createEmployeeMap();
        EmployeeManage.showEmployee();
        displayMainMenu();
    }

    public static void bookingMovieTicket4D() throws IOException {
        displaybBokingMovieTicket4DMenu();

    }

    private static void displaybBokingMovieTicket4DMenu() throws IOException {
        System.out.println("Menu booking Movie Ticket 4D:\n" +
                "1. Booking Ticket\n" +
                "2. Show Ticket Selled\n" +
                "3. Back to Main menu"
        );
        Scanner scanner=new Scanner(System.in);
        String choose= scanner.nextLine();
        confirmBookingTicket4D(choose);
    }

    private static void confirmBookingTicket4D(String choose) throws IOException {
        switch (choose) {
            case "1":{
                bookingTicket4D();
                break;
            }
            case "2":{
                showTicketShelled();
                break;
            }
            case "3":{
                displayMainMenu();
                break;
            }
            default: {
                displaybBokingMovieTicket4DMenu();
                break;
            }
        }
    }

    private static void showTicketShelled() {
    }

    private static void bookingTicket4D() throws IOException {
        displayCustomerNameList();
    }

    public static void findEmployee() {

    }


}



