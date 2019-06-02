package pl.coderslab.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.feeding.Feeding;
import pl.coderslab.app.feeding.LeftBreast;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MainTest {


    public class Enum {

    }

    public static String switchtest(int day){

//        int dayOfWeek = day;
        String dayOfWeekString;
        switch (day) {
            case 1: dayOfWeekString = "Monday";
                break;
            case 2: dayOfWeekString = "Tuesday";
                break;

            case 3: dayOfWeekString = "Wednesday";
                break;

            default: dayOfWeekString = "Invalid";
                break;

        }
        return dayOfWeekString;
    }

    public static void main(String[] args) {
//        Baby baby = new Baby();
//
//        String date = "2016-11-09";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        LocalDate formatDate = LocalDate.parse(date, formatter);
//
//        baby.setBirthday(formatDate);
//
//        System.out.println(baby.getBirthday());
//
//        System.out.println(UserStatus.ACTIVE);

        ObjectMapper mapper = new ObjectMapper();

        String[] arr = new String[]{"test1", "test2", "element3"};

        Baby baby = new Baby();
        baby.setName("Ola");
        baby.setHeight(58);
        baby.setWeight(3.660);
        baby.setBirthDate(LocalDate.now());

        try {
            String josonstring = mapper.writeValueAsString(arr);
//            String josonstring1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString (arr);

            System.out.println(josonstring);
//            System.out.println(josonstring1);
            String[] arr1 = mapper.readValue(josonstring, String[].class);
            System.out.println(Arrays.toString(arr1));

        } catch (IOException e) {
            e.printStackTrace();
        }


        String now = "2016-11-09 10:30:52";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(formatDateTime);
        System.out.println(formatDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println(switchtest(3));

        Feeding feeding = new Feeding();
        LeftBreast leftBreast = new LeftBreast();
        System.out.println(feeding.getClass().getName());
        System.out.println(feeding.getClass().getSimpleName());
        System.out.println(leftBreast.getClass().getName());
        System.out.println(leftBreast.getClass().getSimpleName());


    }






}
