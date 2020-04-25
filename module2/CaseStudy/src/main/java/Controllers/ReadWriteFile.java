package Controllers;

import Models.*;

import java.awt.image.VolatileImage;
import java.io.*;
import java.util.ArrayList;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ReadWriteFile {
    static ArrayList<Villa> villas = new ArrayList<Villa>();
    static ArrayList<House> houses = new ArrayList<House>();
    static ArrayList<Room> rooms = new ArrayList<Room>();
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static String fileVilla = "D:\\codegym\\module2\\CaseStudy\\src\\main\\java\\Data\\Villa.csv";
    static String fileHouse = "D:\\codegym\\module2\\CaseStudy\\src\\main\\java\\Data\\House.csv";
    static String fileRoom = "D:\\codegym\\module2\\CaseStudy\\src\\main\\java\\Data\\Room.csv";
    static String fileCustomer = "D:\\codegym\\module2\\CaseStudy\\src\\main\\java\\Data\\Customer.csv";
    // the delimiter to use for separating entries
    static  final char DEFAULT_SEPARATOR = ',';
    // the character to use for quoted elements
    static  final char DEFAULT_QUOTE = '"';
    // the line number to skip for start reading
   static final int NUM_OF_LINE_SKIP = 0;
    public static void writeHouse(House house) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileHouse, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer,
                     CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(house.getId(), house.getNameService(), house.getAreaUsed(), house.getRentalCost(), house.getMaxRenter(), house.getTypeOfRent(), house.getStandarOfRoom(), house.getDescribeOtherConvenient(), house.getLevel());
            csvPrinter.flush();
        }

    }
    public static void writeVilla(Villa villa) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileVilla, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer,
                     CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(villa.getId(), villa.getNameService(), villa.getAreaUsed(), villa.getRentalCost(), villa.getMaxRenter(), villa.getTypeOfRent(), villa.getStandarOfRoom(), villa.getDescribeOtherConvenient(), villa.getAreaOfPool(), villa.getLevel());
            csvPrinter.flush();
        }

    }

    public static void writeRoom(Room room) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoom, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer,
                     CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(room.getId(), room.getNameService(), room.getAreaUsed(), room.getRentalCost(), room.getMaxRenter(), room.getTypeOfRent(), room.getFreeServiceAttached());
            csvPrinter.flush();
        }

    }
    public static void writeCustomer(Customer customer) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileCustomer, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer,
                     CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(customer.getName(),customer.getBirthday(),customer.getGender(),customer.getId(),customer.getPhoneNumber(),customer.getEmail(),customer.getTypeOfCustomer(),customer.getAddress());
            csvPrinter.flush();
        }

    }
public static void loadVilla() throws FileNotFoundException {
       if(!new File(fileVilla).exists()){
           return;
       }
    ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
    strategy.setType(Villa.class);
    String[] columns = new String[] { "id","nameService",  "areaUsed",  "rentalCost",  "maxRenter",  "typeOfRent", "standarOfRoom","describeOtherConvenient", "areaOfPool", "level"};
    strategy.setColumnMapping(columns);

    CsvToBean<Villa> csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(fileVilla))
            .withMappingStrategy(strategy)
            .withSeparator(DEFAULT_SEPARATOR)
            .withQuoteChar(DEFAULT_QUOTE)
            .withSkipLines(NUM_OF_LINE_SKIP)
            .withIgnoreLeadingWhiteSpace(true)
            .build();
    villas = (ArrayList<Villa>) csvToBean.parse();
}
    public static void loadHouse() throws FileNotFoundException {
        if(!new File(fileHouse).exists()){
            return;
        }
        ColumnPositionMappingStrategy<House> strategy1 = new ColumnPositionMappingStrategy<>();
        strategy1.setType(House.class);
        String[] columns = new String[] { "id","nameService",  "areaUsed",  "rentalCost",  "maxRenter",  "typeOfRent", "standarOfRoom","describeOtherConvenient", "level"};
        strategy1.setColumnMapping(columns);
        CsvToBean<House> csvToBean1 = new CsvToBeanBuilder<House>(new FileReader(fileHouse))
                .withMappingStrategy(strategy1)
                .withSeparator(DEFAULT_SEPARATOR)
                .withQuoteChar(DEFAULT_QUOTE)
                .withSkipLines(NUM_OF_LINE_SKIP)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        houses = (ArrayList<House>) csvToBean1.parse();

    }
    public static void loadRoom() throws FileNotFoundException {
        if(!new File(fileRoom).exists()){
            return;
        }
        ColumnPositionMappingStrategy<Room> strategy2 = new ColumnPositionMappingStrategy<>();
        strategy2.setType(Room.class);
        String[] columns = new String[] { "id","nameService",  "areaUsed",  "rentalCost",  "maxRenter",  "typeOfRent",  "freeServiceAttached" };
        strategy2.setColumnMapping(columns);

        CsvToBean<Room> csvToBean2 = new CsvToBeanBuilder<Room>(new FileReader(fileRoom))
                .withMappingStrategy(strategy2)
                .withSeparator(DEFAULT_SEPARATOR)
                .withQuoteChar(DEFAULT_QUOTE)
                .withSkipLines(NUM_OF_LINE_SKIP)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        rooms = (ArrayList<Room>) csvToBean2.parse();
           }
    public static void loadCustomer() throws FileNotFoundException {
        if(!new File(fileCustomer).exists()){
            return;
        }
        ColumnPositionMappingStrategy<Customer> strategy3 = new ColumnPositionMappingStrategy<>();
        strategy3.setType(Customer.class);
        String[] columns = new String[] {  "name",  "birthday",  "gender",  "id",  "phoneNumber",  "email",  "typeOfCustomer",  "address" };
        strategy3.setColumnMapping(columns);

        CsvToBean<Customer> csvToBean2 = new CsvToBeanBuilder<Customer>(new FileReader(fileCustomer))
                .withMappingStrategy(strategy3)
                .withSeparator(DEFAULT_SEPARATOR)
                .withQuoteChar(DEFAULT_QUOTE)
                .withSkipLines(NUM_OF_LINE_SKIP)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        customers = (ArrayList<Customer>) csvToBean2.parse();
    }
