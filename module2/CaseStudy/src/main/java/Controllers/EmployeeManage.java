package Controllers;

import Models.Employer;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManage {
    public static Map<String, String> mapEmployee = new HashMap<String, String>();
    public static void createEmployeeMap(){
        for (Employer employer : ReadWriteFile.employers) {
            mapEmployee.put(employer.getId(),employer.getName());
        }

    }
    public static void showEmployee(){
        System.out.println("Danh sách Nhân viên:");
        for (Map.Entry<String, String> entry : mapEmployee.entrySet()) {
            System.out.println("Key: "+entry.getKey() + " - Name: " + entry.getValue());
        }
        System.out.println("---------------------------------");
    }
}
