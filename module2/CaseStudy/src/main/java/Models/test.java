package Models;

import Controllers.MainController;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
//Room room=new Room("a","a",1,1,1,"a","a");
//        room.showInfo();
//        String a="20/12/1900";
//        System.out.println(a.substring(6));
//        System.out.println(AddNewServices.validateBirthDay("20/12/1900"));
////        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        long futureTime = 0;
//        try {
//            Date date = format.parse("23/04/2020");
//            System.out.println(date);
//            futureTime = date.getTime();
//            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Vie/Hanoi"));
//            cal.setTime(date);
//            int year = cal.get(Calendar.YEAR);
//            int month = cal.get(Calendar.MONTH);
//            int day = cal.get(Calendar.DAY_OF_MONTH);
//            System.out.println(month);
//        } catch (ParseException e) {
//            System.out.println("loi");
//        }
//
//        long curTime = System.currentTimeMillis();
//        long diff = futureTime - curTime;
//        System.out.println(diff);
//        String value="thanh";
//        value= value.substring(0,1).toUpperCase()+value.substring(1);
//        System.out.println(value);
//        Customer customer=new Customer("a","a","a","a","a","a","a","a");
//        customer.showInfo();
        MainController.displayMainMenu();


    }
}