//    public static ArrayList<Room> loadRoom() {
//
//        try {
//            String path = "/media/oem/STUDY AND WORK/6. MODULE2/HoangNgocThach-C0220G1/1. JavaCore/src/CaseStudy/Data/Room.csv";
//            BufferedReader reader = Files.newBufferedReader(Paths.get(path));
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//            for (CSVRecord csvRecord : csvParser) {
//                String id = csvRecord.get(0);
//                String serviceName = csvRecord.get(1);
//                Float usedArea = Float.parseFloat(csvRecord.get(2));
//                int rentCost = Integer.parseInt(csvRecord.get(3));
//                int maxPeoples = Integer.parseInt(csvRecord.get(4));
//                String typeOfRent = csvRecord.get(5);
//                String freeServices = csvRecord.get(6);
//                Room room = new Room(id, serviceName, usedArea, rentCost, maxPeoples, typeOfRent, freeServices);
//                rooms.add(room);
//            }
//        } catch (Exception e) {
//        }
//        return rooms;
//    }
}
//    private static final String COMMA_DELIMITER = ",";
//    private static final String NEW_LINE_SEPARATOR = "\n";
//    private static final String HOUSE_FILE_HEADER = "id,name,areaUsed,rentalCost,maxRenter,typeOfRent,standarOfRoom,describeOtherConvenient,level";
//
//    public static void writeHouse(House house) {
//        String fileName = "D:\\codegym\\module2\\CaseStudy\\src\\Data/House.csv";
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(fileName, true);
//            fileWriter.append(String.valueOf(house.getId()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(house.getNameService());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getRentalCost()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getMaxRenter()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getTypeOfRent()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getStandarOfRoom()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getDescribeOtherConvenient()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(house.getLevel()));
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            System.out.println("CSV file was created successfully !!!");
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileWriter !!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void writeVilla(Villa villa) {
//        String fileName = "D:\\codegym\\module2\\CaseStudy\\src\\Data/Villa.csv";
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(fileName, true);
//            fileWriter.append(String.valueOf(villa.getId()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(villa.getNameService());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getRentalCost()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getMaxRenter()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getTypeOfRent()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getStandarOfRoom()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getDescribeOtherConvenient()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getAreaOfPool()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(villa.getLevel()));
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            System.out.println("CSV file was created successfully !!!");
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileWriter !!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void writeRoom(Room room) {
//        String fileName = "D:\\codegym\\module2\\CaseStudy\\src\\Data/Room.csv";
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(fileName, true);
//            fileWriter.append(String.valueOf(room.getId()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(room.getNameService());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(room.getRentalCost()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(room.getMaxRenter()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(room.getTypeOfRent()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(room.getFreeServiceAttached()));
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            System.out.println("CSV file was created successfully !!!");
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileWriter !!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
