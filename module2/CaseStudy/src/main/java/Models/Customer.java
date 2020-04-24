package Models;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;
    private String typeOfCustomer;
    private String address;
    private Services typeOfService;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String id, String phoneNumber, String email, String typeOfCustomer, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phonNumber) {
        this.phoneNumber = phonNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(Services typeOfService) {
        this.typeOfService = typeOfService;
    }

    public void showInfo() {
        System.out.print("Customer infomation:" + "\n"
                + "Name: " + this.name + "\n"
                + "Birthday: " + this.birthday + "\n"
                + "Gender: " + this.gender + "\n"
                + "Id: " + this.id + "\n"
                + "Phone number: " + this.phoneNumber + "\n"
                + "Email: " + this.email + "\n"
                + "Type of customer: " + this.id + "\n"
                + "Address: " + this.address + "\n"

        );
    }
}
