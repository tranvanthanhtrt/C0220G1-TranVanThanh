package Controllers;

import Models.Services;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteObjectFile {
    public static void writeService(ArrayList<Services> services, String typeOfService) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\codegym\\module2\\CaseStudy\\src\\Data/" + typeOfService + ".csv"));
            oos.writeObject(services);
            System.out.println("Success...");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oos.close();
        }
    }

    public static ArrayList<Services> loadService(String typeOfService) throws IOException {
        ObjectInputStream ois = null;
        ArrayList<Services> services = new ArrayList<Services>();
        File file = new File("D:\\codegym\\module2\\CaseStudy\\src\\Data/" + typeOfService + ".csv");
        if (file.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                services = (ArrayList<Services>) ois.readObject();
               
            }catch (ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
             finally {
                ois.close();
            }
            return services;
        }
        return services;
    }


}


