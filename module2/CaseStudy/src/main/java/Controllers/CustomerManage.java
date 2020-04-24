package Controllers;

import Models.Customer;
import Models.Villa;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class CustomerManage {
        public static Customer addNewCustomer() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.print("Input Name of customer: ");
            name = scanner.nextLine();

        }
        while (!validateCustomerName(name));
        String birthday;
        do {
            System.out.print("Input birthday (dd/mm/yyyy): ");
            birthday = scanner.nextLine();

        }
        while (!validateBirthDay(birthday));
        String gender;
        do {
            System.out.print("Input gender of customer: ");
            gender = scanner.nextLine();
            gender=gender.substring(0,1).toUpperCase()+gender.substring(1).toLowerCase();

        }
        while (!validateGender(gender));
        String id;
        do {
            System.out.print("Input Id of customer (xxx xxx xxx): ");
            id = scanner.nextLine();
            if(isExistedCustomerId(id)){
                System.out.println("Customer ID already exists, try another !");
                id="";
            }
        }
        while (!validateId(id));

        System.out.print("Input phone number of customer: ");
        String phoneNumber = scanner.nextLine();

        String email;
        do {
            System.out.print("Input email (abc@abc.abc): ");
            email = scanner.nextLine();

        }
        while (!validateEmail(email));

        System.out.print("Input type of customer: ");
        String typeOfCustomer = scanner.nextLine();
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        return new Customer(name, birthday, gender, id, phoneNumber, email, typeOfCustomer, address);
    }

    public static boolean validateCustomerName(String value) {
        String PATTERN = "([A-Z][a-z]+\\s)*([A-Z][a-z]+)$";
        if (!Pattern.matches(PATTERN, value)) {
            System.out.println("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String value) {
        String PATTERN = "[a-z 1-9]+@[a-z 1-9]+[.]([a-z 1-9]+)$";
        if (!Pattern.matches(PATTERN, value)) {
            System.out.println("Email phải đúng định dạng abc@abc.abc");
            return false;
        }
        return true;
    }

    public static boolean validateGender(String value) {
        value=value.toLowerCase();
        String PATTERN = "male|female|unknown";
        if (!Pattern.matches(PATTERN, value)) {
            System.out.println("Gender phải là Male hoặc Female hoặc Unknown!");
            return false;
        }
        return true;
    }

    public static boolean validateId(String value) {
        String PATTERN = "[\\d]{3}\\s[\\d]{3}\\s([\\d]{3})$";
        if (!Pattern.matches(PATTERN, value)) {
            System.out.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX !");
        }
        return Pattern.matches(PATTERN, value);
    }

    public static boolean validateBirthDay(String value) {
        String PATTERN = "\\d{2}/\\d{2}/\\d{4}";
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int year = cal.get(Calendar.YEAR);
        if (!Pattern.matches(PATTERN, value)) {
            return false;
        }
        boolean isValidateBirthday = (year - Integer.parseInt(value.substring(6)) > 18) & (Integer.parseInt(value.substring(6)) > 1900);
        if (!isValidateBirthday) {
            System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
            return false;
        }
        return true;
    }
    public static boolean isExistedCustomerId(String id) throws FileNotFoundException {
        ReadWriteFile.loadCustomer();
        for (Customer customer : ReadWriteFile.customers) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
