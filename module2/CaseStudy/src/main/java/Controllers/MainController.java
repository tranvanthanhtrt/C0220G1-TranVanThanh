package Controllers;

import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                break;
            }
            case 5: {
                showAllHouseNotDuplicate();
                break;
            }
            case 6: {
                showAllRoomNotDuplicate();
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

    public static void showAllVillaNotDuplicate() {

    }

    public static void showAllHouseNotDuplicate() {

    }

    public static void showAllRoomNotDuplicate() {

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

        confirmChooseCustomerForBooking(chooseCustomerBooking, chooseTypeServiceBooking);

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
            System.out.printf(index + ". %-10s - Name: " + villa.getNameService(),villa.getId() );
            System.out.println();
            index++;
        }
        System.out.println("----------------------------");

    }
    public static void confirmChooseCustomerForBooking(int chooseCustomer, int chooseService) {
        for (int i = 0; i < ReadWriteFile.customers.size(); i++) {
            if (i+1 == chooseCustomer) {
                booking(chooseCustomer, chooseService);
            }
        }
    }
    public static void confirmChooseTypeServiceForBooking(int chooseTypeServiceBooking) throws IOException {
        switch (chooseTypeServiceBooking){
            case 1:{
                displayVillaNameList();
            }
        }

    }

    private static void booking(int chooseCustomer, int chooseService) {

    }


    public static void showInformationEmployee() {
    }

    public static void bookingMovieTicket4D() {
    }

    public static void findEmployee() {
    }


}



